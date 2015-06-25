package ar.com.algo2.jcmd.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ar.com.algo2.jcmd.dominio.Aplicacion;
import ar.com.algo2.jcmd.dominio.Argumento;

public class AceptarListener implements ActionListener {

	private Aplicacion aplicacion;
	private JFrame frame;

	public AceptarListener() {}

	public AceptarListener(JFrame frame, Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		this.frame=frame;
	}

	public void actionPerformed(ActionEvent e) {

		List<Argumento> argumentosObligatorioNoCompletados = new ArrayList<Argumento>();

		StringBuffer cmd = new StringBuffer();

		cmd.append(this.aplicacion.getComando().getNombre()).append(" ");

		for (Argumento a: this.aplicacion.getArgumentos()) {

			if (a.getOptional().booleanValue() == false && (a.getValor() == null || a.getValor().equalsIgnoreCase(""))) {
				argumentosObligatorioNoCompletados.add(a);
				continue;
			}

			cmd.append(a.getNombre()).append(" ").append(a.getValor()).append(" ");
		}

		if (!argumentosObligatorioNoCompletados.isEmpty()) {

			StringBuffer buff = new StringBuffer();

			buff.append("Los siguientes parámetros son obligatorios:\n\n");

			for (Argumento a: argumentosObligatorioNoCompletados) 
				buff.append("        ").append(a.getEtiqueta()).append("\n");


			buff.append("\n\nNo se ejecuta comando");

			JOptionPane.showMessageDialog(this.frame, buff.toString(), "Error en ejecución", JOptionPane.ERROR_MESSAGE);			
			return;
		}

		try {

			//si es Windows le agrego cmd /c - está pendiente si es Linux, posiblemente haya que poner bash
			Process p = Runtime.getRuntime().exec("" + (System.getProperty("os.name").toLowerCase().contains("Windows".toLowerCase()) == true ? "cmd /c": "") + cmd.toString());
			BufferedReader bi = new BufferedReader (new InputStreamReader(p.getInputStream()));

			String lineaRta;

			StringBuffer rta = new StringBuffer();

			while ((lineaRta = bi.readLine()) != null) 
				rta.append(lineaRta).append("\n");
					
			JOptionPane.showMessageDialog(this.frame, rta.toString(), "Resultado de la ejecución", JOptionPane.INFORMATION_MESSAGE);

			bi.close();
			p.waitFor();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}




