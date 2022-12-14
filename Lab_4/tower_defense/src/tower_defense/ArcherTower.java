package tower_defense;

public class ArcherTower extends Tower{

	private boolean armor_penetration = true;
	private int cost = 1500;
	private int damage = 2;
	private int range = 5;
	protected MapLocation place;
	private boolean upgraded = true;
	
	
	public boolean getAbility() {
		return this.armor_penetration;
	}
	
	public ArcherTower(MapLocation loc, Map map, Gold resource) {
		this.place = loc;
		display(map, resource, this.upgraded);
		
	}
	
	public void display(Map map, Gold resource, boolean upgraded) {
		if (upgraded == true) {
		if (placement(resource.getGold(), cost) == true) {
			resource.setGold(resource.getGold()-cost);
			System.out.println("An archer tower was build at location ("+this.place.x +","+this.place.y+")");
			System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
			System.out.println();
		} else {
			System.out.println("Required cost for an archer tower is "+cost+" while you have "+resource.getGold());
			System.out.println();
		}
	  }
	}
	
	public void MonsterFire(Monster[] enemies, Gold g, int terminate) {
		int c = 0;
		for (Monster enemy:enemies) {
			c++;
			if (enemy.IsActive() && this.place.InRangeOf(enemy.currentLocation(), this.range)) {
				enemy.decrease_health(this.damage);
				System.out.println("Enemy "+c+" took "+this.damage+" damage");
				if (enemy.IsNeutralized()) {
					System.out.println("Enemy "+c+" was killed");
					terminate++;
					g.setGold(g.getGold() + enemy.reward());
				} else {
					System.out.println("Remaining health of enemy "+c+" is "+enemy.health);
				}
			}
		}
	}
	
	public void BossFire(Boss boss, Gold g, int terminate) {
		if (boss.IsActive() && this.place.InRangeOf(boss.currentLocation(), this.range)) {
				boss.decrease_health(this.damage);
				System.out.println("The boss took "+this.damage+" poisonous damage");
			if (boss.IsNeutralized()) {
				System.out.println("The boss was killed");
				terminate++;
				g.setGold(g.getGold() + boss.reward());
			} else {
				if (boss.getArmor() == 0) {
					System.out.println("Remaining health of the boss is "+boss.health);
				} else {
					System.out.println("Remaining health of the boss is "+boss.health+" and armor is "+boss.getArmor());
				}
			}
		}
	}
	
}
