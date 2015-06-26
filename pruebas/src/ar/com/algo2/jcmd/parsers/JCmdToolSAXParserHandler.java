package ar.com.algo2.jcmd.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import ar.com.algo2.jcmd.dominio.Accion;
import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoComboBox;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;
import ar.com.algo2.jcmd.dominio.ArgumentoNumerico;
import ar.com.algo2.jcmd.dominio.Comando;
import ar.com.algo2.jcmd.dominio.Constante;
import ar.com.algo2.jcmd.dominio.Lanzador;
import ar.com.algo2.jcmd.dominio.Parametro;
import ar.com.algo2.jcmd.dominio.Regla;
import ar.com.algo2.jcmd.dominio.Validacion;

public class JCmdToolSAXParserHandler extends DefaultHandler {

	private Lanzador lanzador = null;
	private boolean salida = false;
	private boolean etiqueta = false;
	private boolean regla = false;
	private boolean valor = false;
	private boolean parametro = false;
	private boolean constante = false;
	
	public Lanzador getLanzador() {
		return this.lanzador;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{

		if(qName.equals("lanzador"))
		{
			lanzador = new Lanzador();		
		}

		if(qName.equals("comando"))
		{
			Comando comando = new Comando();			
			comando.setAlias(attributes.getValue("alias"));
			comando.setDescripcion(attributes.getValue("descripcion"));
			comando.setNombre(attributes.getValue("nombre"));
			lanzador.getComandos().add(comando);
			
		}

		if(qName.equals("aplicacion"))
		{
			Aplicacion aplicacion = new Aplicacion();
			aplicacion.setDescripcion(attributes.getValue("descripcion"));
			aplicacion.setNombre(attributes.getValue("nombre"));	
			
			lanzador.getUltimoComando().addAplicacion(aplicacion);				
			lanzador.getUltimoComando().getUltimaAplicacion().setComando(lanzador.getUltimoComando());
		}

		if(qName.equals("argumento"))
		{			
			
			if(attributes.getValue("tipo") == null || attributes.getValue("tipo").equals("Text"))
			{	
				Argumento argumento = new Argumento();
				argumento.setAlternativo(attributes.getValue("alternativo"));
				argumento.setAuxiliar(attributes.getValue("auxiliar") != null ? new Boolean(attributes.getValue("auxiliar")) : new Boolean(false));
				argumento.setDescripcion(attributes.getValue("descripcion"));
				argumento.setHabilitado(attributes.getValue("enable") != null ? new Boolean(attributes.getValue("enable")) : new Boolean(true));
				argumento.setNombre(attributes.getValue("nombre"));
				argumento.setOptional(attributes.getValue("optional") != null ? new Boolean(attributes.getValue("optional")) : new Boolean(true));
				argumento.setOrden(attributes.getValue("orden") != null ? new Long(attributes.getValue("orden")) : null);
				argumento.setSeparador(attributes.getValue("separador"));
				argumento.setTipo(attributes.getValue("tipo"));
				
				lanzador.getUltimoComando().getUltimaAplicacion().addArgumento(argumento);
			
			} else if(attributes.getValue("tipo").equals("Boolean")) {
				
				ArgumentoBoolean argumento = new ArgumentoBoolean();
				argumento.setAlternativo(attributes.getValue("alternativo"));
				argumento.setAuxiliar(attributes.getValue("auxiliar") != null ? new Boolean(attributes.getValue("auxiliar")) : new Boolean(false));
				argumento.setDescripcion(attributes.getValue("descripcion"));
				argumento.setHabilitado(attributes.getValue("enable") != null ? new Boolean(attributes.getValue("enable")) : new Boolean(true));
				argumento.setNombre(attributes.getValue("nombre"));
				argumento.setOptional(attributes.getValue("optional") != null ? new Boolean(attributes.getValue("optional")) : new Boolean(true));
				argumento.setOrden(attributes.getValue("orden") != null ? new Long(attributes.getValue("orden")) : null);
				argumento.setSeparador(attributes.getValue("separador"));
				argumento.setTipo(attributes.getValue("tipo"));
				argumento.setValorInicial(attributes.getValue("valorInicial") != null ? new Boolean(attributes.getValue("valorInicial")) : new Boolean(false));
				argumento.setValor("" + argumento.getValorBooleano());

				lanzador.getUltimoComando().getUltimaAplicacion().addArgumento(argumento);
				
			} else if(attributes.getValue("tipo").equals("Number")) {
				
				ArgumentoNumerico argumento = new ArgumentoNumerico();
				argumento.setAlternativo(attributes.getValue("alternativo"));
				argumento.setAuxiliar(attributes.getValue("auxiliar") != null ? new Boolean(attributes.getValue("auxiliar")) : new Boolean(false));
				argumento.setDescripcion(attributes.getValue("descripcion"));
				argumento.setHabilitado(attributes.getValue("enable") != null ? new Boolean(attributes.getValue("enable")) : new Boolean(true));
				argumento.setNombre(attributes.getValue("nombre"));
				argumento.setOptional(attributes.getValue("optional") != null ? new Boolean(attributes.getValue("optional")) : new Boolean(true));
				argumento.setOrden(attributes.getValue("orden") != null ? new Long(attributes.getValue("orden")) : null);
				argumento.setSeparador(attributes.getValue("separador"));
				argumento.setTipo(attributes.getValue("tipo"));
				argumento.setMask(attributes.getValue("mask"));
				
				lanzador.getUltimoComando().getUltimaAplicacion().addArgumento(argumento);
				
			} else if(attributes.getValue("tipo").equals("ComboBox")) {
				
				ArgumentoComboBox argumento = new ArgumentoComboBox();
				argumento.setAlternativo(attributes.getValue("alternativo"));
				argumento.setAuxiliar(attributes.getValue("auxiliar") != null ? new Boolean(attributes.getValue("auxiliar")) : new Boolean(false));
				argumento.setDescripcion(attributes.getValue("descripcion"));
				argumento.setHabilitado(attributes.getValue("enable") != null ? new Boolean(attributes.getValue("enable")) : new Boolean(true));
				argumento.setNombre(attributes.getValue("nombre"));
				argumento.setOptional(attributes.getValue("optional") != null ? new Boolean(attributes.getValue("optional")) : new Boolean(true));
				argumento.setOrden(attributes.getValue("orden") != null ? new Long(attributes.getValue("orden")) : null);
				argumento.setSeparador(attributes.getValue("separador"));
				argumento.setTipo(attributes.getValue("tipo"));				
				
				lanzador.getUltimoComando().getUltimaAplicacion().addArgumento(argumento);				
			
			} else if(attributes.getValue("tipo").equals("Search"))	{
				
				Argumento argumento = new Argumento();
				argumento.setAlternativo(attributes.getValue("alternativo"));
				argumento.setAuxiliar(attributes.getValue("auxiliar") != null ? new Boolean(attributes.getValue("auxiliar")) : new Boolean(false));
				argumento.setDescripcion(attributes.getValue("descripcion"));
				argumento.setHabilitado(attributes.getValue("enable") != null ? new Boolean(attributes.getValue("enable")) : new Boolean(true));
				argumento.setNombre(attributes.getValue("nombre"));
				argumento.setOptional(attributes.getValue("optional") != null ? new Boolean(attributes.getValue("optional")) : new Boolean(true));
				argumento.setOrden(attributes.getValue("orden") != null ? new Long(attributes.getValue("orden")) : null);
				argumento.setSeparador(attributes.getValue("separador"));
				argumento.setTipo(attributes.getValue("tipo"));
				
				lanzador.getUltimoComando().getUltimaAplicacion().addArgumento(argumento);		
			
			} else if(attributes.getValue("tipo").equals("Date")) {
				
				ArgumentoDate argumento = new ArgumentoDate();
				argumento.setAlternativo(attributes.getValue("alternativo"));
				argumento.setAuxiliar(attributes.getValue("auxiliar") != null ? new Boolean(attributes.getValue("auxiliar")) : new Boolean(false));
				argumento.setDescripcion(attributes.getValue("descripcion"));
				argumento.setHabilitado(attributes.getValue("enable") != null ? new Boolean(attributes.getValue("enable")) : new Boolean(true));
				argumento.setNombre(attributes.getValue("nombre"));
				argumento.setOptional(attributes.getValue("optional") != null ? new Boolean(attributes.getValue("optional")) : new Boolean(true));
				argumento.setOrden(attributes.getValue("orden") != null ? new Long(attributes.getValue("orden")) : null);
				argumento.setSeparador(attributes.getValue("separador"));
				argumento.setTipo(attributes.getValue("tipo"));
				argumento.setFormato(attributes.getValue("formato"));
				
				lanzador.getUltimoComando().getUltimaAplicacion().addArgumento(argumento);
			}
		}

		if(qName.equals("validacion"))
		{
			Validacion validacion = new Validacion();			
			lanzador.getUltimoComando().getUltimaAplicacion().addValidacion(validacion);
		}

		if(qName.equals("accion"))
		{
			Accion accion = new Accion();
			accion.setNombre(attributes.getValue("nombre"));	
			
			lanzador.getUltimoComando().getUltimaAplicacion().getUltimaValidacion().setAccion(accion);
		}
	
		if(qName.equals("regla"))
		{
			Regla regla = new Regla();
			lanzador.getUltimoComando().getUltimaAplicacion().getUltimoArgumento().addRegla(regla);
			
			this.regla = true;
		}
		
		if(qName.equals("etiqueta"))
		{
			this.etiqueta = true;
		}

		if(qName.equals("parametro"))
		{
			this.parametro = true;
		}

		if(qName.equals("constante"))
		{
			this.constante = true;
		}

		if(qName.equals("salida"))
		{
			this.salida=true;
		}

		if(qName.equals("valor"))
		{
			this.valor=true;
		}

	}

	public void endElement(String uri, String localName, String qName)
	{
		if(salida)
		{
			this.salida = false;
		}

		if(etiqueta)
		{
			this.etiqueta = false;
			
		}
		if(regla)
		{
			this.regla = false;
		}

		if(valor)
		{
			this.valor = false;
		}

		if(parametro)
		{
			this.parametro = false;
		}

		if(constante)
		{
			this.constante = false;
		}

	}

	public void characters(char ch[], int start, int length)
	{
		if(salida)
		{
			lanzador.getUltimoComando().setOutput(new String(ch, start, length));
			this.salida = false;
		}

		if(etiqueta)
		{						
			lanzador.getUltimoComando().getUltimaAplicacion().getUltimoArgumento().setEtiqueta(new String(ch, start, length));
			this.etiqueta = false;
			
		}
		if(regla)
		{
			lanzador.getUltimoComando().getUltimaAplicacion().getUltimoArgumento().getUltimaRegla().setValidacionSobreCampo(new String(ch, start, length));
			this.regla = false;
		}

		if(valor)
		{
			((ArgumentoComboBox)lanzador.getUltimoComando().getUltimaAplicacion().getUltimoArgumento()).getValores().add(new String(ch, start, length));
			this.valor = false;
		}

		if(parametro)
		{
			lanzador.getUltimoComando().getUltimaAplicacion().getUltimaValidacion().getAccion().addParametro(new Parametro(new String(ch, start, length)));
			this.parametro = false;
		}

		if(constante)
		{
			lanzador.getUltimoComando().getUltimaAplicacion().getUltimaValidacion().getAccion().addParametro(new Constante(new String(ch, start, length)));
			this.constante = false;
		}

	}

}
