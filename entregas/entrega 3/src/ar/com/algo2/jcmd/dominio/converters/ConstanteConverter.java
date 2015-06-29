package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Constante;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class ConstanteConverter implements SingleValueConverter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Constante.class);
	}

	@Override
	public Object fromString(String value) {
		return new Constante(value);
	}

	@Override
	public String toString(Object obj) {
		return ((Constante) obj).getValor();
	}

}
