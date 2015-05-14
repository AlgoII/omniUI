package parcerXMLdedificios;



public class TestXMLParseado 
{
	public static void main(String[] args)
	{
		EdificioTag edificio = EdificioTag.getInstancia();
		
		//Obtengo y muestro los datos del departamento 5
		DepartamentoTag departamento5 = edificio.getDepartamento();
		System.out.println(departamento5.getNumero());
		System.out.println(departamento5.getPiso());
		System.out.println(departamento5.getTitular());
		
		/*//Obtengo y muestro los datos del departamento 6
		DepartamentoTag departamento6 = edificio.getDepartamentoTag("6");
		System.out.println(departamento6.getNumero());
		System.out.println(departamento6.getPiso());
		System.out.println(departamento6.getTitular());*/
	}
}
