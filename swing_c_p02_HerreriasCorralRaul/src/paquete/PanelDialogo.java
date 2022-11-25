/**
 * swing_c_p02_HerreriasCorralRaul - paquete - PanelDialogo.java
 * 25 nov 2022 - 14:26:08
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class PanelDialogo extends JPanel{
	
	private JPanel panel1, panel2, panel3, panel4;
	private PanelUno panelUno;
	private PanelCentro panelCentro;
	private PanelLateral panelLateral;
	private JToggleButton copia1, copia2, copia3;
	
	public PanelDialogo() {
		
		this.setLayout(new BorderLayout());
		
		panelUno = new PanelUno();
		panelCentro = new PanelCentro();
		panelLateral = new PanelLateral();
		
		copia1 = panelLateral.btn1;
		copia1.addActionListener(e -> visibilidadPanel2());
		
		copia2 = panelLateral.btn2;
		copia2.addActionListener(e -> comprobarCampos());
		
		copia3 = panelLateral.btn3;
		copia3.addActionListener(e -> borrarTodo());
		
		Border border1 = BorderFactory.createLineBorder(Color.RED, 4, true);
		Border border3 = BorderFactory.createLineBorder(Color.BLUE, 4, true);
		Border border4 = BorderFactory.createLineBorder(Color.PINK, 4, true);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		panelCentro.setBorder(border1);
		panelLateral.setBorder(border3);
		panel4.setBorder(border4);
		
		this.add(panelUno, BorderLayout.NORTH);
		
		this.add(panelCentro, BorderLayout.CENTER);
		
		this.add(panelLateral, BorderLayout.WEST);
		this.add(panel4, BorderLayout.SOUTH);
	}

	private void visibilidadPanel2() {
		if (copia1.isSelected()) {
			panelCentro.panelDos.setVisible(false);
		} else {
			panelCentro.panelDos.setVisible(true);
		}
	}
	
	private boolean comprobarCampos() {
		return panelCentro.panelDos.comprobarCampos();
	}
	
	private void borrarTodo() {
		panelCentro.panelDos.borrarTodo();
	}
}