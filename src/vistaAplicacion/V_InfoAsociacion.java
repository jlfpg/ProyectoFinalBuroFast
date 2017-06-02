package vistaAplicacion;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;


@SuppressWarnings("serial")
public class V_InfoAsociacion extends JFrame {
	private JTextField txtNba;
	private JTextField txtn;
	private JTextField txtDeporte;
	private JTextField txtMadrid;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtCjgcom;
	private JTextField textField_8;
	private JTextField txtBreuce;
	private JTextField textField_10;
	private JTextField txtCiverson;
	private JTextField txtBaloncesto;
	private JTextField textField_12;
	private JTextField txtMadrid_1;
	private JTextField txtDeporte_1;
	private JTextField txtDeporte_2;
	private JTextField textField_16;
	private JTextField txtNba_1;
	private JTextField txtPendiente;
	private JTextField textField_19;
	private JTextField textField_20;

	public V_InfoAsociacion() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Asociaciones");
		setBounds(100, 100, 842, 504);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblInfoAsociacion = new JLabel("INFORMACION ASOCIACION");
		lblInfoAsociacion.setBounds(10, 11, 816, 25);
		lblInfoAsociacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoAsociacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblInfoAsociacion);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la asociacion");
		lblNombreDeLa.setBounds(10, 71, 174, 14);
		getContentPane().add(lblNombreDeLa);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setBounds(317, 134, 46, 14);
		getContentPane().add(lblCif);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 102, 67, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblTipo = new JLabel("Tipo de Asociacion");
		lblTipo.setBounds(571, 134, 118, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setBounds(10, 134, 78, 14);
		getContentPane().add(lblMunicipio);
		
		JLabel lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(317, 165, 108, 14);
		getContentPane().add(lblCodigoPostal);
		
		JLabel lblTelefonoFijo = new JLabel("Telefono Fijo");
		lblTelefonoFijo.setBounds(10, 165, 118, 14);
		getContentPane().add(lblTelefonoFijo);
		
		JLabel lblTelefonoMovil = new JLabel("Telefono Movil");
		lblTelefonoMovil.setBounds(571, 196, 96, 14);
		getContentPane().add(lblTelefonoMovil);
		
		JLabel lblRepresentantante = new JLabel("Representantante");
		lblRepresentantante.setBounds(571, 165, 108, 14);
		getContentPane().add(lblRepresentantante);
		
		JLabel lblMail = new JLabel("Email");
		lblMail.setBounds(10, 196, 46, 14);
		getContentPane().add(lblMail);
		
		JLabel lblFaxl = new JLabel("Fax");
		lblFaxl.setBounds(317, 196, 46, 14);
		getContentPane().add(lblFaxl);
		
		txtNba = new JTextField();
		txtNba.setText("NBA");
		txtNba.setBounds(161, 68, 665, 20);
		getContentPane().add(txtNba);
		txtNba.setColumns(10);
		
		txtn = new JTextField();
		txtn.setText("092829N");
		txtn.setBounds(405, 131, 127, 20);
		getContentPane().add(txtn);
		txtn.setColumns(10);
		
		txtDeporte = new JTextField();
		txtDeporte.setText("Deporte");
		txtDeporte.setBounds(699, 131, 127, 20);
		getContentPane().add(txtDeporte);
		txtDeporte.setColumns(10);
		
		txtMadrid = new JTextField();
		txtMadrid.setText("Madrid");
		txtMadrid.setBounds(161, 131, 127, 20);
		getContentPane().add(txtMadrid);
		txtMadrid.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("93443345");
		textField_5.setBounds(161, 162, 127, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("3242");
		textField_6.setBounds(405, 162, 127, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		txtCjgcom = new JTextField();
		txtCjgcom.setText("CJ@g.com");
		txtCjgcom.setBounds(161, 193, 127, 20);
		getContentPane().add(txtCjgcom);
		txtCjgcom.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(405, 193, 127, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		txtBreuce = new JTextField();
		txtBreuce.setText("Bruce");
		txtBreuce.setBounds(699, 162, 127, 20);
		getContentPane().add(txtBreuce);
		txtBreuce.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(699, 193, 127, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNombreActividad = new JLabel("Nombre actividad");
		lblNombreActividad.setBounds(10, 281, 110, 14);
		getContentPane().add(lblNombreActividad);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 312, 46, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(317, 312, 46, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblTipoActividad = new JLabel("Tipo ");
		lblTipoActividad.setBounds(10, 343, 110, 14);
		getContentPane().add(lblTipoActividad);
		
		JLabel lblTipo_1 = new JLabel("Tipo  Actividad");
		lblTipo_1.setBounds(317, 346, 110, 14);
		getContentPane().add(lblTipo_1);
		
		JLabel lblNumeroDestinatarios = new JLabel("Numero  Destinatarios");
		lblNumeroDestinatarios.setBounds(571, 343, 163, 14);
		getContentPane().add(lblNumeroDestinatarios);
		
		JLabel lblOrganizador = new JLabel("Organizador");
		lblOrganizador.setBounds(571, 312, 96, 14);
		getContentPane().add(lblOrganizador);
		
		JLabel lblNewLabel = new JLabel("Subvencion");
		lblNewLabel.setBounds(10, 388, 86, 14);
		Font font2 = lblNewLabel.getFont();
		Map attributes2 = font2.getAttributes();
		attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblNewLabel.setFont(font2.deriveFont(attributes2));
		getContentPane().add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 430, 46, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setBounds(317, 430, 46, 14);
		getContentPane().add(lblImporte);
		
		JLabel lblFecha_1 = new JLabel("Fecha");
		lblFecha_1.setBounds(571, 430, 46, 14);
		getContentPane().add(lblFecha_1);
		
		JLabel lblNewLabel_1 = new JLabel("Asociacion");
		lblNewLabel_1.setBounds(10, 36, 118, 14);
		Font font = lblNewLabel_1.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblNewLabel_1.setFont(font.deriveFont(attributes));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(10, 242, 83, 14);
		Font font1 = lblActividad.getFont();
		Map attributes1 = font.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblActividad.setFont(font1.deriveFont(attributes1));
		getContentPane().add(lblActividad);
		
		txtCiverson = new JTextField();
		txtCiverson.setText("C/Iverson");
		txtCiverson.setBounds(161, 99, 665, 20);
		getContentPane().add(txtCiverson);
		txtCiverson.setColumns(10);
		
		txtBaloncesto = new JTextField();
		txtBaloncesto.setText("Baloncesto");
		txtBaloncesto.setBounds(161, 278, 665, 20);
		getContentPane().add(txtBaloncesto);
		txtBaloncesto.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setText("13/05/2017");
		textField_12.setBounds(161, 309, 127, 20);
		getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		txtMadrid_1 = new JTextField();
		txtMadrid_1.setText("Madrid");
		txtMadrid_1.setBounds(405, 309, 127, 20);
		getContentPane().add(txtMadrid_1);
		txtMadrid_1.setColumns(10);
		
		txtDeporte_1 = new JTextField();
		txtDeporte_1.setText("Deporte");
		txtDeporte_1.setBounds(161, 340, 127, 20);
		getContentPane().add(txtDeporte_1);
		txtDeporte_1.setColumns(10);
		
		txtDeporte_2 = new JTextField();
		txtDeporte_2.setText("Deporte");
		txtDeporte_2.setBounds(405, 340, 127, 20);
		getContentPane().add(txtDeporte_2);
		txtDeporte_2.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setText("50");
		textField_16.setBounds(699, 340, 127, 20);
		getContentPane().add(textField_16);
		textField_16.setColumns(10);
		
		txtNba_1 = new JTextField();
		txtNba_1.setText("NBA");
		txtNba_1.setBounds(699, 309, 127, 20);
		getContentPane().add(txtNba_1);
		txtNba_1.setColumns(10);
		
		txtPendiente = new JTextField();
		txtPendiente.setText("Pendiente");
		txtPendiente.setBounds(161, 427, 127, 20);
		getContentPane().add(txtPendiente);
		txtPendiente.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setText("2345");
		textField_19.setBounds(405, 427, 127, 20);
		getContentPane().add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setText("07/03/2017");
		textField_20.setBounds(699, 427, 127, 20);
		getContentPane().add(textField_20);
		textField_20.setColumns(10);
	}
}
