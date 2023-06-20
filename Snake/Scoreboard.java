package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Scoreboard {
	private static int score = 0;
	private static int levelNumber = 1;
	
	//getters and setters
	public static int getScore() {
		return score;
	}
	
	public static void setScore(int s) {
		score = s;
	}
	
	public static int getLevelNumber() {
		return levelNumber;
	}
	
	public static void setLevelNumber(int ln) {
		levelNumber = ln;
	}
	
	public void splashPage(Graphics2D paintbrush, BufferedImage mainMenu, BufferedImage howToPlayNormalMode, BufferedImage pickFruitType, BufferedImage howToPlayWallTileMode, BufferedImage scoreBoard, ImageObserver b) {
		//main menu: title, name, press enter to go to how to play 
		if (SnakeRunner.getGameState() == 0) {
			paintbrush.drawImage(mainMenu, 0, 0, b);
		}
		if (SnakeRunner.getGameState() == 1) {
			paintbrush.drawImage(howToPlayNormalMode, 0, 0, b);
		}
		if (SnakeRunner.getGameState() == 2) {
			paintbrush.drawImage(howToPlayWallTileMode, 0, 0, b);
		}
		if (SnakeRunner.getGameState() == 3 | SnakeRunner.getGameState() == 4) {
			paintbrush.drawImage(pickFruitType, 0, 0, b);
		}
		if (SnakeRunner.getGameState() == 9 | SnakeRunner.getGameState() == 14) {
			paintbrush.drawImage(scoreBoard, 0, 0,  b);
			paintbrush.setColor(Color.white);
			paintbrush.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
			paintbrush.drawString("" + score, 225, 72);
		}
	}
	
	public void scoreBoard(Graphics2D paintbrush) {
		paintbrush.setColor(Color.white);
		paintbrush.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		paintbrush.drawString("Score: " + score, 30, 40);
	}
}
