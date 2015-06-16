package ar.com.ejemplo.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ar.com.ejemplo.swing.domain.Aplicacion;

public class MenuItemAplicacionListener implements ActionListener {

	PantallaPrincipal pantallaPrincipal;
	Aplicacion aplicacion;

	public MenuItemAplicacionListener(PantallaPrincipal pantallaPrincipal, Aplicacion aplicacion) {
		this.pantallaPrincipal = pantallaPrincipal;
		this.aplicacion = aplicacion;
	}

	public void actionPerformed(ActionEvent a) {
		try {
			this.pantallaPrincipal.dibujarArgumentos(aplicacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
