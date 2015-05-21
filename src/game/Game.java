package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.geom.Ellipse2D;



import java.awt.Image;
import java.awt.Point;
//import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
import java.io.IOException;
//import java.io.InputStream;







import java.util.concurrent.TimeUnit;


//import javax.swing.ImageIcon;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel
{
	public static circle Circle; 
	public static JFrame frame = new JFrame("Project: λ");
	public static Grid grid = new Grid();
	public static String gameState = "Menu";
	public static Players players;
	public static Game game = new Game();
	public static listener mouse = new listener();
	public static Image logo = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/images/Logo.png"));
	public static Image p2 = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/images/players2.png"));
	public static Image p3 = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/images/players3.png"));
	public static Image p4 = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/images/players4.png"));

	public void printSimpleString(String s, int width, int XPos, int YPos, Graphics2D g2d)
	{
        int stringLen = (int)
            g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
	}
	@Override
	public void paint(Graphics g) 
	{
		
		Graphics2D g2d = (Graphics2D) g;
		/*g2d.setColor(Color.RED);	
		g2d.fillRect(0, 0, 100, 100);
		g2d.fillRect(600, 0, 100, 100);
		g2d.fillRect(600, 400, 100, 100);
		g2d.fillRect(0, 400, 100, 100);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(100, 0, 100, 100);
		g2d.fillRect(0, 100, 100, 100);
		g2d.fillRect(500, 0, 100, 100);
		g2d.fillRect(600, 100, 100, 100);*/
		if(gameState == "Menu")
		{
			g2d.setColor(Color.ORANGE);
			g2d.fillRect(0, 0, 701, 520);
			g2d.drawImage(logo, 100, 0, null);
			g2d.drawImage(p2, 90, 200, null);
			g2d.drawImage(p3, 410, 200, null);
			g2d.drawImage(p4, 250, 310, null);
		}
		else if(gameState == "GameOver")
		{
			g2d.setColor(Color.YELLOW);
			g2d.fillRect(0, 0, 701, 520);
			g2d.setColor(Color.black);
			String win = "Winner: " + players.players[winner].Disease.onMouseover();
			g2d.drawString(win, (701/2)-(10*(win.length()/2)), 100);
			g2d.setColor(Color.black);
			g2d.drawRect(250, 300, 200, 100);
			g2d.setColor(Color.white);
			g2d.fillRect(251, 301, 199, 99);
			g2d.setColor(Color.black);
			g2d.drawString("Menu", 345, 345);
			//printSimpleString(players.players[winner].Disease.onMouseover(), 701, 350, 350, g2d);
		}
		else if(gameState == "Playing" || gameState == "GameOverTemp")
		{
			for(int x = 0; x<35; x=x+1)
			{
				g2d.setColor(grid.getContent(x).Disease.getColor());
				g2d.fillRect((100*(x%7)), 100*(x/7), 100, 100);
				
			}

			for(int x = 0; x<35; x=x+1)
			{
				if(grid.moves[x].isOn)
				{
					g2d.setColor(Color.GREEN);
					g2d.fillRect((100*(x%7)), 100*(x/7), 100, 100);
					//g2d.fillRect(300, 100, 100, 100);
					//System.out.println(100*(x%7) + " " + grid.getContent(x).Disease.getColor());
				}
			}

			g2d.setColor(Color.BLACK);
			//g2d.fillOval((int)Circle.x, (int)Circle.y, 50, 50);
			for(int x = 0; x < 8; x = x+1)
			{
				g2d.drawLine(100 * x, 0, 100 * x, 500);
			}

			for(int y = 0; y < 6; y = y+1)
			{
				g2d.drawLine(0, 100*y, 700, 100*y);
			}
			
			g2d.setColor(players.players[playerTurn].Disease.getColor());
			g2d.fillRect(0, 501, 701, 20);
			g2d.setColor(Color.BLACK);
			g2d.drawString("Disease: " + players.players[playerTurn].Disease.onMouseover() + "                 Moves Left: " + movesLeft, 10, 515);
			
			if (canSpecial)
			{
				g2d.setColor(Color.DARK_GRAY);
				g2d.fillRect(601, 501, 100, 20);
				g2d.setColor(Color.BLACK);
				g2d.drawString("Special", 610, 515);
			}
		}
		
		

		if(mouse.isClicked())
		{
			g2d.setColor(Color.GRAY);
		}
		else
		{
			g2d.setColor(Color.MAGENTA);
		}

		g2d.fillOval((int)mouse.getMouseX()-(25/2), (int)mouse.getMouseY()-(25/2), 25, 25);


		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(701,520);
	}

	public static int playerTurn = 0;
	public static int winner = 0;
	public static boolean canSpecial = false;
	public static int movesLeft = 3;

	//final public static Image iReport = new ImageIcon(frame.getClass().getResource("/images/image.png"));
	public static void main(String[] args) throws IOException, InterruptedException 
	{

		frame.add(game);
		frame.addMouseListener(mouse);
		//frame.setSize(700, 500);
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/image.png"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/images/Icon.jpg")));
		//Image image = new ImageIcon(frame.getClass().getResource("/images/image.png")).getImage();
		//frame.setIconImage(iReport);
		frame.setCursor(frame.getToolkit().createCustomCursor(
				new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
				"null"));
		frame.setVisible(true);
		//frame.setPreferredSize(new Dimension(700,500));
		frame.pack();
		//frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getLocation()
		/*grid.getContent(10).setContains(new TestDisease());
		grid.getContent(12).setContains(new TestDisease());
		grid.getContent(34).setContains(new TestDisease());
		grid.getContent(1).setContains(new TestDisease());
		System.out.println(toNum(new Point(250, 250)));*/

		boolean mousetrigger = false;
		
		
		boolean[] temp = new boolean[35];
		boolean[] canPlay;
		int[] count; 
		int playerswithnone = 0;
		int squareClicked = 0;
		boolean wincalc = true;
		boolean justStarted = true;
		while (true)
		{
			if(gameState == "Menu")
			{
				if(justStarted)
				{
					TimeUnit.SECONDS.sleep(2);
					justStarted = false;
				}
				if(mouse.isClicked())
				{
					for(int x = 0; x<35; x=x+1)
					{
						grid.squares[x].Disease = new BlankDisease();
						canSpecial = false;
					}
					if((mouse.getMouseX() > 90 && mouse.getMouseX() < 290) && (mouse.getMouseY() > 200 && mouse.getMouseY() < 300))
					{
						System.out.println("p2" + " " + mouse.getMouseX() + " " + mouse.getMouseY());
						players = new Players(2);
						players.players[0].setDisease(new FluDisease());
						players.players[1].setDisease(new ColdDisease());
						grid.getContent(14).setContains(players.players[0].Disease);
						grid.squares[14].age = 0;
						grid.getContent(20).setContains(players.players[1].Disease);
						grid.squares[20].age = 0;
						gameState = "Playing";
					}
					if((mouse.getMouseX() > 410 && mouse.getMouseX() < 610) && (mouse.getMouseY() > 200 && mouse.getMouseY() < 300))
					{
						System.out.println("p3" + " " + mouse.getMouseX() + " " + mouse.getMouseY());
						players = new Players(3);
						players.players[0].setDisease(new FluDisease());
						players.players[1].setDisease(new ColdDisease());
						players.players[2].setDisease(new FungusDisease());
						//players.players[3].setDisease(new ColdDisease());
						grid.getContent(3).setContains(players.players[0].Disease);
						grid.squares[3].age = 0;
						grid.getContent(28).setContains(players.players[1].Disease);
						grid.squares[28].age = 0;
						grid.getContent(34).setContains(players.players[2].Disease);
						grid.squares[34].age = 0;
						//grid.getContent(34).setContains(players.players[3].Disease);
						//grid.squares[34].age = 0;
						gameState = "Playing";
					}
					if((mouse.getMouseX() > 250 && mouse.getMouseX() < 450) && (mouse.getMouseY() > 310 && mouse.getMouseY() < 410))
					{
						System.out.println("p4" + " " + mouse.getMouseX() + " " + mouse.getMouseY());
						players = new Players(4);
						players.players[0].setDisease(new FluDisease());
						players.players[1].setDisease(new ColdDisease());
						players.players[2].setDisease(new FungusDisease());
						players.players[3].setDisease(new TestDisease());
						grid.getContent(0).setContains(players.players[0].Disease);
						grid.squares[0].age = 0;
						grid.getContent(6).setContains(players.players[1].Disease);
						grid.squares[6].age = 0;
						grid.getContent(28).setContains(players.players[2].Disease);
						grid.squares[28].age = 0;
						grid.getContent(34).setContains(players.players[3].Disease);
						grid.squares[34].age = 0;
						gameState = "Playing";
					}
					playerTurn = 0;
				}
			}
			else if(gameState == "GameOver")
			{
				if(wincalc)
				{
					count = new int[players.players.length];
					for(int x = 0; x<players.players.length; x=x+1)
					{
						for(int u = 0; u<count.length;u=u+1)
						{
							count[u] = 0;
						}
						for (int y = 0; y<35; y=y+1)
						{
							for(int i = 0; i<players.players.length; i=i+1)
							{
								if(grid.squares[y].Disease.getClass() 
										== players.players[i].Disease.getClass())
								{
									count[i] = count[i] + 1;
								}

							}
						}
						if(count[x] > 1)
						{
							winner = x;
						}
					}
					wincalc = false;
				}
				else
				{
					if(mouse.isClicked() && mousetrigger)
					{
						gameState = "Menu";
						justStarted = true;
						//gameState = "GameOver";
						//wincalc = true;
						
					}
					
					
					
					if(mouse.isClicked())
					{
						mousetrigger = false;
					}
					else
					{
						mousetrigger = true;
					}
				}
				
			}
			else if(gameState == "GameOverTemp")
			{
				if(mouse.isClicked() && mousetrigger)
				{
					gameState = "GameOver";
					wincalc = true;
					
				}
				
				
				
				if(mouse.isClicked())
				{
					mousetrigger = false;
				}
				else
				{
					mousetrigger = true;
				}
			}
			else if(gameState == "Playing")
			{
				
			
				canPlay = new boolean[players.players.length];
				for(int x = 0; x<canPlay.length; x=x+1)
				{
					canPlay[x] = true;
				}
				count = new int[players.players.length];
				for(int x =0; x<count.length;x=x+1)
				{
					count[x] = 1;
				}
				boolean clickSuccess = false;

				int numPlayers = players.players.length;
				//System.out.println(numPlayers);
				//System.out.println(x);
				/*if(mouse.isClicked())
				{
					if(count[playerTurn] == 0)
					{
						playerTurn = playerTurn+1;
						if(playerTurn >= count.length)
						{
							playerTurn = 0;
						}
					}
				}*/
				//System.out.println(playerTurn);
				if(mouse.isClicked() && mousetrigger)
				{
				
					playerswithnone = 0;
					if(mouse.getMouseX() > 600 && mouse.getMouseY() > 500 && canSpecial)
					{
						if (movesLeft >= 2)
						{
							grid.squares[squareClicked].Disease.Special(squareClicked);
							System.out.println("special");
							movesLeft = movesLeft - 2;
							for(int x = 0; x<35; x=x+1)
							{
								if(grid.squares[x].Disease.getClass() != new BlankDisease().getClass())
								{
									grid.squares[x].onTurnEnd();
								}
							}
							for(int x = 0; x<count.length;x=x+1)
							{
								count[x] = 0;
							}
							for (int y = 0; y<35; y=y+1)
							{
								for(int i = 0; i<players.players.length; i=i+1)
								{
									if(grid.squares[y].Disease.getClass() 
											== players.players[i].Disease.getClass())
									{
										count[i] = count[i] + 1;
									}

								}
							}
							for(int x = 0; x<canPlay.length;x=x+1)
							{
								if(count[x] == 0)
								{
									canPlay[x] = false;

								}
								System.out.println(canPlay[x]);
							}
							//movesLeft = movesLeft - 1;
							if(movesLeft < 1)
							{
								movesLeft = 3;
								boolean outloop = true;
								int tempPlayerTurn = playerTurn;
								while(outloop)
								{
									tempPlayerTurn = tempPlayerTurn + 1;
									if(tempPlayerTurn >= numPlayers)
									{
										tempPlayerTurn = 0;
									}
									if(canPlay[tempPlayerTurn])
									{
										outloop = false;
										playerTurn = tempPlayerTurn;
									}
							
									if(playerswithnone == players.players.length)
									{
										System.out.println("Game Over");
										outloop = false;
										gameState = "GameOverTemp";
									}
								}
								if(grid.squares[squareClicked].Disease.getClass() == players.players[playerTurn].Disease.getClass())
								{
									canSpecial =true;
									System.out.println("canSpecial");
								}
								else
								{
									canSpecial = false;
								}
							}
						}
						
					}
					else if(mouse.getMouseY()<500)
					{
						int GridClick = toNum(new Point((int)mouse.getMouseX(), (int)mouse.getMouseY()));
						squareClicked = GridClick;
						canSpecial = false;
						if(grid.squares[squareClicked].Disease.getClass() == players.players[playerTurn].Disease.getClass())
						{
							canSpecial = true;
							System.out.println("canSpecial");
						}
						else
						{
							canSpecial = false;
						}
						if(grid.squares[squareClicked].Disease.getClass() == players.players[playerTurn].Disease.getClass())
						{
							canSpecial =true;
							System.out.println("canSpecial");
						}
						else
						{
							canSpecial = false;
						}

						//System.out.println(mouse.getMouseX() + " " + mouse.getMouseY());
						//Circle = new circle(mouse.getMouseX(), mouse.getMouseY());
						System.out.println(mouse.getMouseY());
						grid.getContent(toNum(new Point((int)mouse.getMouseX(), (int)mouse.getMouseY()))).whenClicked();



						for (int x = 0; x<35; x=x+1)
						{
							temp[x] = false;
						}

						if(players.players[playerTurn].Disease.getClass() != grid.getContent(GridClick).Disease.getClass() && grid.moves[GridClick].isOn)
						{

							clickSuccess = true;
							grid.squares[GridClick].Disease = players.players[playerTurn].getDisease();

						}	
						else
						{
							if(grid.getContent(GridClick).Spread()[0]&& grid.getContent(GridClick).Disease.getClass() == players.players[playerTurn].Disease.getClass())
							{
								temp[GridClick-7] = true;
							}


							if(grid.getContent(GridClick).Spread()[1]&& grid.getContent(GridClick).Disease.getClass() == players.players[playerTurn].Disease.getClass())
							{
								temp[GridClick-1] = true;
							}


							if(grid.getContent(GridClick).Spread()[2]&& grid.getContent(GridClick).Disease.getClass() == players.players[playerTurn].Disease.getClass())
							{
								temp[GridClick+1] = true;
							}


							if(grid.getContent(GridClick).Spread()[3]&& grid.getContent(GridClick).Disease.getClass() == players.players[playerTurn].Disease.getClass())
							{
								temp[GridClick+7] = true;
							}
						}
						for(int x = 0;x<35;x=x+1)
						{
							grid.moves[x].isOn = temp[x];
						}


						if(clickSuccess)
						{
							
							for(int x = 0; x<35; x=x+1)
							{
								if(grid.squares[x].Disease.getClass() != new BlankDisease().getClass())
								{
									grid.squares[x].onTurnEnd();
								}
							}
							for(int x = 0; x<count.length;x=x+1)
							{
								count[x] = 0;
							}
							for (int y = 0; y<35; y=y+1)
							{
								for(int i = 0; i<players.players.length; i=i+1)
								{
									if(grid.squares[y].Disease.getClass() 
											== players.players[i].Disease.getClass())
									{
										count[i] = count[i] + 1;
									}

								}
							}
							for(int x = 0; x<canPlay.length;x=x+1)
							{
								if(count[x] == 0)
								{
									canPlay[x] = false;

								}
								System.out.println(canPlay[x]);
							}
							movesLeft = movesLeft - 1;
							if(movesLeft < 1)
							{
								movesLeft = 3;
								boolean outloop = true;
								int tempPlayerTurn = playerTurn;
								while(outloop)
								{
									tempPlayerTurn = tempPlayerTurn + 1;
									if(tempPlayerTurn >= numPlayers)
									{
										tempPlayerTurn = 0;
									}
									if(canPlay[tempPlayerTurn])
									{
										outloop = false;
										playerTurn = tempPlayerTurn;
									}
							
									if(playerswithnone == players.players.length)
									{
										System.out.println("Game Over");
										outloop = false;
										gameState = "GameOverTemp";
									}
								}
								for(int x = 0; x<canPlay.length;x=x+1)
								{
									if(count[x] == 0)
									{
										canPlay[x] = false;

									}
									System.out.println("thing" + canPlay[x]);
								}
								canSpecial = false;

							}
					
						
						
					
						
				
						//System.out.println(playerTurn);
						//System.out.println(count[0]);
					
						
							System.out.println(playerTurn);

					
						
						}
					
						
					}
				
					
				
					/*for(int x = 0; x<35; x=x+1)
					{
						if(grid.squares[x].Disease.getClass() != new BlankDisease().getClass())
						{
							grid.squares[x].onTurnEnd();
						}
					}*/
					playerswithnone = 0;
					for(int x = 0; x<count.length;x=x+1)
					{
						count[x] = 0;
					}
					for (int y = 0; y<35; y=y+1)
					{
						for(int i = 0; i<players.players.length; i=i+1)
						{
							if(grid.squares[y].Disease.getClass() 
									== players.players[i].Disease.getClass())
							{
								count[i] = count[i] + 1;
							}

						}
					}
					for(int x = 0; x<players.players.length; x=x+1)
					{
						if (count[x] == 0)
						{
							playerswithnone = playerswithnone + 1;
						}
					}
					if(playerswithnone == players.players.length-1)
					{
						System.out.println("Game Over");
						//outloop = false;
						gameState = "GameOverTemp";
					}
					System.out.println(playerswithnone);

					//grid.moves[(toNum(new Point((int)mouse.getMouseX(), (int)mouse.getMouseY())))].isOn = true;
				}
				
				
				
				/*for(int x = 0; x<players.players.length; x=x+1)
				{
					if (count[x] == 0)
					{
						playerswithnone = playerswithnone + 1;
					}
				}*/

			


				if(mouse.isClicked())
				{
					mousetrigger = false;
				}
				else
				{
					mousetrigger = true;
				}
			
				
				
			}
			frame.repaint();
		}
	}

	public static int toNum(Point in)
	{
		return (in.x/100 )+((in.y/100)*7);
	}

}
