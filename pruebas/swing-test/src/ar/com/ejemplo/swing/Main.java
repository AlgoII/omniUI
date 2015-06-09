package ar.com.ejemplo.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import ar.com.ejemplo.swing.domain.Argumento;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					
					List<Argumento> argumentos = new ArrayList<Argumento>();
					
					argumentos.add(new Argumento("Campo 1", "", new Boolean(true)));
					argumentos.add(new Argumento("Campo 2", "", new Boolean(true)));
					argumentos.add(new Argumento("Campo 3", "", new Boolean(true)));
					
					PantallaPrincipal pantalla = new PantallaPrincipal("pantalla de prueba");
					pantalla.setDomainForTest(argumentos);						
					pantalla.dibujar();
					pantalla.setVisible(true);
					
				}   
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
