package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class WallTiles {

	private static ArrayList<Tile> wallTile;

	public WallTiles() {
		wallTile = new ArrayList<Tile>();
	}
	
	public void makeWallTiles() {
		int row = (int) (Math.random()*15)+3;
		int column = (int)(Math.random()*17)+1;
		Color col = Color.decode("#578A34");
		int x = (int) Board.board[row][column].getX();
		int y = (int) Board.board[row][column].getY();
		wallTile.add(new Tile(x, y, col, row, column));
	}
	
	public void draw(Graphics2D win) {
		for (Tile w:wallTile) {
			win.setColor(Color.decode("#578A34"));
			win.fill(w);
		}
	}
	
	public static void hitWallTile(Snake snake) {
		for (int i = 0; i < wallTile.size(); i++) {
			if (wallTile.get(i).getRow()==snake.getBody().get(0).getRow() && wallTile.get(i).getColumn() == snake.getBody().get(0).getColumn()) {
				SnakeRunner.setBlack(true);
			}
		}
	}
	
	public static ArrayList<Tile> getWallTile(){
		return wallTile;
	}
}
