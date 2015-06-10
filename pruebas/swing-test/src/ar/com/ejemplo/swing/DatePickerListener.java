package ar.com.ejemplo.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import org.jdatepicker.impl.JDatePickerImpl;

import ar.com.ejemplo.swing.domain.ArgumentoDate;

public class DatePickerListener implements ActionListener {

	private ArgumentoDate argumento;
	private JDatePickerImpl datePicker;

	public DatePickerListener(ArgumentoDate argumento, JDatePickerImpl datePicker) {
		super();
		this.argumento = argumento;
		this.datePicker = datePicker;
	}

	public void actionPerformed(ActionEvent e) {
		argumento.setValor((Date) this.datePicker.getModel().getValue());
	}

}
