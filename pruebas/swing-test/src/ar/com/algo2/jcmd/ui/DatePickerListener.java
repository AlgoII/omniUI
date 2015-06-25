package ar.com.algo2.jcmd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdatepicker.impl.JDatePickerImpl;

import ar.com.algo2.jcmd.dominio.ArgumentoDate;

public class DatePickerListener implements ActionListener {

	private ArgumentoDate argumento;
	private JDatePickerImpl datePicker;

	public DatePickerListener(ArgumentoDate argumento, JDatePickerImpl datePicker) {
		super();
		this.argumento = argumento;
		this.datePicker = datePicker;
	}

	public void actionPerformed(ActionEvent e) {
		argumento.setValorFecha((Date) this.datePicker.getModel().getValue());
		argumento.setValor((new SimpleDateFormat(argumento.getFormato())).format(this.datePicker.getModel().getValue()));
	}

}
