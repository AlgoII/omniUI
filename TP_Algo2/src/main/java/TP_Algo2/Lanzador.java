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
				sp.parse("xml-spec-final.xml",new Lanzador());
			}
			
			return instancia;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	public Aplicacion ultimaAplicacion = null;
	public Comando ultimoComando = null;
	public Argumento ultimoArgumento = null;
	public Validacion ultimaValidacion = null;
	public Accion ultimaAccion = null;
	public ArgumentoCombo ultimoArgumentoCombo = null;

	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		
		if(qName.equals("lanzador"))
		{
			instancia = new Lanzador();
			
		}
		
		if(qName.equals("comando"))
		{
			Comando comando = new Comando();
			List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
			
			
			instancia.comandos.add(comando);
			comando.setAlias(attributes.getValue("alias"));
			comando.setAplicaciones(aplicaciones);
			comando.setDescripcion(attributes.getValue("descripcion"));
			comando.setNombre(attributes.getValue("nombre"));
			comando.setSalida(attributes.getValue("salida"));
			
			this.ultimoComando = comando;
		}
		
		if(qName.equals("aplicacion"))
		{
			Aplicacion aplicacion = new Aplicacion();
			List<Validacion> validaciones = new ArrayList<Validacion>();
			List<Argumento> argumentos = new ArrayList<Argumento>();
			
			ultimoComando.aplicaciones.add(aplicacion);
			aplicacion.setArgumentos(argumentos);
			aplicacion.setDescripcion(attributes.getValue("descripcion"));
			aplicacion.setNombre(attributes.getValue("nombre"));
			aplicacion.setValidaciones(validaciones);
			
			this.ultimaAplicacion = aplicacion;
		}
		
		if((qName.equals("argumento"))&&(attributes.getValue("tipo")=="Boolean"))
		{
			ArgumentoBoolean argumento = new ArgumentoBoolean();
			ultimaAplicacion.argumentos.add(argumento);
			List<Regla> reglas = new ArrayList<Regla>();
			
			argumento.setReglas(reglas);
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			
			this.ultimoArgumento = argumento;
			
		}
		
		if((qName.equals("argumento"))&&(attributes.getValue("tipo")=="Text"))
		{
			ArgumentoTexto argumento = new ArgumentoTexto();
			ultimaAplicacion.argumentos.add(argumento);
			List<Regla> reglas = new ArrayList<Regla>();
			
			argumento.setReglas(reglas);
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			
			this.ultimoArgumento = argumento;
			
		}
		
		if((qName.equals("argumento"))&&(attributes.getValue("tipo")=="Number"))
		{
			ArgumentoNumerico argumento = new ArgumentoNumerico();
			ultimaAplicacion.argumentos.add(argumento);
			List<Regla> reglas = new ArrayList<Regla>();
			
			argumento.setReglas(reglas);
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
			
			this.ultimoArgumento = argumento;
		}
		
		if((qName.equals("argumento"))&&(attributes.getValue("tipo")=="ComboBox"))
		{
			ArgumentoCombo argumento = new ArgumentoCombo();
			ultimaAplicacion.argumentos.add(argumento);
			List<Regla> reglas = new ArrayList<Regla>();
			
			argumento.setReglas(reglas);
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			argumento.valores = new ArrayList<String>();
			
			this.ultimoArgumento = argumento;
			this.ultimoArgumentoCombo = argumento;
			
		}
		
		if((qName.equals("argumento"))&&(attributes.getValue("tipo")=="Search"))
		{
			ArgumentoSearch argumento = new ArgumentoSearch();
			ultimaAplicacion.argumentos.add(argumento);
			List<Regla> reglas = new ArrayList<Regla>();
			
			argumento.setReglas(reglas);
			argumento.setAlternativo(attributes.getValue("alternativo"));
			argumento.setAuxiliar(attributes.getValue("auxiliar"));
			argumento.setDescripcion(attributes.getValue("descripcion"));
			argumento.setHabilitado(attributes.getValue("enable"));
			argumento.setNombre(attributes.getValue("nombre"));
			argumento.setOptional(attributes.getValue("optional"));
			argumento.setOrden(attributes.getValue("orden"));
			argumento.setSeparador(attributes.getValue("separador"));
			argumento.setTipo(attributes.getValue("tipo"));
			
			this.ultimoArgumento = argumento;
			
		}
		
		if((qName.equals("argumento"))&&(attributes.getValue("tipo")=="Date"))
		{
			ArgumentoDate argumento = new ArgumentoDate();
			ultimaAplicacion.argumentos.add(argumento);
			List<Regla> reglas = new ArrayList<Regla>();
	
			argumento.setReglas(reglas);
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
			
			this.ultimoArgumento = argumento;
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
			List<Constante> constantes = new ArrayList<Constante>();
			List<Parametro> parametros = new ArrayList<Parametro>();
			accion.setConstantes(constantes);
			accion.setParametros(parametros);
			accion.setNombre(attributes.getValue("nombre"));
			
			this.ultimaAccion = accion;
		}
		
		if(qName.equals("etiqueta"))
		{
			ultimoArgumento.setLabel(attributes.getValue("etiqueta"));
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
			ultimoComando.salida = (attributes.getValue("salida"));
		}
		if(qName.equals("regla"))
		{
			Regla regla = new Regla();
			regla.setValidacionSobreCampo(attributes.getValue("regla"));
			ultimoArgumento.reglas.add(regla);
		}
		if(qName.equals("valor"))
		{
			ultimoArgumentoCombo.valores.add(attributes.getValue("valor"));
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

}
