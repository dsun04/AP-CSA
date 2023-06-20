package Battleship;

public abstract class ScoutBoat extends Boat{
	public ScoutBoat(int team, Coordinates location, int direction, int health, int vision) {
		super(team, location, direction, health, 1, vision);
	}
	
	public String takeHit(int numAttacks) {
		numAttacks = 0;
		if (Math.random() <= 0.25) {
			numAttacks++;
			health--;
			return this.getID() + " takes 1 damage.";
		}
		else return this.getID() + " has avoided the attack!";
	}
}
