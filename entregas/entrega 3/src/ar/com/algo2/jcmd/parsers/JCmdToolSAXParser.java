package ar.com.algo2.jcmd.parsers;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ar.com.algo2.jcmd.dominio.Lanzador;

public class JCmdToolSAXParser implements JCmdToolParser {	

	@Override
	public Lanzador getLanzadorFromXml(String path) {		
		
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			
			JCmdToolSAXParserHandler handler = new JCmdToolSAXParserHandler();

			SAXParser sp = spf.newSAXParser();
			sp.parse(path, handler);

			return handler.getLanzador();
			
		} catch (Exception e) {
			e.printStackTrace(); //TODO: catcheo de la excepción
		}
		
		return null; //no debería llegar
	}

	@Override
	public String getXmlFromLanzador(Lanzador lanzador) {
		return "[IMPLEMENTACION PENDIENTE] JCmdToolSAXParser.getXmlFromLanzador";
	}

}
