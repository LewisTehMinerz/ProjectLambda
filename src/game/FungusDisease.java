package game;

import java.awt.Color;

public class FungusDisease extends disease
{
	public Color getColor()
	{
		return new Color(165,42,42);
	}
	
	public String onMouseover()
	{
		return "Fungus";
	}
	
	@Override
	public void onAge(int age, int posnum) 
	{
		super.onAge(age, posnum);
	}
	
	@Override
	public void Special(int posnum) 
	{
		
		/*int playernum = 2;
		for(int x = 0; x<Game.players.players.length; x=x+1)
		{
			if(Game.players.players[x].Disease.getClass() == new FungusDisease().getClass())
			{
				playernum = x;
			}
			
		}
		// O Auto-generated method stub
		//super.Special(posnum);
		int [] count = new int[Game.players.players.length];
		for(int x = 0; x<Game.players.players.length; x=x+1)
		{
			for(int u = 0; u<count.length;u=u+1)
			{
				count[u] = 0;
			}
			for (int y = 0; y<35; y=y+1)
			{
				for(int i = 0; i<Game.players.players.length; i=i+1)
				{
					if(Game.grid.squares[y].Disease.getClass() 
							== Game.players.players[i].Disease.getClass())
					{
						count[i] = count[i] + 1;
					}

				}
			}
		}
		//count[playernum] = count[playernum];*/
		//boolean[] Jerry;
		//Jerry = new boolean[4];
		boolean[] Jarry = new boolean[35];
		
		for(int x = 0; x<35;x=x+1)
		{
				if(( Game.grid.getContent(x - 7).Disease.getClass() == this.getClass()) 
						|| (x/7 == (x-1)/7 && posnum != 0 && Game.grid.getContent(x - 1).Disease.getClass() == this.getClass())
						|| (x/7 == (x+1)/7 && Game.grid.getContent(x + 1).Disease.getClass() == this.getClass())
						|| (Game.grid.getContent(x + 7).Disease.getClass() == this.getClass()))
				{
					Jarry[x] = true;
				}
				else
				{
					Jarry[x] = false;
				}
			
		}
		
		for(int x = 0; x<35; x=x+1)
		{
			if(Jarry[x])
			{
				Game.grid.squares[x].Disease = new FungusDisease();
				Game.grid.squares[x].age = 0;
			}
		}
		for(int x = 0; x<35; x=x+1)
		{
			Game.grid.moves[x].isOn = false;
		}
	}
}
