/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelTres.java
 * 26 nov 2022 - 15:28:02
 * @author Raúl Herrerías Corral
 */
package paquete;

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

public class PanelTres extends JPanel{

	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private JLabel labelTipo, labelNiños, labelHabitacion, labelPintura, labelNum, labelImporte;
	private JSpinner spinnerHabitaciones;
	
	public JTextArea TAextras, TAimporte;
	public JCheckBox CB;
	public JSpinner spinnerEdad;
	public JComboBox<String> tipoHabitacion;
	
	private PanelNiños panelNiños;
	private PanelImagenes panelImagenes;
	private int precioHabitacion, precioTotal;
	
	public PanelTres() {
		
		inicializarComponentes();
		
	}

	private void inicializarComponentes() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		this.setBackground(new Color(241,212,175));
		
		Border border = BorderFactory.createDashedBorder(Color.BLACK,
				4, 4, 4, true);
		this.setBorder(border);
		
		Font fuente = new Font("Lato Black", Font.PLAIN, 16);
		
		labelTipo = new JLabel("Tipo de habitación");
		labelTipo.setFont(fuente);
		constraints.insets = new Insets(20,20,20,0);
		add(labelTipo,0,0,1,1);
		
		String[] arrayTipos = new String[]{"Simple","Doble","Suite"};
		tipoHabitacion = new JComboBox<>(arrayTipos);
		constraints.insets = new Insets(20,20,20,20);
		add(tipoHabitacion, 1,0,1,1);
	
		labelNum = new JLabel("Nº de habitaciones");
		labelNum.setFont(fuente);
		constraints.insets = new Insets(20,20,20,0);
		add(labelNum,0,1,1,1);
		

		SpinnerNumberModel modelo = new SpinnerNumberModel(0,0,50,1);
		spinnerHabitaciones = new JSpinner(modelo);
		constraints.insets = new Insets(20,20,20,0);
		add(spinnerHabitaciones,1,1,1,1);
		
		CB = new JCheckBox("¿Niños?");
		CB.setFont(fuente);
		CB.setBackground(new Color(241,212,175));
		constraints.insets = new Insets(10,0,10,0);
		add(CB,0,2,2,1);
		
		labelImporte = new JLabel("Importe habitación");
		labelImporte.setFont(fuente);
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
		add(panelNiños,0,3,1,1);
		panelNiños.setVisible(false);
		
	}
	
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
	
	public void setImporte() {
		
		TAimporte.setText(String.valueOf(precioHabitacion + "€ por habitación, Total: " + precioTotal + "€"));
	}
	
	private void add(Component componente,int columna, int fila, int ancho,
			int alto) {
			constraints.gridx = columna;
			constraints.gridy = fila;
			constraints.gridwidth = ancho;
			constraints.gridheight = alto;
			layout.setConstraints(componente, constraints);
			this.add(componente);
		}
	
	public void mostrarPanel() {
		panelNiños.setVisible(true);
	}
	
	public void esconderPanel() {
		panelNiños.setVisible(false);
	}
	
	public void editarExtras() {
		panelNiños.editarExtras();
	}
	
	public void cambiarImagen() {
		panelImagenes.cambiarImagen();
	}
	
	public boolean camposValidos() {
		
		boolean numHabitaciones = (int) spinnerHabitaciones.getValue() > 0 && 
								  (int) spinnerHabitaciones.getValue() <= 50;
		
		boolean edadNiños = (int) spinnerEdad.getValue() >= 0 &&
							(int) spinnerEdad.getValue() <= 14;
		
		return (numHabitaciones && edadNiños);
	}

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
	
	public void borrarTodo() {
		tipoHabitacion.setSelectedIndex(0);
		spinnerHabitaciones.setValue((int) 0);
		CB.setSelected(false);
		spinnerEdad.setValue((int) 0);
		TAimporte.setText("");
		TAextras.setText("");
	}
	
	class PanelNiños extends JPanel{
		
		public PanelNiños() {
			
			layout = new GridBagLayout();
			this.setLayout(layout);
			constraints = new GridBagConstraints();
			this.setBackground(new Color(241,212,175));
			
			Border border = BorderFactory.createDashedBorder(Color.BLACK,
					4, 4, 4, true);
			this.setBorder(border);
			
			Font fuente = new Font("Lato Black", Font.PLAIN, 16);
			
			labelNiños = new JLabel("Edad de niños");
			labelNiños.setFont(fuente);
			constraints.insets = new Insets(4,20,4,0);
			add(labelNiños,0,0,1,1);
			
			SpinnerNumberModel modelo2 = new SpinnerNumberModel(0,0,14,1);
			spinnerEdad = new JSpinner(modelo2);
			constraints.insets = new Insets(20,20,20,0);
			add(spinnerEdad,1,0,1,1);
			
			TAextras = new JTextArea("Cuna",1,16);
			TAextras.setFont(fuente);
			TAextras.setEditable(false);
			constraints.insets = new Insets(20,20,20,10);
			add(TAextras,0,1,2,2);
			
		}
		
		private void add(Component componente,int columna, int fila, int ancho,
				int alto) {
				constraints.gridx = columna;
				constraints.gridy = fila;
				constraints.gridwidth = ancho;
				constraints.gridheight = alto;
				layout.setConstraints(componente, constraints);
				this.add(componente);
		}
		
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
	
	class PanelImagenes extends JPanel {
		
		public PanelImagenes() {

			layout = new GridBagLayout();
			this.setLayout(layout);
			constraints = new GridBagConstraints();
			this.setBackground(new Color(241,212,175));
			
			Border border = BorderFactory.createDashedBorder(Color.BLACK,
					4, 4, 4, true);
			this.setBorder(border);

			Font fuente = new Font("Lato Black", Font.PLAIN, 16);
			
			labelHabitacion = new JLabel("Habitación simple");
			labelHabitacion.setFont(fuente);
			constraints.insets = new Insets(4,20,4,10);
			add(labelHabitacion,0,0,1,1);
			
			ImageIcon icono = new ImageIcon(this.getClass().getResource("/recursos/habitacionSimple.jpg"));
			Image imagen = icono.getImage().getScaledInstance(300,200, ABORT);
			icono.setImage(imagen);
			labelPintura = new JLabel(icono);
			add(labelPintura,0,1,1,1);
			
		}
		
		private void add(Component componente,int columna, int fila, int ancho,
				int alto) {
				constraints.gridx = columna;
				constraints.gridy = fila;
				constraints.gridwidth = ancho;
				constraints.gridheight = alto;
				layout.setConstraints(componente, constraints);
				this.add(componente);
		}
		
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