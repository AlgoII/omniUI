package ar.com.algo2.jcmd.ui;

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

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoComboBox;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;
import ar.com.algo2.jcmd.dominio.ArgumentoNumerico;
import ar.com.algo2.jcmd.dominio.Comando;
import ar.com.algo2.jcmd.dominio.Lanzador;

@SuppressWarnings("serial")
public class PantallaPrincipal extends JFrame {

	private Lanzador lanzador; //dominio
	
	public void setDomainForTest(Lanzador lanzador) {
		this.lanzador = lanzador;			
	}

	public Lanzador getDomainForTest() {
		return this.lanzador;
	}

	//TODO: este no debería usarse
	public Lanzador getLanzador() {
		return this.lanzador;
	}
	
	//TODO: este no debería usarse
	public void setLanzador(Lanzador lanzador) {
		this.lanzador = lanzador;
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

		for (Comando c: this.lanzador.getComandos()) {

			for (Aplicacion a: c.getAplicaciones()) {

				JMenuItem mi = new JMenuItem(a.getNombre());

				mi.setToolTipText(a.getDescripcion());
				mi.addActionListener(new MenuItemAplicacionListener(this,a));

				aplicaciones.add(mi);

			}
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
		pack();
		this.setLocationRelativeTo(null);	

	}


	public void dibujarArgumentos(Aplicacion aplicacion) throws Exception {

		JPanel panel = new JPanel(new GridBagLayout());

		Border borde = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK),aplicacion.getNombre());
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
				seleccionarArchivo.addActionListener(new SeleccionarArchivoListener((Argumento) argumento, campo));

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.BOTH;
				panel.add(campo,gbc); gbc.gridx++;					
				panel.add(seleccionarArchivo,gbc);

				totalComponentesFila += 3;


			} else if (argumento.getTipo().equalsIgnoreCase("Text")) {

				JTextField campo = new JTextField(10);

				BeanProperty<Argumento, String> argumentoTextoValorProperty = BeanProperty.create("valor");
				BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");

				Binding<Argumento, String, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (Argumento) argumento, argumentoTextoValorProperty, campo, campoProperty); 
				valorBinding.bind();				

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;				
				gbc.ipady=6;				
				panel.add(campo,gbc);
				gbc.ipady=0;

				totalComponentesFila += 2;


			} else if (argumento.getTipo().equalsIgnoreCase("Boolean")) {

				JCheckBox checkbox = new JCheckBox(argumento.getEtiqueta());
				checkbox.setSelected(((ArgumentoBoolean) argumento).getValorInicial());
				checkbox.setHorizontalTextPosition(SwingConstants.LEFT);

				BeanProperty<ArgumentoBoolean, Boolean> argumentoBooleanValorBooleanoProperty = BeanProperty.create("valorBoolean");
				BeanProperty<JCheckBox,Boolean> checkboxProperty = BeanProperty.create("selected");

				Binding<ArgumentoBoolean, Boolean, JCheckBox, Boolean> valorBooleanoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoBoolean) argumento, argumentoBooleanValorBooleanoProperty, checkbox, checkboxProperty); 
				valorBooleanoBinding.bind();
				
				BeanProperty<ArgumentoBoolean, String> argumentoBooleanValorProperty = BeanProperty.create("valor");
				
				//el biinding del selected ya estaría definido...
				Binding<ArgumentoBoolean, String, JCheckBox, Boolean> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoBoolean) argumento, argumentoBooleanValorProperty, checkbox, checkboxProperty); 
				valorBinding.bind();
				
				gbc.gridx++;

				//identación de flags
				if (totalComponentesFila >= 6) {
					gbc.gridy++; gbc.gridx=0;
				}				

				panel.add(checkbox,gbc);

				totalComponentesFila += 1;
				

			} else if (argumento.getTipo().equalsIgnoreCase("ComboBox")) {

				JComboBox combo = new JComboBox(((ArgumentoComboBox) argumento).getValores().toArray());
				combo.setEditable(false);
				combo.setSelectedItem(null);

				BeanProperty<ArgumentoComboBox, String> argumentoComboValorSeleccionadoProperty = BeanProperty.create("valorSeleccionado");
				BeanProperty<JComboBox,String> comboSelectedItemProperty = BeanProperty.create("selectedItem");

				Binding<ArgumentoComboBox, String, JComboBox, String> valorSeleccionadoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoComboBox) argumento, argumentoComboValorSeleccionadoProperty, combo, comboSelectedItemProperty); 
				valorSeleccionadoBinding.bind();
				
				BeanProperty<ArgumentoComboBox, String> argumentoComboValorProperty = BeanProperty.create("valor");
				Binding<ArgumentoComboBox, String, JComboBox, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoComboBox) argumento, argumentoComboValorProperty, combo, comboSelectedItemProperty); 
				valorBinding.bind();			

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				panel.add(combo,gbc);		

				totalComponentesFila += 2;

			} else if (argumento.getTipo().equalsIgnoreCase("Number")) {

				JTextField campoNumerico = null;

				if (((ArgumentoNumerico) argumento).getMask() != null && !((ArgumentoNumerico) argumento).getMask().equalsIgnoreCase("")) {

					MaskFormatter mask = new MaskFormatter(((ArgumentoNumerico) argumento).getMask());
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

				BeanProperty<ArgumentoNumerico, Long> argumentoNumberValorNumericoProperty = BeanProperty.create("valorNumerico");
				BeanProperty<JTextField, String> campoProperty = BeanProperty.create("text");

				Binding<ArgumentoNumerico, Long, JTextField, String> valorNumericoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoNumerico) argumento, argumentoNumberValorNumericoProperty, campoNumerico, campoProperty);

				valorNumericoBinding.setConverter(new Converter<Long, String>() { //TODO: fix para devolver 0 cuando borra todo (valor numérico default)

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

				valorNumericoBinding.bind();
				
				BeanProperty<ArgumentoNumerico, String> argumentoNumberValorProperty = BeanProperty.create("valor");
				Binding<ArgumentoNumerico, String, JTextField, String> valorBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, (ArgumentoNumerico) argumento, argumentoNumberValorProperty, campoNumerico, campoProperty);
				valorBinding.bind();

				gbc.gridy++; gbc.gridx=0; gbc.anchor = GridBagConstraints.EAST;
				gbc.insets = new Insets(5,15,5,5); panel.add(etiqueta, gbc); gbc.insets = new Insets(5,5,5,15);
				gbc.gridx++;
				gbc.fill = GridBagConstraints.HORIZONTAL;				
				gbc.ipady=6;
				panel.add(campoNumerico,gbc);	
				gbc.ipady=0;

				totalComponentesFila += 2;

			} else if (argumento.getTipo().equalsIgnoreCase("Date")) {

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
