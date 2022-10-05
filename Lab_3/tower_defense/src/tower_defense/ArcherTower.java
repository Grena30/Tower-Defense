package tower_defense;

public class ArcherTower {

	private boolean armor_penetration = true;
	private int cost = 1500;
	private int damage = 2;
	private int range = 5;
	private MapLocation location;
	
	// Inherit from Tower
	
	public boolean getAbility() {
		return this.armor_penetration;
	}
	
	public ArcherTower(MapLocation loc, Gold resource) {
		if (placement(resource.getGold(), cost) == true) {
			resource.setGold(resource.getGold()-cost);
			this.location = loc;
			System.out.println("An archer tower was build at location ("+this.location.pMap.x +","+this.location.pMap.y+")");
			System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
		} else {
			System.out.println("Required cost for an archer tower is "+cost+" while you have "+resource.getGold());
		}
	}
	
	public boolean placement(int resource, int cost) {
		if (resource - cost < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public int getLocX() {
		return this.location.pMap.x;
	}
	
	public int getLocY() {
		return this.location.pMap.y;
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
}
