/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelDialogo.java
 * 25 nov 2022 - 14:26:08
 * @author Raúl Herrerías Corral
 */
package paquetePrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import panelesExteriores.PanelCentro;
import panelesExteriores.PanelInferior;
import panelesInteriores.PanelUno;

/**
 * The Class PanelDialogo.
 * Contiene un BordeLayout
 * En la parte superior está Panel 1
 * En la parte central hay un panel contenedor para panel 2 3 y 4
 * En la parte inferior hay otro panel.
 */
public class PanelDialogo extends JPanel implements FocusListener, MouseMotionListener{
	
	/** The panel uno. */
	private PanelUno panelUno;
	
	/** The panel centro. */
	private PanelCentro panelCentro;
	
	/** The panel inferior. */
	private PanelInferior panelInferior;
	
	/** The tf fecha salida. */
	private JTextField tfFechaEntrada, tfFechaSalida;
	
	/** The T aimporte. */
	private JTextArea TAextra, TAimporte;
	
	/** The btn guardar. */
	private JButton btnImprimir, btnNuevo, btnGuardar;
	
	/** The C bcopia. */
	private JCheckBox CBcopia;
	
	/** The tipo habitacion copia. */
	private JComboBox<String> tipoHabitacionCopia;
	
	/** The bar. */
	private JProgressBar bar;
	
	/**
	 * Instantiates a new panel dialogo.
	 */
	public PanelDialogo() {
		
		this.setLayout(new BorderLayout());
		
		panelUno = new PanelUno();
		panelCentro = new PanelCentro();
		panelInferior = new PanelInferior();
		
		tfFechaEntrada = panelCentro.panelDos.tfFechaE;
		tfFechaEntrada.addActionListener(e -> actualizarFecha());
		
		tfFechaSalida = panelCentro.panelDos.tfFechaS;
		tfFechaSalida.addActionListener(e -> actualizarFecha());
		
		CBcopia = panelCentro.panelTres.CB;
		CBcopia.addChangeListener(e -> visibilidadNiños());
		
		TAextra = panelCentro.panelTres.TAextras;
		TAextra.addFocusListener(this);
		
		TAimporte = panelCentro.panelTres.TAimporte;
		TAimporte.addFocusListener(this);
		
		tipoHabitacionCopia = panelCentro.panelTres.tipoHabitacion;
		tipoHabitacionCopia.addActionListener(e -> cambiarImagen());
		
		btnImprimir = panelInferior.btn1;
		btnImprimir.addActionListener(e -> setInfo());
		
		btnNuevo = panelInferior.btn2;
		btnNuevo.addActionListener(e -> reiniciarTodo());
		
		btnGuardar = panelInferior.btn3;
		btnGuardar.addActionListener(e -> guardar());
		
		bar = panelInferior.bar;
		bar.addMouseMotionListener(this);
		
		Border border1 = BorderFactory.createLineBorder(new Color(197,224,220), 8, false);
		
		panelCentro.setBorder(border1);
		
		this.add(panelUno, BorderLayout.NORTH);
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(panelInferior, BorderLayout.SOUTH);
	}
	
