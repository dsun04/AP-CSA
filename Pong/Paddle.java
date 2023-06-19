package Pong;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Paddle extends Rectangle{
	int j = 0;
	int randospeed;
	static int paddle1Speed = 3;
	static int paddle2Speed = 3;
	
	public Paddle (int pStartX, int pStartY,int pWidth, int pHeight) {
		super(pStartX, pStartY, pWidth, pHeight);	
	}

	//making paddle1 move
	public void rCheckMove(int speed) {
		if (GDV5.KeysPressed[KeyEvent.VK_DOWN] && y <= PongRunner.getMaxWindowY()-this.height) {
			this.translate(0, paddle2Speed);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_UP] && y >= 0) {
			this.translate(0, -paddle2Speed);
		}
	}
	
	//making paddle2 move
	public void lCheckMove(int speed) {
		if (GDV5.KeysPressed[KeyEvent.VK_S] && y <= PongRunner.getMaxWindowY()-this.height) {
			this.translate(0, paddle1Speed);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_W] && y >= 0) {
			this.translate(0, -paddle1Speed);
		}
	}
	public void lAutonMove(int speed, Ball ball) {
		//insert autonomous paddle 1 for single player mode
		if(ball.ballVelX < 0) {
			if (this.getCenterY() >= ball.getCenterY() && y>=0) {
				this.translate(0, -4);
			}
		else if (this.getCenterY() < ball.getCenterY() && y<=PongRunner.getMaxWindowY()-this.height) {
				this.translate(0,  4);
		}
	}
		else if (y>=0 && y<=PongRunner.getMaxWindowY()-this.height) {
			if (j % 30 == 0) {
				randospeed = (int)((Math.random()*5)-5/2)*2;
			}
			this.translate(0, randospeed);
			j++;
		}
	}
}
