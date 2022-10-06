package tower_defense;

public class ArtilleryTower extends Tower{
	
	private boolean scatter = true;
	private int cost = 1500;
	private int damage = 2;
	private int range = 2;
	private boolean upgraded = true;
	
	// Inherit from Tower	

	public boolean getAbility() {
		return this.scatter;
	}	

	public ArtilleryTower(int x, int y, Map map, Gold resource) {
		super(x,y,map,resource);
		display(map, resource, this.upgraded);
		
	}
	
	public void display(Map map, Gold resource, boolean upgraded) {
		if (upgraded == true) {
		if (placement(resource.getGold(), cost) == true) {
			resource.setGold(resource.getGold()-cost);
			System.out.println("An artillery tower was build at location ("+this.x +","+this.y+")");
			System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
			System.out.println();
		} else {
			System.out.println("Required cost for an artillery tower is "+cost+" while you have "+resource.getGold());
			System.out.println();
		}
		}
	}
	
	public boolean placement(int resource, int cost) {
		if (resource - cost < 0) {
			return false;
		} else {
			return true;
		}
	}
	
}
