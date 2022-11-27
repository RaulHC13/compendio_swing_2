/*
 * 
 */
package paquetePrincipal;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * Ventana dialogo
 */
public class VentanaDialogo extends JDialog{
	
	/** The panel dialogo. */
	private PanelDialogo panelDialogo;
	
	/** The ancho pantalla. */
	private int anchoPantalla;

	/**
	 * Instantiates a new ventana dialogo.
	 *
	 * @param ventana the ventana
	 * @param modal   the modal
	 */
	public VentanaDialogo(VentanaMain ventana, boolean modal) {
		super(ventana, modal);
		
		iniciarVentana();
	}

	/**
	 * Iniciar ventana.
	 */
	private void iniciarVentana( ) {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamañoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamañoPantalla.height;
			anchoPantalla = tamañoPantalla.width;
		
		Image icono = miPantalla.getImage(this.getClass().getResource("/recursos/icono.png"));
		
		panelDialogo = new PanelDialogo();
		
		this.setSize(anchoPantalla,altoPantalla);
		this.setTitle("Alta Reservas");
		this.setIconImage(icono);
		this.add(panelDialogo);
	}
	
}