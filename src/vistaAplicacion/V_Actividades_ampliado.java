package vistaAplicacion;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_Actividades_ampliado extends JFrame {
	private Controller controlador;
	private JScrollPane scrollPane;
	protected JTable table;
	
	public V_Actividades_ampliado() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Actividades");
		setBounds(100, 100, 720, 504);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
        scrollPane = new JScrollPane();
		table = new JTable();
        
        scrollPane.setBounds(27, 11, 673, 453);
        getContentPane().add(scrollPane);
        
        table.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "Asociación", "Fecha", "Actividad", "Importe", "Subvención"
                }
            ));
        scrollPane.setViewportView(table);  
	}
	
	public void setActividadAmpli(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] {
				"Id Actividad", "Nombre", "Destinatario", "Lugar", "Descripcion","Tipo Actividad"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		
	}
	
	public JTable getTable() {
		return table;
	}


	public void setControlador(Controller controlador){
		this.controlador = controlador;
	}
}

