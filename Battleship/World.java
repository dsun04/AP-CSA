package Battleship;

public class World {
	private Boat[][] map;
	public static final int NORTH = 0;
	public static final int NORTHEAST = 1;
	public static final int EAST = 2;
	public static final int SOUTHEAST = 3;
	public static final int SOUTH = 4;
	public static final int SOUTHWEST = 5;
	public static final int WEST = 6;
	public static final int NORTHWEST = 7;
	
	public World(int width, int height) {
		if (width < 4) width = 4;
		if (width > 10) width = 10;
		if (height < 4) height = 4;
		if (height > 10) height = 10;
		map = new Boat[height][width];
	}
	
	public int getWidth() {
		return map[0].length;
	}
	
	public int getHeight() {
		return map.length;
	}
	
	public boolean isLocationValid(Coordinates c) {
		return c.getX() < getWidth() && c.getX() >= 0 && c.getY() < getHeight() && c.getY() >= 0;
	}
	
	public Boat getOccupant(Coordinates c) {
		if (isLocationValid(c)) {
			return map[c.getY()][c.getX()];
		}
		else return null;
	}
	
	public boolean isLocationOccupied(Coordinates c) {
		return getOccupant(c) != null;
	}
	
	public boolean setOccupant(Boat b, Coordinates c) {
		if (!isLocationOccupied(c) && isLocationValid(c)) {
			map[c.getY()][c.getX()] = b;
			return true;
		}
		else return false;
	}
	
	public void clearOccupant(Coordinates c) {
		map[c.getY()][c.getX()] = null;
	}
	
	public Coordinates getAdjacentLocation(Coordinates c, int x) {
		int xVal = c.getX();
		int yVal = c.getY();
		
		if (x == 0) {
			yVal--;
		}
		
		if (x == 1) {
			yVal--;
			xVal++;
		}
		
		if (x == 2) {
			xVal++;
		}
		
		if (x == 3) {
			xVal++;
			yVal++;
		}
		
		if (x == 4) {
			yVal++;
		}
		
		if (x == 5) {
			yVal++;
			xVal--;
		}
		
		if (x == 6) {
			xVal--;
		}
		
		if (x == 7) {
			yVal--;
			xVal--;
		}
		return new Coordinates (xVal, yVal);
	}
	
	public String drawTeamMap(Boat[] boats, int view) {		
		int numRows = getHeight();
		int numCols = getWidth();
		String[][] mapString = new String[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				mapString[i][j] = "###";
			}
		}
		
		if (view == 2 || view == 3) {
			for (Boat b:boats) {
				setOccupant(b, b.getLocation());
				Coordinates loc = b.getLocation();
				int row = loc.getY();
				int col = loc.getX();
				if (view == 2) mapString[row][col] = b.getDirection() + b.getID();
				if (view == 3) mapString[row][col] = b.getHealth() + b.getID();
			
				int startRow = row - b.getVision();
				int endRow = row + b.getVision();
				int startCol = col - b.getVision();
				int endCol = col + b.getVision();
				for (int i = startRow; i <= endRow; i++) {
					for (int j = startCol; j <= endCol; j++) {
						Coordinates waterLoc = new Coordinates(j,i);
						if (isLocationValid(waterLoc)) {
							if (isLocationOccupied(waterLoc)) {
								if (view == 2) mapString[i][j] = map[i][j].getDirection() + map[i][j].getID();
								if (view == 3) mapString[i][j] = map[i][j].getHealth() + map[i][j].getID();
							}
							else mapString[i][j] = "~~~";
						}
					}
				}	
			}
		}
		
		String result = "@ ";
		char c = 'A';
		for (int i = 1; i <= numCols; i++) {
			result += " " + i + " ";
		}
		
		result += "\n";
		
		for (int i = 0; i < numRows; i++) {
			result += (char)(c+i) + " ";
			for (int j = 0; j < numCols; j++) {
				result += mapString[i][j];
			}
			result += "\n";
		}
		return result;
	}
}
