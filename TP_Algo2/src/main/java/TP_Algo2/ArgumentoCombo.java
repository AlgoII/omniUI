package TP_Algo2;

import java.util.List;
import java.util.ArrayList;

public class ArgumentoCombo extends Argumento
{

	List<String> valores;
	
	public ArgumentoCombo()
	{
		valores = new ArrayList<String>();
	}

	public List<String> getValores()
	{
		return valores;
	}

	public void setValores(List<String> valores)
	{
		this.valores=valores;
	}
	
	public void agregarValor(String valor)
	{
		this.valores.add(valor);
	}
	
	
}
