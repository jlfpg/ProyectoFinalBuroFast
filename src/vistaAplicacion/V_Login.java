package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;
import java.awt.Font;
import java.awt.Image;

@SuppressWarnings("serial")
public class V_Login extends JFrame {
	private Controller controlador;
	private JLabel lblLogin;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	private ImageIcon img;
	private Icon icono;
	private JButton btnConf;
	private JLabel lblNewLabel;

	public V_Login() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Login");
		setBounds(100, 100, 517, 308);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		lblLogin = new JLabel("BUROFAST");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblLogin.setBounds(166, 11, 167, 33);
		getContentPane().add(lblLogin);
		btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.logearse();
			}
		});
		btnEntrar.setBounds(201, 245, 89, 23);
		getContentPane().add(btnEntrar);
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password\r\n");
		passwordField.setBounds(166, 192, 167, 23);
		getContentPane().add(passwordField);
		
		btnConf = new JButton();
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cambiarConfiguracion();
			}
		});
		btnConf.setBounds(10, 11, 35, 30);
		img = new ImageIcon("img/configuracion.png");
		icono = new ImageIcon(img.getImage().getScaledInstance(btnConf.getWidth(), btnConf.getHeight(), Image.SCALE_DEFAULT));
		btnConf.setIcon(icono);
		getContentPane().add(btnConf);
		
		JLabel lblCodigoDeAcceso = new JLabel("          Codigo de Acceso:");
		lblCodigoDeAcceso.setBounds(166, 166, 167, 14);
		getContentPane().add(lblCodigoDeAcceso);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/trafalgar/Documents/workspace/pr-uf6-2-tarea-2-tablas-y-fichero-pi-los-valhalla-nigg-s-master/lib/imgs/Logo 2016.png"));
		lblNewLabel.setBounds(121, -36, 351, 279);
		getContentPane().add(lblNewLabel);
		//C:\\Users\\jorge\\Desktop
	
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}