package Breakout;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Breakout.Ball;
import utilities.GDV5;

public class Paddle extends Rectangle{
	private static int paddleSpeed = 7;
	
	public Paddle (int pStartX, int pStartY,int pWidth, int pHeight) {
		super(pStartX, pStartY, pWidth, pHeight);	
	}
	
	public void paddleMove(int speed) {
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT] && (x <= GDV5.getMaxWindowX() - this.width)){
			this.translate(paddleSpeed, 0);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT] && x>=0) {
			this.translate(-paddleSpeed, 0);
		}
	}
	
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	public static void setPaddleSpeed(int speed) {
		paddleSpeed = speed;
	}
}
