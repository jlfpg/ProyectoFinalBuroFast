package controladorAplicacion;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import modeloAplicacion.Modelo;

import vistaAplicacion.*;

public class Controller {
	private V_Actividades vistAc;
	private V_Subvenciones vistSub;
	private V_ModificarSubvencion vistaMS;
	private V_RegistrarSubvencion vistaRS;
	private V_RegistrarAsociacion vistaRegistro;
	private V_ModificarActividad vistaMA;
	private V_RegistrarActividad vistaRA;
	private V_ModificarAsociacion vistaMAs;
	private V_Login vistaL;
	private V_Asociaciones vistaAs;
	private V_Configuracion vistaC;
	private V_InfoAsociacion vistaDetalle;
	private Modelo database;
	private Modelo Rsubvencion;
	private Modelo Rasociacion;
	private Modelo Ractividad;
	private V_Actividades_ampliado V_Act_amp;
	private V_Asociaciones_ampliado V_Aso_Amp;

	public Controller(V_Actividades vistAc, V_Subvenciones vistSub, V_ModificarSubvencion vistaMS,
			V_RegistrarSubvencion vistaRs, V_RegistrarAsociacion vistaRegistro, V_ModificarActividad vistaMA,
			V_RegistrarActividad vistaRA, V_ModificarAsociacion vistaMAs, V_Login vistaL, V_Asociaciones vistaAs,
			V_Configuracion vistaC, Modelo database,V_InfoAsociacion vistaDetalle,V_Actividades_ampliado V_Act_amp,V_Asociaciones_ampliado V_Aso_Amp) {
		this.vistAc = vistAc;
		this.vistSub = vistSub;
		this.vistaMS = vistaMS;
		this.vistaRS = vistaRs;
		this.vistaRegistro = vistaRegistro;
		this.vistaRA = vistaRA;
		this.vistaMA = vistaMA;
		this.vistaMAs = vistaMAs;
		this.vistaL = vistaL;
		this.vistaAs = vistaAs;
		this.vistaC = vistaC;
		this.vistaDetalle = vistaDetalle;
		this.database = database;
		this.V_Act_amp = V_Act_amp;
		this.V_Aso_Amp = V_Aso_Amp;

	}

	public void guardarConfiguracion() {
		String user = vistaC.getUserTxt().getText();
		String pwd = vistaC.getPwdTxt().getText();
		String url = vistaC.getUrlTxt().getText();
		String db = vistaC.getDbTxt().getText();
		database.guardarDatos(user, pwd, url, db);
		vistaC.dispose();
	}

	public void cargarDatos() {
		database.cargarDatosTablas();
	}

	public void cambiarAsociacion() {
		vistaAs.setVisible(true);
		vistAc.dispose();
		vistaRegistro.dispose();
		vistSub.dispose();
		vistaC.dispose();
	}

	public void cambiarSubvenciones() {
		vistSub.setVisible(true);
		vistAc.dispose();
		vistaRegistro.dispose();
		vistaAs.dispose();
		vistaC.dispose();
	}

	public void cambiarActividad() {
		vistAc.setVisible(true);
		vistSub.dispose();
		vistaRegistro.dispose();
		vistaAs.dispose();
		vistaC.dispose();
	}

	public void cambiarRegistrar() {
		vistaRegistro.setVisible(true);
		vistSub.dispose();
		vistAc.dispose();
		vistaAs.dispose();
		vistaC.dispose();
	}

	public void mostrarBotonVistaAc() {
		if (vistAc.getTable().getSelectedRow() != -1 && vistAc.getTable().getModel()
				.getValueAt(vistAc.getTable().getSelectedRow(), vistAc.getTable().getSelectedColumn()) != null) {
			vistAc.getBtnEliminar().setEnabled(true);
			vistAc.getbtnModificar().setEnabled(true);
		} else {
			vistAc.getBtnEliminar().setEnabled(false);
			vistAc.getbtnModificar().setEnabled(false);
		}
	}
/*
	public void mostrarBotonLimpiarAc() {
		if (vistAc.getBusquedatxt().getText().length() != 0) {
			vistAc.getBtnLimpiar().setEnabled(true);
		} else {
			vistAc.getBtnLimpiar().setEnabled(false);
		}
	}*/

	public void mostrarBotonVistaSub() {
		if (vistSub.getTable().getSelectedRow() != -1 && vistSub.getTable().getModel()
				.getValueAt(vistSub.getTable().getSelectedRow(), vistSub.getTable().getSelectedColumn()) != null) {
			vistSub.getBtnEliminar().setEnabled(true);
			vistSub.getBtnModificar().setEnabled(true);
		} else {
			vistSub.getBtnEliminar().setEnabled(false);
			vistSub.getBtnModificar().setEnabled(false);
		
		}
	}

	public void mostrarBotonLimpiarSub() {
		if (vistSub.getBusquedatxt().getText().length() != 0) {
			vistSub.getBtnLimpiar().setEnabled(true);
		} else {
			vistSub.getBtnLimpiar().setEnabled(false);
		}
	}

	public void mostrarBotonVistaAs() {
		if (vistaAs.getTable().getSelectedRow() != -1 && vistaAs.getTable().getModel().getValueAt(vistaAs.getTable().getSelectedRow(), vistaAs.getTable().getSelectedColumn()) != null) {
			vistaAs.getbtnEliminar().setEnabled(true);
			vistaAs.getbtnModificar().setEnabled(true);
			vistaAs.getbtnDetalle().setEnabled(true);
		} else {
			vistaAs.getbtnEliminar().setEnabled(false);
			vistaAs.getbtnModificar().setEnabled(false);
			vistaAs.getbtnDetalle().setEnabled(false);
		}
	}

