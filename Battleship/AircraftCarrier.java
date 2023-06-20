package Battleship;

public class AircraftCarrier extends Boat implements Attacker{
	private boolean hasPlanes = false;
	
	public AircraftCarrier(int team, Coordinates c, int direction) {
		super(team, c, direction, 5, 1, 1);
	}
	
	public String getID() {
		return "A" + team;
	}
	
	public String getActions() {
		return "Choose any of the following actions for the Aircraft Carrier:\n 1. Move\n 2. Turn left\n 3. Turn right\n 4. Launch planes";
	}
	
	public String act(int[] choices, World w) {
		StringBuilder air = new StringBuilder();
		for (int i : choices) {
			if (i == 1) {
				air.append(move(w) + "\n");
			}
			if (i == 2) {
				air.append(turn(-1) + "\n");
			}
			if (i == 3) {
				air.append(turn(1) + "\n");
			}
			if (i == 4) {
				air.append(attack(w) + "\n");
			}
		}
		return air.toString();
	}
	
	public String attack(World w) {
		String attackResult = "";
		double successRate = 1;
		if (hasPlanes) {
			for (int i = 0; i < 8; i++) {
				Boat occupant = w.getOccupant(w.getAdjacentLocation(this.getLocation(), i));
				if (occupant != null && occupant.getTeam() != this.getTeam()) {
					if (successRate == 1) attackResult += "Air raid!\n";
					attackResult += occupant.takeHit(getStrength(), w) + "\n";
					successRate *= 0.8;
					if (Math.random() > successRate) {
						hasPlanes = false;
						attackResult += "The planes have been destroyed.";
					}
				}
			}
		}
		else attackResult += this.getID() + " has no planes remaining.\n";
		if (successRate == 1) {
			attackResult += "There are no boats in range currently.";
		}
		return attackResult;
	}
}
