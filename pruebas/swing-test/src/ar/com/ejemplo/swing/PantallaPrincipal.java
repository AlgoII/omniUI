package ar.com.ejemplo.swing;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;

import ar.com.ejemplo.swing.domain.Argumento;

@SuppressWarnings("serial")
public class PantallaPrincipal extends JFrame {

	private List<Argumento> argumentos;

	public void setDomainForTest(List<Argumento> argumentos) {
		this.argumentos = argumentos;
	}

	public List<Argumento> getDomainForTest() {
		return this.argumentos;
	}

	public PantallaPrincipal(String nombre) {
		super(nombre);
	}

	public void dibujar() {
				
		JPanel panel = new JPanel(new FlowLayout());
		
		for (Argumento a: this.argumentos) {
			
			JLabel etiqueta = new JLabel (a.getEtiqueta());
			JTextField campo = new JTextField(10);

			BeanProperty<Argumento, String> valorProperty = BeanProperty.create("valor"); 
			BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");
			
			Binding<Argumento, String, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, a, valorProperty, campo, campoProperty); 
			valorBinding.bind();
			
			panel.add(etiqueta);
			panel.add(campo);
						
		}
		
		JButton aceptar = new JButton("aceptar");
		aceptar.addActionListener(new AceptarListener(this.argumentos));		
		
		panel.add(aceptar);
							
		this.setContentPane(panel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
//		this.setSize(300,200); //TODO el pack ajusta todo
		this.setLocationRelativeTo(null);
		
	}



}