	/**
	 * Si las fechas introducidas no son válidas (una fecha imposible o una fecha en la que el dia
	 * de salida sea anterior al de entrada) devolverá ambas fechas a su estado predeterminado, fecha actual
	 * y dia siguiente.
	 */
	private void actualizarFecha() {
		
		DateTimeFormatter formato;
		LocalDate fechaEntrada;
		LocalDate fechaSalida;
		LocalDate hoy = LocalDate.now();
		LocalDate mañana = hoy.plusDays(1);
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			
			fechaEntrada = LocalDate.parse(tfFechaEntrada.getText(),formato);
			fechaSalida = LocalDate.parse(tfFechaSalida.getText(),formato);
			
			if (fechaEntrada.isBefore(fechaSalida)) {
				panelCentro.panelDos.actualizarFecha();
			} else {
				panelCentro.panelDos.tfFechaE.setText((hoy.format(formato)).toString());
				panelCentro.panelDos.tfFechaS.setText((mañana.format(formato)).toString());
				panelCentro.panelDos.actualizarFecha();
			}
			
		} catch (DateTimeParseException e) {
			panelCentro.panelDos.tfFechaE.setText((hoy.format(formato)).toString());
			panelCentro.panelDos.tfFechaS.setText((mañana.format(formato)).toString());
			panelCentro.panelDos.actualizarFecha();
		}
	}

	/**
	 * Visibilidad niños.
	 */
	private void visibilidadNiños() {
		if (CBcopia.isSelected()) {
			panelCentro.panelTres.mostrarPanel();
		} else {
			panelCentro.panelTres.esconderPanel();
		}
	}
	
	/**
	 * Editar extras.
	 */
	private void editarExtras() {
		panelCentro.panelTres.editarExtras();
	}
	
	/**
	 * Si todos los campos son validos, muestra el mensaje de guardado, si no son validos, muestra uno
	 * de error.
	 */
	private void guardar() {
		if (panelCentro.panelDos.camposValidos() && panelCentro.panelTres.camposValidos()) {
			JOptionPane.showMessageDialog(this, "Registro guardado", 
			   "Guardar", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "No se han cumplimentado "
					+ "todos los campos correctamente\nNo se ha podido guardar el registro", 
			   "Guardar", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Devuelve todos los paneles, campos y componentes a sus estados originales.
	 */
	private void reiniciarTodo() {
		panelCentro.panelDos.borrarTodo();
		panelCentro.panelTres.borrarTodo();
		panelCentro.panelCuatro.borrarInfoCliente();
		panelCentro.panelCuatro.borrarInfoHabitacion();
		setProgreso();
	}
	
	/**
	 * Calcular importe.
	 */
	private void calcularImporte() {
		int dias = panelCentro.panelDos.getDias();
		panelCentro.panelTres.calcularImporte(dias);
		panelCentro.panelTres.setImporte();
	}
	
	/**
	 * Cambiar imagen.
	 */
	private void cambiarImagen() {
		panelCentro.panelTres.cambiarImagen();
	}
	
	/**
	 * Imprime en las dos areas de texto la información de cliente y de habitación.
	 */
	private void setInfo() {
		
		String infoCliente = panelCentro.panelDos.getInfoCliente();
	
		int dias = panelCentro.panelDos.getDias();
		panelCentro.panelTres.calcularImporte(dias);
		String infoHabitacion = panelCentro.panelTres.getInfoHabitacion();
		
		if (infoCliente == "" || infoHabitacion == "") {
			JOptionPane.showMessageDialog(this, "No se han cumplimentado "
					+ "todos los campos correctamente", 
					"Error al imprimir", JOptionPane.WARNING_MESSAGE);
		} else {
			
		panelCentro.panelCuatro.setInfoCliente(infoCliente);
		panelCentro.panelCuatro.setInfoHabitacion(infoHabitacion);
		
		}
	}
	
	/**
	 * Llama al método setProgreso, pasandole un número dependiendo de cuantos
	 * campos se han rellenado correctamente.
	 */
	private void setProgreso() {
		
		if (!panelCentro.panelDos.camposValidos() && !panelCentro.panelTres.camposValidos()) {
			panelInferior.setProgreso(0);
		}
		
		if (panelCentro.panelDos.camposValidos() || panelCentro.panelTres.camposValidos()) {
			panelInferior.setProgreso(50);
		}
		
		if (panelCentro.panelDos.camposValidos() && panelCentro.panelTres.camposValidos()) {
			panelInferior.setProgreso(100);
		}
	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		
		if (e.getSource() == TAextra) {
			editarExtras();
		} 
		
		if (e.getSource() == TAimporte) {
			calcularImporte();
		}
	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
	}

	/**
	 * Mouse moved.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() == bar) {
			setProgreso();
		}
	}

	/**
	 * Mouse dragged.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
	}
}