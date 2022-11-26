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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class PanelDialogo extends JPanel implements FocusListener{
	
	private JPanel panel4;
	private PanelUno panelUno;
	private PanelCentro panelCentro;
	private PanelLateral panelLateral;
	
	private JTextField tfFechaEntrada, tfFechaSalida;
	private JTextArea TAextra, TAimporte;
	private JToggleButton copia1, copia2, copia3;
	private JCheckBox CBcopia;
	private JComboBox<String> tipoHabitacionCopia;
	
	public PanelDialogo() {
		
		this.setLayout(new BorderLayout());
		
		panelUno = new PanelUno();
		panelCentro = new PanelCentro();
		panelLateral = new PanelLateral();
		
		tfFechaEntrada = panelCentro.panelDos.tfFechaE;
		tfFechaEntrada.addActionListener(e -> actualizarFecha());
		
		tfFechaSalida = panelCentro.panelDos.tfFechaS;
		tfFechaSalida.addActionListener(e -> actualizarFecha());
		
		copia3 = panelLateral.btn3;
		copia3.addActionListener(e -> borrarTodo());
		
		CBcopia = panelCentro.panelTres.CB;
		CBcopia.addChangeListener(e -> visibilidadNiños());
		
		TAextra = panelCentro.panelTres.TAextras;
		TAextra.addFocusListener(this);
		
		TAimporte = panelCentro.panelTres.TAimporte;
		TAimporte.addFocusListener(this);
		
		tipoHabitacionCopia = panelCentro.panelTres.tipoHabitacion;
		tipoHabitacionCopia.addActionListener(e -> cambiarImagen());
		
		Border border1 = BorderFactory.createLineBorder(Color.RED, 4, true);
		Border border3 = BorderFactory.createLineBorder(Color.BLUE, 4, true);
		Border border4 = BorderFactory.createLineBorder(Color.PINK, 4, true);
		
		panel4 = new JPanel();
		
		panelCentro.setBorder(border1);
		panelLateral.setBorder(border3);
		panel4.setBorder(border4);
		
		this.add(panelUno, BorderLayout.NORTH);
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(panelLateral, BorderLayout.WEST);
		this.add(panel4, BorderLayout.SOUTH);
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

	private void visibilidadPanel2() {
		
		if (copia1.isSelected()) {
			panelCentro.esconderDos();
		} else {
			panelCentro.mostrarDos();
		}
	}
	
	private void visibilidadNiños() {
		if (CBcopia.isSelected()) {
			panelCentro.mostrarNiños();
		} else {
			panelCentro.esconderNiños();
		}
	}
	
	private void editarExtras() {
		panelCentro.panelTres.editarExtras();
	}
	
	private boolean comprobarCampos() {
		return panelCentro.panelDos.comprobarCampos();
	}
	
	private void borrarTodo() {
		panelCentro.panelDos.borrarTodo();
	}
	
	private void calcularImporte() {
		int dias = panelCentro.panelDos.getDias();
		panelCentro.panelTres.calcularImporte(dias);
	}
	
	private void cambiarImagen() {
		panelCentro.panelTres.cambiarImagen();
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