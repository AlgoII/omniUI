package omniui.frames.models;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import omniui.objetos.Objeto;

public class ComandosModel extends DefaultListModel<Objeto>
{
	private static final long serialVersionUID=1L;

	private ArrayList<Objeto> objetos;
	
	public ComandosModel(ArrayList<Objeto> objetos)
	{
		this.objetos=objetos;
	}

	@Override
	public int getSize()
	{
		return objetos.size();
	}
	
	@Override
	public void add(int index, Objeto element)
	{
		super.add(index, objetos.get(index));
	}
	
	
}
