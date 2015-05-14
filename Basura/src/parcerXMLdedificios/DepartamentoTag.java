package parcerXMLdedificios;

public class DepartamentoTag 
{
	private String name;
	private String piso;
	private String titular;


	public String toString()
	{
		return name +", "+ piso +", "+ titular;
	}
	
	// Setter y getters
		public String getNumero() {
			return name;
		}

		public void setNumero(String numero) {
			this.name = numero;
		}

		public String getPiso() {
			return piso;
		}

		public void setPiso(String piso) {
			this.piso = piso;
		}

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}	
}
