package omniui.frames;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameBienvenida extends JFrame
{
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					FrameBienvenida frame=new FrameBienvenida();
					frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameBienvenida()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,389,283);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.configurarFrame();
		this.configurarListeners();
	}

	private void configurarListeners()
	{
		btnIngresar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FrameLanzador frameLanzador = new FrameLanzador();
				frameLanzador.setVisible(true);
				dispose();
			}
		});
		
	}

	private void configurarFrame()
	{
		lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBienvenido.setBounds(10, 11, 351, 51);
		contentPane.add(lblBienvenido);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(141, 102, 89, 110);
		contentPane.add(btnIngresar);
	}
}
