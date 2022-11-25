/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelCentro.java
 * 25 nov 2022 - 17:03:16
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCentro extends JPanel {

	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private JLabel label1, label2;
	public PanelDos panelDos;
	
	public PanelCentro() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBackground(new Color(236,229,206));
		
		constraints = new GridBagConstraints();
		
		label1 = new JLabel("asd");
		label2 = new JLabel("WWW");
		
		panelDos = new PanelDos();
		
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(40,40,0,0);
		this.add(panelDos, 1,1,4,4);
		
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
}