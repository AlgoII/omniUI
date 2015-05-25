package ar.com.algo2.jcmd.appmodel;

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoNumerico;
import ar.com.algo2.jcmd.dominio.Comando;
import ar.com.algo2.jcmd.dominio.Etiqueta;
import ar.com.algo2.jcmd.dominio.converters.AplicacionConverter;
import ar.com.algo2.jcmd.dominio.converters.ArgumentoConverter;
import ar.com.algo2.jcmd.dominio.converters.ComandoConverter;
import ar.com.algo2.jcmd.dominio.converters.EtiquetaConverter;

import com.thoughtworks.xstream.XStream;

public class Main {

	public static void main(String[] args) {

//		String xml3 = "<etiqueta>VALOR</etiqueta>";
//		String xml = "<argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la suma\" optional=\"true\"><etiqueta>Operando</etiqueta></argumento>";		
//		String xml2 = "<aplicacion nombre=\"suma\" descripcion=\"sumatoria de dos numeros\"><argumentos><argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la suma\"optional=\"false\" mask=\"#\"><etiqueta>Operando 1</etiqueta></argumento><argumento orden=\"2\" tipo=\"Number\" descripcion=\"segundo operando de la suma\"optional=\"false\"><etiqueta>Operando 2</etiqueta></argumento><argumento orden=\"3\" nombre=\"-m\" tipo=\"Text\"descripcion=\"mensaje a desplegar\" optional=\"true\"><etiqueta>Mensaje</etiqueta></argumento></argumentos></aplicacion> ";
		String xml4 = "<comando nombre=\"calculadora\" alias=\"Calculadora\" descripcion=\"calculadora de linea de comando\"><aplicaciones><aplicacion nombre=\"suma\" descripcion=\"sumatoria de dos numeros\"><argumentos><argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la suma\" optional=\"false\" mask=\"\"><etiqueta>Operando</etiqueta></argumento><argumento orden=\"2\" tipo=\"Number\" descripcion=\"segundo operando de la suma\" optional=\"false\"><etiqueta>Operando</etiqueta></argumento><argumento orden=\"3\" nombre=\"-m\" tipo=\"Text\" descripcion=\"mensaje a desplegar\" optional=\"true\"><etiqueta>Mensaje</etiqueta></argumento></argumentos></aplicacion><aplicacion nombre=\"resta\" descripcion=\"resta de dos numeros\"><argumentos><argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la resta\" optional=\"false\"><etiqueta>Operando</etiqueta></argumento><argumento orden=\"2\" tipo=\"Number\" descripcion=\"segundo operando de la resta\" optional=\"false\"><etiqueta>Operando</etiqueta></argumento></argumentos></aplicacion></aplicaciones><salida>./input/archivo.txt</salida></comando>";
		
		XStream xstream = new XStream();
		
		xstream.alias("argumento", Argumento.class);
		xstream.alias("etiqueta", Etiqueta.class);
		xstream.alias("aplicacion", Aplicacion.class);
		xstream.alias("comando", Comando.class);
	
		xstream.registerConverter(new ArgumentoConverter());
		xstream.registerConverter(new EtiquetaConverter());
		xstream.registerConverter(new AplicacionConverter());
		xstream.registerConverter(new ComandoConverter());
		
//		xstream.registerConverter(new ArgumentoGenericoConverter(xstream.getConverterLookup().lookupConverterForType(Argumento.class), xstream.getReflectionProvider()));
//
//		xstream.addDefaultImplementation(ArgumentoNumerico.class, Argumento.class);
		
//		Etiqueta a = (Etiqueta) xstream.fromXML(xml3);
//		Argumento a = (Argumento) xstream.fromXML(xml);
//		Aplicacion a = (Aplicacion) xstream.fromXML(xml2);
		Comando a = (Comando) xstream.fromXML(xml4);
				
		System.out.println(a.toString());
		
		System.out.println(xstream.toXML(a));
				
	}

}
