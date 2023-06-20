package Battleship;

public class Cruiser extends ScoutBoat{
	public Cruiser(int team, Coordinates c, int direction) {
		super(team, c, direction, 3, 3);
	}
	
	public String getID() {
		return "C" + team;
	}
	
	public String getActions() {
		return "Choose any of the following actions for the Cruiser:" + "\n" + "1. Move" + "\n" + "2. Turn left" + "\n" + "3. Turn right";
	}

	public String act(int[] choices, World w) {
		String cru = "";
		
		for (int i : choices) {
			if (i == 1) {
				cru += move(w) + "\n";
			}
			else if (i == 2) {
				cru += turn(-1) + "\n";
			}
			else if (i == 3) {
				cru += turn(1) + "\n";
			}
		}
		return cru;
	}
}
