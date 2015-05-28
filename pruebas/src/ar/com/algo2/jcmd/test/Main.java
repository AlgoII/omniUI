package ar.com.algo2.jcmd.test;

import ar.com.algo2.jcmd.appmodel.JCmdToolXMLFactory;
import ar.com.algo2.jcmd.dominio.Lanzador;
import ar.com.algo2.jcmd.parsers.JCmdToolSAXParser;
import ar.com.algo2.jcmd.parsers.JCmdToolXStreamParser;

public class Main {

	public static void main(String[] args) {
				
		JCmdToolXMLFactory xmlFactory = JCmdToolXMLFactory.getInstance();
		xmlFactory.init(new JCmdToolXStreamParser());
//		xmlFactory.init(new JCmdToolSAXParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		System.out.println(lanzador.toString());
		
		System.out.println(xmlFactory.getXmlFromLanzador(lanzador));
					
	}
}
