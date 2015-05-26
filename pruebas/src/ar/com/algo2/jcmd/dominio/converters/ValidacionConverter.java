package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Accion;
import ar.com.algo2.jcmd.dominio.Validacion;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ValidacionConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Validacion.class);
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		
		Validacion validacion = (Validacion) obj;
		
		writer.startNode("accion"); //TODO: ojo, no se si la acción ya tiene definido el tag
		
		ctx.convertAnother(validacion.getAccion());
				
		//TODO: acá podría venir el marshal de un resultado		
		writer.endNode(); 
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		Validacion validacion = new Validacion();
		
		reader.moveDown();
		
		Accion accion = (Accion) ctx.convertAnother(validacion, Accion.class);
		
		validacion.setAccion(accion);
		
		//TODO: acá podría venir el unmarshal de un resultado		
		
		reader.moveUp();
		
		return validacion;
	}

}
