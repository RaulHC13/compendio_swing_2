package paquete;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class VentanaDialogo extends JDialog{
	
	private JLabel label1, label2;

	public VentanaDialogo(VentanaPrincipal ventana, boolean modal) {
		super(ventana, modal);
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		label1 = new JLabel("asd");
		label2 = new JLabel("asdasd");
	}
}