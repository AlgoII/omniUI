package omniui.frames.panels;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;

public class PanelCheckbox extends JPanel
{
	private JLabel lblNombreargumento;
	private JCheckBox checkBox;
	private ArgumentoBoolean argumento;
	
	public PanelCheckbox(Argumento argumento)
	{
		this.argumento = (ArgumentoBoolean)argumento;
		
		this.configurePanel();
		
		this.cargarDatos();
	}
	
	private void cargarDatos()
	{
		lblNombreargumento.setText(argumento.getDescripcion());
		checkBox.setEnabled(argumento.getHabilitado());
		checkBox.setSelected(argumento.getValorInicial());
	}

	/**
	 * Create the panel.
	 */
	public void configurePanel()
	{
		setLayout(null);
		
		lblNombreargumento = new JLabel("NombreArgumento:");
		lblNombreargumento.setBounds(10, 11, 129, 23);
		add(lblNombreargumento);
		
		checkBox = new JCheckBox("");
		checkBox.setBounds(154, 11, 33, 23);
		add(checkBox);
		
	}
}
