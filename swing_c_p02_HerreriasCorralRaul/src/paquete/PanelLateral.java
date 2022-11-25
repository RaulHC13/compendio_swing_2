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
import javax.swing.JToggleButton;

public class PanelLateral extends JPanel{
	
	private BoxLayout layout;
	public JToggleButton btn1,btn2,btn3;
	
	public PanelLateral() {
		
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.setBackground(new Color(236,229,206));
		
		btn1 = new JToggleButton("Panel dos");
		btn2 = new JToggleButton("asdaaa");
		btn3 = new JToggleButton("qweqwe");
		
		this.add(Box.createVerticalGlue());
		this.add(btn1);
		this.add(Box.createVerticalGlue());
		this.add(btn2);
		this.add(Box.createVerticalGlue());
		this.add(btn3);
		this.add(Box.createVerticalGlue());
	}
}