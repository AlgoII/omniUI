package cuadrosDeDialogos;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DibujosSimples extends JPanel
{
	public void paintComponent( Graphics g)
	{
		super.paintComponent(g);
		
		int ancho = getWidth();
		int alto = getHeight();
		
		g.drawLine(0, 0, ancho, alto);
		
		g.drawLine(0, alto, ancho, 0);
	}
}
