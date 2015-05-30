package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Accion;
import ar.com.algo2.jcmd.dominio.Constante;
import ar.com.algo2.jcmd.dominio.Parametro;
import ar.com.algo2.jcmd.dominio.ParametroValidacion;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AccionConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return (clazz.equals(Accion.class));
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		
		Accion accion = (Accion) obj;

		writer.addAttribute("nombre", accion.getNombre());
		
		for (ParametroValidacion parametro: accion.getParametros()) {

			if (parametro instanceof Parametro) 
				writer.startNode("parametro");
			
			else if (parametro instanceof Constante) 
				writer.startNode("constante");
		
			ctx.convertAnother(parametro);
			writer.endNode();
		}
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {

		Accion accion = new Accion();

		accion.setNombre(reader.getAttribute("nombre"));

		while (reader.hasMoreChildren()) {
			
			reader.moveDown();
			
			if ("parametro".equals(reader.getNodeName())) {
				Parametro parametro = (Parametro) ctx.convertAnother(accion, Parametro.class);
				accion.addParametro(parametro);

			} else if ("constante".equals(reader.getNodeName())) {
				Constante constante = (Constante) ctx.convertAnother(accion, Constante.class);
				accion.addParametro(constante);

			}
			
			reader.moveUp();
		}

		return accion;
	}

}
