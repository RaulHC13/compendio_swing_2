/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelLateral.java
 * 25 nov 2022 - 17:29:08
 * @author Raúl Herrerías Corral
 */
package panelesExteriores;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * Panel inferior, contiene los botones imprimir, nuevo y guardar, al igual que contiene
 * la barra de progreso.
 */
public class PanelInferior extends JPanel{
	
	/** The layout. */
	private BoxLayout layout;
	
	/** The icon guardar. */
	private ImageIcon iconImprimir, iconNuevo, iconGuardar;
	
	/** The btn 3. */
	public JButton btn1,btn2,btn3;
	
	/** The bar. */
	public JProgressBar bar;
	
	/**
	 * Instantiates a new panel inferior.
	 */
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
		
		bar = new JProgressBar(0,100);
		bar.setSize(new Dimension(100,100));
		bar.setToolTipText("Mover el cursor por este componente muestra el progreso del formulario.");
		
		
		this.add(Box.createHorizontalGlue());
		this.add(btn1);
		this.add(Box.createHorizontalGlue());
		this.add(btn2);
		this.add(Box.createHorizontalGlue());
		this.add(btn3);
		this.add(Box.createHorizontalGlue());
		this.add(bar);
		this.add(Box.createHorizontalGlue());
	}
	
	/**
	 * Da como valor a la JProgressBar el parametro progreso
	 * y también cambia el color de la barra.
	 *
	 * @param progreso the new progreso
	 */
	public void setProgreso(int progreso) {
			bar.setValue(progreso);
			
			switch (progreso) {
			case 50:
				bar.setForeground(Color.ORANGE);
				break;
			case 100:
				bar.setForeground(Color.GREEN);
				break;
			}
	}
}