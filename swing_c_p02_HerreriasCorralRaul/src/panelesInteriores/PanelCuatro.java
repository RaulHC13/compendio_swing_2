/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelCuatro.java
 * 26 nov 2022 - 21:26:56
 * @author Raúl Herrerías Corral
 */
package panelesInteriores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Panel cuatro, JPanel que contiene un JTabbedPane que a su vez tiene dos pestañas
 * que contienen JTextAreas donde se imprime la información de cliente y habitación.
 */
public class PanelCuatro extends JPanel{
	
	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;
	
	/** The panel. */
	private PanelInformacion panel;
	
	/**
	 * Instantiates a new panel cuatro.
	 */
	public PanelCuatro()  {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		this.setBackground(new Color(236,229,206));
		
		panel = new PanelInformacion();
		add(panel,0,0,1,1);
	}
	
	/**
	 * Adds the.
	 *
	 * @param componente the componente
	 * @param columna    the columna
	 * @param fila       the fila
	 * @param ancho      the ancho
	 * @param alto       the alto
	 */
	private void add(Component componente,int columna, int fila, int ancho,
			int alto) {
			constraints.gridx = columna;
			constraints.gridy = fila;
			constraints.gridwidth = ancho;
			constraints.gridheight = alto;
			layout.setConstraints(componente, constraints);
			this.add(componente);
		}
	
	/**
	 * Sets the info cliente.
	 *
	 * @param info the new info cliente
	 */
	public void setInfoCliente(String info) {
		panel.setInfoCliente(info);
	}
	
	/**
	 * Sets the info habitacion.
	 *
	 * @param info the new info habitacion
	 */
	public void setInfoHabitacion(String info) {
		panel.setInfoHabitacion(info);
	}
	
	/**
	 * Borrar info cliente.
	 */
	public void borrarInfoCliente() {
		panel.borrarInfoCliente();
	}
	
	/**
	 * Borrar info habitacion.
	 */
	public void borrarInfoHabitacion() {
		panel.borrarInfoHabitacion();
	}
	
	/**
	 * The Class PanelInformacion.
	 */
	class PanelInformacion extends JTabbedPane {

		/** The info habitacion. */
		private JTextArea infoCliente,infoHabitacion;
		
		/**
		 * Instantiates a new panel informacion.
		 */
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
		
		/**
		 * Escribe en el campo de texto la información recogida en el parámetro.
		 *
		 * @param info the new info cliente
		 */
		private void setInfoCliente(String info) {
			infoCliente.setText(info);
		}
		
		/**
		 * Borrar info cliente.
		 */
		private void borrarInfoCliente() {
			infoCliente.setText("");
		}
		
		/**
		 * Escribe en el campo de texto la información recogida en el parámetro.
		 *
		 * @param info the new info habitacion
		 */
		private void setInfoHabitacion(String info) {
			infoHabitacion.setText(info);
		}
		
		/**
		 * Borrar info habitacion.
		 */
		private void borrarInfoHabitacion() {
			infoHabitacion.setText("");
		}
	}
}