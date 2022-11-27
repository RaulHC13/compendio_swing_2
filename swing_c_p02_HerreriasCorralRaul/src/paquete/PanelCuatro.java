/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelCuatro.java
 * 26 nov 2022 - 21:26:56
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class PanelCuatro extends JPanel{
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private PanelInformacion panel;
	
	public PanelCuatro()  {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		this.setBackground(new Color(236,229,206));
		
		panel = new PanelInformacion();
		add(panel,0,0,1,1);
	}
	
	private void add(Component componente,int columna, int fila, int ancho,
			int alto) {
			constraints.gridx = columna;
			constraints.gridy = fila;
			constraints.gridwidth = ancho;
			constraints.gridheight = alto;
			layout.setConstraints(componente, constraints);
			this.add(componente);
		}
	
	public void setInfoCliente(String info) {
		panel.setInfoCliente(info);
	}
	
	public void setInfoHabitacion(String info) {
		panel.setInfoHabitacion(info);
	}
	
	public void borrarInfoCliente() {
		panel.borrarInfoCliente();
	}
	
	public void borrarInfoHabitacion() {
		panel.borrarInfoHabitacion();
	}
	
	class PanelInformacion extends JTabbedPane {

		private JTextArea infoCliente,infoHabitacion;
		
		public PanelInformacion() {
			
			Font fuente = new Font("Lato Black", Font.PLAIN, 20);
			
			infoCliente = new JTextArea(16,14);
			infoCliente.setForeground(new Color(13,103,89));
			infoCliente.setFont(fuente);
			infoCliente.setEditable(false);
			
			infoHabitacion = new JTextArea(12,6);
			infoHabitacion.setForeground(new Color(122,179,23));
			infoHabitacion.setFont(fuente);
			infoHabitacion.setEditable(false);
			
			addTab("       Información sobre el cliente       ", infoCliente);
			addTab("       Información sobre la reserva       ", infoHabitacion);
			
		}
		
		private void setInfoCliente(String info) {
			infoCliente.setText(info);
		}
		
		private void borrarInfoCliente() {
			infoCliente.setText("");
		}
		
		private void setInfoHabitacion(String info) {
			infoHabitacion.setText(info);
		}
		private void borrarInfoHabitacion() {
			infoHabitacion.setText("");
		}
	}
}