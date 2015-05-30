package omniui.frames;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import omniui.frames.helper.UIHelper;
import omniui.frames.listener.CicloDeVidaListener;

import ar.com.algo2.jcmd.dominio.Argumento;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoDate;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAplicacion extends JFrame
{
	private static final int ALTO_PANEL = 33;

	private CicloDeVidaListener listener;
	
	private JPanel contentPane;
	private JPanel panelArgumentos;

	private ArrayList<Argumento> argumentos;
	private JButton btnSalir;
	
	public FrameAplicacion(ArrayList<Argumento> argumentos, CicloDeVidaListener listener) {
//		this.argumentos = argumentos;
		ArgumentoBoolean argumentoBoolean = new ArgumentoBoolean();
		argumentoBoolean.setDescripcion("Argumento 1");
		argumentoBoolean.setHabilitado(false);
		argumentoBoolean.setValorInicial(true);
		ArgumentoBoolean argumentoBoolean2 = new ArgumentoBoolean();
		argumentoBoolean2.setDescripcion("Argumento 2");
		argumentoBoolean2.setHabilitado(true);
		argumentoBoolean2.setValorInicial(false);
		ArgumentoDate argumentoDate = new ArgumentoDate();
		argumentoDate.setDescripcion("Argumento 3");
		argumentoDate.setHabilitado(true);
		argumentoDate.setFormato("YYYYMMDD");
		ArgumentoDate argumentoDate2 = new ArgumentoDate();
		argumentoDate2.setDescripcion("Argumento 4");
		argumentoDate2.setHabilitado(false);
		argumentoDate2.setFormato("DD-MM-YYYY");
		this.argumentos = new ArrayList<>();
		this.argumentos.add(argumentoBoolean);
		this.argumentos.add(argumentoBoolean2);
		this.argumentos.add(argumentoDate);
		this.argumentos.add(argumentoDate2);
		
		this.listener = listener;
		
		this.configureFrame();
		
		this.cargarDatos();
		
		this.configurarListeners();
	}

	private void configurarListeners()
	{
		btnSalir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FrameAplicacion.this.listener.seCerroElFrame();
				dispose();
			}
		});
		
	}

	private void configureFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,590,347);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 11, 427, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblArgumentos = new JLabel("Argumentos");
		lblArgumentos.setForeground(Color.BLUE);
		lblArgumentos.setBounds(10, 11, 91, 14);
		panel.add(lblArgumentos);
		
		panelArgumentos = new JPanel();
		panelArgumentos.setBackground(SystemColor.activeCaptionBorder);
		panelArgumentos.setBounds(10, 36, 407, 137);
		panel.add(panelArgumentos);
		panelArgumentos.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(475, 275, 89, 23);
		contentPane.add(btnSalir);
	}
	
	private void cargarDatos()
	{
		int alto = 0;
		for(Argumento argumento : this.argumentos)
		{
			JPanel panelArgumento = UIHelper.getUIControl(argumento);
			panelArgumento.setVisible(true);
			panelArgumento.setBounds(0, alto, 407, ALTO_PANEL);
			panelArgumentos.add(panelArgumento);
			alto = alto + ALTO_PANEL;
			panelArgumentos.setBounds(10, 36, 407, alto);
		}
	}
	
}
