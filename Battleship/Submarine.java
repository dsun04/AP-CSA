package Battleship;

public class Submarine extends ScoutBoat implements Attacker{
	private int numOfTorpedoes;
	
	public Submarine(int team, Coordinates c, int direction, int torpedoes) {
		super(team, c, direction, 3, 2);
		this.numOfTorpedoes = torpedoes;
	}
	
	public String getID() {
		return "S" + team;
	}
	
	public String getActions() {
		return "Choose any of the following actions for the Submarine:" + "\n" + "1. Move" + "\n" + "2. Turn left" + "\n" + "3. Turn right" + "\n" + "4. Submerge" + "\n" + "5. Fire torpedoes";
	}
	
	public String act(int[] choices, World w) {
		String sub = "";
		for (int i : choices) {
			if (i == 1) {
				sub += move(w) + "\n";
			}
			else if (i == 2) {
				sub += turn(-1) + "\n";
			}
			else if (i == 3) {
				sub += turn(1) + "\n";
			}
			else if (i == 4) {
				sub += submerge(w) + "\n";
			}
			else if (i == 5) {
				sub += attack(w) + "\n";
			}
		}	
		return sub;
	}

	public String attack(World w) {
		if (numOfTorpedoes <= 0) {
			return this.getID() + "has no torpedoes remaining.";
		}
		else {
			Coordinates c = getLocation();
			for (int i = 0; i < getVision(); i++) {
				Boat occupant = null;
				if (w.isLocationValid(c)){
					occupant = w.getOccupant(w.getAdjacentLocation(c, this.getDirectionNum()));
				}
				else {
					occupant = null;
				}
				if (occupant != null && occupant.getTeam() != this.getTeam()) {
					numOfTorpedoes--;
					return "Fire torpedoes!\n" + occupant.takeHit((int)(Math.random()*occupant.getHealth())+1, w);
				}
				else c = w.getAdjacentLocation(c, getDirectionNum());
			}
			return "There are no boats in range currently.";
		}
	}
	
	public String submerge(World w) {
		int i = (int)((Math.random()*((this.getLocation().getX() + 2))) + (this.getLocation().getX() - 2));
		int j = (int)((Math.random()*((this.getLocation().getY() + 2))) + (this.getLocation().getY() - 2)); 
		Coordinates oldLocation = getLocation();
		w.clearOccupant(oldLocation);
		Coordinates newLocation = new Coordinates(i,j);
		if (w.isLocationValid(newLocation)) {
			setLocation(newLocation);
		}
		else {
			newLocation = null;
		}
		return this.getID() + " moves from " + oldLocation + " to " + this.getLocation() + ".";
	}
}
