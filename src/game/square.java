package game;

public class square 
{
	//public int x = 0;
	//public int y = 0;
	public int posnum = 0;
	public int age = 0;
	public disease Disease = new BlankDisease();
	
	public square()
	{
		this.age = 0;
	}
	
	public void setContains(disease inDisease)
	{
		Disease = inDisease;
	}
	
	public void whenClicked()
	{
	
	}
	
	public void onTurnEnd()
	{
		Disease.whenClicked(posnum);
		age = age + 1;
		Disease.onAge(age, posnum);
	}
	
	public boolean[] Spread()
	{
		return Disease.SpreadLocation(posnum);
		
	}
}
