package Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class PongRunner extends GDV5 {
	int radius = 12;
	int windowX = GDV5.getMaxWindowX();
	int windowY = GDV5.getMaxWindowY();
	
	Ball ball = new Ball(radius*2);
	Paddle paddle1 = new Paddle(0, 350, 12, 100);
	Paddle paddle2 = new Paddle(1188, 350, 12, 100);
	Scoreboard s1 = new Scoreboard();
	Scoreboard winner = new Scoreboard();
	Scoreboard pause = new Scoreboard();
	Scoreboard colorChoice = new Scoreboard();
	Scoreboard inGame = new Scoreboard();
	
	int gameState = 0;
	int pauseX = ball.getDx();
	int pauseY = ball.getDy();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PongRunner runner = new PongRunner();
		runner.start();
	}

	@Override
	public void update() { //60 frames per second
		cheatingTheSystem(); 
		}


	@Override
	public void draw(Graphics2D win) { //at the processor speed - approximately 3000 frames per second
		//main menu
		if (gameState == 0) s1.splashPage(win);
		
		//display instructions in single player
		if (gameState == 1) {
			winner.displayInstructionsSinglePlayer(win);
		}
		
		//single player game play
		if (gameState == 2) {
			//draw middle divider
			win.setColor(Color.white);
			win.fillRect((int)GDV5.getMaxWindowX()/2, 0, 20, 800);

			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.white);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
		
			//draw and fill paddle2
			win.setColor(Color.white);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
			
			//show scores
			s1.displayScore(win);
			inGame.gamePlaySwitches(win);
			
		}
		//pause screen in single player
		if (gameState == 3) {
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.white);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
				
			//draw and fill paddle2
			win.setColor(Color.white);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			s1.displayScore(win); 
			pause.displayPause(win);
		}
		
		//display winner in single player
		if (gameState == 4) {
			winner.displayWinnerSinglePlayer(win);
		}
		
		//display instructions in multiplayer
		if (gameState == 5) {
			winner.displayInstructionsMultiplayer(win);
		}
		//display paddle color choice screen for multiplayer
		if (gameState == 6) {
			colorChoice.displayColorChoice(win);
		}
		
		//multiplayer game play (RED)
		if (gameState == 7) {
			//draw middle divider
			win.setColor(Color.white);
			win.fillRect((int)GDV5.getMaxWindowX()/2, 0, 20, 800);
			
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.red);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
		
			//draw and fill paddle2
			win.setColor(Color.red);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			//show scores
			s1.displayScore(win);
			inGame.gamePlaySwitches(win);
		}
		
		//multiplayer game play (ORANGE)
		if (gameState == 8) {
			//draw middle divider
			win.setColor(Color.white);
			win.fillRect((int)GDV5.getMaxWindowX()/2, 0, 20, 800);
			
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.orange);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
		
			//draw and fill paddle2
			win.setColor(Color.orange);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			//show scores
			s1.displayScore(win);
			inGame.gamePlaySwitches(win);
		}
		
		//multiplayer game play (YELLOW)
		if (gameState == 9) {
			//draw middle divider
			win.setColor(Color.white);
			win.fillRect((int)GDV5.getMaxWindowX()/2, 0, 20, 800);
			
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.yellow);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
		
			//draw and fill paddle2
			win.setColor(Color.yellow);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			//show scores
			s1.displayScore(win);
			inGame.gamePlaySwitches(win);
		}
		
		//multiplayer game play (GREEN)
		if (gameState == 10) {
			//draw middle divider
			win.setColor(Color.white);
			win.fillRect((int)GDV5.getMaxWindowX()/2, 0, 20, 800);
			
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.green);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
		
			//draw and fill paddle2
			win.setColor(Color.green);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			//show scores
			s1.displayScore(win);
			inGame.gamePlaySwitches(win);
		}
		
		//multiplayer game play (CYAN)
		if (gameState == 11) {
			//draw middle divider
			win.setColor(Color.white);
			win.fillRect((int)GDV5.getMaxWindowX()/2, 0, 20, 800);
			
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.cyan);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
		
			//draw and fill paddle2
			win.setColor(Color.cyan);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			//show scores
			s1.displayScore(win);
			inGame.gamePlaySwitches(win);
		}
		
		//display winner in multiplayer
		if (gameState == 12) {
			winner.displayWinnerMultiplayer(win);
		}
		
		//pause screen in multiplayer (RED)
		if (gameState == 13) {
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.red);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
				
			//draw and fill paddle2
			win.setColor(Color.red);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			s1.displayScore(win); 
			pause.displayPause(win);
		}
		
		//pause screen in multiplayer (ORANGE)
		if (gameState == 14) {
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.orange);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
				
			//draw and fill paddle2
			win.setColor(Color.orange);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
							
			s1.displayScore(win); 
			pause.displayPause(win);
		}
		
		//pause screen in multiplayer (YELLOW)
		if (gameState == 15) {
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.yellow);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
						
			//draw and fill paddle2
			win.setColor(Color.yellow);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
					
			s1.displayScore(win); 
			pause.displayPause(win);
		}
		
		//pause screen in multiplayer (GREEN)
		if (gameState == 16) {
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.green);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
								
			//draw and fill paddle2
			win.setColor(Color.green);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
							
			s1.displayScore(win); 
			pause.displayPause(win);
		}
		
		//pause screen in multiplayer (CYAN)
		if (gameState == 17) {
			//draw ball
			win.setColor(Color.white);
			win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
			
			//draw and fill paddle1
			win.setColor(Color.cyan);
			win.fillRect((int)paddle1.getX(), (int)paddle1.getY(), (int)paddle1.getWidth(), (int)paddle1.getHeight());
								
			//draw and fill paddle2
			win.setColor(Color.cyan);
			win.fillRect((int)paddle2.getX(), (int)paddle2.getY(), (int)paddle2.getWidth(), (int)paddle2.getHeight());
							
			s1.displayScore(win); 
			pause.displayPause(win);
		}
	}
	public void paddleBounce() {
		if (ball.intersects(paddle1)) {
			if (collisionDirection(paddle1, ball, 5, 5) == 1) {
				ball.ballVelX = (ball.ballVelX + 1) * -1;
				ball.ballVelY = (ball.ballVelY + 1) * -1;
			}
			else if (collisionDirection (paddle1, ball, -5, -5) == 3) {
				ball.ballVelX = (ball.ballVelX + 1) * -1;
				ball.ballVelY = (ball.ballVelY + 1) * -1;
			}
			ball.ballVelX *= -1;
			//ball.ballVelY *= -1;
		}
		if (ball.intersects(paddle2)) {
			if (collisionDirection(paddle2, ball, 5, 5) == 1) {
				ball.ballVelX = (ball.ballVelX + 1) * -1;
				ball.ballVelY = (ball.ballVelY + 1) * -1;
			}
			else if (collisionDirection(paddle2, ball, -5, -5) == 3) {
				ball.ballVelX = (ball.ballVelX + 1) * -1;
				ball.ballVelY = (ball.ballVelY + 1) * -1;
			}
			ball.ballVelX = (ball.ballVelX + 1) * -1;
			//ball.ballVelY *= -1;
		}
	}
	public void cheatingTheSystem() {
		//gameState = 0: main menu, 
		//gameState = 1: single player how to - gameState = 2: single player game play - gameState = 3: single player pause - gameState = 4: single player winner
		//gameState = 5: multiplayer how to - gameState = 6: paddle color choice (same color for both paddles)
		//gameState = 7: multiplayer game play (RED) - gameState = 8: multiplayer game play (ORANGE) - gameState = 9: multiplayer game play (YELLOW) - gameState = 10: multiplayer game play (GREEN) - gameState = 11: multiplayer game play (CYAN)
		//gameState = 12: multiplayer winner
		//gameState = 13: multiplayer pause (RED) - gameState = 14: multiplayer pause (ORANGE) - gameState = 15: multiplayer pause (YELLOW) - gameState = 16: multiplayer pause (GREEN) - gameState = 17: multiplayer pause (CYAN)
		
		//single player game play
		if (gameState == 2) {
			ball.moveSinglePlayer(paddle1, paddle2); 
			paddle2.rCheckMove(5);
			paddle1.lAutonMove(5, ball);
			paddleBounce();
			if(GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameState = 3;
			}
		}
		//multiplayer game play (RED)
		if (gameState == 7) {
			ball.moveMultiplayer(paddle1, paddle2); 
			paddle1.lCheckMove(5); 
			paddle2.rCheckMove(5); 
			paddleBounce(); 
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameState = 13;
			}
		}
		//multiplayer game play (ORANGE)
		if (gameState == 8) {
			ball.moveMultiplayer(paddle1, paddle2); 
			paddle1.lCheckMove(5); 
			paddle2.rCheckMove(5); 
			paddleBounce(); 
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameState = 14;
			}
		}
		//multiplayer game play (YELLOW)
		if (gameState == 9) {
			ball.moveMultiplayer(paddle1, paddle2); 
			paddle1.lCheckMove(5); 
			paddle2.rCheckMove(5); 
			paddleBounce(); 
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameState = 15;
			}
		}
		//multiplayer game play (GREEN)
		if (gameState == 10) {
			ball.moveMultiplayer(paddle1, paddle2); 
			paddle1.lCheckMove(5); 
			paddle2.rCheckMove(5); 
			paddleBounce(); 
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameState = 16;
			}
		}
		//multiplayer game play (BLUE)
		if (gameState == 11) {
			ball.moveMultiplayer(paddle1, paddle2); 
			paddle1.lCheckMove(5); 
			paddle2.rCheckMove(5); 
			paddleBounce(); 
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameState = 17;
			}
		}
		
		//switching back and forth between main menu and game modes
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
			gameState = 0;
			Scoreboard.leftScore = 0;
			Scoreboard.rightScore = 0;
			paddle1.y = 350;
			paddle2.y = 350;
		}
		//press 1 to go to single player how to
		if (gameState == 0 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 1;
		}
		//press 2 to go to multiplayer how to
		if (gameState == 0 && GDV5.KeysPressed[KeyEvent.VK_2]) {
			gameState = 5;
		}
		
		//going back and forth between instructions and game single player
		if (gameState == 1 && GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 2;
		}
		//going to paddle color choice from instructions
		if (gameState == 5 && GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 6;
		}
		
		//going to multiplayer (RED) from paddle color choice
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_1]) {
			gameState = 7;
		}
		
		//going to multiplayer (ORANGE) from paddle color choice
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_2]) {
			gameState = 8;
		}
		
		//going to multiplayer (YELLOW) from paddle color choice
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_3]) {
			gameState = 9;
		}
		
		//going to multiplayer (GREEN) from paddle color choice
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_4]) {
			gameState = 10;
		}
		
		//going to multiplayer (CYAN) from paddle color choice
		if (gameState == 6 && GDV5.KeysPressed[KeyEvent.VK_5]) {
			gameState = 11;
		}
		
		//declare winner after getting to five points in single player
		if (gameState == 2 && (Scoreboard.rightScore == 5 || Scoreboard.leftScore == 5)) {
			gameState = 4;
		}
		//declare winner after getting to five points in multiplayer (RED)
		if (gameState == 7 && (Scoreboard.rightScore == 5 || Scoreboard.leftScore == 5)) {
			gameState = 12;
		}
		
		//declare winner after getting to five points in multiplayer (ORANGE)
		if (gameState == 8 && (Scoreboard.rightScore == 5 || Scoreboard.leftScore == 5)) {
			gameState = 12;
		}
		//declare winner after getting to five points in multiplayer (YELLOW)
		if (gameState == 9 && (Scoreboard.rightScore == 5 || Scoreboard.leftScore == 5)) {
			gameState = 12;
		}
		//declare winner after getting to five points in multiplayer (GREEN)
		if (gameState == 10 && (Scoreboard.rightScore == 5 || Scoreboard.leftScore == 5)) {
			gameState = 12;
		}
		//declare winner after getting to five points in multiplayer (CYAN)
		if (gameState == 11 && (Scoreboard.rightScore == 5 || Scoreboard.leftScore == 5)) {
			gameState = 12;
		}
		
		//reset after finishing a round in single player
		if (gameState == 4 && GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 2; 
			Scoreboard.rightScore = 0; 
			Scoreboard.leftScore = 0;
			Paddle.paddle1Speed = 3;
			Paddle.paddle2Speed = 3;
		}
		//reset after finishing a round in multiplayer
		if (gameState == 12 && GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 6; 
			Scoreboard.rightScore = 0;
			Scoreboard.leftScore = 0;
			Paddle.paddle1Speed = 3;
			Paddle.paddle2Speed = 3;
		}
		
		//pause game in single player
		if (gameState == 3) {
			if (ball.getDx() != 0 && ball.getDy() != 0) {
				pauseX = ball.getDx();
				pauseY = ball.getDy();
			}
			ball.ballVelX = 0;
			ball.ballVelY = 0;
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				ball.ballVelX = pauseX;
				ball.ballVelY = pauseY;
				gameState = 1;
				}
			}
		//pause game in multiplayer (RED)
		if (gameState == 13) {
			if (ball.getDx() != 0 && ball.getDy() != 0) {
				pauseX = ball.getDx();
				pauseY = ball.getDy();
			}
			ball.ballVelX = 0;
			ball.ballVelY = 0;
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				ball.ballVelX = pauseX;
				ball.ballVelY = pauseY;
				gameState = 7;
			}
		}
		//pause game in multiplayer (ORANGE)
		if (gameState == 14) {
			if (ball.getDx() != 0 && ball.getDy() != 0) {
				pauseX = ball.getDx();
				pauseY = ball.getDy();
			}
			ball.ballVelX = 0;
			ball.ballVelY = 0;
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				ball.ballVelX = pauseX;
				ball.ballVelY = pauseY;
				gameState = 8;
			}
		}
		//pause game in multiplayer (YELLOW)
		if (gameState == 15) {
			if (ball.getDx() != 0 && ball.getDy() != 0) {
				pauseX = ball.getDx();
				pauseY = ball.getDy();
				}
				ball.ballVelX = 0;
				ball.ballVelY = 0;
				if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
					ball.ballVelX = pauseX;
					ball.ballVelY = pauseY;
					gameState = 9;
			}
		}
		//pause game in multiplayer (GREEN)
		if (gameState == 16) {
			if (ball.getDx() != 0 && ball.getDy() != 0) {
				pauseX = ball.getDx();
				pauseY = ball.getDy();
			}
			ball.ballVelX = 0;
			ball.ballVelY = 0;
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				ball.ballVelX = pauseX;
				ball.ballVelY = pauseY;
				gameState = 10;
			}
		}
		//pause game in multiplayer (CYAN)
		if (gameState == 17) {
			if (ball.getDx() != 0 && ball.getDy() != 0) {
				pauseX = ball.getDx();
				pauseY = ball.getDy();
			}
			ball.ballVelX = 0;
			ball.ballVelY = 0;
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				ball.ballVelX = pauseX;
				ball.ballVelY = pauseY;
				gameState = 11;
			}
		}
	}
}