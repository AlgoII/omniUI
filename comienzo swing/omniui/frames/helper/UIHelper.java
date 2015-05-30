package omniui.frames.helper;


import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import omniui.frames.panels.PanelCheckbox;
import omniui.frames.panels.PanelDate;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;

public class UIHelper
{
	public static final String YYYYMMDD = "YYYYMMDD";
	public static final String YYYYMMDD_FORMAT = "########";
	public static final String DD_MM_YYYY = "DD-MM-YYYY";
	public static final String DD_MM_YYYY_FORMAT = "##-##-####";
	
	
	public static JPanel getUIControl(Argumento argumento) 
	{
		JPanel panelRetorno = null;
		
		if(argumento instanceof ArgumentoBoolean)
		{
			panelRetorno = new PanelCheckbox(argumento);
		}
		if(argumento instanceof ArgumentoDate)
		{
			panelRetorno = new PanelDate(argumento);
		}
		
		return panelRetorno;
	}
	
	public static MaskFormatter getMask(String formato)
	{
		MaskFormatter formatter = null;
		try
		{
			if(formato.equals(YYYYMMDD))
			{
				formatter = new MaskFormatter(YYYYMMDD_FORMAT);
				formatter.setPlaceholderCharacter('_');
				
			}
			if(formato.equals(DD_MM_YYYY)) {
				formatter = new MaskFormatter(DD_MM_YYYY_FORMAT);
				formatter.setPlaceholderCharacter('_');
			}
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		
		return formatter;
	}
}
