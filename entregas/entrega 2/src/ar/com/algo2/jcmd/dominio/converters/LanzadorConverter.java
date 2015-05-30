package ar.com.algo2.jcmd.dominio.converters;

import java.util.List;

import ar.com.algo2.jcmd.dominio.Comando;
import ar.com.algo2.jcmd.dominio.Lanzador;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LanzadorConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Lanzador.class); 

	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		Lanzador lanzador = (Lanzador) obj;
		
		List<Comando> comandos = lanzador.getComandos();
		
		if (!comandos.isEmpty())
			for (Comando comando: comandos) {	
				writer.startNode("comando");
				ctx.convertAnother(comando);
				writer.endNode();
			}
				
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {

		Lanzador lanzador = new Lanzador();

		@SuppressWarnings("unchecked")
		List<Comando> comandos =  (List<Comando>) ctx.convertAnother(lanzador,List.class);             
						
		for(Comando comando: comandos)	
			lanzador.addComando(comando);


		return lanzador;

	}

}
