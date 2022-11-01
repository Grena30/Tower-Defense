package tower_defense;

public class Boss extends Monster{
	
	private int armor;
	protected int health;
	private int value;
	private int pathStep = 0;
	private boolean IsBoss = true;
	
	public Boss(Path path, int health, int armor, int value) {
		super(path,health,value);
		this.armor = armor;
		this.health = health;
		this.value = value;
		display(IsBoss);
	}
	
	public void display(boolean value) {
		if (value == true) {
		System.out.println("The boss has spawned, it has "+this.health+" health and "+this.armor+" armor");
		}
	}
	
	@Override
	public void Stats() {
		System.out.println("The boss has "+this.getHealth()+" health and "+this.getArmor()+" armor and will reward "+reward()+" gold");
	}
	
	@Override
	public int getValue() {
		return this.value;
	}
	@Override
	public int getHealth() {
		return this.health;
	}
	
	public int getArmor() {
		return this.armor;
	}
	
	public void decrease_armor(int damage) {
		if (damage > this.armor) {
			System.out.println("The boss took "+this.armor+" armor damage and lost "+(damage -this.armor)+" health points");
			this.health = this.health - (damage - this.armor);
			this.armor = 0;
		} else if (this.armor >= damage){
			this.armor = this.armor - damage;
			System.out.println("The boss took "+damage+" armor damage");
		}
	}
	
	@Override
	public void decrease_health(int damage) {
		if (damage > this.health) {
			this.health = 0;
		} else {
		this.health = this.health - damage;
		}
	}
	
	@Override
	public boolean IsNeutralized() {
		return (this.health <= 0) ? true : false;
	}
	
	@Override
	public boolean IsActive() {
		return (!(IsNeutralized() || HasScored())) ? true : false;
	}
	
		
}
