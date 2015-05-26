package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Accion;
import ar.com.algo2.jcmd.dominio.Constante;
import ar.com.algo2.jcmd.dominio.Parametro;

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

		for (Parametro parametro: accion.getParametros()) {

			writer.startNode("parametro");
			ctx.convertAnother(parametro);
			writer.endNode();
		}

		for (Constante constante: accion.getConstantes()) {
			writer.startNode("constante");
			ctx.convertAnother(constante);
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
				accion.addConstante(constante);

			}
			
			reader.moveUp();
		}

		return accion;
	}

}
