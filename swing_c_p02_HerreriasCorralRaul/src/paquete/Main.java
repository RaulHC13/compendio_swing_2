/**
 * swing_c_p02_HerreriasCorralRaul - paquete - Main.java
 * 23 nov 2022 - 8:24:21
 * @author Raúl Herrerías Corral
 */
package paquete;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		VentanaMain ventanaPrincipal = new VentanaMain();
		
		ventanaPrincipal.setVentanaPrincipal(ventanaPrincipal);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.setVisible(true);
	}
}