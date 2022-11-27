/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelLateral.java
 * 25 nov 2022 - 17:29:08
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInferior extends JPanel{
	
	private BoxLayout layout;
	public JButton btn1,btn2,btn3;
	private ImageIcon iconImprimir, iconNuevo, iconGuardar;
	
	public PanelInferior() {
		
		layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		this.setBackground(new Color(236,229,206));
		
		iconImprimir = new ImageIcon(this.getClass().getResource("/recursos/btnImprimir.png"));
		Image imagen1 = iconImprimir.getImage().getScaledInstance(100, 100, ABORT);
		iconImprimir.setImage(imagen1);
		
		iconNuevo = new ImageIcon(this.getClass().getResource("/recursos/btnNuevo.png"));
		Image imagen2 = iconNuevo.getImage().getScaledInstance(100, 100, ABORT);
		iconNuevo.setImage(imagen2);
		
		iconGuardar = new ImageIcon(this.getClass().getResource("/recursos/btnGuardar.png"));
		Image imagen3 = iconGuardar.getImage().getScaledInstance(100, 100, ABORT);
		iconGuardar.setImage(imagen3);
		
		Font fuente = new Font("Lato Black", Font.PLAIN, 16);
		
		btn1 = new JButton(iconImprimir);
		btn1.setText("    Imprimir a documento");
		btn1.setBackground(null);
		btn1.setFont(fuente);
		btn1.setBorder(null);
		
		btn2 = new JButton(iconNuevo);
		btn2.setText("    Nuevo");
		btn2.setBackground(null);
		btn2.setFont(fuente);
		btn2.setBorder(null);
		
		btn3 = new JButton(iconGuardar);
		btn3.setText("    Guardar");
		btn3.setBackground(null);
		btn3.setFont(fuente);
		btn3.setBorder(null);
		
		this.add(Box.createHorizontalGlue());
		this.add(btn1);
		this.add(Box.createHorizontalGlue());
		this.add(btn2);
		this.add(Box.createHorizontalGlue());
		this.add(btn3);
		this.add(Box.createHorizontalGlue());
	}
}