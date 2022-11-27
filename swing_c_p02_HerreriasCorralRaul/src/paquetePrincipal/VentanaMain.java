/**
 * swing_c_p02_HerreriasCorralRaul - paquete - Ventana.java
 * 23 nov 2022 - 8:24:25
 * @author Raúl Herrerías Corral
 */
package paquetePrincipal;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Ventana main
 */
public class VentanaMain extends JFrame{

	/** The ventana dialogo. */
	private VentanaDialogo ventanaDialogo;
	
	/** The ventana principal. */
	private VentanaMain ventanaPrincipal;
	
	/** The menu. */
	private JMenuBar menu;
	
	/** The ayuda. */
	private JMenu archivo, registro, ayuda;
	
	/** The acerca de. */
	private JMenuItem salir, alta, baja, acercaDe;
	
	/** The panel main. */
	private PanelMain panelMain;
	
	/** The copia 2. */
	private JButton copia1, copia2;
	
	/**
	 * Instantiates a new ventana main.
	 */
	public VentanaMain() {
		
		inicializarVentana();
		inicializarComponentes();
		setListeners();
		
		this.setVisible(true);
	}

	/**
	 * Sets the listeners.
	 */
	private void setListeners() {
		
		copia1 = panelMain.btnAlta;
		copia2 = panelMain.btnBaja;
		
		registro.setMnemonic(KeyEvent.VK_R);
		
		copia1.setMnemonic(KeyEvent.VK_A);
		copia1.addActionListener(e -> altaReservas());
		
		copia2.setMnemonic(KeyEvent.VK_B);
		copia2.addActionListener(e -> bajaReservas());
		
		salir.addActionListener(e -> salir());
		alta.addActionListener(e -> altaReservas());
		baja.addActionListener(e -> bajaReservas());
		acercaDe.addActionListener(e -> acercaDe());
	}

	/**
	 * Inicializar ventana.
	 */
	private void inicializarVentana() {
		
		this.setTitle("Gestion de hotel ---- Hotel La Rueda");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamañoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamañoPantalla.height;
		int anchoPantalla = tamañoPantalla.width;
		
		this.setSize(anchoPantalla/2, altoPantalla/2);
		this.setLocation(anchoPantalla/4, altoPantalla/4);
		
		Image icono = miPantalla.getImage(this.getClass().getResource("/recursos/icono.png"));
		
//		this.setResizable(false);
		this.setIconImage(icono);
	}
	
	/**
	 * Sets the ventana principal.
	 *
	 * @param ventana the new ventana principal
	 */
	public void setVentanaPrincipal(VentanaMain ventana) {
		ventanaPrincipal = ventana;
	}
	
	/**
	 * Inicializar componentes.
	 */
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
	
	/**
	 * Baja reservas.
	 */
	private void bajaReservas() {
		JOptionPane.showMessageDialog(this, "Esta opción aun está en desarrollo", 
				"Baja reservas", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Salir.
	 */
	private void salir() {
		this.dispose();
	}
	
	/**
	 * Alta reservas.
	 */
	private void altaReservas() {
		ventanaDialogo = new VentanaDialogo(this, true);
		ventanaDialogo.setVisible(true);
	}
	
	/**
	 * Acerca de.
	 */
	private void acercaDe() {
		JOptionPane.showMessageDialog(this, "Aplicación para reservas Hotel La Rueda" + 
	"\n© 2022 Raúl Herrerías Corral. All rights reserved.", 
				"Acerca de", JOptionPane.INFORMATION_MESSAGE);
	}
}