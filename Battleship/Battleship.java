package Battleship;

public class Battleship extends Boat implements Attacker{
	public Battleship(int team, Coordinates c, int direction) {
		super(team, c, direction, 4, 3, 1);
	}
	
	public String getID() {
		return "B" + team;
	}
	
	public String getActions() {
		return "Choose any of the following actions for the Battleship:\n 1. Move\n 2. Turn left\n 3. Turn right\n 4. Attack";
	}
	
	public String act(int[] choices, World w) {
		String bat = ""; 
		for (int i : choices) {
			if (i == 1) {
				bat += move(w) + "\n";
			}
			if (i == 2) {
				bat += turn(-1) + "\n";
			}
			if (i == 3) {
				bat += turn(1) + "\n";
			}
			if (i == 4) {
				bat += attack(w) + "\n";
			}
		}
		return bat;
	}
	
	public String attack(World w) {
		Coordinates c = getLocation();
		Boat occupant = w.getOccupant(w.getAdjacentLocation(c, this.getDirectionNum()));
		if (occupant != null && occupant.getTeam() != this.getTeam()) {
			return "Fire cannons!" + occupant.takeHit(getStrength(), w) + occupant.takeHit(getStrength(), w);
		}
		else {
			return "There are no boats in range currently.";
		}
	}
}
