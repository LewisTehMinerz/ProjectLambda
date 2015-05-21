package game;

public class Players 
{
	public Player[] players;
	int numPlayers = 0;
	public Players(int num)
	{
		numPlayers = num;
		players = new Player[num];
		for (int x = 0; x<num;x=x+1)
		{
			players[x] = new Player();
		}
	}
	
}
