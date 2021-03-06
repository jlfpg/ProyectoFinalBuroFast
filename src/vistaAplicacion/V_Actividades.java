package vistaAplicacion;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_Actividades extends JFrame{
	private Controller controlador;
	private JButton btnAsociaciones;
	private JButton btnRegistrarAs;
	private JButton btnSubvenciones;
	private JButton btnActividades;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblFiltro;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblCampoBsqueda;
	private JTextField busquedatxt;
	private JButton btnLimpiar;
	private JComboBox<String> registros;
	
	public V_Actividades() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Actividades");
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
					controlador.BorrarActividad();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        lblFiltro = new JLabel("Filtro de Búsqueda");
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.BusquedaActividad();
        	}
        });
        btnLimpiar = new JButton("Limpiar");
        btnRegistrar = new JButton("Registrar");
        lblCampoBsqueda = new JLabel("Campo Búsqueda");
        busquedatxt = new JTextField();
        busquedatxt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.BusquedaActividad();
        	}
        });
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
            public void mouseClicked(MouseEvent evt) {
            	controlador.cambiarRegistrar();
            	
            }
        });
        
        btnSubvenciones.setBounds(428, 22, 175, 40);
        getContentPane().add(btnSubvenciones);
        btnSubvenciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	controlador.cambiarSubvenciones();
            }
        });
        
        btnActividades.setBounds(624, 22, 175, 40);
        getContentPane().add( btnActividades);
        btnActividades.setEnabled(false);
        
        scrollPane.setBounds(27, 193, 673, 242);
        getContentPane().add(scrollPane);
        
        btnModificar.setBounds(710, 378, 89, 23);
        getContentPane().add(btnModificar);
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarModificarAct();
			}
		});
        
        btnEliminar.setBounds(710, 412, 89, 23);
        getContentPane().add(btnEliminar);
        btnEliminar.setEnabled(false);
        
        btnRegistrar.setBounds(710, 344, 89, 23);
        getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarRegistrarAct();
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
        		//controlador.mostrarBotonLimpiarAc();
        		controlador.modificarAct();
        	}
        });
        
        registros.setModel(new DefaultComboBoxModel<String>(new String[] {"Nombre actividad", "Fecha", "Lugar", "Tipo actividad", "Tipo asociacion", "NºDestinatarios", "Organizador"}));
        registros.setBounds(147, 119, 144, 23);
        getContentPane().add(registros);
        
        table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		    	controlador.mostrarBotonVistaAc();
		        if (me.getClickCount() == 2) {
		            controlador.ampliarActividad();
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
	
	public void setActividad(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] {
				"id_actividad", "nombre", "n_destinatarios", "lugar", "descripcion"}){
			public boolean isCellEditable (int row, int column){
				return false;
			}
		});
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
	    alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tabla[1].length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
	}
	
	public JTable getTable() {
		return table;
	}

	public JButton getbtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public String getBusquedatxt() {
		return busquedatxt.getText();
	}

	public void setBusquedatxt(JTextField busquedatxt) {
		this.busquedatxt = busquedatxt;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	public void setControlador(Controller controlador){
		this.controlador = controlador;
	}
	
}
