package game;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class listener implements MouseListener 
{
	private boolean mouseclicked = false;
	
	public float getMouseX()
	{
		 Point xy = MouseInfo.getPointerInfo().getLocation();
		 return (float) (xy.x-Game.frame.getLocation().getX());
	}
	
	public float getMouseY()
	{
		 Point xy = MouseInfo.getPointerInfo().getLocation();
		 return (float) ((xy.y-Game.frame.getLocation().getY()));
	}


	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		mouseclicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		mouseclicked = false;
	}
	
	public boolean isClicked()
	{
		return mouseclicked;
	}

}
