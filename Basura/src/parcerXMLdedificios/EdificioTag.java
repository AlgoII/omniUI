package parcerXMLdedificios;

//import java.util.Enumeration;
//import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class EdificioTag extends DefaultHandler
{
	private DepartamentoTag departamento; //Subtag de la clase, puede tener muchas instancias de este Tag
	

	private static EdificioTag instancia = null;
	
	private EdificioTag()   //Constructor del tag
	{
		departamento = new DepartamentoTag();  //Subtag de la clase
	}
	
	/*public DepartamentoTag getDepartamentoTag (String name)
	{
		return departamento.get(name);
	}
	public void addDepartamentoTag( DepartamentoTag d)
	{
		departamento.put(d.getNumero(), d);
	}*/
	
	public String toString ()
	{
		String x="";
		//DepartamentoTag aux;
		//Enumeration<String> e = departamento.keys();
		//while (e.hasMoreElements())
		//{
		//	aux = departamento.get(e.nextElement());
		//	x+=aux.toString()+"\n";
		//}
		x += "-- Departamento --\n";
		x += departamento.toString();
		return x;
	}
	
	public static EdificioTag getInstancia()
	{
		try 
		{
			if( instancia == null )
			{
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				sp.parse("edificio.xml", new EdificioTag());
			}
			return instancia;
			
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void startElement (String uri, String localName, String qName, Attributes attributes)
	{
		if( qName.equals("edificio") )
		{
			instancia = new EdificioTag();
		}
		
		if( qName.equals("departamento") )
		{
			DepartamentoTag departamento = new DepartamentoTag();
			departamento.setNumero(attributes.getValue("name"));
			departamento.setPiso(attributes.getValue("piso"));
			departamento.setTitular(attributes.getValue("titular"));
		}
	}

	public void endElement(String uri, String localName, String qName)
	{
		
	}
// Setters y Getters

	public static void setInstancia(EdificioTag instancia) 
	{
		EdificioTag.instancia = instancia;
	}
	public DepartamentoTag getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoTag departamento) {
		this.departamento = departamento;
	}

}
