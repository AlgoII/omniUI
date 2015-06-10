package ar.com.ejemplo.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;


import ar.com.ejemplo.swing.domain.Argumento;
import ar.com.ejemplo.swing.domain.ArgumentoBoolean;
import ar.com.ejemplo.swing.domain.ArgumentoCombo;
import ar.com.ejemplo.swing.domain.ArgumentoDate;
import ar.com.ejemplo.swing.domain.ArgumentoNumber;
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

	public void dibujar() throws Exception {

		JPanel panel = new JPanel(new FlowLayout());

		for (Argumento argumento: this.argumentos) {

			JLabel etiqueta = new JLabel (argumento.getEtiqueta());

			if (argumento.getTipo().equalsIgnoreCase("Search")) {

				JTextField campo = new JTextField(10);			
				campo.setEditable(false);

				JButton seleccionarArchivo = new JButton("Buscar");
				seleccionarArchivo.addActionListener(new SeleccionarArchivoListener((ArgumentoTexto) argumento, campo));

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

				
				
			} else if (argumento instanceof ArgumentoNumber) {

				JTextField campoNumerico = null;

				if (((ArgumentoNumber) argumento).getMask() != null && !((ArgumentoNumber) argumento).getMask().equalsIgnoreCase("")) {

					MaskFormatter mask = new MaskFormatter(((ArgumentoNumber) argumento).getMask());
					mask.setPlaceholderCharacter('0');	

					campoNumerico = new JFormattedTextField(mask);
					campoNumerico.setColumns(10);

				} else {

					campoNumerico = new JTextField(10);
					campoNumerico.addKeyListener(new KeyAdapter() {

						public void keyTyped(KeyEvent e)
						{
							char caracter = e.getKeyChar();

							if(((caracter < '0') ||	(caracter > '9')) && (caracter != '\b'))
							{
								e.consume();  // ignorar el evento de teclado
							}
						}
					});
				}

				BeanProperty<ArgumentoNumber, Long> argumentoNumberValorProperty = BeanProperty.create("valor");
				BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");

				Binding<ArgumentoNumber, Long, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoNumber) argumento, argumentoNumberValorProperty, campoNumerico, campoProperty);
				
				valorBinding.setConverter(new Converter<Long, String>() { //TODO: fix para devolver 0 cuando borra todo (valor numérico default)

					@Override
					public Long convertReverse(String campo) {
						if (campo != null && !campo.equalsIgnoreCase(""))
							return new Long (campo);
						else 
							return new Long (0);
					}

					@Override
					public String convertForward(Long valor) {
						return valor != null ? "" + valor.longValue() : "0";
					}
				});
				
				valorBinding.bind();
				
				panel.add(etiqueta);
				panel.add(campoNumerico);				

			} else if (argumento instanceof ArgumentoDate) {
								
				UtilDateModel model = new UtilDateModel();
				Properties p = new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new ArgumentoDateFormatter(((ArgumentoDate) argumento).getFormato()));
				
				datePicker.addActionListener(new DatePickerListener((ArgumentoDate) argumento, datePicker));
												
				panel.add(etiqueta);
				panel.add(datePicker);
				
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
