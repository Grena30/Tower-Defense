package tower_defense;

public class Monster implements Enemy{
	
	protected int health;
	protected int value;
	private int pathStep = 0;
	private Path path;
	private boolean IsBoss = false;
	
	
	public Monster(Path path, int health, int value) {
		this.value = value;
		this.health = health;
		this.path = path;
		display(this.IsBoss);
	}
	
	public void display(boolean value) {
		if (value == false) {
		System.out.println("A monster has spawned, it has "+this.getHealth()+" health");
		}
	}
	
	public void advance() {
		pathStep += 1;
	}
	
	public MapLocation currentLocation() {
		return path.GetLocationAt(pathStep);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void decrease_health(int dmg) {
		this.health = this.health - dmg;
	}
	
	
	public void Stats() {
		System.out.println("The enemy has "+this.health+" health and will reward "+this.value+" gold");
		System.out.println();
	}
	
	public boolean IsNeutralized() {
		return (this.health <= 0) ? true : false;
	}
	
	public boolean HasScored() {
		return (pathStep >= this.path.Length) ? true : false;
	}
	
	public boolean IsActive() {
		return (!(IsNeutralized() || HasScored())) ? true : false;
	}
	
	public int reward() {
		return this.value;
		
	}

}

