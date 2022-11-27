/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelUno.java
 * 25 nov 2022 - 11:22:17
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelUno extends JPanel {
	
	private JLabel nombre;
	private GridBagLayout layout;

	public PanelUno() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBackground(new Color(236,229,206));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 6, true);
		Color fondo = new Color(224, 142, 121);
		
		Font fuente = new Font("Lato Black", Font.PLAIN, 60);
		Color color = new Color(53,92,140);
		
		nombre = new JLabel("Hotel La Rueda. Reserva de habitaciones");
		nombre.setFont(fuente);
		nombre.setForeground(color);
		
		this.setBorder(border);
		this.setBackground(fondo);
		this.add(nombre);
	}
}