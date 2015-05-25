package ar.com.algo2.jcmd.dominio.converters;

import java.util.List;

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AplicacionConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Aplicacion.class); 
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		Aplicacion aplicacion = (Aplicacion) obj;
		if (aplicacion.getNombre() != null) writer.addAttribute("nombre", aplicacion.getNombre());
		if (aplicacion.getDescripcion() != null) writer.addAttribute("descripcion", aplicacion.getDescripcion());	

		List<Argumento> argumentos = aplicacion.getArgumentos();
		if (!argumentos.isEmpty()) {
			writer.startNode("argumentos"); 

			for (Argumento argumento: argumentos) {
				writer.startNode("argumento");
				ctx.convertAnother(argumento);				
				writer.endNode();
			}

			writer.endNode();
		}
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {

		Aplicacion aplicacion = new Aplicacion();

		aplicacion.setNombre(reader.getAttribute("nombre"));
		aplicacion.setDescripcion(reader.getAttribute("descripcion"));

		reader.moveDown();

		if ("argumentos".equals(reader.getNodeName())) {

			@SuppressWarnings("unchecked")
			List<Argumento> argumentos =  (List<Argumento>) ctx.convertAnother(aplicacion,List.class);             

			for(Argumento a: argumentos)
				aplicacion.addArgumento(a);

		}

		reader.moveUp();

		return aplicacion;
	}

}
