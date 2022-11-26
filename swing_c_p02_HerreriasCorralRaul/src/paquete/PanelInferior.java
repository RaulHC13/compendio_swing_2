/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelLateral.java
 * 25 nov 2022 - 17:29:08
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInferior extends JPanel{
	
	private BoxLayout layout;
	public JButton btn1,btn2,btn3;
	
	public PanelInferior() {
		
		layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		this.setBackground(new Color(236,229,206));
		
		btn1 = new JButton("Imprimir");
		btn2 = new JButton("Nuevo");
		btn3 = new JButton("Guardar");
		
		this.add(Box.createHorizontalGlue());
		this.add(btn1);
		this.add(Box.createHorizontalGlue());
		this.add(btn2);
		this.add(Box.createHorizontalGlue());
		this.add(btn3);
		this.add(Box.createHorizontalGlue());
	}
}