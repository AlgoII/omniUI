package ar.com.ejemplo.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

import ar.com.ejemplo.swing.domain.ArgumentoTexto;

public class SeleccionarArchivoListener implements ActionListener {

	private ArgumentoTexto argumento;
	private JTextField campo;

	public SeleccionarArchivoListener(ArgumentoTexto argumento, JTextField campo) {
		this.argumento = argumento;
		this.campo = campo;
	}

	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser();			
		jfc.setDialogTitle("elegir archivo");
		jfc.setMultiSelectionEnabled(false);
		jfc.showOpenDialog(null);
		
		campo.setText(jfc.getSelectedFile().getAbsolutePath());
		argumento.setValor(jfc.getSelectedFile().getAbsolutePath());

	}

}
