package TP_Algo2;

public class TestXML
{
	
	public static void main(String[] args)
	{
		Lanzador lanzador = Lanzador.getInstancia();

		for(Comando com: lanzador.comandos)
		{
			System.out.println("Comando: "+com.nombre);
			
			for(Aplicacion ap : com.aplicaciones)
			{
				System.out.println("Aplicacion: "+ap.nombre);
				
				for(Argumento arg : ap.argumentos)
				{
					System.out.println("Argumento: "+arg.nombre);
				}
				for(Validacion val: ap.validaciones)
				{
					System.out.println("Validacion, nombre de Accion: "+val.accion.nombre);
				}
			}
			
		}
	}
}
