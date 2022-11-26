/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelCentro.java
 * 25 nov 2022 - 17:03:16
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
	public PanelTres panelTres;
	
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
		label1.setForeground(new Color(85,98,112));
		constraints.insets = new Insets(10,40,0,0);
		this.add(label1,0,0,1,2);
		
		panelDos = new PanelDos();
		constraints.insets = new Insets(40,40,0,0);
		this.add(panelDos, 0,1,1,1);
		
		label2 = new JLabel("Datos reserva");
		label2.setFont(fuente);
		label2.setForeground(new Color(85,98,112));
		constraints.insets = new Insets(10,40,0,0);
		this.add(label2,0,2,1,2);
		
		panelTres = new PanelTres();
		constraints.insets = new Insets(40,40,100,0);
		this.add(panelTres, 0,3,1,1);
		
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
	
	public void esconderDos() {
		label1.setVisible(false);
		panelDos.setVisible(false);
	}
	
	public void mostrarDos() {
		label1.setVisible(true);
		panelDos.setVisible(true);
	}
	
	public void esconderNiños() {
		panelTres.esconderPanel();
	}
	
	public void mostrarNiños() {
		panelTres.mostrarPanel();
	}
}