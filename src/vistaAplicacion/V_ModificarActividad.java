package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_ModificarActividad extends JFrame {
	private JTextField txtAct;
	private JTextField txtOrganizador;
	private JTextField txtTipo;
	private JTextField txtLugar;
	private Controller controlador;
	private JTextField txtNdestinatarios;
	private JTextField txtFecha;
	private JTextField txtTipoActividad;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public V_ModificarActividad() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Actividad");
		setBounds(100, 100, 535, 275);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblAsociacin = new JLabel("Actividad:");
		JLabel lblImporte = new JLabel("Fecha:");
		JLabel lblFecha = new JLabel("Tipo:");
		JLabel lblActividad = new JLabel("Nº Destinatarios:");
		JLabel lblLugar = new JLabel("Lugar:");
		JLabel lblOrganizador = new JLabel("Organizador:");
		JLabel lblTipoAsocia = new JLabel("Tipo Actividad:");
		txtAct = new JTextField();
		txtOrganizador = new JTextField();
		txtTipo = new JTextField();
		txtLugar = new JTextField();
		txtTipoActividad = new JTextField();
		txtFecha = new JTextField();
		txtNdestinatarios = new JTextField();
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");
		
		lblAsociacin.setBounds(44, 34, 63, 14);
		getContentPane().add(lblAsociacin);
		
		lblImporte.setBounds(314, 146, 59, 14);
		getContentPane().add(lblImporte);
		
		lblFecha.setBounds(314, 34, 59, 14);
		getContentPane().add(lblFecha);

		lblActividad.setBounds(44, 146, 108, 14);
		getContentPane().add(lblActividad);
		
		lblLugar.setBounds(314, 91, 59, 14);
		getContentPane().add(lblLugar);

		txtTipo.setColumns(10);
		txtTipo.setBounds(390, 31, 86, 20);
		getContentPane().add(txtTipo);

		txtLugar.setColumns(10);
		txtLugar.setBounds(390, 88, 86, 20);
		getContentPane().add(txtLugar);
		
		txtAct.setBounds(158, 31, 86, 20);
		getContentPane().add(txtAct);
		txtAct.setColumns(10);

		txtOrganizador.setColumns(10);
		txtOrganizador.setBounds(158, 88, 86, 20);
		getContentPane().add(txtOrganizador);

		txtNdestinatarios.setColumns(10);
		txtNdestinatarios.setBounds(158, 143, 86, 20);
		getContentPane().add(txtNdestinatarios);

		txtFecha.setColumns(10);
		txtFecha.setBounds(390, 143, 86, 20);
		getContentPane().add(txtFecha);

		lblOrganizador.setBounds(44, 91, 108, 14);
		getContentPane().add(lblOrganizador);

		lblTipoAsocia.setBounds(44, 199, 108, 14);
		getContentPane().add(lblTipoAsocia);

		txtTipoActividad.setColumns(10);
		txtTipoActividad.setBounds(158, 196, 86, 20);
		getContentPane().add(txtTipoActividad);
		
		btnGuardar.setBounds(284, 195, 89, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeMactividad();
			//controlador.modificarAct();
			}
		});

		btnCancelar.setBounds(387, 195, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarMActividad();
			}
		});

	}
	
	

	public String getTxtAct() {
		return txtAct.getText();
	}

	public void setTxtAct(String sat) {
		txtAct.setText(sat);
	}

	public String getTxtOrganizador() {
		return txtOrganizador.getText();
	}

	public void setTxtOrganizador(String sor) {
		txtOrganizador.setText(sor);
	}

	public String getTxtTipo() {
		return txtTipo.getText();
	}

	public void setTxtTipo(String stp) {
		txtTipo.setText(stp);
	}

	public String getTxtLugar() {
		return txtLugar.getText();
	}

	public void setTxtLugar(String stl) {
		txtLugar.setText(stl);
	}

	public String getTxtNdestinatarios() {
		return txtNdestinatarios.getText();
	}

	public void setTxtNdestinatarios(String  std) {
		txtNdestinatarios.setText(std);;
	}

	public String getTxtFecha() {
		return txtFecha.getText();
	}

	public void setTxtFecha(String stf) {
		txtFecha.setText(stf);
	}

	public String getTxtTipoActividad() {
		return txtTipoActividad.getText();
	}

	public void setTxtTipoActividad(String stta) {
		txtTipoActividad.setText(stta);;
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}