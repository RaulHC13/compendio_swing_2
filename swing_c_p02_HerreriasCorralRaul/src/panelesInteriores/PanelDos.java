/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelDos.java
 * 25 nov 2022 - 17:44:31
 * @author Raúl Herrerías Corral
 */
package panelesInteriores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

/**
 * Panel dos, se recoge la información del cliente mediante un formulario.
 */
public class PanelDos extends JPanel{

	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;
	
	/** The label dias. */
	private JLabel labelNombre, labelApellidos, labelDNI, labelTelefono,
				   labelFechaE, labelFechaS, labelDias;
	
	/** The tf dias. */
	private JTextField tfNombre, tfApellido, tfDias;
	
	/** The tf DNI. */
	private JFormattedTextField tfTelefono, tfDNI;
	
	/** The tf fecha S. */
	public JTextField tfFechaE, tfFechaS;
	
	/**
	 * Instantiates a new panel dos.
	 */
	public PanelDos() {
		
		inicializarComponentes();
		setFechas();
	}
	
	/**
	 * Inicializar componentes.
	 */
	private void inicializarComponentes() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		this.setBackground(new Color(241,212,175));
		
		Color colorBorder = new Color(160,197,95);
		
		Border border1 = BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE);
		Border border2 = BorderFactory.createDashedBorder(colorBorder, 
				4, 50, 4, false);
		
		Border border = BorderFactory.createCompoundBorder(border1, border2);
		
		this.setBorder(border);
		
		Font fuente = new Font("Lato Black", Font.PLAIN, 18);
		
		constraints.insets = new Insets(10,10,10,10);
		
		labelNombre = new JLabel("Nombre");
		labelNombre.setFont(fuente);
		labelNombre.setForeground(new Color(13,103,89));
		this.add(labelNombre,0,0,1,1);
		tfNombre = new JTextField("", 10);
		this.add(tfNombre,1,0,1,1);
		
		labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(fuente);
		labelApellidos.setForeground(new Color(13,103,89));
		this.add(labelApellidos, 0,1,1,1);
		tfApellido = new JTextField("", 10);
		this.add(tfApellido,1,1,1,1);
		
		labelDNI = new JLabel("DNI");
		labelDNI.setFont(fuente);
		labelDNI.setForeground(new Color(13,103,89));
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
		labelTelefono.setForeground(new Color(13,103,89));
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
		labelFechaE.setForeground(new Color(13,103,89));
		this.add(labelFechaE, 0,4,1,1);
		tfFechaE = new JTextField();
		this.add(tfFechaE, 1,4,1,1);
		
		labelFechaS = new JLabel("Fecha de salida");
		labelFechaS.setFont(fuente);
		labelFechaS.setForeground(new Color(13,103,89));
		this.add(labelFechaS, 4,0,1,1);
		tfFechaS = new JTextField();
		this.add(tfFechaS,5,0,1,1);
		
		labelDias = new JLabel("Dias de estancia");
		labelDias.setFont(fuente);
		labelDias.setForeground(new Color(13,103,89));
		this.add(labelDias, 4,1,1,1); 
		
		tfDias = new JTextField(2);
		tfDias.setEditable(false);
		this.add(tfDias,5,1,1,1);
		
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
	 * Consigue la fecha actual, luego le suma 1 y esas son las 2 fechas por defecto.
	 * Las resta y se consiguen los dias de diferencia entre estas, por defecto 1.
	 */
	private void setFechas() {
		
		LocalDate fechaEntrada = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		tfFechaE.setText(fechaEntrada.format(formato).toString());
		
		LocalDate fechaSalida = fechaEntrada.plusDays(1);
		tfFechaS.setText(fechaSalida.format(formato).toString());
		
		long diasDiferencia = ChronoUnit.DAYS.between
				(fechaEntrada, fechaSalida);
		
		tfDias.setText(String.valueOf(diasDiferencia));
	}
	
	/**
	 * Actualizar fecha.
	 */
	public void actualizarFecha() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaEntrada = LocalDate.parse(tfFechaE.getText(),formato);
		LocalDate fechaSalida = LocalDate.parse(tfFechaS.getText(),formato);
		
		long diasDiferencia = ChronoUnit.DAYS.between
				(fechaEntrada, fechaSalida);
		
		tfDias.setText(String.valueOf(diasDiferencia));
	}
	
	
	/**
	 * Devuelve los dias
	 *
	 * @return the dias
	 */
	public int getDias() {
		return Integer.parseInt(tfDias.getText());
	}
	
	/**
	 * Borrar todo.
	 */
	public void borrarTodo() {
		
		tfNombre.setText("");
		tfApellido.setText("");
		tfDNI.setText("");
		tfTelefono.setText("");
		
		setFechas();
	}
	
	/**
	 * Asegura que los campos han sido rellenados correctamente.
	 *
	 * @return true, if successful
	 */
	public boolean camposValidos() {
		
		boolean nombre = !tfNombre.getText().trim().isEmpty();
		boolean apellidos = !tfApellido.getText().trim().isEmpty();
		boolean dni = tfDNI.getText().trim().length() == 9;
		boolean telefono = tfTelefono.getText().trim().length() == 9;
		
		return (nombre && apellidos && dni && telefono);
	}

	/**
	 * Crea la string que se va a imprimir en panel 4 a partir de la información 
	 * que se ha escrito en el formulario.
	 * 
	 * Comprueba que los campos han sido correctamente rellenados, si no es asi, devuelve "".
	 *
	 * @return the info cliente
	 */
	public String getInfoCliente() {
		
		if (camposValidos()) {
			
			String nombre = tfNombre.getText().toString().trim();
			String apellidos = tfApellido.getText().toString().trim();
			String dni = tfDNI.getText().toString();
			String telefono = tfTelefono.getText().trim();
			String fechaEntrada = tfFechaE.getText().toString().trim();
			String fechaSalida = tfFechaS.getText().toString().trim();
			int numDias = getDias();
			
			String resultado = String.format("Nombre: %s\nApellidos: %s"
					+ "\nDNI: %s\nNº Telefono: %s\nFecha de entrada: %s"
					+ "\nFecha de salida: %s\nDias de estancia total: %d" 
					,nombre,apellidos,dni,telefono,fechaEntrada,fechaSalida,numDias);
			
			return resultado;
			
		} else {
			return "";
		}
	}
}