/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelMain.java
 * 23 nov 2022 - 9:18:08
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMain extends JPanel {

	public JButton btnAlta, btnBaja;
	private ImageIcon iconoAdd, iconoBaja;
	
	public PanelMain() {
		
		this.setLayout(null);
		
		iconoAdd = new ImageIcon(this.getClass().getResource("/recursos/iconoAlta.png"));
		Image imagen = iconoAdd.getImage().getScaledInstance(170, 180, ABORT);
		iconoAdd.setImage(imagen);

		iconoBaja = new ImageIcon(this.getClass().getResource("/recursos/iconoBaja.png"));
		Image imagen2 = iconoBaja.getImage().getScaledInstance(200, 290, ABORT);
		iconoBaja.setImage(imagen2);
		
		btnAlta = new JButton("Alta reserva");
		btnBaja = new JButton("Baja reserva");
		btnAlta.setIcon(iconoAdd);
		btnBaja.setIcon(iconoBaja);
	
		btnAlta.setBounds(100,120,340,220);
		btnBaja.setBounds(500,120,340,220);
		
		this.add(btnAlta);
		this.add(btnBaja);
	}
}