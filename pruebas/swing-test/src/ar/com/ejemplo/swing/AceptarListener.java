package ar.com.ejemplo.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ar.com.ejemplo.swing.domain.Argumento;

public class AceptarListener implements ActionListener {

	private List<Argumento> argumentos;
	private JFrame frame;

	public AceptarListener() {}

	public AceptarListener(JFrame frame, List<Argumento> argumentos) {
		this.argumentos = argumentos;
		this.frame=frame;
	}

	public void actionPerformed(ActionEvent e) {

		StringBuffer buff = new StringBuffer();
		
		for (Argumento a: this.argumentos)
			buff.append(a.toString()).append("\n");
		
		JOptionPane.showMessageDialog(this.frame, buff.toString());
              

	}

}
