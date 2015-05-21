package game;

import java.awt.Color;

public class disease 
{
	public int[] getXposMove()
	{
		int[] Xpos;
		Xpos = new int[35];
		return Xpos;
	}
	
	public int[] getYposMove()
	{
		int[] Ypos;
		Ypos = new int[35];
		return Ypos;
	}
	
	public boolean[] SpreadLocation(int posnum)
	{
		boolean[] Jerry;
		
		/*int temp = 0;
		if(posnum - 7 > -1 && Game.grid.getContent(posnum - 7).Disease.getClass() != this.getClass())
		{
			temp = temp + 1;
		}
		if(posnum%7 == (posnum-1)%7 && Game.grid.getContent(posnum - 1).Disease.getClass() != this.getClass())
		{
			temp = temp + 1;
		}
		if(posnum%7 == (posnum+1)%7 && Game.grid.getContent(posnum + 1).Disease.getClass() != this.getClass())
		{
			temp = temp + 1;
		}
		if(posnum + 7 > -1 && Game.grid.getContent(posnum + 7).Disease.getClass() != this.getClass())
		{
			temp = temp + 1;
		}*/
		Jerry = new boolean[4];
		//if(temp == 0)
		//{
			
		//}
		//if(temp == 1)
		//{
		if(posnum - 7 > -1 && Game.grid.getContent(posnum - 7).Disease.getClass() != this.getClass())
		{
			Jerry[0] = true;
		}
		else
		{
			Jerry[0] = false;
		}
		//}
		if(posnum/7 == (posnum-1)/7 && posnum != 0 && Game.grid.getContent(posnum - 1).Disease.getClass() != this.getClass())
		{
			Jerry[1] = true;
		}
		else
		{
			Jerry[1] = false;
		}
		if(posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum + 1).Disease.getClass() != this.getClass())
		{
			Jerry[2] = true;
		}
		else
		{
			Jerry[2] = false;
		}
		if(posnum + 7 <= 34 && Game.grid.getContent(posnum + 7).Disease.getClass() != this.getClass())
		{
			Jerry[3] = true;
		}
		else
		{
			Jerry[3] = false;
		}
		return Jerry;
	}
	
	public Color getColor()
	{
		return Color.BLUE;
	}
	
	public void whenClicked(int posnum)
	{
		
	}
	
	public void onAge(int age, int posnum)
	{
		if (age > 20)
		{
			Game.grid.getContent(posnum).Disease = new BlankDisease();
			Game.grid.squares[posnum].age = 0;
		}
	}
	
	public String onMouseover()
	{
		return "Disease";
	}
	
	public void Special(int posnum)
	{
		
	}
	
}
