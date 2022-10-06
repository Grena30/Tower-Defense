package tower_defense;

public class Round extends Point{

	private Enemy[] enemies;
	private Tower[] towers;
	
	public Round(int x, int y, Enemy[] enemies, Tower[] towers, Map map) {
		super(x,y);
		this.enemies = enemies;
		this.towers = towers;
		if (map.OnMap(this.x, this.y) == false) {
			System.out.println("Round number will be shown at location ("+this.x+" "+this.y+")");
			this.enemies = enemies;
			/*while(enemies.length > 0) {
				for(Tower t:this.towers) {
					t.EnemyFire(enemies);
			}
		}*/
	  }
	}
	
}
