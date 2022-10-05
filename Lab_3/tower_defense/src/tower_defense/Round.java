package tower_defense;

public class Round {

	private Enemy[] enemies;
	private Tower[] towers;
	
	public Round(Enemy[] enemies) {
		this.enemies = enemies;
		while(enemies.length > 0) {
			for(Tower tower:this.towers) {
				tower.EnemyFire(enemies);
			}
		}
	}
	
}
