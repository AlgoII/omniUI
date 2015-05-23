package ar.com.algo2.jcmd.appmodel;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.converters.AplicacionConverter;
import ar.com.algo2.jcmd.dominio.converters.ArgumentoConverter;
import ar.com.algo2.jcmd.dominio.converters.EtiquetaConverter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;

public class Main {

	public static void main(String[] args) {

//		String xml = "<argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la suma\" optional=\"true\"><etiqueta>Operando</etiqueta></argumento>";
		
		//TODO: ArrayList y herencia
		String xml2 = "<aplicacion nombre=\"suma\" descripcion=\"sumatoria de dos numeros\"><argumentos><argumento orden=\"1\" tipo=\"Number\" descripcion=\"primer operando de la suma\"optional=\"false\"><etiqueta>Operando 1</etiqueta></argumento><argumento orden=\"2\" tipo=\"Number\" descripcion=\"segundo operando de la suma\"optional=\"false\"><etiqueta>Operando 2</etiqueta></argumento><argumento orden=\"3\" nombre=\"-m\" tipo=\"Text\"descripcion=\"mensaje a desplegar\" optional=\"true\"><etiqueta>Mensaje</etiqueta></argumento></argumentos></aplicacion> ";
		
		XStream xstream = new XStream();
	
		xstream.registerConverter(new ArgumentoConverter());
		xstream.registerConverter(new EtiquetaConverter());
		xstream.registerConverter(new AplicacionConverter());

		xstream.alias("argumento", Argumento.class); //TODO: con esto no tendría que definir el writer.startNode()/writer.endNode del unmarshall y 	reader.moveDown()/moveUp() en el marshall
		xstream.alias("etiqueta", Argumento.class);
		xstream.alias("aplicacion",Aplicacion.class);
		
//		Argumento a = (Argumento) xstream.fromXML(xml);
		Aplicacion a = (Aplicacion) xstream.fromXML(xml2);
		
		System.out.println(a.toString());
		
		System.out.println(xstream.toXML(a)); //TODO con esto chequeo que el marshall esté ok
		
	}

}
