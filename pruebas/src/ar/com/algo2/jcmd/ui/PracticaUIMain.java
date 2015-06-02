package ar.com.pruebas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//TODO -> JFrame -> top-level container -> contener componentes de la aplicacion

public class PracticaUIMain extends JFrame {

	private static final long serialVersionUID = -8776155968921510480L;

	public PracticaUIMain() {
		
		//TODO: creamos el botón y le agregamos un listener
		JButton quitButton = new JButton("Quit");
		quitButton.setToolTipText("tooltip"); //TODO: ver si sirve en lugar de textfield descriptivo

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		quitButton.setMnemonic(KeyEvent.VK_B); //ALT+B
		
		createLayout(quitButton);

		setTitle("Simple example");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createMenuBar();

	}


//	http://zetcode.com/tutorials/javaswingtutorial/menusandtoolbars/
//	https://blogs.oracle.com/geertjan/entry/beans_binding_via_the_road
	
	 private void createMenuBar() {

		   JMenuBar menubar = new JMenuBar();
	        
	        ImageIcon iconNew = new ImageIcon("D:\\carpeta_personal\\facultad\\algo2\\naranja.png");
	        ImageIcon iconOpen = new ImageIcon("D:\\carpeta_personal\\facultad\\algo2\\naranja.png");
	        ImageIcon iconSave = new ImageIcon("D:\\carpeta_personal\\facultad\\algo2\\naranja.png");
	        ImageIcon iconExit = new ImageIcon("D:\\carpeta_personal\\facultad\\algo2\\naranja.png");


//	        JMenuItem newMi = new JMenuItem("New", iconNew);
//	        JMenuItem openMi = new JMenuItem("Open", iconOpen);
//	        JMenuItem saveMi = new JMenuItem("Save", iconSave);
//	        JMenuItem exitMi = new JMenuItem("Exit", iconExit);

	        
	        JMenu fileMenu = new JMenu("File");
	        fileMenu.setMnemonic(KeyEvent.VK_F);

	        JMenuItem newMi = new JMenuItem(new MenuItemAction("New", iconNew, 
	                KeyEvent.VK_N));

	        JMenuItem openMi = new JMenuItem(new MenuItemAction("Open", iconOpen, 
	                KeyEvent.VK_O));

	        JMenuItem saveMi = new JMenuItem(new MenuItemAction("Save", iconSave, 
	                KeyEvent.VK_S));

	        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
	        exitMi.setMnemonic(KeyEvent.VK_E);
	        exitMi.setToolTipText("Exit application");
	        exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
	            ActionEvent.CTRL_MASK));

	        exitMi.addActionListener(new ActionListener() {	       
	            public void actionPerformed(ActionEvent event) {
	                System.exit(0);
	            }
	        });

	        fileMenu.add(newMi);
	        fileMenu.add(openMi);
	        fileMenu.add(saveMi);
	        fileMenu.addSeparator();
	        fileMenu.add(exitMi);
	        
	        menubar.add(fileMenu);

	        JMenu helpMenu = new JMenu("Help");
	        menubar.add(Box.createHorizontalGlue()); //absorbe los espacios extra -> lo acomoda a la derecha	   
	        menubar.add(helpMenu);

	        setJMenuBar(menubar);			  
	        
	    }

	 
	 private class MenuItemAction extends AbstractAction {
	        
		private static final long serialVersionUID = -3507535161956291614L;

			public MenuItemAction(String text, ImageIcon icon, 
	                Integer mnemonic) {
	            super(text);
	            
	            putValue(SMALL_ICON, icon);
	            putValue(MNEMONIC_KEY, mnemonic);
	        }
	  
	        public void actionPerformed(ActionEvent e) {
	            
	            System.out.println(e.getActionCommand());
	        }
	    }

	 
	
	private void createLayout(JComponent... arg) {
		
//TODO: pane es el área donde van los componentes -> "content de un JFrame" -> los componentes se organizan por layouts
//		BorderLayout -> default. Acá usa GroupLayout -> SequentialGroup vs ParalellGroup -> dos dimensiones
//		JPanel -> es un Container "mejorado", supuestamente acepta tooltips
//		JMenu, JMenuBar, JMenuItem -> TODO: será mejor usar menúes que listboxes?		
		
		JPanel pane = (JPanel) getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true); //espacio entre componentes

		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addComponent(arg[0])
				.addGap(200)
				);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[0])
				.addGap(120)
				);
		
		pack(); //ajusta tamaño automáticamente
	}

	public static void main(String[] args) {

		//TODO: previene cuelgues 		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				PracticaUIMain ex = new PracticaUIMain();
				ex.setVisible(true);
			}
		});

	}

}
