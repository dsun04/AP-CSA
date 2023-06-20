package Battleship;

public abstract class Boat {
	int team;
	Coordinates location;
	int direction;
	int health;
	int strength;
	int vision;
	
	public Boat(int t ,Coordinates l, int d, int h, int s, int v) {
		this.team = t;
		this.location = l;
		this.direction = d;
		this.health = h;
		this.strength = s;
		this.vision = v;
	}
	
	public int getTeam() {
		return team;
	}
	
	public Coordinates getLocation() {
		return location;
	}
	
	public int getDirectionNum() {
		return direction;
	}
	
	char getDirection() {
		if (direction == 0) return '\u2191';
		if (direction == 1) return '\u2197';
		if (direction == 2) return '\u2192';
		if (direction == 3) return '\u2198';
		if (direction == 4) return '\u2193';
		if (direction == 5) return '\u2199';
		if (direction == 6) return '\u2190';
		if (direction == 7) return '\u2196';
		return 'a';
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getVision() {
		return vision;
	}
	
	abstract String getID();
	abstract String act(int arr[], World w);
	abstract String getActions();
	
	public String move(World w) {
		Coordinates newLocation = w.getAdjacentLocation(location, direction);
		if (!w.isLocationValid(newLocation)){
			return this + " cannot move off the map.";
		}
		else if (w.isLocationOccupied(w.getAdjacentLocation(location, direction))) {
			return this + " cannot move to " + newLocation + " as it is occupied.";
		}
		else {
			String oldLocation = location.toString();
			w.clearOccupant(location);
			location = w.getAdjacentLocation(location, direction);
			w.setOccupant(this, location);
			return this + " moves from " + oldLocation + " to " + location + ".";
		}
	}
	public String turn(int d) {
		//turn left
		if (d < 0) {
			if (direction > 0) {
				direction--;
			}
			else {
				direction = 7;
			}
			String newDirection = "";
			if (direction == 0) {
				newDirection = "N";
			}
			if (direction == 1) {
				newDirection = "NE";
			}
			if (direction == 2) {
				newDirection = "E";
			}
			if (direction == 3) {
				newDirection = "SE";
			}
			if (direction == 4) {
				newDirection = "S";
			}
			if (direction == 5) {
				newDirection = "SW";
			}
			if (direction == 6) {
				newDirection = "W";
			}
			if (direction == 7) {
				newDirection = "NW";
			}
			return "\n" + this + " turned left, now facing " + newDirection;
		}
		if (d > 0) {
			if (direction < 7) {
				direction++;
			}
			else direction = 0;
			String newDirection = "";
			if (direction == 0) {
				newDirection = "N";
			}
			if (direction == 1) {
				newDirection = "NE";
			}
			if (direction == 2) {
				newDirection = "E";
			}
			if (direction == 3) {
				newDirection = "SE";
			}
			if (direction == 4) {
				newDirection = "S";
			}
			if (direction == 5) {
				newDirection = "SW";
			}
			if (direction == 6) {
				newDirection = "W";
			}
			if (direction == 7) {
				newDirection = "NW";
			}
			return "\n" + this + " turned right, now facing " + newDirection;
		}
		return "";
	}
	
	public String takeHit(int s, World w) {
		health -= s;
		if (health < 0) {
			health = 0;
		}
		if (health == 0) {
			return "\n" + this + " has been sunk!";
		}
		else {
			return "\n" + this + " takes " + s + " damage.";
		}
	}
	
	public void setLocation(Coordinates c) {
		location = c;
	}
	
	public String toString() {
		return getID();
	}
}
