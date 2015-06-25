package ar.com.algo2.jcmd.ui.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

@SuppressWarnings("serial")
public class ArgumentoDateFormatter extends AbstractFormatter {

	private String datePattern;
    private SimpleDateFormat dateFormatter;
    
    public ArgumentoDateFormatter() {
    	super();
    	datePattern = "yyyy-MM-dd";
    	dateFormatter = new SimpleDateFormat(datePattern);
    }
    
    public ArgumentoDateFormatter(String formato) {
    	super();
    	if (formato != null && !formato.equalsIgnoreCase(""))
    		this.datePattern = formato;
    	else
    		this.datePattern = "yyyy-MM-dd";

    	dateFormatter = new SimpleDateFormat(datePattern);
    }

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";    
	}
}
