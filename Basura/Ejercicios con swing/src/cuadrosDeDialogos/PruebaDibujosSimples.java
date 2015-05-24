package cuadrosDeDialogos;

import javax.swing.JFrame;

public class PruebaDibujosSimples 
{
	public static void main( String[] args )
	{
		DibujosSimples panel = new DibujosSimples();
		
		JFrame aplication = new JFrame();
		
		aplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aplication.add( panel );
		aplication.setSize(250, 250);
		aplication.setVisible( true );
	}
}
