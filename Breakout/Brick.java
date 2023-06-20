package Breakout;

import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick extends Rectangle{
	private static Color[] blues = {Color.decode("#BCD9EA"), Color.decode("#8BBDD9"), Color.decode("#5BA4CF"), Color.decode("#298FCA"), Color.decode("#0079BF")}; 
	private static Color[] sunset = {Color.decode("#8B2E57"), Color.decode("#B63C47"), Color.decode("#FF7443"), Color.decode("#FF8643"), Color.decode("#FF9E44"), Color.decode("#FFAB43"), Color.decode("#FFD143")};
	private static Color[] greens = {Color.decode("#4B6043"), Color.decode("#658354"), Color.decode("#75975E"), Color.decode("#87AB69"), Color.decode("#95BB72"), Color.decode("#A3C585"), Color.decode("#B3CF99"), Color.decode("#C7DDB5"), Color.decode("#DDEAD1")};
	private static Color[][] colors = {blues, sunset, greens};
	private Color bcol;
	
	private static Color lastHitColor;
	
	private static int verticalRectangles = BreakoutRunner.getVerticalRectangles();
	private static int totalRectangles = BreakoutRunner.getTotalRectangles();
	
	private static int wPadding = 10;
	private static int hPadding = wPadding;
	
	private static int initHeight = 25;
	
	
	private boolean alive = true;
	
	public Brick(int x, int y, Color c) {
		super(x, y, (GDV5.getMaxWindowX() - (14+1)*wPadding)/14, initHeight);
		bcol = c;
	}

	public static int getColorArrayLength() {
		return colors.length;
	}
	public static int getSunsetArrayLength() {
		return sunset.length;
	}
	public static int getBluesArrayLength() {
		return blues.length;
	}
	public static int getGreensArrayLength() {
		return greens.length;
	}
	
	public static Brick[] makeBricks() {
		Brick[] bricks = null;
		Color col;
		
		int width = (GDV5.getMaxWindowX() - (14+1)*wPadding)/14;
		int height = initHeight;
		
		int offset = (GDV5.getMaxWindowX() - (width * 14 + wPadding*(14-1)))/2;
		int x = offset;
		int y = x;
		int colinc = 0;
		
		if (BreakoutRunner.getGameState() == 2) {
			bricks = new Brick[5*14];
			System.out.println(bricks.length);
			for (int i = 0; i < bricks.length; i++) {
				bricks[i] = new Brick(x,y,colors[0][colinc%blues.length]);
				x += bricks[0].width + wPadding;
				if (x+width >= GDV5.getMaxWindowX()) {
					y += bricks[0].height + hPadding;
					x=offset;
					colinc++;
				}
			}
		}
		if (BreakoutRunner.getGameState() == 5) {
			bricks = new Brick[7*14];
			for (int i = 0; i < bricks.length; i++) {
				bricks[i] = new Brick(x,y,colors[1][colinc%sunset.length]);
				x += bricks[0].width + wPadding;
				if (x+width >= GDV5.getMaxWindowX()) {
					y += bricks[0].height + hPadding;
					x=offset;
					colinc++;
				}
			}
		}
			if (BreakoutRunner.getGameState() == 8) {
				bricks = new Brick[9*14];
				for (int i = 0; i < bricks.length; i++) {
				bricks[i] = new Brick(x,y,colors[2][colinc%greens.length]);
				x += bricks[0].width + wPadding;
				if (x+width >= GDV5.getMaxWindowX()) {
					y += bricks[0].height + hPadding;
					x=offset;
					colinc++;
				}
			}
		}
		return bricks;
	}
	public void hit() {
		Particle.makeParticles(this);
		alive = false;
//		PowerUp.makePowerUp(this);
		BreakoutRunner.setDrawPart(true);
		width = 0;
		height = 0;
		
	}
	
	public Color getCol() {
		return bcol;
	}
	
	public static Color getLastHitColor() {
		return lastHitColor;
	}
	
	public static void setLastHitColor(Color latestColor) {
		lastHitColor = latestColor;
	}
	
	public boolean getStatus() {
		return alive;
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(this.getCol());
		pb.fill(this);
	}
	public static void drawBricks(Graphics2D win, Brick[] bricks) {
		for (Brick b:bricks) {
			b.draw(win);
		}
		if (BreakoutRunner.getDrawPart()) {
			Particle.drawParticles(win, bricks);
		}
	}
}
