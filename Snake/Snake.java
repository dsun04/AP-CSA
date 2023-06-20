package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import utilities.GDV5;

public class Snake{
	
	private static ArrayList<Tile> body;
	Color col;
	private int row;
	private int column;
	private static int speed = 20;
	private int x,y;
	
	public Snake(){
		body = new ArrayList<Tile>();
		x = 270;
		y = 270;
		row = 9;
		column = 9;
		col = Color.decode("#4675E9");
		for (int i = 0; i < 5; i++) {
			body.add(new Tile(x, y, col, row, column));
			x += Tile.getDimension();
			column++;
		}
		body.get(0).setDirection(2); //set direction for head
		Board.board[row][10].setDirection(2);
		Board.board[row][11].setDirection(2);
		Board.board[row][12].setDirection(2);
		Board.board[row][13].setDirection(2);
	}
	
	public void move() {
		for (Tile t:body) {
			t.move();
			hitBorder();
			hitSnake();
			WallTiles.hitWallTile(this);
		}		
	}
	
	public void hitBorder() {
		if (body.get(0).getX() < 31) {
			System.out.println("hit");
			Particle.makeParticlesLeft(this);
			SnakeRunner.setDrawParticles(true);
		}
		
		if (body.get(0).getX() > 539) {
			Particle.makeParticlesRight(this);
			SnakeRunner.setDrawParticles(true);
		}
		
		if (body.get(0).getY() < 91) {
			Particle.makeParticlesUp(this);
			SnakeRunner.setDrawParticles(true);
		}
		
		if (body.get(0).getY() > 539) {
			Particle.makeParticlesDown(this);
			SnakeRunner.setDrawParticles(true);
		}
	}
	
	public void hitSnake() {
		for (int i = 1; i < body.size(); i++) {
			if (body.get(0).getRow() == body.get(i).getRow() && body.get(0).getColumn() == body.get(i).getColumn()) {
				SnakeRunner.setBlack(true);
			}
		}
	}
	
	public void headSetDirection() {
		Tile head = body.get(0); 
		int row = head.getRow();
		int column = head.getColumn();
		
		if (GDV5.KeysPressed[KeyEvent.VK_UP]) {
			head.setDirection(1);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
			head.setDirection(3);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
			head.setDirection(0);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
			head.setDirection(2);
		}
		Board.board[row][column].setDirection(head.getDirection());
	}
	
	public void bodyGetDirection() {
		int row;
		int column;
		for (int i = 1; i<body.size(); i++) {
			row = body.get(i).getRow();
			column = body.get(i).getColumn();
			body.get(i).setDirection(Board.board[row][column].getDirection());
		}
	}
	
	public void addBody() {
		Tile tail = body.get(body.size()-1);
		int direction = tail.getDirection();
		int row = tail.getRow();
		int column = tail.getColumn();
		Color col = tail.getCol();
		int x = (int)tail.getX();
		int y = (int)tail.getY();
		
		if (direction==0) { //right movement
			column--;
			x -= 30;
			body.add(new Tile(x,y,col,row,column));
		}
		if (direction == 1) { //upwards movement
			row++;
			y+= 30;
			body.add(new Tile(x,y,col,row,column));
		}
		if (direction == 2) {//left movement
			column++;
			x += 30;
			body.add(new Tile(x,y,col,row,column));
		}
		if (direction == 3) {//downwards movement 
			row--; 
			y -= 30;
			body.add(new Tile(x,y,col,row,column));
		}
	}
	
	public void draw(Graphics2D pb) {
		for (Tile t:body) {
			pb.setColor(col);
			pb.fill(t);
		}
	}
	
	//getters and setters 
	public static ArrayList<Tile> getBody(){
		return body;
	}
	
	public Color getCol() {
		return col;
	}
	
	public void setCol(Color col) {
		this.col = col;
	}
	
	public static int getSpeed() {
		return speed;
	}
	
	public static void setSpeed(int s) {
		speed = s;
	}
}
