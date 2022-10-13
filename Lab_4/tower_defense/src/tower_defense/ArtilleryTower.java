package tower_defense;

public class ArtilleryTower extends Tower{
	
	private boolean scatter = true;
	private int cost = 1500;
	private int damage = 2;
	private int range = 2;
	protected MapLocation place;
	private boolean upgraded = true;
	

	public boolean getAbility() {
		return this.scatter;
	}	

	public ArtilleryTower(MapLocation loc, Map map, Gold resource) {
		this.place = loc;
		display(map, resource, this.upgraded);
		
	}
	
	public void display(Map map, Gold resource, boolean upgraded) {
		if (upgraded == true) {
		if (placement(resource.getGold(), cost) == true) {
			resource.setGold(resource.getGold()-cost);
			System.out.println("An artillery tower was build at location ("+this.place.x +","+this.place.y+")");
			System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
			System.out.println();
		} else {
			System.out.println("Required cost for an artillery tower is "+cost+" while you have "+resource.getGold());
			System.out.println();
		}
		}
	}
	
	public void MonsterFire(Monster[] enemies, Gold g, int terminate) {
		for (Monster enemy:enemies) {
			if (enemy.IsActive() && this.place.InRangeOf(enemy.currentLocation(), this.range)) {
				enemy.decrease_health(this.damage);
				System.out.println("An enemy took "+this.damage+" damage");
				if (enemy.IsNeutralized()) {
					System.out.println("An enemy was killed");
					terminate++;
					g.setGold(g.getGold() + enemy.reward());
				} else {
					System.out.println("Remaining health is "+enemy.health);
				}
			}
		}
	}
	
	public void BossFire(Boss boss, Gold g, int terminate) {
		
	}
	
	
}
