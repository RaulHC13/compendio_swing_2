/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelCentro.java
 * 25 nov 2022 - 17:03:16
 * @author Raúl Herrerías Corral
 */
package panelesExteriores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import panelesInteriores.PanelCuatro;
import panelesInteriores.PanelDos;
import panelesInteriores.PanelTres;

/**
 * Panel central, panel que contiene los paneles 2 3 y 4.
 * Es un GridBagLayout.
 */
public class PanelCentro extends JPanel {

	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;
	
	/** The label 2. */
	private JLabel label1, label2;
	
	/** The panel dos. */
	public PanelDos panelDos;
	
	/** The panel tres. */
	public PanelTres panelTres;
	
	/** The panel cuatro. */
	public PanelCuatro panelCuatro;
	
	/**
	 * Instantiates a new panel centro.
	 */
	public PanelCentro() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBackground(new Color(236,229,206));
		
		Font fuente = new Font("Lato Black", Font.BOLD, 24);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weightx = 1;
		constraints.weighty = 1;
		
		label1 = new JLabel("Datos personales");
		label1.setFont(fuente);
		label1.setForeground(new Color(13,103,89));
		constraints.insets = new Insets(20,40,0,0);
		this.add(label1,0,0,1,1);
		
		panelDos = new PanelDos();
		constraints.insets = new Insets(0,40,40,0);
		this.add(panelDos, 0,1,1,1);
		
		label2 = new JLabel("Datos reserva");
		label2.setFont(fuente);
		label2.setForeground(new Color(122,179,23));
		constraints.insets = new Insets(0,40,0,0);
		this.add(label2,0,2,1,1);
		
		panelTres = new PanelTres();
//		constraints.insets = new Insets(30,40,100,0);
		this.add(panelTres, 0,3,2,1);
		
		panelCuatro = new PanelCuatro();
//		constraints.insets = new Insets(40,40,100,0);
		this.add(panelCuatro,1,1,3,3);
		
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
}