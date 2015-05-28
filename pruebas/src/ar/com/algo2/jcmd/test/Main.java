package ar.com.algo2.jcmd.test;

import ar.com.algo2.jcmd.appmodel.JCmdToolXMLFactory;
import ar.com.algo2.jcmd.dominio.Accion;
import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.Comando;
import ar.com.algo2.jcmd.dominio.Constante;
import ar.com.algo2.jcmd.dominio.Lanzador;
import ar.com.algo2.jcmd.dominio.Parametro;
import ar.com.algo2.jcmd.dominio.Regla;
import ar.com.algo2.jcmd.dominio.Validacion;
import ar.com.algo2.jcmd.dominio.converters.AccionConverter;
import ar.com.algo2.jcmd.dominio.converters.AplicacionConverter;
import ar.com.algo2.jcmd.dominio.converters.ArgumentoConverter;
import ar.com.algo2.jcmd.dominio.converters.ComandoConverter;
import ar.com.algo2.jcmd.dominio.converters.ConstanteConverter;
import ar.com.algo2.jcmd.dominio.converters.LanzadorConverter;
import ar.com.algo2.jcmd.dominio.converters.ParametroConverter;
import ar.com.algo2.jcmd.dominio.converters.ReglaConverter;
import ar.com.algo2.jcmd.dominio.converters.ValidacionConverter;
import ar.com.algo2.jcmd.parsers.JCmdToolXStreamParser;

import com.thoughtworks.xstream.XStream;

public class Main {

	public static void main(String[] args) {
				
		JCmdToolXMLFactory xmlFactory = JCmdToolXMLFactory.getInstance();
		xmlFactory.init(new JCmdToolXStreamParser());
		
		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		System.out.println(lanzador.toString());
		
		System.out.println(xmlFactory.getXmlFromLanzador(lanzador));
			
	}

}
