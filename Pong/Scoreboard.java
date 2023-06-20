package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import utilities.GDV5;

public class Scoreboard {
	
	static int leftScore = 0;
	static int rightScore = 0;
	
	
	public void splashPage(Graphics2D paintbrush) {
		//Title and name
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font ("Comic Sans MS", Font.PLAIN, 120));
		paintbrush.drawString("Pong", 475, 180);
		
		paintbrush.setFont(new Font ("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("by Dominique Sun", 440, 260);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		paintbrush.drawString("Main Menu", 455, 400);

		//Start playing in different modes
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Single Player Mode", 150, 540);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Two-Player Mode", 715, 540);
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		paintbrush.drawString("Press 1 to start", 220, 590);
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		paintbrush.drawString("Press 2 to start", 775, 590);
	}
	public void displayScore(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font ("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString(leftScore + "                        " + rightScore, GDV5.getMaxWindowX()/2 - 150, 100);
	}
	public void displayWinnerMultiplayer(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
		paintbrush.drawString("Player " + Ball.multiplayerWinnerNumber + " Wins!", 285, 350);
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press ENTER to restart!", 405, 450);
		
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press ESCAPE to go to Main Menu.", 320, 525);
	}
	public void displayWinnerSinglePlayer(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
		if (Ball.singlePlayerWinnerNumber == "Player") {
			paintbrush.drawString("You Win!", 400, 350);
		}
		if (Ball.singlePlayerWinnerNumber == "Computer") {
			paintbrush.drawString("Computer Wins", 250, 350);
		}
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press ENTER to restart!", 405, 450);
		
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press ESCAPE to go to Main Menu.", 320, 525);
	}
	public void displayInstructionsSinglePlayer(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 84));
		paintbrush.drawString("How to Play:", 380, 200);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		paintbrush.drawString("First to 5 Points Wins!", 435, 275);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Computer: Left Paddle", 400, 370);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Player: Right Paddle", 422, 490);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		paintbrush.drawString("Use the UP/DOWN arrow keys", 440, 540);
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Press ENTER to play", 420, 640);
		
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		paintbrush.drawString("Press ESCAPE to go to Main Menu", 420, 690);
	}
	
	public void displayInstructionsMultiplayer(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 84));
		paintbrush.drawString("How to Play:", 375, 200);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		paintbrush.drawString("First to 5 Points Wins!", 430, 275);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Player 1: Left Paddle", 410, 370);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		paintbrush.drawString("Use the S/W keys", 500, 420);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Player 2: Right Paddle", 397, 500);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		paintbrush.drawString("Use the UP/DOWN arrow keys", 432, 550);	
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Press ENTER to play", 410, 620);
		
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		paintbrush.drawString("Press ESCAPE to go to Main Menu", 410, 670);
	}
	public void displayPause(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 84));
		paintbrush.drawString("Pause", 485, 400);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		paintbrush.drawString("Press ENTER to unpause", 375, 475);
	}
	
	public void displayColorChoice(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		paintbrush.drawString("Choose Paddle Color:", 360, 200);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press 1 for ", 465, 300);
		
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("RED", 660, 300);
		
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press 2 for ", 425, 375);
		
		paintbrush.setColor(Color.ORANGE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("ORANGE", 625, 375);
		
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press 3 for ", 425, 450);
		
		paintbrush.setColor(Color.YELLOW);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("YELLOW", 625, 450);
		
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press 4 for ", 440, 525);
		
		paintbrush.setColor(Color.GREEN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("GREEN", 640, 525);
		
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("Press 5 for ", 450, 600);
		
		paintbrush.setColor(Color.CYAN);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		paintbrush.drawString("CYAN", 650, 600);
	}
	public void gamePlaySwitches(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		paintbrush.drawString("Press ESC to quit", 20, 35);
		
		paintbrush.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		paintbrush.drawString("Press SPACE to pause", 1000, 35);
	}
}
