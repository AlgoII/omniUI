package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Etiqueta;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class EtiquetaConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Etiqueta.class); 
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		
		Etiqueta etiqueta = (Etiqueta) obj;		
//		writer.startNode("etiqueta");
		writer.addAttribute("valor", etiqueta.getValor());
//		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		
		
		
		Etiqueta etiqueta = new Etiqueta();
//		reader.moveDown();
		etiqueta.setValor(reader.getValue());
//		reader.moveUp();
			
		return etiqueta;
	}

}
