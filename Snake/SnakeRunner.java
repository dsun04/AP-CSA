package Snake;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Color;

import utilities.GDV5;
import utilities.SoundDriver;

public class SnakeRunner extends GDV5{
	//max window size for x and y in GDV5 must be 570
	public static void main(String[] args) {
		Board.makeBoard();
		SnakeRunner g1 = new SnakeRunner();
		g1.start();
	}
	
	Snake snake = new Snake();
	Fruit fruit = new Fruit();
	Images images = new Images();
	WallTiles wallTile = new WallTiles();
	Scoreboard mainMenu = new Scoreboard();
	Scoreboard scoreBoard = new Scoreboard();
	PowerUp powerUp = new PowerUp();
	
	static int count = 0;
	private static int gameState = 0;
	
	private static boolean snakeAlive = true;
	private static boolean snakeEatsItself = false;
	private static boolean drawParticles = false;
	private static boolean black = false;
	private static SoundDriver s1;
	private String[] filenames = new String [2];
	
	public SnakeRunner() {
		//sound
		filenames[0] = "Dover.wav";
		filenames[1] = "snakeEatingSound.wav";
		setS1(new SoundDriver(filenames, this));
		s1.loop(0);
	}
	
	public void update() {
		// gameState 0: main menu (and pick level), gameState 1: normal mode instructions, gameState 2: wall tile mode instructions, gameState 3: pick fruit type for level 1, gameState 4: pick fruit type for level 2
		// gameState 5: level 1 apple, gameState 6: level 1 banana, gameState 7: level 1 grapes, gameState 8: level 1 cherry, gameState 9: level 1 end
		// gameState 10: level 2 apple, gameState 11: level 2 banana, gameState 12: level 2 grapes, gameState 13: level 2 cherry, gameState 14: level 2 end
		if (gameState == 5 | gameState == 6| gameState == 7 | gameState == 8) {
			count++;
			snake.headSetDirection();
			if (snakeAlive) {
				if (count % snake.getSpeed() == 0) { //count mod controls speed
					snake.bodyGetDirection(); 
					snake.move();
				}
			}
			fruit.makeFruit();
			fruit.intersectFruit(snake, wallTile);		
			powerUp.makePowerUps();
			powerUp.intersectPowerUp(snake);
			
			//make snake die and end level
			if (drawParticles) {
				snakeAlive = false;
				Particle.moveParticles(snake);
				if (count % 300 == 0) {
					gameState = 9;
				}
			}	
			if (black) {
				snakeAlive = false;
				snakeEatsItself = true;
				if (count % 300 == 0) {
					gameState = 9;
				}
			}	
		}
		
		if (gameState == 10 | gameState == 11 | gameState == 12 | gameState == 13) {
			s1.play(0);
			count++;
			snake.headSetDirection();
			if (snakeAlive) {
				if (count % snake.getSpeed() == 0) { //count mod controls speed
					snake.bodyGetDirection(); 
					snake.move();
				}
			}
			fruit.makeFruit();
			fruit.intersectFruit(snake, wallTile);	
			powerUp.makePowerUps();
			powerUp.intersectPowerUp(snake);
			
			//make snake die and end level
			if (drawParticles) {
				snakeAlive = false;
				Particle.moveParticles(snake);
				if (count % 300 == 0) {
					gameState = 14;
				}
			}	
			if (black) {
				snakeAlive = false;
				snakeEatsItself = true;
				if (count % 300 == 0) {
					gameState = 14;
				}
			}	
		}
		
		//escape to main menu
		if (KeysPressed[KeyEvent.VK_ESCAPE]) {
			gameState = 0;
			Scoreboard.setScore(0);
		}
		
		//controls from main menu
		if (gameState == 0 && KeysPressed[KeyEvent.VK_1]) {
			gameState = 1;
		}
		if (gameState == 0 && KeysPressed[KeyEvent.VK_2]) {
			gameState = 2;
		}
		
		//controls from normal mode how to play
		if (gameState == 1 && KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 3;
		}
		
		//controls from wall tile how to play
		if (gameState == 2 && KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 4;
		}
				
		//controls from normal mode pick fruit
		if (gameState == 3 && KeysPressed[KeyEvent.VK_1]) {
			gameState = 5;
			black = false;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			snake = new Snake();
		}
		if (gameState == 3 && KeysPressed[KeyEvent.VK_2]) {
			gameState = 6;
			black = false;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			snake = new Snake();

		}
		if (gameState == 3 && KeysPressed[KeyEvent.VK_3]) {
			gameState = 7;
			black = false;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			snake = new Snake();

		}
		if (gameState == 3 && KeysPressed[KeyEvent.VK_4]) {
			gameState = 8;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			black = false;
			snake = new Snake();

		}
		
		//controls from wall tile pick fruit
		if (gameState == 4 && KeysPressed[KeyEvent.VK_1]) {
			gameState = 10;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			black = false;
			snake = new Snake();
			wallTile = new WallTiles();

		}
		if (gameState == 4 && KeysPressed[KeyEvent.VK_2]) {
			gameState = 11;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			black = false;
			snake = new Snake();
			wallTile = new WallTiles();


		}
		if (gameState == 4 && KeysPressed[KeyEvent.VK_3]) {
			gameState = 12;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			black = false;
			snake = new Snake();
			wallTile = new WallTiles();


		}
		if (gameState == 4 && KeysPressed[KeyEvent.VK_4]) {
			gameState = 13;
			drawParticles = false;
			snakeAlive = true;
			snakeEatsItself = false;
			black = false;
			snake = new Snake();
			wallTile = new WallTiles();


		}
		
		//level 1 end to pick fruit
		if (gameState == 9 && KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 3;
			Scoreboard.setScore(0);
		}
		
		//level 2 end to pick fruit
		if (gameState == 14 && KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 4;
			Scoreboard.setScore(0);
		}
	}
	
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		mainMenu.splashPage(win, images.mainMenu, images.howToPlayNormalMode, images.pickFruitType, images.howToPlayWallTileMode, images.score, this);
		
