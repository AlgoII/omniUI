package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Etiqueta;

import com.thoughtworks.xstream.converters.SingleValueConverter;

//si extiendo de AbastractSingleValue, el toString usa el toString de la clase, por eso no me sirves

public class EtiquetaConverter implements SingleValueConverter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Etiqueta.class);
	}

	@Override
	public Object fromString(String value) {
		return new Etiqueta(value);
	}

	@Override
	public String toString(Object obj) {
		return ((Etiqueta) obj).getValor();
	}
}
