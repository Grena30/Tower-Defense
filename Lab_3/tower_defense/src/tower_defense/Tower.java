package tower_defense;

public class Tower extends MapLocation{

	private int cost = 500;
	private int damage = 1;
	private int range = 3;
	private boolean upgraded = false;
	
	
	public Tower(int x, int y, Map map, Gold resource) {
		super(x, y, map);
		display(map, resource, this.upgraded);
	}
	
	public boolean placement(int resource, int cost) {
		if (resource - cost < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void display(Map map, Gold resource, boolean upgraded) {
		if (upgraded == false) {
		if (placement(resource.getGold(), cost) == true && map.OnMap(this.x, this.y) == true) {
			resource.setGold(resource.getGold()-cost);
			System.out.println("A tower was build at location ("+this.x +","+this.y+")");
			System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
			System.out.println();
		} else if (placement(resource.getGold(), cost) == false){
			System.out.println("Required cost for a tower is "+cost+" while you have "+resource.getGold());
			System.out.println();
		}
		}
	}
	public void EnemyFire(Enemy[] enemies) {
		for (Enemy enemy:enemies) {
			if (enemy.IsActive() && InRangeOf(enemy.currentLocation(), range)) {
				enemy.decrease_health(damage);
				System.out.println("An enemy took "+damage+" damage");
				if (enemy.IsNeutralized()) {
					System.out.println("An enemy was killed");
				}
			}
		}
	}
}	

