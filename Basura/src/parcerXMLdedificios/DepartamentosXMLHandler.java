package parcerXMLdedificios;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class DepartamentosXMLHandler extends DefaultHandler 
{
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		System.out.println("Comienza tag: " + qName);
		
		for( int i=0 ; i<attributes.getLength(); i++ ) 
		{
			System.out.print("    " + attributes.getQName(i) + " = ");
			System.out.println(attributes.getValue(i));
		}
	}

	public void endElement(String uri, String localName, String qName)
	{
		System.out.println("Cierra: " + qName);
	}
}
