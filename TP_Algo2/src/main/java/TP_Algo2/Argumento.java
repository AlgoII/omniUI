package TP_Algo2;

import java.util.List;
import java.util.ArrayList;

public class Argumento
{
	String alternativo;
	boolean auxiliar;
	String descripcion;
	boolean habilitado;
	String label;
	String nombre;
	boolean optional;
	Integer orden;
	String separador;
	String tipo;
	List<Regla> reglas;
	
	//setters y getters
	public Argumento()
	{
		reglas = new ArrayList<Regla>();
	}
	
	public List<Regla> getReglas()
	{
		return reglas;
	}
	
	public void setReglas(List<Regla> reglas)
	{
		this.reglas=reglas;
	}
	
	
	
	public String getAlternativo()
	{
		return alternativo;
	}
	public void setAlternativo(String alternativo)
	{
		this.alternativo=alternativo;
	}
	public boolean isAuxiliar()
	{
		return auxiliar;
	}
	public void setAuxiliar(String auxiliar)
	{
		if(auxiliar!=null)
		{
		if(auxiliar.equals("true"))
		{
		this.auxiliar=true;
		}
		if(auxiliar.equals("false"))
		{
		this.auxiliar=false;
		}
		}
		
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	public boolean isHabilitado()
	{
		return habilitado;
	}
	public void setHabilitado(String habilitado)
	{
		if(habilitado!=null)
		{
		if(habilitado.equals("true"))
		{
		this.habilitado=true;
		}
		if(habilitado.equals("false"))
		{
		this.habilitado=false;
		}
		}
	}
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label=label;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public boolean isOptional()
	{
		return optional;
	}
	public void setOptional(String optional)
	{
		if(optional!=null)
		{
		if(optional.equals("true"))
		{
			this.optional=true;
		}
		if(optional.equals("false"))
		{
			this.optional=false;
		}
		}
	}
	
	public Integer getOrden()
	{
		return orden;
	}
	public void setOrden(String orden)
	{
		this.orden = Integer.parseInt(orden);

	}
	public String getSeparador()
	{
		return separador;
	}
	public void setSeparador(String separador)
	{
		this.separador=separador;
	}
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo=tipo;
	}
	
	
	
	
	
}
