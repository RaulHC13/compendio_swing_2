/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelMain.java
 * 23 nov 2022 - 9:18:08
 * @author Raúl Herrerías Corral
 */
package paquetePrincipal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel de la clase principal
 */
public class PanelMain extends JPanel {

	/** The btn baja. */
	public JButton btnAlta, btnBaja;
	
	/** The icono baja. */
	private ImageIcon iconoAdd, iconoBaja;
	
	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;

	/**
	 * Instantiates a new panel main.
	 */
	public PanelMain() {

		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		Font fuente = new Font("", Font.BOLD, 22);
		
		iconoAdd = new ImageIcon(this.getClass().getResource("/recursos/iconoAlta.png"));
		Image imagen = iconoAdd.getImage().getScaledInstance(180, 180, ABORT);
		iconoAdd.setImage(imagen);

		iconoBaja = new ImageIcon(this.getClass().getResource("/recursos/iconoBaja.png"));
		Image imagen2 = iconoBaja.getImage().getScaledInstance(190, 190, ABORT);
		iconoBaja.setImage(imagen2);

		btnAlta = new JButton("    Alta reserva");
		btnBaja = new JButton("    Baja reserva");
		btnAlta.setFont(fuente);
		btnBaja.setFont(fuente);
		btnAlta.setIcon(iconoAdd);
		btnBaja.setIcon(iconoBaja);
		
		Color fondo = new Color(197,224,220);
		
		this.setBackground(fondo);
		
		constraints.insets = (new Insets(0,60,0,60));
		add(btnAlta, 0,0,1,1);
		
		add(btnBaja, 1,0,1,1);

		btnAlta.setBackground(null);
		btnAlta.setBorder(null);
		
		btnBaja.setBackground(null);
		btnBaja.setBorder(null);
		
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