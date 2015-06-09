package ar.com.ejemplo.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import ar.com.ejemplo.swing.domain.Argumento;
import ar.com.ejemplo.swing.domain.ArgumentoBoolean;
import ar.com.ejemplo.swing.domain.ArgumentoCombo;
import ar.com.ejemplo.swing.domain.ArgumentoTexto;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					
					List<Argumento> argumentos = new ArrayList<Argumento>();
					
					argumentos.add(new ArgumentoTexto("Campo 1", new Boolean(true),"Text", ""));
					argumentos.add(new ArgumentoTexto("Campo 2", new Boolean(false),"Search", ""));
					argumentos.add(new ArgumentoBoolean("Campo 3", new Boolean(true),"Boolean", new Boolean(false))); //TODO: verificar tema valor por defecto
					
					List<String> valores = new ArrayList<String>();
					valores.add("uno");
					valores.add("todos");
					valores.add("ninguno");
										
					argumentos.add(new ArgumentoCombo("Campo 4", new Boolean(true),"ComboBox",valores));
					
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
