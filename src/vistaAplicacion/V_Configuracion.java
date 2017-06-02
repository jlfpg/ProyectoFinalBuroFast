package vistaAplicacion;

import javax.swing.*;
import java.awt.event.*;

import controladorAplicacion.Controller;

import java.awt.Font;

@SuppressWarnings("serial")
public class V_Configuracion extends JFrame {
	private JTextField dbtxt;
	private JTextField pwdtxt;
	private JTextField urltxt;
	private JTextField usertxt;
	private Controller controlador;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public V_Configuracion() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 420, 241);
		getContentPane().setLayout(null);
		setTitle("Modificar BBDD");
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel lblConfigurarConexinBbdd = new JLabel("CONFIGURAR CONEXIÓN BBDD");
		lblConfigurarConexinBbdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfigurarConexinBbdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfigurarConexinBbdd.setBounds(10, 11, 394, 27);
		getContentPane().add(lblConfigurarConexinBbdd);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(240, 117, 66, 14);
		getContentPane().add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(21, 117, 86, 14);
		getContentPane().add(lblContrasea);

		JLabel lblBaseDeDatos = new JLabel("Base de datos:");
		lblBaseDeDatos.setBounds(21, 63, 104, 14);
		getContentPane().add(lblBaseDeDatos);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(240, 63, 46, 14);
		getContentPane().add(lblUrl);

		dbtxt = new JTextField();
		dbtxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				controlador.mostrarBotonVistaConf();
			}
		});
		dbtxt.setBounds(124, 60, 86, 20);
		getContentPane().add(dbtxt);
		dbtxt.setColumns(10);

		pwdtxt = new JTextField();
		pwdtxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				controlador.mostrarBotonVistaConf();
			}
		});
		pwdtxt.setBounds(124, 114, 86, 20);
		getContentPane().add(pwdtxt);
		pwdtxt.setColumns(10);

		urltxt = new JTextField();
		urltxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				controlador.mostrarBotonVistaConf();
			}
		});
		urltxt.setBounds(299, 60, 86, 20);
		getContentPane().add(urltxt);
		urltxt.setColumns(10);

		usertxt = new JTextField();
		usertxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				controlador.mostrarBotonVistaConf();
			}
		});
		usertxt.setBounds(299, 114, 86, 20);
		getContentPane().add(usertxt);
		usertxt.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(186, 166, 89, 23);
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controlador.guardarConfiguracion();
			}
		});
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarConfiguracion();
			}
		});
		btnCancelar.setBounds(296, 166, 89, 23);
		getContentPane().add(btnCancelar);
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}

	public JTextField getDbTxt() {
		return dbtxt;
	}

	public JTextField getPwdTxt() {
		return pwdtxt;
	}

	public JTextField getUrlTxt() {
		return urltxt;
	}

	public JTextField getUserTxt() {
		return usertxt;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

}
