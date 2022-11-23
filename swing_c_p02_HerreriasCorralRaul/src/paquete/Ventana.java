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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame{

	private JMenuBar menu;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, alta, baja, acercaDe;
	private PanelMain panelMain;
	private JButton copia1, copia2;
	
	public Ventana() {
		
		inicializarVentana();
		inicializarComponentes();
		setListeners();
		
		this.setVisible(true);
	}

	private void setListeners() {
		
		copia1 = panelMain.btnAlta;
		copia2 = panelMain.btnBaja;
		
		copia1.addActionListener(e -> prueba());
		copia2.addActionListener(e -> prueba());
		
		salir.addActionListener(e -> salir());
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
	
	private void prueba() {
		
		System.out.println("asdasd");
	}
	
	private void salir() {
		this.dispose();
	}
}