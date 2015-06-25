package ar.com.algo2.jcmd.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import ar.com.algo2.jcmd.appmodel.JCmdToolXMLFactory;
import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoComboBox;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;
import ar.com.algo2.jcmd.dominio.ArgumentoNumerico;
import ar.com.algo2.jcmd.dominio.Comando;
import ar.com.algo2.jcmd.dominio.Lanzador;
import ar.com.algo2.jcmd.parsers.JCmdToolSAXParser;
import ar.com.algo2.jcmd.parsers.JCmdToolXStreamParser;
import ar.com.algo2.jcmd.ui.JCmdToolFrame;

public class Main {
	
	public static void main(String[] args) {

		try {
			
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {

//					Aplicacion commit = new Aplicacion("Commit", "commitea cambios en repositorio local");
//
//					commit.addArgumento(new Argumento("-m","Campo 1", new Boolean(true),"Text", ""));
//					commit.addArgumento(new Argumento("-d","Campo 2", new Boolean(false),"Search", ""));
//					commit.addArgumento(new ArgumentoBoolean("-v","Campo 3", new Boolean(true),"Boolean","",new Boolean(false))); //TODO: valorInicial vs valorBoolean - sincronización en el constructor...
//
//					List<String> valores = new ArrayList<String>();
//					valores.add("uno");
//					valores.add("todos");
//					valores.add("ninguno");
//
//					commit.addArgumento(new ArgumentoComboBox("-f","Campo 4", new Boolean(true),"ComboBox","",valores));
//
//					Comando git = new Comando();
//					git.setNombre("ejecutable"); //TODO: ejecutable -m "hola mundo" -d ejemplo.txt -v -f all
//					git.setAlias("Git");
//					git.setDescripcion("cliente para repositorios git");
//					git.setOutput(null);					
//					git.addAplicacion(commit);
//					commit.setComando(git);
//
//					Aplicacion editor = new Aplicacion("Editor de videos", "edición de videos");
//
//					editor.addArgumento(new ArgumentoNumerico("-n","Campo 5", new Boolean(true),"Number","", "#")); //placeholder = 0					
//					editor.addArgumento(new ArgumentoDate("-d","Campo 6", new Boolean(true),"Date","","yyyyMMdd"));
//
//					Comando ffmpeg = new Comando();
//					ffmpeg.setNombre("ejecutable");
//					ffmpeg.setAlias("FFMpeg");
//					ffmpeg.setDescripcion("Editor de videos");
//					ffmpeg.setOutput(null);
//					ffmpeg.addAplicacion(editor);
//					editor.setComando(ffmpeg);
//
//					Lanzador lanzador = new Lanzador();
//					lanzador.addComando(git);
//					lanzador.addComando(ffmpeg);

					JCmdToolXMLFactory xmlFactory = JCmdToolXMLFactory.getInstance();
					xmlFactory.init(new JCmdToolXStreamParser());
			//		xmlFactory.init(new JCmdToolSAXParser());
			
					Lanzador lanzador = xmlFactory.getLanzadorFromXml("test-ejecutable.xml");
					
					System.out.println(lanzador.toString());
					
					System.out.println(xmlFactory.getXmlFromLanzador(lanzador));
					
					JCmdToolFrame pantalla = new JCmdToolFrame("<omniUI>");

					pantalla.setDomainForTest(lanzador);

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
