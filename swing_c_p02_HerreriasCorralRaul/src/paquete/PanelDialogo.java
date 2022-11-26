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

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
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
	private JSpinner SPcopia;
	
	public PanelDialogo() {
		
		this.setLayout(new BorderLayout());
		
		panelUno = new PanelUno();
		panelCentro = new PanelCentro();
		panelLateral = new PanelLateral();
		
		tfFechaEntrada = panelCentro.panelDos.tfFechaE;
		tfFechaEntrada.addActionListener(e -> actualizarFecha());
		
		tfFechaSalida = panelCentro.panelDos.tfFechaS;
		tfFechaSalida.addActionListener(e -> actualizarFecha());
		
		copia1 = panelLateral.btn1;
		copia1.addActionListener(e -> visibilidadPanel2());
		
		copia2 = panelLateral.btn2;
//		copia2.addActionListener(e -> visibilidadNiños());
		
		copia3 = panelLateral.btn3;
		copia3.addActionListener(e -> borrarTodo());
		
		CBcopia = panelCentro.panelTres.CB;
		CBcopia.addChangeListener(e -> visibilidadNiños());
		
		TAextra = panelCentro.panelTres.TAextras;
		TAextra.addFocusListener(this);
		
		TAimporte = panelCentro.panelTres.TAimporte;
		TAimporte.addFocusListener(this);
		
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
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaEntrada = LocalDate.parse(tfFechaEntrada.getText(),formato);
		LocalDate fechaSalida = LocalDate.parse(tfFechaSalida.getText(),formato);
		
		LocalDate hoy = LocalDate.now();
		LocalDate mañana = hoy.plusDays(1);
		
		if (fechaEntrada.isBefore(fechaSalida)) {
			panelCentro.panelDos.actualizarFecha();
		} else {
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