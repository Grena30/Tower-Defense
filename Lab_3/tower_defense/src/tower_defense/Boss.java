package tower_defense;

public class Boss {
	
	private int armor;
	private int health;
	private int value;
	private MapLocation position;
	
	// Inherit from Enemy
	
	public Boss(MapLocation location, int armor, int health, int value) {
		this.armor = armor;
		this.health = health;
		this.value = value;
		this.position = location;
		System.out.println("A boss has appeared at location ("+position.pMap.x+" "+position.pMap.y+")");
		System.out.println("With "+this.getHealth()+" health and "+this.getArmor()+" armor");
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getArmor() {
		return this.armor;
	}

}
