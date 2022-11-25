/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelDialogo.java
 * 25 nov 2022 - 14:26:08
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDialogo extends JPanel{
	
	private PanelUno panelUno;
	private JPanel panel1, panel2, panel3, panel4;
	
	public PanelDialogo() {
		
		this.setLayout(new BorderLayout());
		
		panelUno = new PanelUno();
		
		Border border1 = BorderFactory.createLineBorder(Color.RED, 4, true);
		Border border2 = BorderFactory.createLineBorder(Color.GREEN, 4, true);
		Border border3 = BorderFactory.createLineBorder(Color.BLUE, 4, true);
		Border border4 = BorderFactory.createLineBorder(Color.PINK, 4, true);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		panel1.setBorder(border1);
		panel3.setBorder(border3);
		panel4.setBorder(border4);
		
		this.add(panelUno, BorderLayout.NORTH);
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.WEST);
		this.add(panel4, BorderLayout.SOUTH);
	}
	
}