package tower_defense;

public class Tower {

	private int cost = 450;
	private int damage = 1;
	private int range;
	private MapLocation location;
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public int getDmg() {
		return this.damage;
	}
	
	public void EnemyFire() {
		
	}
	public boolean placement(int resource,int cost) {
		if (resource - cost < 0) {
			return false;
		} else {
			return true;
		}
	}
}	

