package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Breakout.Brick;
import Breakout.Paddle;
import Breakout.Scoreboard;
import utilities.GDV5;

public class BreakoutRunner extends GDV5{
	Brick[] bricks;
		
	private static int colArrayIndex = 0;
		
	private static int horizontalRectangles = 14;
	private static int verticalRectangles = 5;
	private static int totalRectangles = horizontalRectangles * verticalRectangles;

	private int radius = 12;
	private int windowX = GDV5.getMaxWindowX();
	private int windowY = GDV5.getMaxWindowY();
		
	private int count = 0;
	private int index = 0;
	private static boolean drawPart = false;
	private static boolean drawPowerUp = false;
	private boolean winner = false;
	
	Ball ball = new Ball(radius*2);
	Paddle paddle = new Paddle(600, 785, 125, 15);	
	PowerUp powerup1 = new PowerUp(0, 6000, 10, 50);
	Scoreboard s1 = new Scoreboard();
	Scoreboard s2 = new Scoreboard();
	Scoreboard inGame = new Scoreboard();
	Scoreboard declareWinner = new Scoreboard();
	Scoreboard noLives = new Scoreboard();
	Scoreboard pause = new Scoreboard();
	
	private static int gameState = 0;
	private int pauseX = ball.getBallVelX();
	private int pauseY = ball.getBallVelY();
		
	public BreakoutRunner() {
		super();
	}

	public static void main(String[] args) {
		BreakoutRunner b = new BreakoutRunner();
		b.start();
	}
	public void draw(Graphics2D win) {
		//draw bricks
		if (gameState == 0) {
			s1.splashPage(win);
		}
		if (gameState == 1) {
			s2.howToPlay(win);
		}
		if (gameState == 2) {
			inGame.level1Score(win);
			Brick.drawBricks(win, bricks);
			if (drawPowerUp) {
				powerup1.draw(win);
			}
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw paddle
			win.setColor(Color.white);
			win.fillRect((int)paddle.getX(), (int)paddle.getY(), (int)paddle.getWidth(),  (int)paddle.getHeight());	
		}		
		if (gameState == 3) {
			declareWinner.level1Winner(win);
		}
		if (gameState == 4) {
			noLives.level1NoLives(win);
		}
		if (gameState == 5) {
			inGame.level2Score(win);
			Brick.drawBricks(win, bricks);
			if (drawPowerUp) {
				powerup1.draw(win);
			}
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw paddle
			win.setColor(Color.white);
			win.fillRect((int)paddle.getX(), (int)paddle.getY(), (int)paddle.getWidth(),  (int)paddle.getHeight());	
		}
		if (gameState == 6) {
			declareWinner.level2Winner(win);
		}
		if (gameState == 7) {
			noLives.level2NoLives(win);
		}
		if (gameState == 8) {
			inGame.level3Score(win);
			Brick.drawBricks(win, bricks);
			if (drawPowerUp) {
				powerup1.draw(win);
			}
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw paddle
			win.setColor(Color.white);
			win.fillRect((int)paddle.getX(), (int)paddle.getY(), (int)paddle.getWidth(),  (int)paddle.getHeight());
		}
		if (gameState == 9) {
			declareWinner.level3Winner(win);
		}
		if (gameState == 10) {
			noLives.level3NoLives(win);
		}
		if (gameState == 11) {
			pause.pauseGame(win);
			
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw paddle
			win.setColor(Color.white);
			win.fillRect((int)paddle.getX(), (int)paddle.getY(), (int)paddle.getWidth(),  (int)paddle.getHeight());
		}
	}
	
	public void update() {
		cheatingTheSystem(ball, paddle);
	}

	public void cheatingTheSystem(Ball ball, Paddle paddle) {
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
			gameState = 0;
		}
		
		if (gameState == 0 && GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
			gameState = 1;
		}
		if (gameState == 1 && GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 2;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			Paddle.setPaddleSpeed(7);
			Ball.setBallVelY(5);
			Ball.setBallVelX(-5);
		}
		if (gameState == 2) {
			colArrayIndex = 0;
			verticalRectangles = Brick.getBluesArrayLength();
			ball.move(paddle, bricks, powerup1);
			paddle.paddleMove(5);

			if (drawPowerUp) {
				powerup1.move();
				powerup1.powerUpChanges(paddle, ball);
			}
			if (drawPart) {
				Particle.moveParticles(bricks);
				count = 0;
			}
			count++;
			if (count % 60 == 0) {
				index += 1;
			}
			for (Brick b:bricks) {
				if (b.getWidth() > 0) {
					winner = false;
					break;
				}
				else winner = true;
			}
		}
		
