package paquete;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaDialogo extends JDialog{
	
	private JPanel panelDialogo;
	private JLabel label1, label2;
	private PanelUno panelUno;
	private int anchoPantalla;

	public VentanaDialogo(VentanaMain ventana, boolean modal) {
		super(ventana, modal);
		
		iniciarVentana();
		iniciarComponentes();
	}

	private void iniciarVentana( ) {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamañoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamañoPantalla.height;
			anchoPantalla = tamañoPantalla.width;
		
		Image icono = miPantalla.getImage(this.getClass().getResource("/recursos/icono.png"));
		
		this.setSize(anchoPantalla,altoPantalla);
		this.setTitle("Alta Reservas");
		this.setIconImage(icono);
	}
	
	private void iniciarComponentes() {
		
		panelDialogo = new JPanel();
		panelDialogo.setLayout(null);
		
		inicializarPanelUno();
		
		label1 = new JLabel("asd");
		label2 = new JLabel("asdasd");
		
		label1.setBounds(200,200,200,200);
		panelDialogo.add(panelUno);
		panelDialogo.add(label1);
		
		add(panelDialogo);
		panelDialogo.setVisible(true);
	}
	
	private void inicializarPanelUno() {
		
		panelUno = new PanelUno();
		panelUno.setBounds(0,0,anchoPantalla, 100);
	}
}