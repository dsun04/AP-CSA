package Breakout;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import Breakout.Brick;
import Breakout.Paddle;
import utilities.GDV5;

public class Ball extends Rectangle{
	private int radius = 12;
	private int windowX = GDV5.getMaxWindowX();
	private int windowY = GDV5.getMaxWindowY();
	private static int ballVelX = 9;
	private static int ballVelY = 9;
	
	public Ball(int size) {
		super(200, 300, size, size);
	}

	public int getBallVelX() {
		return ballVelX;
	}
	
	public int getBallVelY() {
		return ballVelY;
	}
	
	public static void setBallVelX(int ballX) {
		ballVelX = ballX;
	}
	
	public static void setBallVelY(int ballY) {
		ballVelY = ballY;
	}
	
	public void wallBounce() {
		int offset = 10;
		int bLeftEdge = (int)(this.getCenterX()-radius);
		int bRightEdge = (int)(this.getCenterX()+radius);
		int bTopEdge = (int)(this.getCenterY()-radius);
		int bBottomEdge = (int)(this.getCenterY()+radius);
		
		if (bLeftEdge < radius - offset) {
			ballVelX = 5;
		}
		
		if (bRightEdge > windowX - radius + offset) {
			ballVelX = -5;
		}
		
		if (bTopEdge <= radius - offset) {
			ballVelY = -ballVelY;
		}
		if (bBottomEdge > windowY - radius + offset) {
			if (bBottomEdge > windowY + 200) {
				Scoreboard.setLives(Scoreboard.getLives()-1);
				ballVelX = 5;
				ballVelY = 5;
				this.x = GDV5.getMaxWindowX()/2;
				this.y = GDV5.getMaxWindowY()/2;
			}
		}
	}
	
	public void paddleBounce(Rectangle paddle) {
		if(this.intersects(paddle)) {
			if (GDV5.collisionDirection(paddle, this, -5, -5) == 1) {
				this.ballVelX *= -1;
				this.ballVelY *= -1;
			}
			this.ballVelY *= -1;
		}
	}
	
	public void ballHitBricks(Brick [] bricks, PowerUp powerup1, Paddle paddle) {
		if (BreakoutRunner.getGameState() == 2 || BreakoutRunner.getGameState() == 5 || BreakoutRunner.getGameState() == 8) {
			for (Brick b:bricks) {
				if(this.intersects(b)) {
					Scoreboard.setScore(Scoreboard.getScore()+1);
					System.out.println(Math.random());
					if (Math.random() < 0.45) {
						BreakoutRunner.setDrawPowerUp(true);
						Brick.setLastHitColor(b.getCol());
						if(powerup1.getY() > GDV5.getMaxWindowY()) {
							powerup1.setLocation((int)b.getCenterX(),(int)b.getCenterY());
						}
					}
					if (GDV5.collisionDirection(b, this, this.getBallVelX(), this.getBallVelY()) == 1) {
						this.ballVelY = (this.ballVelY)*-1;
					}
					else if (GDV5.collisionDirection(b, this, this.getBallVelX(), this.getBallVelY()) == 3) {
						this.ballVelY = (this.ballVelY)*-1;
					}
					else if (GDV5.collisionDirection(b, this, this.getBallVelX(), this.getBallVelY()) == 2) {
						this.ballVelY = (this.ballVelY)*-1;
					}
					else {
						this.ballVelY = (this.ballVelY)*-1;
					}
					b.hit();
				}
			}
		}
	}
	public void move(Paddle paddle, Brick[] bricks, PowerUp powerup1) {
		this.translate(ballVelX, ballVelY);
		wallBounce();
		paddleBounce(paddle);
		ballHitBricks(bricks, powerup1, paddle);
	}
}
