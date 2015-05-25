package ar.com.algo2.jcmd.dominio.converters;

import java.util.List;

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Comando;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ComandoConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Comando.class);
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		Comando comando = (Comando) obj;
		writer.addAttribute("nombre", comando.getNombre());
		writer.addAttribute("alias", comando.getAlias());
		writer.addAttribute("descripcion", comando.getDescripcion());	

		List<Aplicacion> aplicaciones = comando.getAplicaciones();
		if (!aplicaciones.isEmpty()) {
			writer.startNode("aplicaciones"); 

			for (Aplicacion aplicacion: aplicaciones) {
				writer.startNode("aplicacion");
				ctx.convertAnother(aplicacion);				
				writer.endNode();
			}

			writer.endNode();
		}
		
		if (comando.getOutput() != null) {
			writer.startNode("output");
			ctx.convertAnother(comando.getOutput());
			writer.endNode();
		}
		
	}
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		Comando comando = new Comando();

		comando.setNombre(reader.getAttribute("nombre"));
		comando.setDescripcion(reader.getAttribute("descripcion"));
		comando.setAlias(reader.getAttribute("alias"));

		reader.moveDown();
		if ("aplicaciones".equals(reader.getNodeName())) {

			@SuppressWarnings("unchecked")
			List<Aplicacion> aplicaciones =  (List<Aplicacion>) ctx.convertAnother(comando,List.class);             

			for(Aplicacion a: aplicaciones)
				comando.addAplicacion(a);

		}
		reader.moveUp();
				
		if (reader.hasMoreChildren()) {		
			reader.moveDown();
			String output = (String) ctx.convertAnother(comando,String.class);

			comando.setOutput(output);
			reader.moveUp();		
		}
						
		return comando;
	}

}
