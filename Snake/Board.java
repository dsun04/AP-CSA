package Snake;

import java.awt.Color;
import java.awt.Graphics2D;

import utilities.GDV5;

public class Board {

	static Tile[][] board;
	
	public static void makeBoard() {
		int rows = Tile.getNumTiles();
		int columns = Tile.getNumTiles();
		Color col = Color.decode("#4A752C");

		board = new Tile[rows][columns];
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 2 | i == Tile.getNumTiles()) {
					col = Color.decode("#578A34");
				}
				if ((j == 0 | j == Tile.getNumTiles()-1) && i > 2) {
					col = Color.decode("#578A34");
				}
				if (j!=0 && j!=Tile.getNumTiles()-1 && i>2 & i < 18) {
					if (i % 2 == 0 ) {
						if (j % 2 == 1) {
							col = Color.decode("#AAD750");
						}
						else{
							col = Color.decode("#A2D149");
						}
					}
					else{
						if (j % 2 == 1) {
							col = Color.decode("#A2D149");
						}
						else {
							col = Color.decode("#AAD750");
						}
					}
				}
				board[i][j] = new Tile(j*Tile.getDimension(), i*Tile.getDimension(), col);
			}
		}
	}
	
	public static void drawBoard(Graphics2D pb) {
		for (Tile[] row:board) {
			for (Tile t:row) {
				t.draw(pb);
			}
		}
	}
}
