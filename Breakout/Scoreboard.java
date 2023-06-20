package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import utilities.GDV5;

public class Scoreboard {
	private static int score = 0;
	private static int lives = 3;
	private static int levelNumber = 1;
	
	public static int getScore() {
		return score;
	}
	public static void setScore(int s) {
		score = s;
	}
	public static int getLives() {
		return lives;
	}
	public static void setLives(int l) {
		lives = l;
	}
	public static int getLevelNumber() {
		return levelNumber;
	}
	public static void setLevelNumber(int ln) {
		levelNumber = ln;
	}
	
	public void splashPage(Graphics2D paintbrush) {
		//main menu: title, name, press enter to go to how to play 
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font ("Comic Sans MS", Font.PLAIN, 120));
		paintbrush.drawString("Breakout", 350, 280);
		
		paintbrush.setFont(new Font ("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("by Dominique Sun", 440, 370);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		paintbrush.drawString("Main Menu", 455, 470);
		paintbrush.setColor(Color.GREEN);
		paintbrush.drawString("Press SPACE to Play", 320, 570);		
	}
	public void howToPlay(Graphics2D paintbrush) {
		//how to play: random text, press enter to play
		paintbrush.setColor(Color.decode("#5BA4CF"));
		paintbrush.setFont(new Font ("Comic Sans MS", Font.PLAIN, 100));
		paintbrush.drawString("How to Play", 330, 180);
		
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Clear all the bricks", 415, 265);
		paintbrush.drawString("on the screen to win!", 400, 315);
		paintbrush.drawString("Move the paddle using the", 350, 390);
		paintbrush.drawString("LEFT and RIGHT Arrow Keys", 320, 440);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		paintbrush.drawString("Powerups can increase or decrease ball speed,", 325, 505);
		paintbrush.drawString("add another life, or increase paddle speed.", 340, 550);
		
		paintbrush.setColor(Color.decode("#0079BF"));
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		paintbrush.drawString("Press ENTER to Play", 305, 650);
	}
	//level 1: score, lives, levelNumber
	public void level1Score(Graphics2D paintbrush) {
		paintbrush.setColor(Color.decode("#BCD9EA"));
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		paintbrush.drawString("Lives: " + lives, 1100, 775);
		paintbrush.drawString("Level Number: " + levelNumber, 25, 775);
		paintbrush.drawString("SPACE to Pause", 525, 775);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		paintbrush.drawString(" " + score, 590, 400);
	}
	public void level1Winner(Graphics2D paintbrush) {
		//level 1 winner
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("You cleared all the bricks!", 365, 220);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.setColor(Color.decode("#FF7443"));
		paintbrush.drawString("Press 1", 520, 320);
		paintbrush.drawString("to Replay", 495, 395);
		
		paintbrush.setColor(Color.decode("#FFD143"));
		paintbrush.drawString("Press 2", 520, 500);
		paintbrush.drawString("for Next Level", 430, 575);
	}
		
	//level 1 score 
	public void level1NoLives(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("You lost all your lives :(", 390, 325);
		
		paintbrush.setColor(Color.decode("#8BBDD9"));
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.drawString("Press 1", 515, 425);
		paintbrush.drawString("to Replay", 490, 500);
	}
		
	//level 2: score, lives, levelNumber
	public void level2Score(Graphics2D paintbrush) {
		paintbrush.setColor(Color.decode("#FFD143"));
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		paintbrush.drawString("Lives: " + lives, 1100, 775);
		paintbrush.drawString("Level Number: " + levelNumber, 25, 775);
		paintbrush.drawString("SPACE to Pause", 525, 775);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		paintbrush.drawString(" " + score, 590, 400);
	}
	//level 2 winner
	public void level2Winner(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("You cleared all the bricks!", 365, 220);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.setColor(Color.decode("#B3CF99"));
		paintbrush.drawString("Press 1", 520, 320);
		paintbrush.drawString("to Replay", 495, 395);
		
		paintbrush.setColor(Color.decode("#87AB69"));
		paintbrush.drawString("Press 2", 520, 500);
		paintbrush.drawString("for Next Level", 430, 575);
	}
	//level 2 score
	public void level2NoLives(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("You lost all your lives :(", 390, 325);
		
		paintbrush.setColor(Color.decode("#FFD143"));
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.drawString("Press 1", 515, 425);
		paintbrush.drawString("to Replay", 490, 500);
	}
	//level 3: score, lives, levelNumber
	public void level3Score(Graphics2D paintbrush) {
		paintbrush.setColor(Color.decode("#C7DDB5"));
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		paintbrush.drawString("Lives: " + lives, 1100, 775);
		paintbrush.drawString("Level Number: " + levelNumber, 25, 775);
		paintbrush.drawString("SPACE to Pause", 525, 775);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		paintbrush.drawString(" " + score, 590, 400);
	}
	//level 3 winner: you beat all the levels!
	public void level3Winner(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("You cleared all the bricks!", 365, 220);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.setColor(Color.decode("#B3CF99"));
		paintbrush.drawString("Press 1", 520, 320);
		paintbrush.drawString("to Replay", 495, 395);
		
		paintbrush.setColor(Color.decode("#87AB69"));
		paintbrush.drawString("Press ESCAPE", 440, 500);
		paintbrush.drawString("for Main Menu", 435, 575);
	}
	//level 3 score
	public void level3NoLives(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("You lost all your lives :(", 390, 325);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.drawString("Press 1", 515, 425);
		paintbrush.drawString("to Replay", 490, 500);
	}
	//pause game
	public void pauseGame(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 84));
		paintbrush.drawString("Pause", 485, 400);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Press ENTER to unpause", 375, 475);
	}
}
