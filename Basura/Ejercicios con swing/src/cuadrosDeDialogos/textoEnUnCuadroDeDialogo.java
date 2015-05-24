package cuadrosDeDialogos;

import javax.swing.JOptionPane;

public class textoEnUnCuadroDeDialogo 
{
	public static void main ( String[] args )
	{
		String nombre = JOptionPane.showInputDialog("Nombre: ");
		
		String mensaje = String.format("Sr %s ustes es bienvenido a OmniUI", nombre);
		
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
