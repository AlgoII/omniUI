package ar.com.algo2.jcmd.dominio.converters;

import ar.com.algo2.jcmd.dominio.Regla;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class ReglaConverter implements SingleValueConverter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(Regla.class);
	}

	@Override
	public Object fromString(String value) {
		return new Regla(value);
	}

	@Override
	public String toString(Object obj) {
		return ((Regla) obj).getValidacionSobreCampo();
	}

}