	public void mostrarBotonLimpiarAs() {
		if (vistaAs.getTextField().getText().length() != 0) {
			vistaAs.getbtnLimpiar().setEnabled(true);
		} else {
			vistaAs.getbtnLimpiar().setEnabled(false);
		}
	}

	public void mostrarBotonVistaConf() {
		if (vistaC.getPwdTxt().getText().length() != 0 && vistaC.getUserTxt().getText().length() != 0
				&& vistaC.getUrlTxt().getText().length() != 0 && vistaC.getDbTxt().getText().length() != 0)
			vistaC.getBtnAceptar().setEnabled(true);
		else
			vistaC.getBtnAceptar().setEnabled(false);
	}
	
	public void altaSubvencion( String Asociacion, String Importe, String Fecha ,
			String Actividad, String estado){
		database.registrarSubvencion(Asociacion, Importe, Fecha, Actividad, estado);
	}
	 
	public void altaAsociacion(String CIF, String nombre, String direccion, String municipio, String cod_postal, String email, 
			String telf_fijo, String tel_movil, String fax, String CIF2, String tipo){
		database.registrarAsociacion(CIF, nombre, direccion, municipio, cod_postal, email, telf_fijo, tel_movil, fax,CIF2 ,tipo);
	}
	
	public void altaActividad(String nombre, String n_destinatario, String lugar){
		database.registrarActividad(nombre, n_destinatario, lugar);
	}
	
	public void BorrarAsociaciones() throws SQLException{
		int row = vistaAs.getTable().getSelectedRow();
		String ASO = (String)vistaAs.getTable().getValueAt(row, 0);
		database.BorrarAsociacion(ASO);
		
	}
	
	public void BorrarSubvenciones() throws SQLException{
		int row1 = vistSub.getTable().getSelectedRow();
		String SUB = (String)vistSub.getTable().getValueAt(row1, 0);
		database.BorrarSubvencion(SUB);
		
	}
	public void BorrarActividad() throws SQLException{
		int row2 = vistAc.getTable().getSelectedRow();
		String ACT = (String)vistAc.getTable().getValueAt(row2, 0);
		database.BorrarActividad(ACT);
		
	}
	
	public void modificarAct(){
		database.ModificarActividad();
	}
	
	public void BusquedaActividad(){
		database.realizarBusquedaActividad();
		//database.CargarActividad(vistaMA.getTxtAct());
	}
	
	public void setRsubvencion(Modelo rsubvencion) {
		this.Rsubvencion = rsubvencion;
	}
	
	public void setRactividad(Modelo ractividad){
		this.Ractividad=ractividad;
	}
	
	public void setRasociacion(Modelo rasociacion){
		this.Rasociacion=rasociacion;
	}

	public void ampliarActividad(){
		V_Act_amp.setVisible(true);
	}
	
	public void cerrarAmpliAct(){
		V_Act_amp.dispose();
	}
	
	public void ampliarAsociacion(){
		V_Aso_Amp.setVisible(true);
	}
	
	public void cerrarAmpliAso(){
		V_Aso_Amp.dispose();
	}

	public void cambiarModificarSub() {
		vistaMS.setVisible(true);
	}

	public void cambiarRegistrarSub() {
		vistaRS.setVisible(true);
	}

	public void cambiarModificarAct() {
		vistaMA.setVisible(true);
	}

	public void cambiarModificarAsoc() {
		vistaMAs.setVisible(true);
	}
	
	public void cambiarVistaDetalle() {
		vistaDetalle.setVisible(true);
	}
	
	public void cerrarMAsociacion() {
		vistaMAs.dispose();
	}

	public void cambiarRegistrarAct() {
		vistaRA.setVisible(true);
	}

	public void cerrarMSubvencion() {
		vistaMS.dispose();
	}

	public void cerrarRSubvencion() {
		vistaRS.dispose();
	}

	public void cerrarMActividad() {
		vistaMA.dispose();
	}

	public void cerrarRActividad() {
		vistaRA.dispose();
	}

	public void cambiarConfiguracion() {
		vistaC.setVisible(true);
	}

	public void cerrarConfiguracion() {
		vistaC.dispose();
	}

	public void logearse() {
		String Contrasena = "1";
		String Pass = new String(vistaL.getPasswordField().getPassword());
		if (Pass.equals(Contrasena)) {
			vistaAs.setVisible(true);
			vistaL.dispose();
		} else {
			JOptionPane.showMessageDialog(vistaL, "Codigo incorrecto");
		}
	}
	
	public void mensajeMasociacion(){
		JOptionPane.showMessageDialog(vistaMAs, "Se ha modificado correctamente");
	}
	
	public void mensajeRasociacion(){
		JOptionPane.showMessageDialog(vistaRegistro, "Se ha registrado correctamente");
	}	
	
	public void mensajeMsubvencion(){
		JOptionPane.showMessageDialog(vistaMS, "Se ha modificado correctamente");
	}
	
	public void mensajeRsubvencion(){
		JOptionPane.showMessageDialog(vistaRS, "Se ha registrado correctamente");
	}
	
	public void mensajeMactividad(){
		JOptionPane.showMessageDialog(vistaMA, "Se ha modificado correctamente");
	}
	
	public void mensajeRactividad(){
		JOptionPane.showMessageDialog(vistaMA, "Se ha registrado correctamente");
	}
	

}
