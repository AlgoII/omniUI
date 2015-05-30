package omniui.frames.panels;

import javax.swing.JPanel;

import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import omniui.frames.helper.UIHelper;
import javax.swing.JFormattedTextField;

public class PanelDate extends JPanel
{
	
	private ArgumentoDate argumento;
	private JLabel lblNombreargumento;
	private JFormattedTextField formattedTextField;

	/**
	 * Create the panel.
	 */
	public PanelDate(Argumento argumento)
	{
		this.argumento = (ArgumentoDate)argumento;
		
		this.configurarPanel();
		
		this.cargarDatos();
	}

	private void cargarDatos()
	{
		lblNombreargumento.setText(argumento.getDescripcion());
		formattedTextField.setEnabled(argumento.getHabilitado());

		String format = argumento.getFormato();
		MaskFormatter formatter = UIHelper.getMask(format);
		
		formatter.install(formattedTextField);
	}

	private void configurarPanel()
	{
		setLayout(null);
		
		lblNombreargumento = new JLabel("NombreArgumento:");
		lblNombreargumento.setBounds(10, 11, 178, 14);
		add(lblNombreargumento);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(210, 8, 187, 20);
		add(formattedTextField);
		
	}
}
