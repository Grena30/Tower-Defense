package tower_defense;

public class Enemy {
	
	public int health;
	public int value;
	private Path path;
	private int pathStep = 0;
	
	
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
	
	public boolean IsNeutralized() {
		if (health <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean HasScored() {
		if (pathStep >= path.Length) {
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

