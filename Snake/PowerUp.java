package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class PowerUp {

	private ArrayList <Tile> powerUps;
	private int num;
	
	public PowerUp() {
		powerUps = new ArrayList <Tile>();		
	}
	
	public void makePowerUps() {
		int row = (int) (Math.random()*15)+3;
		int column = (int)(Math.random()*17)+1;
		Color col = Color.red;
		int x = (int) Board.board[row][column].getX();
		int y = (int) Board.board[row][column].getY();
		if (powerUps.size()<1) {
			powerUps.add(new Tile(x, y, col, row, column));
			num = (int)(Math.random()*100) + 1;
		}
	}
	
	public void intersectPowerUp(Snake snake) {
		for (int i = 0; i<powerUps.size(); i++) {
			if (powerUps.get(i).getRow()==snake.getBody().get(0).getRow() && powerUps.get(i).getColumn() == snake.getBody().get(0).getColumn()) {
				SnakeRunner.getS1().play(1);
				if (num < 40) { //mushroom
					Snake.setSpeed(Snake.getSpeed() + 5);
				}
				if (num < 70 && num >= 40) { //pill
					snake.getBody().remove(snake.getBody().size()-1);
				}
				if (num < 100 && num >= 70) { //lightning bolt
					Scoreboard.setScore(Scoreboard.getScore() + 3);
				}
				powerUps.remove(i);
			}
		}
	}
	
	public void draw(Graphics2D win, BufferedImage lightningBolt, BufferedImage mushroom, BufferedImage pill, ImageObserver b) {
		for (Tile p:powerUps) {
			if (num < 40) {
				win.drawImage(mushroom, (int)p.getX()-5, (int)p.getY()-5, b);
			}
			if (num < 70 && num >= 40) {
				win.drawImage(pill, (int)p.getX()-4, (int)p.getY()-2, b);
			}
			if (num < 100 && num >= 70) {
				win.drawImage(lightningBolt, (int)p.getX()-1, (int)p.getY()+2, b);
			}
		}
	}
	
	public int getNum() {
		return num;
	}
	
}
