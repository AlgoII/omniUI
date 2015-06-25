package ar.com.algo2.jcmd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ar.com.algo2.jcmd.dominio.Aplicacion;

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
