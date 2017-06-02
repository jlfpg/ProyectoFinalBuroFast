package vistaAplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_Subvenciones extends JFrame {
	private Controller controlador;
	private JButton btnAsociaciones;
	private JButton btnRegistrarAs;
	private JButton btnSubvenciones;
	private JButton btnActividades;
	private JScrollPane scrollPane;
	protected JTable table;
	private JLabel lblFiltro;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	protected JButton btnModificar;
	protected JButton btnEliminar;
	private JLabel lblCampoBsqueda;
	protected JTextField busquedatxt;
	protected JButton btnLimpiar;
	private JComboBox<String> registros;

	public V_Subvenciones() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Subvenciónes");
		setBounds(100, 100, 842, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		btnAsociaciones = new JButton("Asociaciones");
		btnRegistrarAs = new JButton("Registrar Asociacion");
		btnSubvenciones = new JButton("Subvenciones");
		btnActividades = new JButton("Actividades");
		scrollPane = new JScrollPane();
		table = new JTable();
		btnModificar = new JButton("Modificar");
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.BorrarSubvenciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblFiltro = new JLabel("Filtro de Búsqueda");
		btnBuscar = new JButton("Buscar");
		btnLimpiar = new JButton("Limpiar");
		btnRegistrar = new JButton("Registrar");
		lblCampoBsqueda = new JLabel("Campo Búsqueda");
		busquedatxt = new JTextField();
		registros = new JComboBox<String>();

		btnAsociaciones.setBounds(27, 22, 175, 40);
		getContentPane().add(btnAsociaciones);
		btnAsociaciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controlador.cambiarAsociacion();
			}
		});

		btnRegistrarAs.setBounds(229, 22, 175, 40);
		getContentPane().add(btnRegistrarAs);
		btnRegistrarAs.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				controlador.cambiarRegistrar();
			}
		});

		btnSubvenciones.setBounds(428, 22, 175, 40);
		getContentPane().add(btnSubvenciones);
		btnSubvenciones.setEnabled(false);

		btnActividades.setBounds(624, 22, 175, 40);
		getContentPane().add(btnActividades);
		btnActividades.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				controlador.cambiarActividad();
			}
		});

		scrollPane.setBounds(27, 193, 673, 242);
		getContentPane().add(scrollPane);

		btnModificar.setBounds(710, 378, 89, 23);
		getContentPane().add(btnModificar);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarModificarSub();
			}
		});

		btnEliminar.setBounds(710, 412, 89, 23);
		getContentPane().add(btnEliminar);
		btnEliminar.setEnabled(false);

		btnRegistrar.setBounds(710, 344, 89, 23);
		getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarRegistrarSub();
			}
		});

		lblFiltro.setBounds(27, 122, 120, 14);
		getContentPane().add(lblFiltro);

		btnBuscar.setBounds(635, 118, 77, 23);
		getContentPane().add(btnBuscar);

		btnLimpiar.setBounds(722, 118, 77, 23);
		getContentPane().add(btnLimpiar);
		btnLimpiar.setEnabled(false);

		lblCampoBsqueda.setBounds(365, 122, 108, 14);
		getContentPane().add(lblCampoBsqueda);

		busquedatxt.setBounds(481, 118, 144, 23);
		getContentPane().add(busquedatxt);
		busquedatxt.setColumns(10);
		busquedatxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				controlador.mostrarBotonLimpiarSub();
			}
		});

		registros.setModel(new DefaultComboBoxModel<String>(new String[] { "Nombre actividad", "Fecha", "Lugar",
				"Tipo actividad", "Tipo asociacion", "N�destinatario", "Organizador" }));
		registros.setBounds(147, 119, 144, 23);
		getContentPane().add(registros);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controlador.mostrarBotonVistaSub();
				if (e.getClickCount() == 2) {
				}
			}
		});

		scrollPane.setViewportView(table);
		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
			}
		});
	}

	
	public void setSubvencion(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] { "Id subvencion", "Asociacion", "Importe solicitado",
				"Fecha solicitud", "Actividad prevista","Estado" }) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tabla[1].length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTextField getBusquedatxt() {
		return busquedatxt;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}
