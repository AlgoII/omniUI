package omniui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import omniui.frames.listener.CicloDeVidaListener;
import omniui.objetos.Objeto;

public class FrameLanzador extends JFrame implements CicloDeVidaListener
{
	private JPanel contentPane;
	private JList listaComandos;
	private JLabel lblComandodescripcion;
	
	private JButton btnNewButton;
	
	private ArrayList<Objeto> comandos;

	@Override
	public void seCerroElFrame()
	{
		btnNewButton.setEnabled(true);
	}
	
	/**
	 * Create the frame.
	 */
	public FrameLanzador()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,430,470);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.inicializarArray();
		
		this.configurarFrame();
		this.configurarListeners();
		this.configurarModelo();
	}

	private void inicializarArray()
	{
		Objeto objeto1 = new Objeto("Comando 1", "Descripcion 1");
		Objeto objeto2 = new Objeto("Comando 2", "Descripcion 2");
		Objeto objeto3 = new Objeto("Comando 3", "Descripcion 3");
		
		comandos = new ArrayList<Objeto>();
		comandos.add(objeto1);
		comandos.add(objeto2);
		comandos.add(objeto3);
	}

	private void configurarModelo()
	{
		DefaultListModel model = new DefaultListModel<>();
		
		for(Objeto obj : comandos) {
			model.addElement(obj.getNombre());
		}
		
		listaComandos.setModel(model);
	}

	private void configurarListeners()
	{
		listaComandos.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				if(!e.getValueIsAdjusting())
				{
					String nombreComando = listaComandos.getSelectedValue().toString();
					String descripcion = "";
					
					for(Objeto obj : comandos) {
						if(obj.getNombre().equals(nombreComando)) {
							descripcion = obj.getDescripcion();
						}
					}
					
					lblComandodescripcion.setText(descripcion);
				}
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FrameAplicacion frameLanzador = new FrameAplicacion(null, FrameLanzador.this);
				frameLanzador.setVisible(true);

				btnNewButton.setEnabled(false);
			}
		});
		
	}

	private void configurarFrame()
	{
		listaComandos = new JList();
		listaComandos.setBounds(10, 11, 193, 315);
		contentPane.add(listaComandos);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(282, 52, 122, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deseleccionar");
		btnNewButton_1.setBounds(282, 99, 122, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(315, 388, 89, 23);
		contentPane.add(btnSalir);
		
		lblComandodescripcion = new JLabel("");
		lblComandodescripcion.setBounds(10, 392, 262, 14);
		contentPane.add(lblComandodescripcion);
	}
}
