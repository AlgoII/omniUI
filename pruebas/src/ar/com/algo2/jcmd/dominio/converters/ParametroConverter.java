package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Parametro;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class ParametroConverter implements SingleValueConverter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Parametro.class);
	}

	@Override
	public Object fromString(String value) {
		return new Parametro(value);
	}

	@Override
	public String toString(Object obj) {
		return ((Parametro) obj).getValor();
	}

}
