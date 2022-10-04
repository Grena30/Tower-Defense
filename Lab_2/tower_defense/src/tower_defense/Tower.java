package tower_defense;

public class Tower {

	private int cost = 500;
	private int damage = 1;
	private int range = 3;
	private MapLocation location;
	
	
	public Tower(MapLocation loc, Gold resource) {
		if (placement(resource.getGold(), cost) == true) {
			resource.setGold(resource.getGold()-cost);
			this.location = loc;
			System.out.println("A tower was build at location ("+this.location.pMap.x +","+this.location.pMap.y+")");
			System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
		} else {
			System.out.println("Required cost for a tower is "+cost+" while you have "+resource.getGold());
		}
	}
	
	public boolean placement(int resource, int cost) {
		if (resource - cost < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	
	public void setLocation(int x, int y, Map map) {
		location.setMapLoc(x, y, map);
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
	
	public void EnemyFire(Enemy[] enemies) {
		for (Enemy enemy:enemies) {
			if (enemy.IsActive() && location.InRangeOf(this.location, enemy.location, range)) {
				enemy.decrease_health(damage);
				System.out.println("An enemy took "+damage+" damage");
				if (enemy.IsNeutralized()) {
					System.out.println("An enemy was killed");
				}
			}
		}
	}
}	

