/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelTres.java
 * 26 nov 2022 - 15:28:02
 * @author Raúl Herrerías Corral
 */
package panelesInteriores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 * Panel tres, se recoge la información de la habitación mediante un formulario.
 * Contiene un panel niños que se muestra u oculta dependiendo de si la JCheckBox CB está
 * o no seleccionada.
 * Contiene un panel imagenes que siempre se muestra.
 */
public class PanelTres extends JPanel{

	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;
	
	/** The label importe. */
	private JLabel labelTipo, labelNiños, labelHabitacion, labelPintura, labelNum, labelImporte;
	
	/** The spinner habitaciones. */
	private JSpinner spinnerHabitaciones;
	
	/** The T aimporte. */
	public JTextArea TAextras, TAimporte;
	
	/** The cb. */
	public JCheckBox CB;
	
	/** The spinner edad. */
	public JSpinner spinnerEdad;
	
	/** The tipo habitacion. */
	public JComboBox<String> tipoHabitacion;
	
	/** The panel niños. */
	private PanelNiños panelNiños;
	
	/** The panel imagenes. */
	private PanelImagenes panelImagenes;
	
	/** The precio total. */
	private int precioHabitacion, precioTotal;
	
	/**
	 * Instantiates a new panel tres.
	 */
	public PanelTres() {
		
		inicializarComponentes();
		
	}

	/**
	 * Inicializar componentes.
	 */
	private void inicializarComponentes() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		this.setBackground(new Color(241,212,175));
		
		Border border = BorderFactory.createDashedBorder(Color.BLACK,
				4, 4, 4, true);
		this.setBorder(border);
		
		Font fuente = new Font("Lato Black", Font.PLAIN, 18);
		Color color = new Color(122,179,23);
		
		labelTipo = new JLabel("Tipo de habitación");
		labelTipo.setFont(fuente);
		labelTipo.setForeground(color);
		constraints.insets = new Insets(20,20,20,0);
		add(labelTipo,0,0,1,1);
		
		String[] arrayTipos = new String[]{"Simple","Doble","Suite"};
		tipoHabitacion = new JComboBox<>(arrayTipos);
		tipoHabitacion.setForeground(color);
		constraints.insets = new Insets(20,20,20,20);
		add(tipoHabitacion, 1,0,1,1);
	
		labelNum = new JLabel("Nº de habitaciones");
		labelNum.setFont(fuente);
		labelNum.setForeground(color);
		constraints.insets = new Insets(20,20,20,0);
		add(labelNum,0,1,1,1);
		

		SpinnerNumberModel modelo = new SpinnerNumberModel(0,0,50,1);
		spinnerHabitaciones = new JSpinner(modelo);
		constraints.insets = new Insets(20,20,20,0);
		add(spinnerHabitaciones,1,1,1,1);
		
		CB = new JCheckBox("¿Niños?");
		CB.setFont(fuente);
		CB.setBackground(new Color(241,212,175));
		CB.setForeground(color);
		constraints.insets = new Insets(10,0,10,0);
		add(CB,0,2,2,1);
		
		labelImporte = new JLabel("Importe habitación");
		labelImporte.setFont(fuente);
		labelImporte.setForeground(color);
		constraints.insets = new Insets(10,0,10,10);
		add(labelImporte,2,1,1,1);
		
		TAimporte = new JTextArea(1,16);
		TAimporte.setFont(fuente);
		TAimporte.setEditable(false);
		constraints.insets = new Insets(10,0,10,10);
		add(TAimporte,2,2,1,1);
		
		panelImagenes = new PanelImagenes();
		add(panelImagenes,0,0,1,1);
		
