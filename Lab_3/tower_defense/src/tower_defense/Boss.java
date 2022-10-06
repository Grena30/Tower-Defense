package tower_defense;

public class Boss extends Enemy{
	
	private int armor;
	private int health;
	private int value;
	
	
	public Boss(int x, int y, MapLocation[] locations, int health, int armor, int value) {
		super(x,y,locations,health,value);
		this.armor = armor;
		this.health = health;
		this.value = value;
	}
	
	
	public void Stats() {
		System.out.println("The boss has "+this.getHealth()+" health and "+this.getArmor()+" armor and will reward "+reward()+" gold");
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
