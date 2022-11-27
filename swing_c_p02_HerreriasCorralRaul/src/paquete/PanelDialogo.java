/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelDialogo.java
 * 25 nov 2022 - 14:26:08
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelDialogo extends JPanel implements FocusListener{
	
	private PanelUno panelUno;
	private PanelCentro panelCentro;
	private PanelInferior panelInferior;
	
	private JTextField tfFechaEntrada, tfFechaSalida;
	private JTextArea TAextra, TAimporte;
	private JButton btnImprimir, btnNuevo, btnGuardar;
	private JCheckBox CBcopia;
	private JComboBox<String> tipoHabitacionCopia;
	
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
		
		Border border1 = BorderFactory.createLineBorder(new Color(197,224,220), 8, false);
		
		panelCentro.setBorder(border1);
		
		this.add(panelUno, BorderLayout.NORTH);
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(panelInferior, BorderLayout.SOUTH);
	}
	
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

	private void visibilidadNiños() {
		if (CBcopia.isSelected()) {
			panelCentro.panelTres.mostrarPanel();
		} else {
			panelCentro.panelTres.esconderPanel();
		}
	}
	
	private void editarExtras() {
		panelCentro.panelTres.editarExtras();
	}
	
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
	
	private void reiniciarTodo() {
		panelCentro.panelDos.borrarTodo();
		panelCentro.panelTres.borrarTodo();
		panelCentro.panelCuatro.borrarInfoCliente();
		panelCentro.panelCuatro.borrarInfoHabitacion();
	}
	
	private void calcularImporte() {
		int dias = panelCentro.panelDos.getDias();
		panelCentro.panelTres.calcularImporte(dias);
		panelCentro.panelTres.setImporte();
	}
	
	private void cambiarImagen() {
		panelCentro.panelTres.cambiarImagen();
	}
	
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

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == TAextra) {
			editarExtras();
		} else if (e.getSource() == TAimporte) {
			calcularImporte();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}