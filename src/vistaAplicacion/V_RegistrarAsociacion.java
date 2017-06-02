package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_RegistrarAsociacion extends JFrame {
	private Controller controlador;
	private JButton btnRegistrarAs;
	private JButton btnSubvenciones;
	private JButton btnActividades;
	private JTextField txtDenominacinDeLa;
	private JTextField txtCodigoPostal;
	private JTextField txtMunicipioprovincia;
	private JTextField txtDnicif;
	private JTextField txtDireccion;
	private JTextField txtTelf;
	private JTextField txtMail;
	private JTextField txtTelfMovil;
	private JTextField txtFax;
	private JCheckBox chckbxActaOCertificacion;
	private JCheckBox chckbxCertificacionDeDemicilio;
	private JCheckBox chckbxCodigodeCertificacionfiscal;
	private JCheckBox chckbxCopiadelosestatutosdelaasociacionoentidadciudadana;
	private JCheckBox chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM;
	private JButton btnAsociaciones;
	private JLabel lblDenominacióndelaasociacionoentidadciudadana;
	private JLabel lblMunicipio;
	private JLabel lblCdigoPostal;
	private JLabel lblDireccin;
	private JLabel lblTelfFijo;
	private JLabel lblDnicif;
	private JLabel lblMail;
	private JLabel lblTelfMovil;
	private JLabel lblFax;
	private JLabel lblDocumentosAEntregar;
	private V_RegistrarAsociacion vasociacion;
	private JTextField txtTipo;
	private JTextField txtCIF2;
	private JLabel lblTipoDeAsociacion;

	public V_RegistrarAsociacion() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Registrar Asociacion");
		setBounds(100, 100, 842, 504);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnAsociaciones = new JButton("Asociaciones");
		btnAsociaciones.setBounds(27, 22, 175, 40);
		btnRegistrarAs = new JButton("Registrar Asociacion");
		btnRegistrarAs.setBounds(229, 22, 175, 40);
		btnSubvenciones = new JButton("Subvenciones");
		btnSubvenciones.setBounds(428, 22, 175, 40);
		btnActividades = new JButton("Actividades");
		btnActividades.setBounds(624, 22, 175, 40);
		getContentPane().setLayout(null);
		getContentPane().add(btnAsociaciones);
		btnAsociaciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controlador.cambiarAsociacion();
			}
		});
		getContentPane().add(btnRegistrarAs);
		btnRegistrarAs.setEnabled(false);
		
		getContentPane().add(btnSubvenciones);
		btnSubvenciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				controlador.cambiarSubvenciones();
			}
		});
		getContentPane().add(btnActividades);
		btnActividades.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	controlador.cambiarActividad();
            }
        });

		txtDenominacinDeLa = new JTextField();
		txtDenominacinDeLa.setBounds(27, 111, 377, 20);
		getContentPane().add(txtDenominacinDeLa);
		txtDenominacinDeLa.setColumns(10);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(229, 172, 175, 20);
		getContentPane().add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);

		txtMunicipioprovincia = new JTextField();
		txtMunicipioprovincia.setBounds(27, 172, 175, 20);
		getContentPane().add(txtMunicipioprovincia);
		txtMunicipioprovincia.setColumns(10);

		txtDnicif = new JTextField();
		txtDnicif.setBounds(229, 428, 175, 20);
		getContentPane().add(txtDnicif);
		txtDnicif.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(27, 236, 377, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelf = new JTextField();
		txtTelf.setBounds(27, 301, 175, 20);
		getContentPane().add(txtTelf);
		txtTelf.setColumns(10);

		txtMail = new JTextField();
		txtMail.setBounds(27, 363, 377, 20);
		getContentPane().add(txtMail);
		txtMail.setColumns(10);

		txtTelfMovil = new JTextField();
		txtTelfMovil.setBounds(27, 428, 175, 20);
		getContentPane().add(txtTelfMovil);
		txtTelfMovil.setColumns(10);

		txtFax = new JTextField();
		txtFax.setBounds(229, 301, 175, 20);
		getContentPane().add(txtFax);
		txtFax.setColumns(10);

		chckbxActaOCertificacion = new JCheckBox("Acta o Certificacion");
		chckbxActaOCertificacion.setBounds(428, 125, 156, 23);
		getContentPane().add(chckbxActaOCertificacion);

		chckbxCertificacionDeDemicilio = new JCheckBox("Certificacion de domicilio, sede o sedes sociales");
		chckbxCertificacionDeDemicilio.setBounds(428, 171, 352, 22);
		getContentPane().add(chckbxCertificacionDeDemicilio);

		chckbxCodigodeCertificacionfiscal = new JCheckBox("Codigo de Certificacion fiscal");
		chckbxCodigodeCertificacionfiscal.setBounds(428, 217, 352, 23);
		getContentPane().add(chckbxCodigodeCertificacionfiscal);

		chckbxCopiadelosestatutosdelaasociacionoentidadciudadana = new JCheckBox(
				"Copia de los estatutos de la asociacion o entidad ciudadana");
		chckbxCopiadelosestatutosdelaasociacionoentidadciudadana.setBounds(428, 264, 411, 20);
		getContentPane().add(chckbxCopiadelosestatutosdelaasociacionoentidadciudadana);

		chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM = new JCheckBox(
				"Resoluci\u00F3n de la deleaci\u00F3n provincial correspondiente de la JCMM");
		chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM.setBounds(428, 309, 455, 23);
		getContentPane().add(chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeRasociacion();
		
		controlador.altaAsociacion(txtDnicif.getText(), txtDenominacinDeLa.getText(), txtDireccion.getText(),
		txtMunicipioprovincia.getText(), txtCodigoPostal.getText(), txtMail.getText(), txtTelf.getText(), txtTelfMovil.getText(), txtFax.getText(),
		 txtCIF2.getText() , txtTipo.getText());
			
			}
		});
		btnGuardar.setBounds(592, 427, 89, 23);
		getContentPane().add(btnGuardar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(691, 427, 89, 23);
		getContentPane().add(btnLimpiar);
		lblDenominacióndelaasociacionoentidadciudadana = new JLabel(
				"Denominación de la asociacion o entidad ciudadana:");
		lblDenominacióndelaasociacionoentidadciudadana.setBounds(27, 86, 377, 16);
		getContentPane().add(lblDenominacióndelaasociacionoentidadciudadana);
		lblMunicipio = new JLabel("Municipio (Provincia):");
		lblMunicipio.setBounds(27, 148, 135, 16);
		getContentPane().add(lblMunicipio);
		lblCdigoPostal = new JLabel("Código postal:");
		lblCdigoPostal.setBounds(229, 148, 135, 16);
		getContentPane().add(lblCdigoPostal);
		lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(27, 215, 135, 16);
		getContentPane().add(lblDireccin);
		lblTelfFijo = new JLabel("Telf Fijo:");
		lblTelfFijo.setBounds(27, 279, 61, 16);
		getContentPane().add(lblTelfFijo);
		lblDnicif = new JLabel("DNI/CIF:");
		lblDnicif.setBounds(229, 408, 61, 16);
		getContentPane().add(lblDnicif);
		lblMail = new JLabel("Mail:");
		lblMail.setBounds(27, 343, 61, 16);
		getContentPane().add(lblMail);
		lblTelfMovil = new JLabel("Telf Movil:");
		lblTelfMovil.setBounds(27, 408, 73, 16);
		getContentPane().add(lblTelfMovil);
		lblFax = new JLabel("Fax:");
		lblFax.setBounds(229, 274, 61, 16);
		getContentPane().add(lblFax);
		lblDocumentosAEntregar = new JLabel("Documentos a entregar:");
		lblDocumentosAEntregar.setBounds(428, 86, 156, 16);
		getContentPane().add(lblDocumentosAEntregar);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(427, 360, 130, 26);
		getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		
		txtCIF2 = new JTextField();
		txtCIF2.setBounds(427, 425, 130, 26);
		getContentPane().add(txtCIF2);
		txtCIF2.setColumns(10);
		
		lblTipoDeAsociacion = new JLabel("Tipo de Asociacion");
		lblTipoDeAsociacion.setBounds(426, 397, 116, 14);
		getContentPane().add(lblTipoDeAsociacion);
		
		JLabel lblNewLabel = new JLabel("Repetir DNI/CIF");
		lblNewLabel.setBounds(428, 332, 114, 16);
		getContentPane().add(lblNewLabel);
	}
	

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}

	public void setVasociacion(V_RegistrarAsociacion vasociacion) {
		this.vasociacion = vasociacion;
	}
}