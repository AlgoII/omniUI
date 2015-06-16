package ar.com.ejemplo.swing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;


import ar.com.ejemplo.swing.domain.Aplicacion;
import ar.com.ejemplo.swing.domain.Argumento;
import ar.com.ejemplo.swing.domain.ArgumentoBoolean;
import ar.com.ejemplo.swing.domain.ArgumentoCombo;
import ar.com.ejemplo.swing.domain.ArgumentoDate;
import ar.com.ejemplo.swing.domain.ArgumentoNumber;
import ar.com.ejemplo.swing.domain.ArgumentoTexto;

@SuppressWarnings("serial")
public class PantallaPrincipal extends JFrame {

	private List<Aplicacion> aplicaciones;

	public void setDomainForTest(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public List<Aplicacion> getDomainForTest() {
		return this.aplicaciones;
	}

	public List<Aplicacion> getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public PantallaPrincipal(String nombre) {
		super(nombre);
	}

	//	http://zetcode.com/tutorials/javaswingtutorial/ -> el de los menúes

	public void dibujar() throws Exception {

		JMenuBar menubar = new JMenuBar();
		JMenu aplicaciones = new JMenu("Aplicaciones");

		setTitle("<omniUI>");
//		setSize(350, 250); //agrego imagen para usar pack

		for (Aplicacion a: this.aplicaciones) {

			JMenuItem mi = new JMenuItem(a.getNombre());
			
			mi.setToolTipText(a.getDescripcion());
			mi.addActionListener(new MenuItemAplicacionListener(this,a));

			aplicaciones.add(mi);
		}

		aplicaciones.addSeparator();

		JMenuItem salirMi = new JMenuItem("Salir");
		salirMi.setToolTipText("salir de la aplicación");

		salirMi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		aplicaciones.add(salirMi);

		menubar.add(aplicaciones);
		setJMenuBar(menubar);		
		
		BufferedImage myPicture = ImageIO.read(new File("utn-logo.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		add(picLabel);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
		pack();
	}


	public void dibujarArgumentos(Aplicacion aplicacion) throws Exception {

		JPanel panel = new JPanel(new GridBagLayout());

		Border borde = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
		panel.setBorder(borde);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE; //poner en NONE para que funcione el anchor - luego de setear el label se setea el BOTH
		gbc.insets=new Insets(5,5,5,5);	

		int totalComponentesFila=0; //se probó con dos columnas de atributos pero no quedaba bien, solo se admite más de un componente si es un checkbox

		for (Argumento argumento: aplicacion.getArgumentos()) {

			JLabel etiqueta = new JLabel (argumento.getEtiqueta());

			if (argumento.getTipo().equalsIgnoreCase("Search")) {

				JTextField campo = new JTextField(10);
				campo.setEditable(false);

				JButton seleccionarArchivo = new JButton("Buscar");
				seleccionarArchivo.addActionListener(new SeleccionarArchivoListener((ArgumentoTexto) argumento, campo));

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.BOTH;
				panel.add(campo,gbc); gbc.gridx++;					
				panel.add(seleccionarArchivo,gbc);

				totalComponentesFila += 3;


			} else if (argumento instanceof ArgumentoTexto) {

				JTextField campo = new JTextField(10);

				BeanProperty<ArgumentoTexto, String> argumentoTextoValorProperty = BeanProperty.create("valor");
				BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");

				Binding<ArgumentoTexto, String, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoTexto) argumento, argumentoTextoValorProperty, campo, campoProperty); 
				valorBinding.bind();				

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;				
				gbc.ipady=6;				
				panel.add(campo,gbc);
				gbc.ipady=0;

				totalComponentesFila += 2;


			} else if (argumento instanceof ArgumentoBoolean) {

				JCheckBox checkbox = new JCheckBox(argumento.getEtiqueta());
				checkbox.setSelected(((ArgumentoBoolean) argumento).getValor());
				checkbox.setHorizontalTextPosition(SwingConstants.LEFT);

				BeanProperty<ArgumentoBoolean, Boolean> argumentoBooleanValorProperty = BeanProperty.create("valor");
				BeanProperty<JCheckBox,Boolean> checkboxProperty = BeanProperty.create("selected");

				Binding<ArgumentoBoolean, Boolean, JCheckBox, Boolean> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoBoolean) argumento, argumentoBooleanValorProperty, checkbox, checkboxProperty); 
				valorBinding.bind();

				gbc.gridx++;

				//identación de flags
				if (totalComponentesFila >= 6) {
					gbc.gridy++; gbc.gridx=0;
				}				

				panel.add(checkbox,gbc);

				totalComponentesFila += 1;
				

			} else if (argumento instanceof ArgumentoCombo) {

				JComboBox combo = new JComboBox(((ArgumentoCombo) argumento).getValores().toArray());
				combo.setEditable(false);
				combo.setSelectedItem(null);

				BeanProperty<ArgumentoCombo, String> argumentoComboValorProperty = BeanProperty.create("valor");
				BeanProperty<JComboBox,String> comboSelectedItemProperty = BeanProperty.create("selectedItem");

				Binding<ArgumentoCombo, String, JComboBox, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoCombo) argumento, argumentoComboValorProperty, combo, comboSelectedItemProperty); 
				valorBinding.bind();

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				panel.add(combo,gbc);		

				totalComponentesFila += 2;

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

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;				
				gbc.ipady=6;
				panel.add(campoNumerico,gbc);	
				gbc.ipady=0;

				totalComponentesFila += 2;

			} else if (argumento instanceof ArgumentoDate) {

				UtilDateModel model = new UtilDateModel();
				Properties p = new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new ArgumentoDateFormatter(((ArgumentoDate) argumento).getFormato()));

				datePicker.addActionListener(new DatePickerListener((ArgumentoDate) argumento, datePicker));

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				panel.add(datePicker,gbc);

				totalComponentesFila += 2;

			}

			//TODO: para que sean 6 componentes por fila
			//			
			//			if (totalComponentesFila >= 6) {
			//				gbc.gridy++;
			//				gbc.gridx=0;
			//				totalComponentesFila=0;
			//			} else {
			//				gbc.gridx++;
			//			}

			//por posible identación de n flags seguidos
			if (totalComponentesFila >= 6) 
				totalComponentesFila=0;

			gbc.gridheight=1;
			gbc.gridwidth=1;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.NONE;
			gbc.insets=new Insets(5,5,5,5);

		} //fin del for

		JButton aceptar = new JButton("Ejecutar");
		aceptar.addActionListener(new AceptarListener(this,aplicacion.getArgumentos()));		

		gbc.insets=new Insets(25,5,5,5);
		gbc.fill=GridBagConstraints.NONE;
		gbc.gridx = 1; 
		gbc.gridy = aplicacion.getArgumentos().size()+5;

		panel.add(aceptar,gbc);

		this.setContentPane(panel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