		if (gameState == 2 && winner == true) {
			gameState = 3;
		}
		
		if (gameState == 2 && Scoreboard.getLives() == 0) {
			gameState = 4;
		}
		
		if (gameState == 2 && GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
			gameState = 11;
		}
		
		if (gameState == 3 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 2;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		if (gameState == 3 && GDV5.KeysPressed[KeyEvent.VK_2]) {
			gameState = 5;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		
		if (gameState == 4 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 2;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			Paddle.setPaddleSpeed(7);
			Ball.setBallVelY(5);
			Ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		
		if (gameState == 5) {
			colArrayIndex = 1;
			verticalRectangles = Brick.getSunsetArrayLength();
			ball.move(paddle, bricks, powerup1);
			paddle.paddleMove(7);
			Scoreboard.setLevelNumber(2);

			if (drawPowerUp) {
				powerup1.move();
				powerup1.powerUpChanges(paddle, ball);
			}
			if (drawPart) {
				Particle.moveParticles(bricks);
				count = 0;
			}
			count++;
			if (count % 60 == 0) {
				index += 1;
			}
			for (Brick b:bricks) {
				if (b.getWidth() > 0) {
					winner = false;
					break;
				}
				else winner = true;
			}
		}
		if (gameState == 5 && winner) {
			gameState = 6;
		}
		if (gameState == 5 && Scoreboard.getLives() == 0) {
			gameState = 7;
		}
		if (gameState == 5 && GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
			gameState = 11;
		}
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 5;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_2]) {
			gameState = 8;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		if (gameState == 7 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 5;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		
		if (gameState == 8) {
			colArrayIndex = 2;
			verticalRectangles = Brick.getGreensArrayLength();
			ball.move(paddle, bricks, powerup1);
			paddle.paddleMove(7);
			Scoreboard.setLevelNumber(3);

			if (drawPowerUp) {
				powerup1.move();
				powerup1.powerUpChanges(paddle, ball);
			}
			if (drawPart) {
				Particle.moveParticles(bricks);
				count = 0;
			}
			count++;
			if (count % 60 == 0) {
				index += 1;
			}
			for (Brick b:bricks) {
				if (b.getWidth() > 0) {
					winner = false;
					break;
				}
				else winner = true;
			}
		}
		if (gameState == 8 && winner) {
			gameState = 9;
		}
		
		if (gameState == 8 && Scoreboard.getLives() == 0) {
			gameState = 10;
		}
		if (gameState == 9 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 8;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		if (gameState == 8 && GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
			gameState = 11;
		}
		if (gameState == 10 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 8;
			bricks = Brick.makeBricks();
			Scoreboard.setLives(3);
			Scoreboard.setScore(0);
			paddle.setPaddleSpeed(7);
			ball.setBallVelY(5);
			ball.setBallVelX(-5);
			ball.setLocation(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2);
		}
		
		if (gameState == 11) {
			if (ball.getBallVelX() != 0 && ball.getBallVelY() != 0) {
				pauseX = ball.getBallVelX();
				pauseY = ball.getBallVelY();
			}
			ball.setBallVelX(0);
			ball.setBallVelY(0);
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				ball.setBallVelX(pauseX);
				ball.setBallVelY(pauseY);
				gameState = 2;
				}
		}
	}
	//Getters and Setters
	public static int getColArrayIndex() {
		return colArrayIndex;
	}
	public void setColArrayIndex(int index) {
		colArrayIndex = index;
	}
	public static int getHorizontalRectangles() {
		return horizontalRectangles;
	}
	public static int getVerticalRectangles() {
		return verticalRectangles;
	}
	public static int getTotalRectangles() {
		return totalRectangles;
	}
	public static boolean getDrawPart() {
		return drawPart;
	}
	public static void setDrawPart(boolean dP) {
		drawPart = dP;
	}
	public static boolean getDrawPowerUp() {
		return drawPowerUp;
	}
	public static void setDrawPowerUp(boolean dpu) {
		drawPowerUp = dpu;
	}
	public static int getGameState() {
		return gameState;
	}
}
