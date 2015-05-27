package TP_Algo2;

public class ArgumentoBoolean extends Argumento
{
	boolean valorInicial;

	public boolean isValorInicial()
	{
		return valorInicial;
	}

	public void setValorInicial(String valorInicial)
	{
		if(valorInicial=="true")
		{
		this.valorInicial=true;
		}
		if(valorInicial=="false")
		{
		this.valorInicial=false;
		}
		
	}
	
	

}
