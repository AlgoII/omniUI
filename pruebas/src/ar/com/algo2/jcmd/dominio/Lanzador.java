package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	
	List<Comando> comandos = new ArrayList<Comando>();

	public Lanzador(List<Comando> comandos) {
		super();
		this.comandos = comandos;
	}
	
	public Lanzador() {}
	
	public void addComando(Comando comando) {
		this.comandos.add(comando);
	}

	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		for (Comando comando: this.comandos)
			buff.append(comando.toString()).append("\n");
		
		return "Lanzador [comandos=\n" + comandos.toString() + "]";
	}

	public List<Comando> getComandos() {
		return comandos;
	}

	public void setComandos(List<Comando> comandos) {
		this.comandos = comandos;
	}
		

}