		if (gameState == 5 | gameState == 6 | gameState == 7 | gameState == 8) {
			Board.drawBoard(win);
			if (snakeAlive && snakeEatsItself == false) {
				snake.draw(win);
			}
			else if(snakeEatsItself) {
				snake.draw(win);
				snake.setCol(Color.black);
			}
			else {
				Particle.drawParticles(win, snake);
			}
			fruit.draw(win, images.apple, this, images.banana, images.grapes, images.cherry, images.lightningBolt, images.mushroom, images.pill);
			scoreBoard.scoreBoard(win);
			powerUp.draw(win, images.lightningBolt, images.mushroom, images.pill, this);
		}
		
		if (gameState == 10 | gameState == 11 | gameState == 12 | gameState == 13) {
			Board.drawBoard(win);
			
			if (snakeAlive && snakeEatsItself == false) {
				snake.draw(win);
			}
			
			else if (snakeEatsItself) {
				snake.draw(win);
				snake.setCol(Color.black);
			}
			
			else {
				Particle.drawParticles(win, snake);
			}
			fruit.draw(win, images.apple, this, images.banana, images.grapes, images.cherry, images.lightningBolt, images.mushroom, images.pill);
			wallTile.draw(win);
			scoreBoard.scoreBoard(win);
			powerUp.draw(win, images.lightningBolt, images.mushroom, images.pill, this);
		}	
	}
	
	//getters and setters
	public static boolean getDrawParticles() {
		return drawParticles;
	}
	
	public static void setDrawParticles(boolean dP) {
		drawParticles = dP;
	}
	
	public static boolean getBlack() {
		return black;
	}
	
	public static void setBlack(boolean sB) {
		black = sB;
	}
	
	public static int getGameState() {
		return gameState;
	}
	public static int getCount() {
		return count;
	}

	public static SoundDriver getS1() {
		return s1;
	}

	public static void setS1(SoundDriver sound1) {
		s1 = sound1;
	}
}
