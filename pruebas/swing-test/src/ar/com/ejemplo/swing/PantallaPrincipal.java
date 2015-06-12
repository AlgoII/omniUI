package ar.com.ejemplo.swing;

import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.SwingConstants;
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

		JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets=new Insets(5,5,5,5);
		
		for (Argumento argumento: this.argumentos) {

			JLabel etiqueta = new JLabel (argumento.getEtiqueta());
			
			if (argumento.getTipo().equalsIgnoreCase("Search")) {

				JTextField campo = new JTextField(10);
//				JTextField campo = new JTextField();
				campo.setEditable(false);

				JButton seleccionarArchivo = new JButton("Buscar");
				seleccionarArchivo.addActionListener(new SeleccionarArchivoListener((ArgumentoTexto) argumento, campo));
																						
				panel.add(etiqueta,gbc); gbc.gridx++; 		
				panel.add(campo,gbc); gbc.gridx++;					
				panel.add(seleccionarArchivo,gbc);

				
			} else if (argumento instanceof ArgumentoTexto) {

				JTextField campo = new JTextField(10);

				BeanProperty<ArgumentoTexto, String> argumentoTextoValorProperty = BeanProperty.create("valor");
				BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");

				Binding<ArgumentoTexto, String, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoTexto) argumento, argumentoTextoValorProperty, campo, campoProperty); 
				valorBinding.bind();
																	
				panel.add(etiqueta,gbc); gbc.gridx++; 
				panel.add(campo,gbc);
				
				if (argumento.getOptional().booleanValue() == false) {

					JLabel obligatorio = new JLabel("obligatorio");

					obligatorio.setForeground(Color.RED);
					obligatorio.setFont(new Font("Serif",Font.ITALIC,12));
							
					gbc.gridx++;
					panel.add(obligatorio,gbc);

					campo.getDocument().addDocumentListener(new ObligatorioListener(obligatorio,campo));					

				}


			} else if (argumento instanceof ArgumentoBoolean) {

				JCheckBox checkbox = new JCheckBox(argumento.getEtiqueta());
				checkbox.setSelected(((ArgumentoBoolean) argumento).getValor());
				checkbox.setHorizontalTextPosition(SwingConstants.LEFT);

				BeanProperty<ArgumentoBoolean, Boolean> argumentoBooleanValorProperty = BeanProperty.create("valor");
				BeanProperty<JCheckBox,Boolean> checkboxProperty = BeanProperty.create("selected");

				Binding<ArgumentoBoolean, Boolean, JCheckBox, Boolean> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoBoolean) argumento, argumentoBooleanValorProperty, checkbox, checkboxProperty); 
				valorBinding.bind();
				
				panel.add(checkbox,gbc);


			} else if (argumento instanceof ArgumentoCombo) {

				JComboBox combo = new JComboBox(((ArgumentoCombo) argumento).getValores().toArray());
				combo.setEditable(false);
				combo.setSelectedItem(null);

				BeanProperty<ArgumentoCombo, String> argumentoComboValorProperty = BeanProperty.create("valor");
				BeanProperty<JComboBox,String> comboSelectedItemProperty = BeanProperty.create("selectedItem");

				Binding<ArgumentoCombo, String, JComboBox, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoCombo) argumento, argumentoComboValorProperty, combo, comboSelectedItemProperty); 
				valorBinding.bind();
				
				panel.add(etiqueta,gbc); gbc.gridx++; 				
				panel.add(combo,gbc);;				
				
			} else if (argumento instanceof ArgumentoNumber) {

				JTextField campoNumerico = null;

				if (((ArgumentoNumber) argumento).getMask() != null && !((ArgumentoNumber) argumento).getMask().equalsIgnoreCase("")) {

					MaskFormatter mask = new MaskFormatter(((ArgumentoNumber) argumento).getMask());
					mask.setPlaceholderCharacter('0');	

					campoNumerico = new JFormattedTextField(mask);

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
				
				panel.add(etiqueta,gbc); gbc.gridx++; 				
				panel.add(campoNumerico,gbc);				

			} else if (argumento instanceof ArgumentoDate) {
								
				UtilDateModel model = new UtilDateModel();
				Properties p = new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new ArgumentoDateFormatter(((ArgumentoDate) argumento).getFormato()));
				
				datePicker.addActionListener(new DatePickerListener((ArgumentoDate) argumento, datePicker));
				
				panel.add(etiqueta,gbc); gbc.gridx++; 								
				panel.add(datePicker,gbc);
				
			}
			
			gbc.gridx=0;
			gbc.gridy++;
			gbc.gridheight=1;
			gbc.gridwidth=1;
						
		} //fin del for
				
		JButton aceptar = new JButton("Ejecutar");
		aceptar.addActionListener(new AceptarListener(this.argumentos));		
		
		gbc.insets=new Insets(50,0,10,0);
		gbc.gridx = 1; //TODO: ojo, esto hay que calcularlo
		gbc.gridy = this.argumentos.size() + 3;
		
		panel.add(aceptar,gbc);

		this.setContentPane(panel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
