package modeloAplicacion;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import javax.swing.JTextField;

import controladorAplicacion.Controller;
import vistaAplicacion.V_Actividades;
import vistaAplicacion.V_Asociaciones;
import vistaAplicacion.V_Subvenciones;
import vistaAplicacion.V_Actividades_ampliado;
import vistaAplicacion.V_Asociaciones_ampliado;
import vistaAplicacion.V_ModificarActividad;
import vistaAplicacion.V_RegistrarActividad;
import vistaAplicacion.V_RegistrarAsociacion;
import vistaAplicacion.V_RegistrarSubvencion;

public class Modelo {
	private String database;
	private String user;
	private String pwd;
	private String url;
	private Connection connect;

	private String[][] ArraydatosAsociacion;
	private V_Asociaciones VAsociacion;
	private String[][] ArraydatosActividad;
	private V_Actividades VActividades;
	private String[][] ArraySubvencion;
	private V_Subvenciones VSubvencion;
	
	private String[][] ArraysDatosActAmpli;
	private V_Actividades_ampliado V_Act_Amp;
	
	private String[][] ArraysDatosAsoAmpli;
	private V_Asociaciones_ampliado V_Aso_Amp;
	
	private V_RegistrarSubvencion RSubvencion;
	private V_RegistrarAsociacion RAsociacion;
	private V_RegistrarActividad RActividad;
	private V_Actividades MActividad;
	private V_ModificarActividad ModiActividad;

