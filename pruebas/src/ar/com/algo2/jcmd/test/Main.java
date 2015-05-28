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

////		String xml5 = "<lanzador><comando nombre=\"calculadora\" alias=\"Calculadora\" descripcion=\"calculadora de linea de comando\"><aplicaciones><aplicacion nombre=\"suma\" descripcion=\"sumatoria de dos numeros\"><argumentos><argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la suma\" optional=\"false\" mask=\"##.##\"><etiqueta>Operando</etiqueta></argumento><argumento orden=\"2\" tipo=\"Number\" descripcion=\"segundo operando de la suma\" optional=\"false\"><etiqueta> Operando </etiqueta><reglas><regla>VALOR != null</regla><regla>VALOR > 0</regla></reglas></argumento><argumento orden=\"3\" nombre=\"-m\" tipo=\"Text\" descripcion=\"mensaje a desplegar\" optional=\"true\"><etiqueta> Mensaje </etiqueta></argumento><argumento orden=\"4\" nombre=\"-d\" tipo=\"Date\" descripcion=\"mensaje a desplegar\" optional=\"true\" formato=\"YYYYDDMM\"><etiqueta> Fecha </etiqueta></argumento></argumentos></aplicacion><aplicacion nombre=\"resta\" descripcion=\"resta de dos numeros\"><argumentos><argumento nombre=\"n1\" orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la resta\" optional=\"false\" auxiliar=\"true\"><etiqueta> Operando 1</etiqueta></argumento><argumento orden=\"2\" nombre=\"-n2\" tipo=\"Number\" descripcion=\"segundo operando de la resta\" optional=\"false\" enable=\"false\"><etiqueta> Operando 2 </etiqueta></argumento><argumento orden=\"3\" nombre=\"-cb\" tipo=\"ComboBox\" descripcion=\"segundo operando de la resta\" optional=\"true\"><etiqueta> Operando 3</etiqueta><valores><valor>all</valor><valor>normal</valor><valor>no</valor></valores></argumento><argumento orden=\"4\" nombre=\"-c\" tipo=\"Boolean\" alternativo=\"--checkbox\" descripcion=\"segundo operando de la resta\"	optional=\"false\" separador=\"=\"><etiqueta> Operando 4</etiqueta></argumento></argumentos></aplicacion></aplicaciones><salida>./input/archivo.txt</salida></comando><comando nombre=\"echo\"><aplicaciones><aplicacion><argumentos><argumento><etiqueta> Mensaje </etiqueta></argumento></argumentos><validaciones><validacion><accion nombre=\"habilitarCampoSiCheckboxEstaEnTrue\"><parametro>-v</parametro><parametro>pathVerbose</parametro></accion></validacion><validacion><accion nombre=\"mostrarFechaEnFormatoLatino\"><constante>La fecha de hoy es: </constante><parametro>--date</parametro></accion></validacion></validaciones></aplicacion></aplicaciones><salida>./input/archivo2.txt</salida></comando></lanzador>";		
//		String xml6 = "<lanzador><comando nombre=\"git\" alias=\"Git\" descripcion=\"cliente de Git\"><aplicaciones><aplicacion nombre=\"commit\" descripcion=\"actualiza indice en el repositorio local\"><argumentos><argumento orden=\"1\" nombre=\"-v\" alternativo=\"--verbose\" descripcion=\"muestra lo comitteado\" optional=\"true\" enable=\"true\" tipo=\"Boolean\" valorInicial=\"true\" ><etiqueta>Verboso</etiqueta></argumento><argumento orden=\"2\" nombre=\"pathVerbose\" auxiliar=\"true\" enable=\"false\"  tipo=\"Search\" /><!-- ficticio, no es del comando git. Representaría la ruta del archivo donde dejar el log del -v. Es para mostrar las validaciones generales de la aplicación (ver más abajo) --><argumento orden=\"3\" nombre=\"-m\" alternativo=\"--message\" descripcion=\"mensaje del commit\" optional=\"false\" tipo=\"Text\" ><etiqueta>Mensaje para el log</etiqueta><reglas><regla>VALOR.contains(\".log\")</regla></reglas></argumento><argumento orden=\"4\" nombre=\"-F\" alternativo=\"--file\" descripcion=\"lee mensaje de archivo\" tipo=\"Search\"><etiqueta>Archivo origen del mensaje</etiqueta></argumento><argumento orden=\"5\" nombre=\"-S\" alternativo=\"--gpg-sign\" separador=\"=\" descripcion=\"firma GPG\" tipo=\"Text\"><etiqueta>Key ID</etiqueta></argumento><argumento orden=\"6\" nombre=\"-u\" alternativo=\"--untracked-files\" separador=\"=\" descripcion=\"firma GPG\" tipo=\"ComboBox\"><etiqueta>Modo</etiqueta><valores><valor>all</valor><valor>normal</valor><valor>no</valor></valores></argumento><argumento orden=\"7\" nombre=\"--status\" descripcion=\"incluye status en el mensaje del commit\" tipo=\"Boolean\" valorInicial=\"false\" /><argumento orden=\"8\" nombre=\"-m\" alternativo=\"--mainline\" descripcion=\"numero padre\" tipo=\"Number\" mask=\"#\"><etiqueta>Version</etiqueta><reglas><regla>VALOR != null</regla><regla>VALOR > 0</regla></reglas></argumento><!-- este campo es del git revert, se agrega para mostrar el campo numérico --><argumento orden=\"9\" nombre=\"--date\" descripcion=\"sobreescribe la fecha del commit\" tipo=\"Date\" mask=\"YYYYMMDD\"><etiqueta>Fecha del commit</etiqueta></argumento><argumento><etiqueta>Nombre(s) de archivo(s)</etiqueta></argumento></argumentos><validaciones><validacion><accion nombre=\"habilitarCampoSiCheckboxEstaEnTrue\"><parametro>-v</parametro><parametro>pathVerbose</parametro></accion></validacion><validacion><accion nombre=\"mostrarFechaEnFormatoLatino\"><constante>La fecha de hoy es: </constante><parametro>--date</parametro></accion></validacion></validaciones></aplicacion></aplicaciones><salida>./input/archivo.txt</salida></comando><comando nombre=\"echo\"><aplicaciones><aplicacion><argumentos><argumento><etiqueta>Mensaje</etiqueta></argumento></argumentos></aplicacion></aplicaciones></comando></lanzador>";
//		
//		XStream xstream = new XStream();
//		
//		xstream.alias("argumento", Argumento.class);
//		xstream.alias("etiqueta", String.class);
//		xstream.alias("aplicacion", Aplicacion.class);
//		xstream.alias("comando", Comando.class);				
//		xstream.alias("lanzador", Lanzador.class);
//		xstream.alias("valor", String.class);
//		xstream.alias("regla", Regla.class);
//		xstream.alias("parametro", Parametro.class);
//		xstream.alias("constante", Constante.class);
//		xstream.alias("validacion", Validacion.class);
//		xstream.alias("accion", Accion.class);
//			
//		xstream.registerConverter(new ArgumentoConverter());
//		xstream.registerConverter(new AplicacionConverter());
//		xstream.registerConverter(new ComandoConverter());
//		xstream.registerConverter(new LanzadorConverter());
//		xstream.registerConverter(new ReglaConverter());
//		xstream.registerConverter(new ParametroConverter());
//		xstream.registerConverter(new ConstanteConverter());
//		xstream.registerConverter(new AccionConverter());
//		xstream.registerConverter(new ValidacionConverter());
//		
//		Lanzador a = (Lanzador) xstream.fromXML(xml6);
//						
//		System.out.println(a.toString());
//		
//		System.out.println(xstream.toXML(a));
				
		JCmdToolXMLFactory xmlFactory = JCmdToolXMLFactory.getInstance();
		xmlFactory.init(new JCmdToolXStreamParser());
		
		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		System.out.println(lanzador.toString());
		
		System.out.println(xmlFactory.getXmlFromLanzador(lanzador));

		
		
	}

}
