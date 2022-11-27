/**
 * swing_c_p02_HerreriasCorralRaul - paquete - Main.java
 * 23 nov 2022 - 8:24:21
 * @author Raúl Herrerías Corral
 */
package paquetePrincipal;

import javax.swing.JFrame;

/**
 * Clase principal
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		VentanaMain ventanaPrincipal = new VentanaMain();
		
		ventanaPrincipal.setVentanaPrincipal(ventanaPrincipal);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.setVisible(true);
	}
}