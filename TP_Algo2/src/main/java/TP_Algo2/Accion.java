package TP_Algo2;

import java.util.List;
import java.util.ArrayList;

public class Accion
{
	String nombre;
	List<Constante> constantes;
	List<Parametro> parametros;
	
	public Accion()
	{
		constantes = new ArrayList<Constante>();
		parametros = new ArrayList<Parametro>();
	}
	
	//Setters y getters
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public List<Constante> getConstantes()
	{
		return constantes;
	}
	public void setConstantes(List<Constante> constantes)
	{
		this.constantes=constantes;
	}
	public List<Parametro> getParametros()
	{
		return parametros;
	}
	public void setParametros(List<Parametro> parametros)
	{
		this.parametros=parametros;
	}
	
	

	
	
	
}
