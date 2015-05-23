package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.Etiqueta;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class ArgumentoConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {		
		return Argumento.class == clazz;
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {	
	
		Argumento argumento = (Argumento) obj;
//		writer.startNode("argumento");
		writer.addAttribute("orden", ""+argumento.getOrden());
		writer.addAttribute("tipo", ""+argumento.getTipo());
		writer.addAttribute("descripcion", ""+argumento.getDescripcion());
		writer.addAttribute("optional", ""+argumento.getOptional());
		writer.addAttribute("valor", ""+argumento.getValor());
		
		if (argumento.getEtiqueta() != null) {
			writer.startNode("etiqueta"); 
			
			ctx.convertAnother(argumento.getEtiqueta());
		
			writer.endNode();		
		}
//		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		Argumento argumento = new Argumento();
		argumento.setOrden(new Long(reader.getAttribute("orden")));
		argumento.setTipo(reader.getAttribute("tipo"));
		argumento.setDescripcion(reader.getAttribute("descripcion"));
		argumento.setOptional(new Boolean(reader.getAttribute("optional")));
		argumento.setValor(reader.getValue());
		reader.moveDown();
		
		 if ("etiqueta".equals(reader.getNodeName())) {
					 
             Etiqueta etiqueta = (Etiqueta) ctx.convertAnother(argumento, Etiqueta.class);
                    
             argumento.setEtiqueta(etiqueta);
		 }
		
		reader.moveUp();
		
		return argumento;
	}

}
