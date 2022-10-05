package tower_defense;

public class Enemy {
	
	public int health;
	public int value;
	private Path path;
	private int pathStep = 0;
	protected MapLocation location;
	//path.GetLocationAt(pathStep, path);
	
	
	public Enemy(MapLocation position, int health, int value) {
		this.location = position;
		this.value = value;
		this.health = health;
		System.out.println("An enemy has appeared at location ("+position.pMap.x+" "+position.pMap.y+")");
		System.out.println("With "+this.health+" health");
	}
	
	public Enemy(Path path) {
		this.path = path;
	}
	
	public void advance() {
		pathStep += 1;
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
		return this.location.pMap.x;
	}
	
	public int getLocY() {
		return this.location.pMap.y;
	}
	
	public boolean IsNeutralized() {
		if (this.health <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean HasScored() {
		if (this.pathStep >= this.path.Length) {
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

