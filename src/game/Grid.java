package game;

public class Grid 
{
	square[] squares = new square[35];
	PosMove[] moves = new PosMove[35];
	public Grid()
	{
		
		for(int x=0; x<35; x=x+1)
		{
			moves[x] = new PosMove();
			moves[x].posnum=x;
			squares[x] = new square();
			squares[x].posnum=x;
		}
	}
	
	public square getContent(int x)
	{
		if(x>-1 && x<35)
		{
			return squares[x];
		}
		else
		{
			square Jeremy = new square();
			Jeremy.Disease = new disease();
			return Jeremy;
		}
	}
}
