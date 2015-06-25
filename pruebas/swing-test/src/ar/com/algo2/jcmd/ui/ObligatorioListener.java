package ar.com.algo2.jcmd.ui;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ObligatorioListener implements DocumentListener {

	private JLabel obligatorio;
	private JTextField campo;
	
	private void chequear() {
				
		if (campo.getText().isEmpty())
			obligatorio.setText("obligatorio");
		else
			obligatorio.setText("");	
	}

	public ObligatorioListener(JLabel obligatorio, JTextField campo) {
		super();
		this.obligatorio = obligatorio;
		this.campo = campo;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		chequear();		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		chequear();	
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		chequear();			
	}
	
}
