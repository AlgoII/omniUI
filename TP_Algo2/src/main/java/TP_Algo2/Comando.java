package TP_Algo2;

import java.util.List;
import java.util.ArrayList;

public class Comando
{
	String alias;
	List<Aplicacion> aplicaciones;
	String descripcion;
	String nombre;
	String salida;
	
	public Comando()
	{
		aplicaciones = new ArrayList<Aplicacion>();
	}
	
	//Setters y Getters
	
	
	public String getAlias()
	{
		return alias;
	}
	public void setAlias(String alias)
	{
		this.alias=alias;
	}
	public List<Aplicacion> getAplicaciones()
	{
		return aplicaciones;
	}
	public void setAplicaciones(List<Aplicacion> aplicaciones)
	{
		this.aplicaciones=aplicaciones;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public String getSalida()
	{
		return salida;
	}
	public void setSalida(String salida)
	{
		this.salida=salida;
	}
	
	
	
	
	

}
