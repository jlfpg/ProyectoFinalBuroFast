package ejecutable;

import controladorAplicacion.Controller;
import modeloAplicacion.Modelo;
import vistaAplicacion.V_Actividades;
import vistaAplicacion.V_Asociaciones;
import vistaAplicacion.V_Configuracion;
import vistaAplicacion.V_InfoAsociacion;
import vistaAplicacion.V_Login;
import vistaAplicacion.V_ModificarActividad;
import vistaAplicacion.V_ModificarAsociacion;
import vistaAplicacion.V_ModificarSubvencion;
import vistaAplicacion.V_RegistrarActividad;
import vistaAplicacion.V_RegistrarAsociacion;
import vistaAplicacion.V_RegistrarSubvencion;
import vistaAplicacion.V_Subvenciones;
import vistaAplicacion.V_Asociaciones_ampliado;
import vistaAplicacion.V_Actividades_ampliado;

public class BuroFast{
	BuroFast() {
		super();
	}
	
	public static void main(String[] args) { 
		V_Actividades ventanaAct = new V_Actividades();
		V_Subvenciones ventanaSub = new V_Subvenciones();
		V_ModificarSubvencion ventanaMS = new V_ModificarSubvencion();
		V_RegistrarSubvencion ventanaRs = new V_RegistrarSubvencion();
		V_RegistrarAsociacion ventanaRegistro = new V_RegistrarAsociacion();
		V_RegistrarActividad ventanaRA = new V_RegistrarActividad();
		V_ModificarActividad ventanaMA = new V_ModificarActividad();
		V_ModificarAsociacion ventanaMAs = new V_ModificarAsociacion(); 
		V_Configuracion ventanaC = new V_Configuracion();
		V_Asociaciones ventanaAs = new V_Asociaciones();
		V_InfoAsociacion ventanaDetalle = new V_InfoAsociacion();
		V_Login ventanaL = new V_Login();
		Modelo connection = new Modelo();
		V_Asociaciones_ampliado V_Aso_Amp = new V_Asociaciones_ampliado();
		V_Actividades_ampliado V_Act_amp = new V_Actividades_ampliado();
		Controller controlador = new Controller(ventanaAct ,ventanaSub,ventanaMS,ventanaRs, ventanaRegistro,ventanaMA,ventanaRA,ventanaMAs,ventanaL,ventanaAs,ventanaC,connection,ventanaDetalle,V_Act_amp,V_Aso_Amp);
		
		connection.setDatosAsociacion(ventanaAs);
		connection.setDatosActividad(ventanaAct);
		connection.setDatosSubvencion(ventanaSub);
		connection.setDatosActividadAmpli(V_Act_amp);
		connection.setDatosAsociacionAmpli(V_Aso_Amp);
		connection.cargarDatosTablas();
		
		ventanaAct.setControlador(controlador);
		ventanaSub.setControlador(controlador);
		ventanaMS.setControlador(controlador);
		ventanaRs.setControlador(controlador);
		ventanaRegistro.setControlador(controlador);
		ventanaC.setControlador(controlador);
		ventanaMA.setControlador(controlador);
		ventanaRA.setControlador(controlador);
		ventanaMAs.setControlador(controlador);
		ventanaL.setControlador(controlador);
		ventanaAs.setControlador(controlador);
		ventanaL.setVisible(true);
	}
}
