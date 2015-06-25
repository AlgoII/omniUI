package ar.com.algo2.jcmd.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.ui.JCmdToolFrame;

public class MenuItemAplicacionListener implements ActionListener {

	JCmdToolFrame pantallaPrincipal;
	Aplicacion aplicacion;

	public MenuItemAplicacionListener(JCmdToolFrame pantallaPrincipal, Aplicacion aplicacion) {
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
