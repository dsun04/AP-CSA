package Battleship;

public class Destroyer extends Boat implements Attacker{
	public Destroyer(int team, Coordinates c, int direction) {
		super(team, c, direction, 2, 2, 1);
	}
	
	public String getID() {
		return "D" + team;
	}
	
	public String getActions() {
		return "Choose any of the following actions for the Destroyer:\n 1. Move\n 2. Turn left\n 3. Turn right\n 4. Attack";
	}
	
	public String act(int[] choices, World w) {
		String des = "";
		for (int i : choices) {
			if (i == 1) {
				des += move(w) + "\n";
			}
			if (i == 2) {
				des += turn(-1) + "\n";
			}
			if (i == 3) {
				des += turn(1) + "\n";
			}
			if (i == 4) {
				des += attack(w) + "\n";
			}
		}
		return des;
	}
	
	public String attack(World w) {
		Coordinates c = getLocation();
		Boat occupant = w.getOccupant(w.getAdjacentLocation(c, getDirectionNum()));
		if (occupant != null && occupant.getTeam() != this.getTeam()) {
			return occupant.getID() + occupant.takeHit(getStrength(), w);
		}
		else return "There are no boats in range currently.";
	}
	
	public String takeHit(int attackerStrength, World w) {
		if (Math.random() > 0.5) {
			return " avoids the attack!";
		}
		else {
			return super.takeHit(attackerStrength, w);
		}
	}
}