		panelNiños = new PanelNiños();
		add(panelNiños,0,1,1,1);
		panelNiños.setVisible(false);
		
	}
	
	/**
	 * Calcula el importe, recibiendo como parametro el número de dias de estancia.
	 *
	 * @param numDias the num dias
	 */
	public void calcularImporte(int numDias) {
		
		String tipo = tipoHabitacion.getSelectedItem().toString();
		int precioUnidad = 0;
		
		switch (tipo) {
		
		case "Simple":
			precioUnidad = 50;
			break;
		case "Doble":
			precioUnidad = 75;
			break;
		case "Suite":
			precioUnidad = 125;
			break;
		}
		
		if (panelNiños.isVisible()) precioUnidad += 20;
		 precioHabitacion = precioUnidad * numDias;
		 int numHabitaciones = (int) spinnerHabitaciones.getValue();
		 precioTotal = precioHabitacion * numHabitaciones;
		
	}
	
	/**
	 * Escribe el importe en el area de texto.
	 */
	public void setImporte() {
		
		TAimporte.setText(String.valueOf(precioHabitacion + "€ por habitación, Total: " + precioTotal + "€"));
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
	
	/**
	 * Mostrar panel.
	 */
	public void mostrarPanel() {
		panelNiños.setVisible(true);
	}
	
	/**
	 * Esconder panel.
	 */
	public void esconderPanel() {
		panelNiños.setVisible(false);
	}
	
	/**
	 * Editar extras.
	 */
	public void editarExtras() {
		panelNiños.editarExtras();
	}
	
	/**
	 * Cambiar imagen.
	 */
	public void cambiarImagen() {
		panelImagenes.cambiarImagen();
	}
	
	/**
	 * Comprueba que los campos sean validos.
	 *
	 * @return true, if successful
	 */
	public boolean camposValidos() {
		
		boolean numHabitaciones = (int) spinnerHabitaciones.getValue() > 0 && 
								  (int) spinnerHabitaciones.getValue() <= 50;
		
		boolean edadNiños = (int) spinnerEdad.getValue() >= 0 &&
							(int) spinnerEdad.getValue() <= 14;
		
		return (numHabitaciones && edadNiños);
	}

	/**
	 * Crea la string que se va a imprimir en panel 4 a partir de la información 
	 * que se ha escrito en el formulario.
	 *
	 * @return the info habitacion
	 */
	public String getInfoHabitacion() {
		
		if (camposValidos()) {
			
			String tipo = tipoHabitacion.getSelectedItem().toString();
			int numHabitaciones = (int) spinnerHabitaciones.getValue();
			
			
			
			String niño = CB.isSelected() ? "Si" : "No";
			String extra = ""; 
			
			if (CB.isSelected()) {
				int edad = (int) spinnerEdad.getValue();
				if (edad <= 3) {
					extra = "Cuna";
				}
				
				if (edad >= 4 && edad <= 10) {
					extra = "Cama supletoria pequeña";
				}
				
				if (edad >= 11 && edad <= 14) {
					extra = "Cama supletoria normal";
				}
			} else {
				extra = "No se han solicitado";
			}
			
			String info = String.format("Tipo de habitación: %s"
					+ "\nNúmero de habitaciones reservadas: %d\nNiños: %s"
					+ "\nExtras: %s\nPrecio por habitación: %d€\nImporte total: %d€", 
					tipo, numHabitaciones, niño, extra, precioHabitacion, precioTotal);
			
			return info;
			
		} else {
			return "";
		}
	}
	
	/**
	 * Borrar todo.
	 */
	public void borrarTodo() {
		tipoHabitacion.setSelectedIndex(0);
		spinnerHabitaciones.setValue((int) 0);
		CB.setSelected(false);
		spinnerEdad.setValue((int) 0);
		TAimporte.setText("");
		TAextras.setText("");
	}
	
	/**
	 * The Class PanelNiños.
	 */
	class PanelNiños extends JPanel{
		
		/**
		 * Instantiates a new panel niños.
		 */
		public PanelNiños() {
			
			layout = new GridBagLayout();
			this.setLayout(layout);
			constraints = new GridBagConstraints();
			this.setBackground(new Color(241,212,175));
			
			Border border = BorderFactory.createDashedBorder(Color.BLACK,
					4, 4, 4, true);
			this.setBorder(border);
			
			Font fuente = new Font("Lato Black", Font.PLAIN, 18);
			Color color = new Color(122,179,23);
			
			labelNiños = new JLabel("Edad de niños");
			labelNiños.setFont(fuente);
			labelNiños.setForeground(color);
			constraints.insets = new Insets(4,20,4,0);
			add(labelNiños,0,0,1,1);
			
			SpinnerNumberModel modelo2 = new SpinnerNumberModel(0,0,14,1);
			spinnerEdad = new JSpinner(modelo2);
			spinnerEdad.setForeground(color);
			constraints.insets = new Insets(20,20,20,0);
			add(spinnerEdad,1,0,1,1);
			
			TAextras = new JTextArea("Cuna",1,16);
			TAextras.setFont(fuente);
			TAextras.setForeground(color);
			TAextras.setEditable(false);
			constraints.insets = new Insets(20,20,20,10);
			add(TAextras,0,1,2,2);
			
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
		
		/**
		 * Editar extras.
		 */
		private void editarExtras() {
			
			int edad = (int) spinnerEdad.getValue();
			
			if (edad <= 3) {
				TAextras.setText("Cuna");
			}
			
			if (edad >= 4 && edad <= 10) {
				TAextras.setText("Cama supletoria pequeña");
			}
			
			if (edad >= 11 && edad <= 14) {
				TAextras.setText("Cama supletoria normal");
			}
		}
	}
	
	/**
	 * The Class PanelImagenes.
	 */
	class PanelImagenes extends JPanel {
		
		/**
		 * Instantiates a new panel imagenes.
		 */
		public PanelImagenes() {

			layout = new GridBagLayout();
			this.setLayout(layout);
			constraints = new GridBagConstraints();
			this.setBackground(new Color(241,212,175));
			
			Border border = BorderFactory.createDashedBorder(Color.BLACK,
					4, 4, 4, true);
//			this.setBorder(border);

			Font fuente = new Font("Lato Black", Font.PLAIN, 18);
			Color color = new Color(122,179,23);
			
			labelHabitacion = new JLabel("Habitación simple");
			labelHabitacion.setFont(fuente);
			labelHabitacion.setForeground(color);
			constraints.insets = new Insets(4,20,4,10);
			add(labelHabitacion,0,0,1,1);
			
			ImageIcon icono = new ImageIcon(this.getClass().getResource("/recursos/habitacionSimple.jpg"));
			Image imagen = icono.getImage().getScaledInstance(300,200, ABORT);
			icono.setImage(imagen);
			labelPintura = new JLabel(icono);
			add(labelPintura,0,1,1,1);
			
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
		
		/**
		 * Dependiendo de la habitacion seleccionada mostrara una de tres imagenes y mostrara 
		 * el nombre en un JLabel
		 */
		private void cambiarImagen() {
			String tipo = tipoHabitacion.getSelectedItem().toString();
			
			switch (tipo) {
			
			case "Simple":
				labelHabitacion.setText("Habitación simple");
				ImageIcon icono1 = new ImageIcon(this.getClass().getResource("/recursos/habitacionSimple.jpg"));
				Image imagen1 = icono1.getImage().getScaledInstance(300,200, ABORT);
				icono1.setImage(imagen1);
				labelPintura.setIcon(icono1);
				break;
			case "Doble":
				labelHabitacion.setText("Habitación doble");
				ImageIcon icono2 = new ImageIcon(this.getClass().getResource("/recursos/habitacionDoble.jpg"));
				Image imagen2 = icono2.getImage().getScaledInstance(300,200, ABORT);
				icono2.setImage(imagen2);
				labelPintura.setIcon(icono2);
				break;
			case "Suite":
				labelHabitacion.setText("Habitación suite");
				ImageIcon icono3 = new ImageIcon(this.getClass().getResource("/recursos/habitacionSuite.jpg"));
				Image imagen3 = icono3.getImage().getScaledInstance(300,200, ABORT);
				icono3.setImage(imagen3);
				labelPintura.setIcon(icono3);
				break;
			}
		}
	}
}