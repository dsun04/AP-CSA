package Pong;

import java.awt.Rectangle;

import utilities.GDV5;

public class Ball extends Rectangle{
	int radius = 12;
	int windowX = PongRunner.getMaxWindowX();
	int windowY = PongRunner.getMaxWindowY();
	int ballVelX = 3;
	int ballVelY = 3;
	static int multiplayerWinnerNumber = 0;
	static String singlePlayerWinnerNumber = "";
	boolean pause = false;
	int i = 0;
	
	public Ball(int size) {
		super(200, 300, size, size);
	}

	public int getDx() {
		return ballVelX;
	}
	
	public void setDx(int ballVelX) {
		this.ballVelX = ballVelX;

	}
	
	public int getDy() {
		return ballVelY;
	}
	
	public void setDy(int ballVelY) {
		this.ballVelY = ballVelY;
	}
	
	//bounce the ball off the top and bottom walls
	public void wallBounceMultiplayer() {
		int offset = 10;
		int bLeftEdge = (int)(this.getCenterX()-radius);
		int bRightEdge = (int)(this.getCenterX()+radius);
		int bTopEdge = (int)(this.getCenterY()-radius);
		int bBottomEdge = (int)(this.getCenterY()+radius);
		
		if (bLeftEdge < radius - offset) {
			if (bLeftEdge < -200) {
				Scoreboard.rightScore += 1;
				Paddle.paddle2Speed += 1;
				ballVelX = 3;
				ballVelY = -3;
				this.x = GDV5.getMaxWindowX()/2;
				this.y = GDV5.getMaxWindowY()/2;
				if (Scoreboard.rightScore == 5) {
					multiplayerWinnerNumber = 2;
				}
			}
		}
		if (bRightEdge > windowX - radius + offset) {
			if (bRightEdge > windowX + 200) {
				Scoreboard.leftScore += 1;
				Paddle.paddle1Speed += 1;
				ballVelX = -3;
				ballVelY = 3;
				this.x = GDV5.getMaxWindowX()/2;
				this.y = GDV5.getMaxWindowY()/2;
				if (Scoreboard.leftScore == 5) {
					multiplayerWinnerNumber = 1;
				}
			}
		}
		if (bTopEdge <= radius - offset|| bBottomEdge >= windowY - radius + offset) {
			ballVelY = -ballVelY;
		}
	}
	
	public void wallBounceSinglePlayer() {
		int offset = 10;
		int bLeftEdge = (int)(this.getCenterX()-radius);
		int bRightEdge = (int)(this.getCenterX()+radius);
		int bTopEdge = (int)(this.getCenterY()-radius);
		int bBottomEdge = (int)(this.getCenterY()+radius);
		
		if (bLeftEdge < radius - offset) {
			if (bLeftEdge < -200) {
				Scoreboard.rightScore += 1;
				ballVelX = 3;
				ballVelY = -3;
				Paddle.paddle2Speed += 1;
				this.x = GDV5.getMaxWindowX()/2;
				this.y = GDV5.getMaxWindowY()/2;
				if (Scoreboard.rightScore == 5) {
					singlePlayerWinnerNumber = "Player";
				}
			}
		}
		if (bRightEdge > windowX - radius + offset) {
			if (bRightEdge > windowX + 200) {
				Scoreboard.leftScore += 1;
				ballVelX = -3;
				ballVelY = 3;
				Paddle.paddle1Speed += 1;
				this.x = GDV5.getMaxWindowX()/2;
				this.y = GDV5.getMaxWindowY()/2;
				if (Scoreboard.leftScore == 5) {
					singlePlayerWinnerNumber = "Computer";
				}
			}
		}
		if (bTopEdge <= radius - offset|| bBottomEdge >= windowY - radius + offset) {
			ballVelY = -ballVelY;
		}
	}
	
	public void moveMultiplayer(Paddle paddle1, Paddle paddle2) {
		this.translate(ballVelX, ballVelY);
			
		wallBounceMultiplayer();
	}
	
	public void moveSinglePlayer(Paddle paddle1, Paddle paddle2) {
		this.translate(ballVelX, ballVelY);
		
		wallBounceSinglePlayer();
	}
}
