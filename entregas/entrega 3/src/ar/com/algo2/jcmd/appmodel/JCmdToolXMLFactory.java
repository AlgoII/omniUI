package ar.com.algo2.jcmd.appmodel;

import ar.com.algo2.jcmd.dominio.Lanzador;
import ar.com.algo2.jcmd.parsers.JCmdToolParser;
import ar.com.algo2.jcmd.parsers.JCmdToolSAXParser;

public class JCmdToolXMLFactory {

	private static JCmdToolXMLFactory instancia = null;
	private JCmdToolParser parser;

	private JCmdToolXMLFactory() {}
	
	public static JCmdToolXMLFactory getInstance()
	{
		if(instancia == null)			
			instancia = new JCmdToolXMLFactory();
		
		return instancia;
	}
	
	public void init() {
		this.parser = new JCmdToolSAXParser(); //default
	}
	
	public void init(JCmdToolParser parser) {
		this.parser = parser;
	}
	
	public Lanzador getLanzadorFromXml(String path) {				
		return this.parser.getLanzadorFromXml(path);
	}
	
	public String getXmlFromLanzador(Lanzador lanzador) {
		return this.parser.getXmlFromLanzador(lanzador);
	}

}
