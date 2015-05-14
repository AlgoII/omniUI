package parcerXMLdedificios;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestXML {

	public static void main(String[] args){
		try {
			SAXParserFactory sax_parcer_factory = SAXParserFactory.newInstance();
			SAXParser sax_parcer = sax_parcer_factory.newSAXParser();
			
			sax_parcer.parse("edificio.xml", new DepartamentosXMLHandler());
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}