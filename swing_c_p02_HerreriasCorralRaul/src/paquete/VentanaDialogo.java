package paquete;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaDialogo extends JDialog{
	
	private PanelDialogo panelDialogo;
	private int anchoPantalla;

	public VentanaDialogo(VentanaMain ventana, boolean modal) {
		super(ventana, modal);
		
		iniciarVentana();
	}

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