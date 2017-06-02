package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_RegistrarActividad extends JFrame {
	private JTextField txtNombreAct;
	private JTextField txtOrganizador;
	private JTextField txtTipo;
	private JTextField txtLugar;
	private Controller controlador;
	private JTextField txtNdestinatarios;
	private JTextField txtFecha;
	private JTextField txtTipoAct;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public V_RegistrarActividad() {
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
		txtNombreAct = new JTextField();
		txtOrganizador = new JTextField();
		txtTipo = new JTextField();
		txtLugar = new JTextField();
		txtTipoAct = new JTextField();
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

		txtNombreAct.setBounds(158, 31, 86, 20);
		getContentPane().add(txtNombreAct);
		txtNombreAct.setColumns(10);

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

		lblTipoAsocia.setBounds(44, 197, 108, 14);
		getContentPane().add(lblTipoAsocia);

		txtTipoAct.setColumns(10);
		txtTipoAct.setBounds(158, 192, 86, 20);
		getContentPane().add(txtTipoAct);

		btnGuardar.setBounds(284, 195, 89, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeRactividad();
				//controlador.cerrarRActividad();
				controlador.altaActividad(txtNombreAct.getText(),txtNdestinatarios.getText(),txtLugar.getText());
			}
		});

		btnCancelar.setBounds(387, 195, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarRActividad();
				;
			}
		});
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}