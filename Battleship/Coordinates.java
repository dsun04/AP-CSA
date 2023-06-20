package Battleship;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordinates(int xVal, int yVal) {
		this.x = xVal;
		this.y = yVal;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setCoordinates(int xVal, int yVal) {
		this.x = xVal;
		this.y = yVal;
	}

	public String toString() {
		return "" + (char)(y+65) + (x+1);
	}
}
