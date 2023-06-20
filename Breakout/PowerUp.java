package Breakout;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

import utilities.GDV5;

public class PowerUp extends Rectangle{
	private boolean active = false;
	private int speedy = 3;
	private int pwidth = 10;
	private int pheight = 10;
	
	private boolean powerUpAlive = true;
			
	public PowerUp(int x, int y, int width, int height) {
		super(x,y, width, height);
		this.pwidth = width;
		this.pheight = height;		
	}
	
	public void move() {
		this.translate(0, speedy);
	}
	
	public void draw(Graphics2D win) {
		if (powerUpAlive) {
			win.setColor(Brick.getLastHitColor());
			win.fill(this);
		}
	}
	
	public void powerUpChanges(Paddle paddle, Ball ball) {
		if (this.intersects(paddle)) {
			this.setLocation(2000,2000);
			System.out.println(ball.getBallVelX() + " " + ball.getBallVelY());
			System.out.println(paddle.getPaddleSpeed());
			if (Math.random() > 0 && Math.random() < 0.15) {
				ball.setBallVelX(ball.getBallVelX()-1);
				ball.setBallVelY(ball.getBallVelY()-1);
			}
			else if(Math.random() >= 0.15 && Math.random() < 0.3) {
				paddle.setPaddleSpeed(paddle.getPaddleSpeed()+1);
			}
			else if(Math.random() >= 0.3 && Math.random() < 0.45) {
				Scoreboard.setLives(Scoreboard.getLives()+1);
			}
		}
	}
}
