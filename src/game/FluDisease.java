package game;

import java.awt.Color;

public class FluDisease extends disease
{
	@Override
	public Color getColor()
	{
		return Color.YELLOW;
	}
	
	public void whenClicked(int posnum)
	{
		
	}
	public String onMouseover()
	{
		return "Flu";
	}
	
	public void Special(int posnum)
	{
		boolean[] Jerry;
		Jerry = new boolean[8];
		if(posnum - 7 > -1 && Game.grid.getContent(posnum - 7).Disease.getClass() != this.getClass()
				&& (posnum - 7 > -1 && Game.grid.getContent(posnum - 7).Disease.getClass() != (new BlankDisease().getClass())))
		{
			Jerry[0] = true;
		}
		else
		{
			Jerry[0] = false;
		}
		//}
		if(posnum/7 == (posnum-1)/7 && posnum != 0 && Game.grid.getContent(posnum - 1).Disease.getClass() != this.getClass()
				&& (posnum/7 == (posnum-1)/7 && Game.grid.getContent(posnum - 1).Disease.getClass() != new BlankDisease().getClass()))
		{
			Jerry[1] = true;
		}
		else
		{
			Jerry[1] = false;
		}
		if(posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum + 1).Disease.getClass() != this.getClass()
				&& posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum + 1).Disease.getClass() != new BlankDisease().getClass())
		{
			Jerry[2] = true;
		}
		else
		{
			Jerry[2] = false;
		}
		if(posnum + 7 <= 34 && Game.grid.getContent(posnum + 7).Disease.getClass() != this.getClass()
				&& (posnum + 7 <= 34 && Game.grid.getContent(posnum + 7).Disease.getClass() != (new BlankDisease().getClass())))
		{
			Jerry[3] = true;
		}
		else
		{
			Jerry[3] = false;
		}
		if(posnum - 7 > -1 && Game.grid.getContent(posnum - 8).Disease.getClass() != this.getClass() &&
				posnum/7 == (posnum-1)/7 && posnum != 0 && Game.grid.getContent(posnum - 8).Disease.getClass() != this.getClass()
				&& (posnum - 7 > -1 && Game.grid.getContent(posnum - 8).Disease.getClass() != (new BlankDisease().getClass()) &&
				posnum/7 == (posnum-1)/7 && Game.grid.getContent(posnum -8).Disease.getClass() != new BlankDisease().getClass()))
		{
			Jerry[4] = true;
		}
		else
		{
			Jerry[4] = false;
		}
		if(posnum - 7 > -1 && Game.grid.getContent(posnum - 6).Disease.getClass() != this.getClass() &&
				posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum - 6).Disease.getClass() != this.getClass()
				&& (posnum - 7 > -1 && Game.grid.getContent(posnum - 6).Disease.getClass() != (new BlankDisease().getClass()) &&
				posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum - 6).Disease.getClass() != new BlankDisease().getClass()))
		{
			Jerry[5] = true;
		}
		else
		{
			Jerry[5] = false;
		}
		if(posnum + 7 <= 34 && Game.grid.getContent(posnum + 6).Disease.getClass() != this.getClass() &&
				posnum/7 == (posnum-1)/7 && posnum != 0 && Game.grid.getContent(posnum + 6).Disease.getClass() != this.getClass()
				&& (posnum + 7 <= 34 && Game.grid.getContent(posnum + 6).Disease.getClass() != (new BlankDisease().getClass()) &&
				posnum/7 == (posnum-1)/7 && Game.grid.getContent(posnum + 6).Disease.getClass() != new BlankDisease().getClass()))
		{
			Jerry[6] = true;
		}
		else
		{
			Jerry[6] = false;
		}
		if((posnum + 7 <= 34 && Game.grid.getContent(posnum + 8).Disease.getClass() != (this.getClass()) &&
				posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum + 8).Disease.getClass() != this.getClass()) 
				&& (posnum + 7 <= 34 && Game.grid.getContent(posnum + 8).Disease.getClass() != (new BlankDisease().getClass()) &&
				posnum/7 == (posnum+1)/7 && Game.grid.getContent(posnum + 8).Disease.getClass() != new BlankDisease().getClass()))
		{
			Jerry[7] = true;
		}
		else
		{
			Jerry[7] = false;
		}
		
		for(int x = 0; x<8; x=x+1)
		{
			if(x == 0 && Jerry[x])
			{
				Game.grid.squares[posnum-7].Disease=new FluDisease();
				Game.grid.squares[posnum-7].age = 0;
			}
			if(x == 1 && Jerry[x])
			{
				Game.grid.squares[posnum-1].Disease=new FluDisease();
				Game.grid.squares[posnum-1].age = 0;
			}
			if(x == 2 && Jerry[x])
			{
				Game.grid.squares[posnum+1].Disease=new FluDisease();
				Game.grid.squares[posnum+1].age = 0;
			}
			if(x == 3 && Jerry[x])
			{
				Game.grid.squares[posnum+7].Disease=new FluDisease();
				Game.grid.squares[posnum+7].age = 0;
			}
			if(x == 4 && Jerry[x])
			{
				Game.grid.squares[posnum-8].Disease=new FluDisease();
				Game.grid.squares[posnum-8].age = 0;
			}
			if(x == 5 && Jerry[x])
			{
				Game.grid.squares[posnum-6].Disease=new FluDisease();
				Game.grid.squares[posnum-6].age = 0;
			}
			if(x == 6 && Jerry[x])
			{
				Game.grid.squares[posnum+6].Disease=new FluDisease();
				Game.grid.squares[posnum+6].age = 0;
			}
			if(x == 7 && Jerry[x])
			{
				Game.grid.squares[posnum+8].Disease=new FluDisease();
				Game.grid.squares[posnum+8].age = 0;
			}
		}
		
		for(int x = 0; x<35; x=x+1)
		{
			Game.grid.moves[x].isOn = false;
		}
	}
}
