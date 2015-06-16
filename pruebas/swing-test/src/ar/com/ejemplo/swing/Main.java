package ar.com.ejemplo.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import ar.com.ejemplo.swing.domain.Aplicacion;
import ar.com.ejemplo.swing.domain.ArgumentoBoolean;
import ar.com.ejemplo.swing.domain.ArgumentoCombo;
import ar.com.ejemplo.swing.domain.ArgumentoDate;
import ar.com.ejemplo.swing.domain.ArgumentoNumber;
import ar.com.ejemplo.swing.domain.ArgumentoTexto;

public class Main {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();

					Aplicacion commit = new Aplicacion("Commit","commitea cambios en repositorio local");
					
					commit.addArgumento(new ArgumentoTexto("Campo 1", new Boolean(true),"Text", ""));
					commit.addArgumento(new ArgumentoTexto("Campo 2", new Boolean(false),"Search", ""));
					commit.addArgumento(new ArgumentoBoolean("Campo 3", new Boolean(true),"Boolean", new Boolean(false))); //TODO: verificar tema valor por defecto

					List<String> valores = new ArrayList<String>();
					valores.add("uno");
					valores.add("todos");
					valores.add("ninguno");

					commit.addArgumento(new ArgumentoCombo("Campo 4", new Boolean(true),"ComboBox",valores));
					
					aplicaciones.add(commit);
					
					Aplicacion editor = new Aplicacion("Editor de videos","edición de videos");
					
					editor.addArgumento(new ArgumentoNumber("Campo 5", new Boolean(true),"Number", "#")); //placeholder = 0					
					editor.addArgumento(new ArgumentoDate("Campo 6", new Boolean(true),"Date","yyyyMMdd"));

					aplicaciones.add(editor);
					
					PantallaPrincipal pantalla = new PantallaPrincipal("<omniUI>");
					
					pantalla.setDomainForTest(aplicaciones);
					
					pantalla.setResizable(false); //TODO: validar si tiene que ser ajustable
					
					try {
						pantalla.dibujar();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					pantalla.setVisible(true);

				}   
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
