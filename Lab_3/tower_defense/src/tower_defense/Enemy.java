package tower_defense;

public class Enemy extends Path{
	
	public int health;
	public int value;
	private int pathStep = 0;
	//path.GetLocationAt(pathStep, path);
	
	
	public Enemy(int x, int y, MapLocation[] locations, int health, int value) {
		super(x,y,locations);
		this.value = value;
		this.health = health;
		this.path = locations;
	}
	
	public void advance() {
		pathStep += 1;
	}
	
	public MapLocation currentLocation() {
		return this.path[pathStep];
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void decrease_health(int dmg) {
		this.health = this.health - dmg;
	}
	
	public int getLocX() {
		return this.x;
	}
	
	public int getLocY() {
		return this.y;
	}
	
	public void Stats() {
		System.out.println("The enemy has "+this.health+" health and will reward "+this.value+" gold");
		System.out.println();
	}
	
	public boolean IsNeutralized() {
		if (this.health <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean HasScored() {
		if (pathStep >= this.path.length) {
			return true;
		} else {
			return false;
		}
	}
	public boolean IsActive() {
		if (!(IsNeutralized() || HasScored())) {
			return true;
		} else {
			return false;
		}
	}
	
	public int reward() {
		return this.value;
		
	}

}

