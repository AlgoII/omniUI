package ar.com.algo2.jcmd.dominio.converters;

import java.util.List;

import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoComboBox;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;
import ar.com.algo2.jcmd.dominio.ArgumentoNumerico;
import ar.com.algo2.jcmd.dominio.Regla;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class ArgumentoConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {		
		return (clazz.equals(Argumento.class) || clazz.equals(ArgumentoNumerico.class) || clazz.equals(ArgumentoDate.class) || clazz.equals(ArgumentoComboBox.class) || clazz.equals(ArgumentoBoolean.class));
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {	

		Argumento argumento = (Argumento) obj;
		if (argumento.getOrden() != null) writer.addAttribute("orden", ""+argumento.getOrden());
		if (argumento.getNombre() != null) writer.addAttribute("nombre", ""+argumento.getNombre());
		if (argumento.getAlternativo() != null) writer.addAttribute("alternativo", ""+argumento.getAlternativo());
		if (argumento.getTipo() != null) writer.addAttribute("tipo", ""+argumento.getTipo());
		if (argumento.getDescripcion() != null) writer.addAttribute("descripcion", ""+argumento.getDescripcion());
		if (argumento.getHabilitado() != null) writer.addAttribute("enable", ""+argumento.getHabilitado());
		if (argumento.getOptional() != null) writer.addAttribute("optional", ""+argumento.getOptional());
		if (argumento.getSeparador() != null) writer.addAttribute("separador", ""+argumento.getSeparador());
	
		if (argumento.getTipo() != null && argumento.getTipo().equalsIgnoreCase("Number")) {
			ArgumentoNumerico argumentoNumerico = (ArgumentoNumerico) obj;
			String mask = argumentoNumerico.getMask();

			if (mask != null)
				writer.addAttribute("mask", mask);
			
		} else if (argumento.getTipo() != null && argumento.getTipo().equalsIgnoreCase("Date")) {
			ArgumentoDate argumentoDate = (ArgumentoDate) obj;
			String formato = argumentoDate.getFormato();

			if (formato != null)
				writer.addAttribute("formato", formato);
			
		} else if (argumento.getTipo() != null && argumento.getTipo().equalsIgnoreCase("Boolean")) {
			ArgumentoBoolean argumentoBoolean = (ArgumentoBoolean) obj;
			Boolean valorInicial = argumentoBoolean.getValorInicial();

			if (valorInicial != null)
				writer.addAttribute("valorInicial","" + valorInicial);
			
		} 
				
		if (argumento.getEtiqueta() != null) {
			writer.startNode("etiqueta"); 

			ctx.convertAnother(argumento.getEtiqueta());

			writer.endNode();		
		}
				
		if (argumento.getTipo() != null && argumento.getTipo().equalsIgnoreCase("ComboBox")) {
			
			ArgumentoComboBox argumentoComboBox = (ArgumentoComboBox) obj;
			
			if (!argumentoComboBox.getValores().isEmpty()) {
				writer.startNode("valores"); 

				for (String valor: argumentoComboBox.getValores()) {
					writer.startNode("valor");
					ctx.convertAnother(valor);				
					writer.endNode();
				}

				writer.endNode();
			}		
		}	
				
		if (!argumento.getReglas().isEmpty()) {
			writer.startNode("reglas"); 

			for (Regla regla: argumento.getReglas()) {
				writer.startNode("regla");
				ctx.convertAnother(regla);				
				writer.endNode();
			}
			
			writer.endNode();
		}
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {

		Argumento argumento = null;

		if ((reader.getAttribute("tipo") == null) || (reader.getAttribute("tipo").equalsIgnoreCase("Text"))  || (reader.getAttribute("tipo").equalsIgnoreCase("Search")) )  
			argumento = new Argumento();
		
		else if (reader.getAttribute("tipo").equalsIgnoreCase("Number"))
			 argumento = new ArgumentoNumerico(reader.getAttribute("mask"));
		
		else if (reader.getAttribute("tipo").equalsIgnoreCase("Date")) 
			 argumento = new ArgumentoDate(reader.getAttribute("formato"));
		 
		else if (reader.getAttribute("tipo").equalsIgnoreCase("ComboBox"))
			 argumento = new ArgumentoComboBox();
			
		else if (reader.getAttribute("tipo").equalsIgnoreCase("Boolean")) 
			 argumento = new ArgumentoBoolean(reader.getAttribute("valorInicial") != null ? new Boolean(reader.getAttribute("valorInicial")) : new Boolean(false));
	
			
		argumento.setNombre(reader.getAttribute("nombre"));
		argumento.setHabilitado(reader.getAttribute("enable") != null ? new Boolean(reader.getAttribute("enable")) : new Boolean(true));
		argumento.setAlternativo(reader.getAttribute("alternativo"));
		argumento.setAuxiliar(reader.getAttribute("auxiliar") != null ? new Boolean(reader.getAttribute("auxiliar")) : new Boolean(false));
		argumento.setSeparador(reader.getAttribute("separador"));
		
		if (reader.getAttribute("orden") != null ) argumento.setOrden(new Long(reader.getAttribute("orden")));
		argumento.setTipo(reader.getAttribute("tipo"));
		argumento.setDescripcion(reader.getAttribute("descripcion"));
		argumento.setOptional(reader.getAttribute("optional") != null ? new Boolean(reader.getAttribute("optional")) : new Boolean(true));
		
		if (reader.hasMoreChildren()) { //caso de los auxiliares sin etiqueta

			reader.moveDown();		
			if ("etiqueta".equals(reader.getNodeName())) {

				String etiqueta = (String) ctx.convertAnother(argumento, String.class);

				argumento.setEtiqueta(etiqueta);
			}
			
			reader.moveUp();
		}
				
		if (argumento.getTipo() != null && argumento.getTipo().equalsIgnoreCase("ComboBox")) {
			reader.moveDown();		

			@SuppressWarnings("unchecked")
			List<String> valores = (List<String>) ctx.convertAnother(argumento, List.class);
			
			for (String valor: valores)
				((ArgumentoComboBox) argumento).addValor(valor);		
						
			reader.moveUp();
		}
		
		if (reader.hasMoreChildren()) {
			reader.moveDown();		
			
			@SuppressWarnings("unchecked")
			List<Regla> reglas = (List<Regla>) ctx.convertAnother(argumento, List.class);

			for (Regla regla: reglas)
				argumento.addRegla(regla);		
			
			reader.moveUp();		
		}

		return argumento;
	}

}

