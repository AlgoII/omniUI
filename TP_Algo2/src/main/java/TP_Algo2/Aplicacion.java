package TP_Algo2;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion
{
	List<Argumento> argumentos;
	String descripcion;
	String nombre;
	List<Validacion> validaciones;
	
	public Aplicacion()
	{
		argumentos = new ArrayList<Argumento>();
		validaciones = new ArrayList<Validacion>();
	}
	//Setters y Getters
	
	public List<Argumento> getArgumentos()
	{
		return argumentos;
	}
	public void setArgumentos(List<Argumento> argumentos)
	{
		this.argumentos=argumentos;
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
	public List<Validacion> getValidaciones()
	{
		return validaciones;
	}
	public void setValidaciones(List<Validacion> validaciones)
	{
		this.validaciones=validaciones;
	}
	
	
	
	
	

}
