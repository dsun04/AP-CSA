package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utilities.GDV5;

public class Tile extends Rectangle{
	
	private int row;
	private int column;
	private int direction;
	private Color col;
	private static int numTiles = 19;
	private static int dimension = GDV5.getMaxWindowX()/numTiles;
//	
	public Tile(int x, int y, Color col) {
		super(x, y, 0, 0);
		this.setSize(dimension,dimension);
		this.col = col;
		this.direction = 2;
	}
	
	public Tile (int x, int y, Color col, int row, int column) {
		super(x,y,30,30);
		this.col = col;
		this.row = row;
		this.column = column;
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(col);
		pb.fill(this);
	}
	
	public void move() {
		if (direction == 0) {
			this.x += this.width; //moving right
			this.column++;
		}
		if (direction == 1) {
			this.y -= this.width; //moving up
			this.row--;
		}
		if (direction == 2) {
			this.x -= this.width; //moving left
			this.column--;
		}
		if (direction == 3) {
			this.y += this.width; //moving down
			this.row++;
		}
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}

	public static int getDimension() {
		return dimension;
	}

	public void setDimension(int size) {
		this.dimension = size;
	}
	
	public static int getNumTiles() {
		return numTiles;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
}

