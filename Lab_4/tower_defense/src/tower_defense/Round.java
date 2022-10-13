package tower_defense;

public class Round{

	private Monster[] enemies;
	private BasicTower[] towers;
	private Boss boss;
	protected int x;
	protected int y;
	
	public Round(int x, int y, Monster[] enemies, BasicTower[] towers, Boss boss, Map map) {
		this.x = x;
		this.y = y;
		this.enemies = enemies;
		this.towers = towers;
		this.boss = boss;
		if (map.OnMap(this.x, this.y) == false) {
			System.out.println("Round number will be shown at location ("+this.x+" "+this.y+")");
	  }
	}
	
	
	public void RoundStart(Gold g) {
		while(enemies.length > 0 && boss.getHealth() > 0) {
		for(BasicTower t:this.towers) {
			
		}
	}
	
 }
	
}
