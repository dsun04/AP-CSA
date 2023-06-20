package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public class Fruit{

	private ArrayList<Tile> fruit;
	
	public Fruit() {
		fruit = new ArrayList<Tile>();
	}
	
	public void makeFruit() {
		int row = (int) (Math.random()*15)+3;
		int column = (int)(Math.random()*17)+1;
		Color col = Color.red;
		int x = (int) Board.board[row][column].getX();
		int y = (int) Board.board[row][column].getY();
		if (fruit.size()<1) {
			fruit.add(new Tile(x, y, col, row, column));
		}
	}
	
	public void intersectFruit(Snake snake, WallTiles wallTile) {
		for (int i = 0; i<fruit.size(); i++) {
			if (fruit.get(i).getRow()==snake.getBody().get(0).getRow() && fruit.get(i).getColumn() == snake.getBody().get(0).getColumn()) {
				snake.addBody();
				fruit.remove(i);
				Scoreboard.setScore(Scoreboard.getScore()+1);
				Snake.setSpeed(Snake.getSpeed()-1);
				SnakeRunner.getS1().play(1);
				if (SnakeRunner.getGameState() == 10 | SnakeRunner.getGameState() == 11 | SnakeRunner.getGameState() == 12 | SnakeRunner.getGameState() == 13) {
					wallTile.makeWallTiles();
				}
			}
		}
	}
	
	public void draw(Graphics2D win, BufferedImage apple, ImageObserver b, BufferedImage banana, BufferedImage grapes, BufferedImage cherry, BufferedImage lb, BufferedImage mush, BufferedImage pill) {
		for (Tile f:fruit) {
			if (SnakeRunner.getGameState() == 5 | SnakeRunner.getGameState() == 10) win.drawImage(apple, (int)f.getX()-23, (int)f.getY()-20,b);
			if (SnakeRunner.getGameState() == 6 | SnakeRunner.getGameState() == 11) win.drawImage(banana, (int)f.getX()-9, (int)f.getY()-11, b);
			if (SnakeRunner.getGameState() == 7 | SnakeRunner.getGameState() == 12) win.drawImage(grapes, (int)f.getX()-3, (int)f.getY()-6, b);
			if (SnakeRunner.getGameState() == 8 | SnakeRunner.getGameState() == 13) win.drawImage(cherry, (int)f.getX()-3, (int)f.getY()-2, b);
		}
	}
}
