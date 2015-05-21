package game;

import java.awt.Color;

public class BlankDisease extends disease 
{
	@Override
	public int[] getXposMove()
	{
		int[] Xpos;
		Xpos = new int[0];
		return Xpos;
	}
	
	public int[] getYposMove()
	{
		int[] Ypos;
		Ypos = new int[0];
		return Ypos;
	}
	
	public Color getColor()
	{
		return Color.WHITE;
	}
	
	@Override
	public void whenClicked(int posnum)
	{
		//Game.grid.getContent(posnum).setContains(new TestDisease());
		
	}
	
	public boolean[] SpreadLocation(int posnum)
	{
		boolean[] out = new boolean[4];
		for(int x = 0; x<4; x=x+1)
		{
			out[x] = false;
		}
		return out;
	}
}
