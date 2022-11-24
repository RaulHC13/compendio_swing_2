/**
 * swing_c_p02_HerreriasCorralRaul - paquete - Ventana.java
 * 23 nov 2022 - 8:24:25
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame{

	private VentanaDialogo ventanaDialogo;
	private VentanaPrincipal ventanaPrincipal;
	private JMenuBar menu;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, alta, baja, acercaDe;
	private PanelMain panelMain;
	private JButton copia1, copia2;
	
	public VentanaPrincipal() {
		
		inicializarVentana();
		inicializarComponentes();
		setListeners();
		
		
		this.setVisible(true);
	}

	private void setListeners() {
		
		copia1 = panelMain.btnAlta;
		copia2 = panelMain.btnBaja;
		
		//ALT Q PROVISIONAL
		registro.setMnemonic(KeyEvent.VK_Q);
		
		copia1.setMnemonic(KeyEvent.VK_A);
		copia1.addActionListener(e -> altaReservas());
		
		copia2.setMnemonic(KeyEvent.VK_B);
		copia2.addActionListener(e -> bajaReservas());
		
		salir.addActionListener(e -> salir());
		alta.addActionListener(e -> altaReservas());
		baja.addActionListener(e -> bajaReservas());
		acercaDe.addActionListener(e -> acercaDe());
	}

	private void inicializarVentana() {
		
		this.setTitle("Gestion de hotel ---- Herrerias Corral Raul");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamañoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamañoPantalla.height;
		int anchoPantalla = tamañoPantalla.width;
		
		this.setSize(anchoPantalla/2, altoPantalla/2);
		this.setLocation(anchoPantalla/4, altoPantalla/4);
		
		Image icono = miPantalla.getImage(this.getClass().getResource("/recursos/icono.png"));
		
		this.setResizable(false);
		this.setIconImage(icono);
	}
	
	public void setVentanaPrincipal(VentanaPrincipal ventana) {
		ventanaPrincipal = ventana;
	}
	
	private void inicializarComponentes() {
		
		menu = new JMenuBar();
		
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");
		
		salir = new JMenuItem("Salir");
		alta = new JMenuItem("Alta reservas");
		baja = new JMenuItem("Baja reservas");
		acercaDe = new JMenuItem("Acerca de");
		
		panelMain = new PanelMain();
		panelMain.setBackground(Color.RED);
		
		archivo.add(salir);
		
		registro.add(alta);
		registro.add(baja);
		
		ayuda.add(acercaDe);
		
		menu.add(archivo);
		menu.add(registro);
		menu.add(ayuda);
		
		this.add(panelMain);
		
		this.setJMenuBar(menu);
	}
	
	private void bajaReservas() {
		JOptionPane.showMessageDialog(this, "Esta opción aun está en desarrollo", 
				"Baja reservas", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private void salir() {
		this.dispose();
	}
	
	private void altaReservas() {
		ventanaDialogo = new VentanaDialogo(this, true);
		ventanaDialogo.setVisible(true);
	}
	
	private void acercaDe() {
		JOptionPane.showMessageDialog(this, "La empresarial empresa está empresariando.", 
				"Acerca de", JOptionPane.INFORMATION_MESSAGE);
	}
}