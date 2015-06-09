package ar.com.ejemplo.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import ar.com.ejemplo.swing.domain.ArgumentoBoolean;
import ar.com.ejemplo.swing.domain.ArgumentoCombo;
import ar.com.ejemplo.swing.domain.ArgumentoTexto;

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

		for (Argumento argumento: this.argumentos) {

			JLabel etiqueta = new JLabel (argumento.getEtiqueta());

			if (argumento.getTipo().equalsIgnoreCase("Search")) { //TODO: validar si hace falta quedarse con el Argumento.tipo o con el resultado de instanceof

				JTextField campo = new JTextField(10);			
				campo.setEditable(false);
			
				JButton seleccionarArchivo = new JButton("Buscar");
				seleccionarArchivo.addActionListener(new SeleccionarArchivoListener((ArgumentoTexto) argumento, campo));
				
				//TODO: acá el binding lo hace el listener

				panel.add(etiqueta);
				panel.add(campo);
				panel.add(seleccionarArchivo);
								
			} else if (argumento instanceof ArgumentoTexto) {

				JTextField campo = new JTextField(10);			

				BeanProperty<ArgumentoTexto, String> argumentoTextoValorProperty = BeanProperty.create("valor");
				BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");

				Binding<ArgumentoTexto, String, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoTexto) argumento, argumentoTextoValorProperty, campo, campoProperty); 
				valorBinding.bind();

				panel.add(etiqueta);
				panel.add(campo);

				//TODO: ESTE OPCIONAL ES PROPIO DEL ARGUMENTO NO DEL TIPO - pero por ahora considera solo campos de texto
				if (argumento.getOptional().booleanValue() == false) {

					JLabel obligatorio = new JLabel("obligatorio");

					obligatorio.setForeground(Color.RED);
					obligatorio.setFont(new Font("Serif",Font.ITALIC,12));

					panel.add(obligatorio);

					campo.getDocument().addDocumentListener(new ObligatorioListener(obligatorio,campo));					

				}


			} else if (argumento instanceof ArgumentoBoolean) {

				JCheckBox checkbox = new JCheckBox(argumento.getEtiqueta());
				checkbox.setSelected(((ArgumentoBoolean) argumento).getValor());

				BeanProperty<ArgumentoBoolean, Boolean> argumentoBooleanValorProperty = BeanProperty.create("valor");
				BeanProperty<JCheckBox,Boolean> checkboxProperty = BeanProperty.create("selected");

				Binding<ArgumentoBoolean, Boolean, JCheckBox, Boolean> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoBoolean) argumento, argumentoBooleanValorProperty, checkbox, checkboxProperty); 
				valorBinding.bind();

				panel.add(checkbox);


			} else if (argumento instanceof ArgumentoCombo) {

				JComboBox combo = new JComboBox(((ArgumentoCombo) argumento).getValores().toArray());
				combo.setEditable(false);
				combo.setSelectedItem(null);

				BeanProperty<ArgumentoCombo, String> argumentoComboValorProperty = BeanProperty.create("valor");
				BeanProperty<JComboBox,String> comboSelectedItemProperty = BeanProperty.create("selectedItem");

				Binding<ArgumentoCombo, String, JComboBox, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoCombo) argumento, argumentoComboValorProperty, combo, comboSelectedItemProperty); 
				valorBinding.bind();

				panel.add(etiqueta);
				panel.add(combo);				

			}

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
