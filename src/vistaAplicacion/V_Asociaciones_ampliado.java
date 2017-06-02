package vistaAplicacion;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladorAplicacion.Controller;

public class V_Asociaciones_ampliado extends JFrame {

	private Controller controlador;
	private JScrollPane scrollPane;
	protected JTable table;
	
	public V_Asociaciones_ampliado() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Actividades");
		setBounds(100, 100, 1609, 504);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
        scrollPane = new JScrollPane();
		table = new JTable();
        
        scrollPane.setBounds(27, 11, 1566, 453);
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
	
	public void setAsociacionAmpli(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] {
				"CIF", "Nombre", "Direccion", "Municipio", "C.P","E-Mail","Telefono Fijo","Documentacion","Estatuto","Certificado Social",
				"Numero Asociacion","Acta","Fecha Solicitud",
				"Telefono movil","Fax","Representante","Categoria"}));
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
