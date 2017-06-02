package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_ModificarSubvencion extends JFrame {
	private JTextField txtAso;
	private JTextField textImpo;
	private JTextField txtFecha;
	private JTextField txtActi;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private Controller controlador;

	public V_ModificarSubvencion() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Subvencion");
		setBounds(100, 100, 519, 238);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblAsociacin = new JLabel("Asociación:");
		JLabel lblImporte = new JLabel("Importe:");
		JLabel lblSubvencin = new JLabel("Estado");
		JLabel lblFecha = new JLabel("Fecha:");
		JLabel lblActividad = new JLabel("Actividad:");
		JComboBox<String> comboEstado = new JComboBox<String>();
		txtAso = new JTextField();
		textImpo = new JTextField();
		txtFecha = new JTextField();
		txtActi = new JTextField();
		btnGuardar = new JButton();
		btnCancelar = new JButton();
		
		lblAsociacin.setBounds(48, 25, 69, 14);
		getContentPane().add(lblAsociacin);

		lblImporte.setBounds(48, 82, 48, 14);
		getContentPane().add(lblImporte);

		lblSubvencin.setBounds(61, 143, 54, 14);
		getContentPane().add(lblSubvencin);

		comboEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "Concedido", "Pendiente", "Denegado" }));
		comboEstado.setBounds(125, 140, 92, 20);
		getContentPane().add(comboEstado);

		txtAso.setBounds(127, 22, 115, 20);
		getContentPane().add(txtAso);
		txtAso.setColumns(10);

		textImpo.setColumns(10);
		textImpo.setBounds(125, 79, 115, 20);
		getContentPane().add(textImpo);
		
		lblFecha.setBounds(272, 25, 43, 14);
		getContentPane().add(lblFecha);

		lblActividad.setBounds(272, 82, 58, 14);
		getContentPane().add(lblActividad);
		
		txtFecha.setColumns(10);
		txtFecha.setBounds(340, 22, 115, 20);
		getContentPane().add(txtFecha);

		txtActi.setColumns(10);
		txtActi.setBounds(340, 79, 115, 20);
		getContentPane().add(txtActi);

		btnGuardar.setBounds(272, 139, 86, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeMsubvencion();
				
			}
		});
		
		btnCancelar.setBounds(371, 139, 86, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarMSubvencion();;
			}
		});
		

	}
	

	public void setTxtAso(JTextField txtAso) {
		this.txtAso = txtAso;
	}

	public void setTextImpo(JTextField textImpo) {
		this.textImpo = textImpo;
	}

	public void setTxtFecha(JTextField txtFecha) {
		this.txtFecha = txtFecha;
	}

	public void setTxtActi(JTextField txtActi) {
		this.txtActi = txtActi;
	}

	

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}
