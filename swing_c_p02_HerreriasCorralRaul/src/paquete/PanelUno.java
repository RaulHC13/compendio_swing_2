/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelUno.java
 * 25 nov 2022 - 11:22:17
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelUno extends JPanel {
	
	private JLabel nombre;
	private BoxLayout layout;

	public PanelUno() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 4, true);
		Color fondo = new Color(241, 212, 175);
		
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