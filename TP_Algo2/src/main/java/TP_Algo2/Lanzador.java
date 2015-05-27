package TP_Algo2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;


public class Lanzador extends DefaultHandler
{
	List<Comando> comandos;
	
	private static Lanzador instancia = null;
	
	private Lanzador()
	{
		comandos = new ArrayList<Comando>();
	}
	
	public static Lanzador getInstancia()
	{
		try
		{
			if(instancia==null)
			{
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				sp.parse("xml-spec-v7.xml",new Lanzador());
			}
			
			return instancia;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	Aplicacion ultimaAplicacion = null;
	Comando ultimoComando = null;
	Argumento ultimoArgumento = null;
	Validacion ultimaValidacion = null;
	Accion ultimaAccion = null;
	ArgumentoCombo ultimoArgumentoCombo = null;
	Regla ultimaRegla = null;
	boolean salida = false;
	boolean etiqueta = false;
	boolean regla = false;
	boolean valor = false;

	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		
		if(qName.equals("lanzador"))
		{
			instancia = new Lanzador();
			
		}
		
		if(qName.equals("comando"))
		{
			Comando comando = new Comando();
			
			instancia.comandos.add(comando);
			comando.setAlias(attributes.getValue("alias"));
			comando.setDescripcion(attributes.getValue("descripcion"));
			comando.setNombre(attributes.getValue("nombre"));
			comando.setSalida(attributes.getValue("salida"));
			
			this.ultimoComando = comando;
		}
		
		if(qName.equals("aplicacion"))
		{
			Aplicacion aplicacion = new Aplicacion();
			ultimoComando.aplicaciones.add(aplicacion);
			aplicacion.setDescripcion(attributes.getValue("descripcion"));
			aplicacion.setNombre(attributes.getValue("nombre"));

			
			this.ultimaAplicacion = aplicacion;
		}
		
		
		if((qName.equals("argumento"))&&(attributes.getLength()>1))
		{
			if(attributes.getValue("tipo").equals("Boolean"))
			{
			ArgumentoBoolean argumento = new ArgumentoBoolean();
			ultimaAplicacion.argumentos.add(argumento);
			this.ultimoArgumento = argumento;
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			argumento.setValorInicial(attributes.getValue("valorInicial"));
			}
			
			if(attributes.getValue("tipo").equals("Text"))
			{	
			Argumento argumento = new Argumento();
			ultimaAplicacion.argumentos.add(argumento);
			this.ultimoArgumento = argumento;
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			}
			
			if(attributes.getValue("tipo").equals("Number"))
			{
			ArgumentoNumerico argumento = new ArgumentoNumerico();
			ultimaAplicacion.argumentos.add(argumento);
			this.ultimoArgumento = argumento;
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			argumento.setMascara(attributes.getValue("mascara"));
			}
			
			if(attributes.getValue("tipo").equals("ComboBox"))
			{
			ArgumentoCombo argumento = new ArgumentoCombo();
			ultimaAplicacion.argumentos.add(argumento);
			this.ultimoArgumento = argumento;
			this.ultimoArgumentoCombo = argumento;
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			}
			
			if(attributes.getValue("tipo").equals("Search"))
			{	
			Argumento argumento = new Argumento();
			ultimaAplicacion.argumentos.add(argumento);
			this.ultimoArgumento = argumento;
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			}
			
			if(attributes.getValue("tipo").equals("Date"))
			{
			ArgumentoDate argumento = new ArgumentoDate();
			ultimaAplicacion.argumentos.add(argumento);
			this.ultimoArgumento = argumento;
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			argumento.setFormato(attributes.getValue("formato"));
			}
		}
			
		if(qName.equals("validacion"))
		{
			Validacion validacion = new Validacion();
			ultimaAplicacion.validaciones.add(validacion);
			
			this.ultimaValidacion = validacion;
			
		}
		
		if(qName.equals("accion"))
		{
			Accion accion = new Accion();
			ultimaValidacion.accion=accion;
			accion.setNombre(attributes.getValue("nombre"));
			
			this.ultimaAccion = accion;
		}
		
		if(qName.equals("etiqueta"))
		{
			this.etiqueta = true;
		}
		
		if(qName.equals("parametro"))
		{
			Parametro parametro = new Parametro();
			
			ultimaAccion.parametros.add(parametro);
			parametro.setValor(attributes.getValue("parametro"));
		}
		
		if(qName.equals("constante"))
		{
			Constante constante = new Constante();
			
			ultimaAccion.constantes.add(constante);
			constante.setValor(attributes.getValue("parametro"));
		}
		
		if(qName.equals("salida"))
		{
			this.salida=true;;
		}
		if(qName.equals("regla"))
		{
			Regla regla = new Regla();
			ultimoArgumento.reglas.add(regla);
			this.ultimaRegla = regla;
			this.regla = true;
		}
		if(qName.equals("valor"))
		{
			this.valor=true;
		}
		
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		if(qName.equals("comando"))
		{
			this.ultimoComando = null;
			
		}
		
		if(qName.equals("aplicacion"))
		{
			this.ultimaAplicacion = null;
		}
		
		if(qName.equals("validacion"))
		{
			this.ultimaValidacion = null;
		}
		if(qName.equals("accion"))
		{
			this.ultimaAccion = null;
		}
		if(qName.equals("argumento"))
		{
			this.ultimoArgumento = null;
		}
	}

	public void characters(char ch[], int start, int length)
	{
		if(salida)
		{
			ultimoComando.setSalida(new String(ch, start, length));
			this.salida = false;
		}
		
		if(etiqueta)
		{
			if(ultimoArgumento!=null)
			{
			ultimoArgumento.setLabel(new String(ch, start, length));
			this.etiqueta = false;
			}
		}
		if(regla)
		{
			ultimaRegla.setValidacionSobreCampo(new String(ch, start, length));
			this.regla = false;
		}
		if(valor)
		{
			ultimoArgumentoCombo.agregarValor(new String(ch, start, length));
			this.valor = false;
		}
		
		
	}
	
}
