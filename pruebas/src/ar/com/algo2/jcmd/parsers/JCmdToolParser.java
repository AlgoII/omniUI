package ar.com.algo2.jcmd.parsers;

import ar.com.algo2.jcmd.dominio.Lanzador;

public interface JCmdToolParser {

	public Lanzador getLanzadorFromXml(String path);
	public String getXmlFromLanzador(Lanzador lanzador); //TODO: no solicitado en enunciado, para testing

}
