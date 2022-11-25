/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelDos.java
 * 25 nov 2022 - 17:44:31
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class PanelDos extends JPanel{

	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private JLabel labelNombre, labelApellidos, labelDNI, labelTelefono,
				   labelFechaE, labelFechaS, labelDias;
	private JTextField tfNombre, tfApellido, tfFechaE, tfFechaS, tfDias;
	private JFormattedTextField tfTelefono, tfDNI;
	
	public PanelDos() {
		
		inicializarComponentes();
		setFechas();
	}
	
	private void inicializarComponentes() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		this.setBackground(new Color(241,212,175));
		
		Border border = BorderFactory.createDashedBorder(Color.BLACK,
						4, 4, 4, true);
		this.setBorder(border);
		
		Font fuente = new Font("", Font.BOLD, 16);
		
		constraints.insets = new Insets(10,10,10,10);
		
		labelNombre = new JLabel("Nombre");
		labelNombre.setFont(fuente);
		this.add(labelNombre,0,0,1,1);
		tfNombre = new JTextField("", 10);
		this.add(tfNombre,1,0,1,1);
		
		labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(fuente);
		this.add(labelApellidos, 0,1,1,1);
		tfApellido = new JTextField("", 10);
		this.add(tfApellido,1,1,1,1);
		
		labelDNI = new JLabel("DNI");
		labelDNI.setFont(fuente);
		this.add(labelDNI, 0,2,1,1);
		try {
			MaskFormatter mascaraDNI = new MaskFormatter("########U");
			tfDNI = new JFormattedTextField(mascaraDNI);
			tfDNI.setFocusLostBehavior(tfDNI.COMMIT);
			tfDNI.setColumns(10);
			this.add(tfDNI, 1,2,2,1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		labelTelefono = new JLabel("Nº Telefono");
		labelTelefono.setFont(fuente);
		this.add(labelTelefono, 0,3,1,1);
		try {
			MaskFormatter mascaraTF = new MaskFormatter("#########");
			tfTelefono = new JFormattedTextField(mascaraTF);
			tfTelefono.setFocusLostBehavior(tfTelefono.COMMIT);
			tfTelefono.setColumns(10);
			this.add(tfTelefono, 1,3,1,1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		labelFechaE = new JLabel("Fecha de entrada");
		labelFechaE.setFont(fuente);
		this.add(labelFechaE, 0,4,1,1);
		tfFechaE = new JTextField();
		tfFechaE.setEditable(false);
		this.add(tfFechaE, 1,4,1,1);
		
		labelFechaS = new JLabel("Fecha de salida");
		labelFechaS.setFont(fuente);
		this.add(labelFechaS, 4,0,1,1);
		tfFechaS = new JTextField();
		tfFechaS.setEditable(false);
		this.add(tfFechaS,5,0,1,1);
		
		labelDias = new JLabel("Dias de estancia");
		labelDias.setFont(fuente);
		this.add(labelDias, 4,1,1,1); 
		tfDias = new JTextField();
		tfDias.setEditable(false);
		this.add(tfDias,5,1,1,1);
		
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
	
	private void setFechas() {
		
		LocalDate fechaEntrada = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		tfFechaE.setText(fechaEntrada.format(formato).toString());
		
		LocalDate fechaSalida = fechaEntrada.plusDays(1);
		tfFechaS.setText(fechaSalida.format(formato).toString());
		
		int diaEntrada = fechaEntrada.getDayOfYear();
		int diaSalida = fechaSalida.getDayOfYear();
		int numDias = diaSalida - diaEntrada;
		
		tfDias.setText(String.valueOf(numDias));
	}
	
	public boolean comprobarCampos() {
		
		boolean nombre = !tfNombre.getText().trim().isEmpty();
		boolean apellidos = !tfApellido.getText().trim().isEmpty();
		boolean dni = tfDNI.getText().trim().length() == 9;
		boolean telefono = tfTelefono.getText().trim().length() == 9;
		
		return (nombre && apellidos && dni && telefono);
	}
	
	public void borrarTodo() {
		
		tfNombre.setText("");
		tfApellido.setText("");
		tfDNI.setText("");
		tfTelefono.setText("");
		
		setFechas();
	}
}