package ar.com.algo2.jcmd.parsers;

import java.io.File;

import com.thoughtworks.xstream.XStream;

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

public class JCmdToolXStreamParser implements JCmdToolParser {

	private XStream xstream = null;

	public JCmdToolXStreamParser() {

		this.xstream = new XStream();

		this.xstream.alias("argumento", Argumento.class);
		this.xstream.alias("etiqueta", String.class);
		this.xstream.alias("aplicacion", Aplicacion.class);
		this.xstream.alias("comando", Comando.class);				
		this.xstream.alias("lanzador", Lanzador.class);
		this.xstream.alias("valor", String.class);
		this.xstream.alias("regla", Regla.class);
		this.xstream.alias("parametro", Parametro.class);
		this.xstream.alias("constante", Constante.class);
		this.xstream.alias("validacion", Validacion.class);
		this.xstream.alias("accion", Accion.class);

		this.xstream.registerConverter(new ArgumentoConverter());
		this.xstream.registerConverter(new AplicacionConverter());
		this.xstream.registerConverter(new ComandoConverter());
		this.xstream.registerConverter(new LanzadorConverter());
		this.xstream.registerConverter(new ReglaConverter());
		this.xstream.registerConverter(new ParametroConverter());
		this.xstream.registerConverter(new ConstanteConverter());
		this.xstream.registerConverter(new AccionConverter());
		this.xstream.registerConverter(new ValidacionConverter());

	}

	@Override
	public Lanzador getLanzadorFromXml(String path) {
		return (Lanzador) this.xstream.fromXML(new File(path));
	}

	@Override
	public String getXmlFromLanzador(Lanzador lanzador) {
		return this.xstream.toXML(lanzador);
	}

}