	public Modelo() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File fichero = new File("configuracion.ini");
			if (fichero.exists()) {
				entrada = new FileInputStream(fichero);
				propiedades.load(entrada);
				database = propiedades.getProperty("database");
				user = propiedades.getProperty("user");
				pwd = propiedades.getProperty("password");
				url = propiedades.getProperty("url") + database;
			} else
				System.out.println("Fichero no encontrado");
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, pwd);
			System.out.println("Database connection enabled");
		} catch (Exception e) {
			System.out.println("Could not connect with database");
			e.printStackTrace();
		}
	}

	public void guardarDatos(String user, String pwd, String url, String db) {
		Properties propiedades = new Properties();
		OutputStream salida = null;
		try {
			File fichero = new File("configuracion.ini");
			if (fichero.exists()) {
				salida = new FileOutputStream(fichero);
				propiedades.setProperty("database", db);
				propiedades.setProperty("user", user);
				propiedades.setProperty("password", pwd);
				propiedades.setProperty("url", url);
				propiedades.store(salida, null);
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (salida != null) {
				try {
					salida.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void DataAso() {
		try {
			String query = "Select asociacion.CIF,asociacion.nombre,asociacion.direccion,asociacion.municipio,asociacion.cod_postal,asociacion.e_mail,asociacion.tlf_fijo,asociacion.fecha_solicitud,asociacion_tipo.CIF,asociacion_tipo.tipo "
					+ "from gestionAsociaciones.asociacion  INNER join asociacion_tipo ON asociacion_tipo.CIF=asociacion.CIF ";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();
			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraydatosAsociacion = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosAsociacion[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void DataActividad() {
		try {
			String query = "Select * from gestionAsociaciones.actividad";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();
			
			ArraydatosActividad = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosActividad[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void DataSubvencion() {
		try {
			String query = "SELECT subvencion.id_subvencion,subvencion.asociacion,subvencion.importe_solicitado,subvencion.fecha_solicitud,actividad.nombre,subvencion.estado FROM subvencion JOIN actividad ON actividad.id_actividad = subvencion.actividad_prev";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraySubvencion = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraySubvencion[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void DataAsoAmpli(){
		try {
			String query = "SELECT asociacion.CIF,asociacion.nombre,asociacion.direccion,asociacion.municipio,asociacion.cod_postal,asociacion.e_mail,asociacion.tlf_fijo,asociacion.id_documentacion,asociacion.estatuto_asoc,asociacion.certif_dom_social,asociacion.numero_asociacionRDP,asociacion.acta_junta_directiva,asociacion.fecha_solicitud,asociacion.tlf_movil,asociacion.fax,representante.nombre,tipo.categoria from asociacion "
					+ "INNER join asociacion_tipo "
					+ "ON asociacion_tipo.CIF=asociacion.CIF "
					+ "INNER join representante "
					+ "ON representante.NIF_NIE=asociacion.representante "
					+ "INNER join tipo "
					+ "ON asociacion_tipo.tipo=tipo.id_tipo "
					+ "INNER join organiza_participa "
					+ "ON organiza_participa.asociacion=asociacion_tipo.CIF";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraysDatosAsoAmpli = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraysDatosAsoAmpli[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
	}
	
	public void DataSubAmpli(){
		try {
			String query = "SELECT actividad.id_actividad, actividad.nombre, actividad.n_destinatarios, actividad.lugar, actividad.descripcion,tipo.categoria "
					+ "FROM actividad INNER join actividad_tipo "
					+ "on actividad_tipo.actividad=actividad.id_actividad JOIN tipo on actividad_tipo.tipo=tipo.id_tipo" ;
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraysDatosActAmpli = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraysDatosActAmpli[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
	}
	
	public void registrarAsociacion(String CIF, String nombre, String direccion, String municipio, String cod_postal, String email, 
			String telf_fijo, String tel_movil, String fax, String CIF2, String tipo){
		try {
			String sql = "Insert into gestionAsociaciones.asociacion (`CIF`,`nombre`,`direccion`,`municipio`,`cod_postal`,`e_mail`,`tlf_fijo`,`tlf_movil`,`fax`) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			String sql2 = "Insert into gestionAsociaciones.asociacion_tipo (`CIF`,`tipo`) values (?, ?)";
			
			PreparedStatement stmt = connect.prepareStatement(sql);
			PreparedStatement stmt2 = connect.prepareStatement(sql2);
			
			
			stmt.setString(1, CIF);
			stmt2.setString(1, CIF2);
			stmt.setString(2, nombre);
			stmt2.setString(2, tipo);
			stmt.setString(3, direccion);
			stmt.setString(4, municipio);
			stmt.setString(5, cod_postal);
			stmt.setString(6, email);
			stmt.setString(7, telf_fijo);
			stmt.setString(8, tel_movil);
			stmt.setString(9, fax);
			stmt.executeUpdate();
			stmt2.executeUpdate();
			stmt.close();
			stmt2.close();
			cargarDatosTablas();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		
	}
	
	public void registrarSubvencion( String asociacion, String importe, String fecha,
			String actividad, String estado) {
		try {
			String sql = "Insert into gestionAsociaciones.subvencion (`asociacion`,`importe_solicitado`,`fecha_solicitud`,`actividad_prev`,`estado`) values (?, ?, ?, ?,?)";
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, asociacion);
			stmt.setString(2, importe);
			stmt.setString(3, fecha);
			stmt.setString(4, actividad);
			stmt.setString(5, estado);
			stmt.executeUpdate();
			stmt.close();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public void registrarActividad(String nombre, String n_destinatario, String lugar){
		
		try {
			String sql = "Insert into gestionAsociaciones.actividad (`nombre`,`n_destinatarios`,`lugar`) values (?, ?, ?)";
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, n_destinatario);
			stmt.setString(3, lugar);
			stmt.executeUpdate();
			stmt.close();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	
	}
	
	public void BorrarAsociacion(String ASO)throws SQLException {
		
		try {
			String[] querys = new String[5];
			querys[0] = "DELETE FROM asociacion_tipo WHERE CIF = '"+ASO+"'";
			querys[1] = "DELETE FROM subvencion WHERE asociacion = '"+ASO+"'";
			querys[2] = "DELETE FROM organiza_participa WHERE asociacion = '"+ASO+"'";
			querys[3] = "DELETE FROM sede_localmunicipal WHERE asociacion = '"+ASO+"'";
			querys[4] = "DELETE FROM asociacion WHERE CIF = '"+ASO+"'";
			PreparedStatement stmt;
			for(int i = 0; i < querys.length; i++){
			stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
			stmt.executeUpdate();
			}
			cargarDatosTablas();
			} catch (Exception e) {
			System.out.println("Borrado");
			}
		}
		
	public void BorrarSubvencion(String SUB)throws SQLException {
		
		try {
			String[] querys = new String[5];
			querys[0] = "DELETE FROM asociacion_tipo WHERE CIF = '"+SUB+"'";
			querys[1] = "DELETE FROM subvencion WHERE id_subvencion = '"+SUB+"'";
			querys[2] = "DELETE FROM organiza_participa WHERE asociacion = '"+SUB+"'";
			querys[3] = "DELETE FROM sede_localmunicipal WHERE asociacion = '"+SUB+"'";
			querys[4] = "DELETE FROM asociacion WHERE CIF = '"+SUB+"'";
			PreparedStatement stmt;
			for(int i = 0; i < querys.length; i++){
			stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
			stmt.executeUpdate();
			}
			cargarDatosTablas();
			} catch (Exception e) {
			System.out.println("Borrado");
			}
		}
	
	
	public void BorrarActividad(String ACT)throws SQLException {
		
		try {
			String[] querys = new String[5];
			querys[0] = "DELETE FROM actividad WHERE id_actividad = '"+ACT+"'";
			querys[1] = "DELETE FROM subvencion WHERE asociacion = '"+ACT+"'";
			querys[2] = "DELETE FROM organiza_participa WHERE asociacion = '"+ACT+"'";
			querys[3] = "DELETE FROM sede_localmunicipal WHERE asociacion = '"+ACT+"'";
			querys[4] = "DELETE FROM asociacion WHERE CIF = '"+ACT+"'";
			PreparedStatement stmt;
			for(int i = 0; i < querys.length; i++){
			stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
			stmt.executeUpdate();
			}
			cargarDatosTablas();
			} catch (Exception e) {
			System.out.println("Borrado");
			}
		}

	public void CargarActividad(int id_actividad) {
		try {
			//int cod = Integer.parseInt(ModiActividad.getTextFieldCodigoEQuipo());
			
			String sql = "'Select * from gestionAsociaciones.actividad WHERE id_actividad = '"
					+ id_actividad + "';";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			
			for (int i = 0; i < ArraydatosActividad.length; i++) {
			
			if (rset.next()) {
				ModiActividad.setTxtAct(rset.getString(i + 1));
				ModiActividad.setTxtOrganizador(rset.getString(i+ 1));
				ModiActividad.setTxtTipo(rset.getString(i + 1));
				ModiActividad.setTxtLugar(rset.getString(i+ 1) );
				ModiActividad.setTxtTipoActividad(rset.getString(i + 1));
				ModiActividad.setTxtFecha(rset.getString(i + 1));
				ModiActividad.setTxtNdestinatarios(rset.getString(i + 1));
				
				}
			}	
			stmt.close();
			rset.close();

			System.out.println("update prestamo realizado con exito");
			//MActividad.getbtnModificar();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void ModificarActividad(){
		try{
		int id_actividad = Integer.parseInt(ModiActividad.getTxtAct());
		;
		String sql = "SELECT TipodeEquipo, Notas, Equipo_COD, Causa, PiezasReutilizables FROM almacen WHERE Equipo_COD = '"
				+ id_actividad + "';";
		
		Statement stmt = connect.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		
		if (rset.next()) {
		String act = ModiActividad.getTxtAct();
		String org = ModiActividad.getTxtOrganizador();
		String tpo= ModiActividad.getTxtTipo();
		String lga = ModiActividad.getTxtLugar();
		String tpa = ModiActividad.getTxtTipoActividad();
		String fca = ModiActividad.getTxtFecha();
		String dst = ModiActividad.getTxtNdestinatarios();
		
		String sql1 = "UPDATE actividad SET nombre = '" + act + "', n_destinatario = '" + dst
				+ "', lugar = '" + lga + "' WHERE id_actividad = '" + id_actividad
				+ "';";
		
		//UPDATE `actividad` SET `nombre` = 'eeee', `n_destinatarios` = '40', `lugar` = 'aaaaa' WHERE `actividad`.`id_actividad` = 8;
		/*
		String sql1 = "UPDATE actividad SET Responsable = '" + responsable + "', Equipo_COD = '" + cod
				+ "', FechadeInicio = '" + fechainicio + "', FechaFin  = '" + fechafin + "',EquipoPrestado ='"
				+ equipoprestado + "', DestinodelPrestamo ='" + destinoprestamo + "' WHERE Equipo_COD = '" + cod
				+ "';";*/
		PreparedStatement stmt2 = connect.prepareStatement(sql1);
		stmt2.executeUpdate();
		stmt2.close();
	}
		stmt.close();
		rset.close();
			
		System.out.println("update prestamo realizado con exito");
		
		cargarDatosTablas();
	} catch (SQLException s) {
		s.printStackTrace();
	}
}
	
	
	public void realizarBusquedaActividad() {
		try {
			
			String id_actividad = VActividades.getBusquedatxt();
			String n_destinatarios = VActividades.getBusquedatxt();
			String lugar = VActividades.getBusquedatxt();
			String descripcion = VActividades.getBusquedatxt();
			
			
			String query;
			if (id_actividad.equals("")) {
					query = "SELECT nombre,n_destinatarios,lugar,descripcion FROM actividad WHERE id_actividad like '%" + id_actividad + "%' and n_destinatarios like '%"+ n_destinatarios +"%' and lugar like '%"+ lugar +"%' and descripcion like '%"+ descripcion +"%' ;";
			} else {
				query = "SELECT nombre,n_destinatarios,lugar,descripcion FROM actividad WHERE id_actividad="
						+ id_actividad + ";";
			}

			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();
			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();
			ArraydatosActividad = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosActividad[i][j] = rset.getString((j + 1));
					}
				}
			}
			VActividades.setActividad(ArraydatosActividad);
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	

	public String[][] getDatosAsociacion() {
		return ArraydatosAsociacion;
	}

	public void setDatosAsociacion(V_Asociaciones asociacion) {
		this.VAsociacion = asociacion;
	}

	public String[][] getArraydatosActividad() {
		return ArraydatosActividad;
	}

	public void setDatosActividad(V_Actividades actividad) {
		this.VActividades = actividad;
	}

	public String[][] getArraySubvencion() {
		return ArraySubvencion;
	}

	public void setDatosSubvencion(V_Subvenciones subvencion) {
		this.VSubvencion = subvencion;
	}
	
	public String[][] getArraySubvencionAmpli() {
		return ArraysDatosActAmpli;
	}
	
	public void setDatosActividadAmpli(V_Actividades_ampliado V_Sub_Amp){
		this.V_Act_Amp = V_Sub_Amp;
	}
	
	public String[][] getArrayAsociacionAmpli(){
		return ArraysDatosAsoAmpli;
	}
	
	public void setDatosAsociacionAmpli(V_Asociaciones_ampliado V_Aso_Amp){
		this.V_Aso_Amp = V_Aso_Amp;
	}

	public void setRSubvencion(V_RegistrarSubvencion rSubvencion) {
		this.RSubvencion = rSubvencion;
	}
	

	public void setRAsociacion(V_RegistrarAsociacion rAsociacion) {
		this.RAsociacion = rAsociacion;
	}
	
	

	public void setRActividad(V_RegistrarActividad rActividad) {
		this.RActividad = rActividad;
	}

	public void cargarDatosTablas() {
		this.DataAso();
		VAsociacion.setAsociacion(ArraydatosAsociacion);
		this.DataActividad();
		VActividades.setActividad(ArraydatosActividad);
		this.DataSubvencion();
		VSubvencion.setSubvencion(ArraySubvencion);
		this.DataSubAmpli();
		V_Act_Amp.setActividadAmpli(ArraysDatosActAmpli);
		this.DataAsoAmpli();
		V_Aso_Amp.setAsociacionAmpli(ArraysDatosAsoAmpli);

	}

}
