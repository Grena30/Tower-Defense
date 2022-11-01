package tower_defense;

public class Round{

	private Monster[] enemies;
	private BasicTower[] towers;
	private ArcherTower[] attowers;
	private ArcaneTower[] artowers;
	private Boss boss;
	private Gold gold;
	private Lives lives;
	
	public Round(BasicTower[] towers_, ArcaneTower[] artowers_, ArcherTower[] attowers_, Monster[] enemies_, Boss boss_, Gold gold_, Lives lives_) {
		this.towers = towers_;
		this.attowers = attowers_;
		this.artowers = artowers_;
		this.enemies = enemies_;
		this.boss = boss_;
		this.gold = gold_;
		this.lives = lives_;
	}
	
	public Round(BasicTower[] towers_, ArcaneTower[] artowers_, ArcherTower[] attowers_, Monster[] enemies_, Gold gold_, Lives lives_) {
		this.towers = towers_;
		this.attowers = attowers_;
		this.artowers = artowers_;
		this.enemies = enemies_;
		this.gold = gold_;
		this.lives = lives_;
	}
	
	
	public void StartSimulation() {
		int count = 0;
		while (this.lives.getLives() != 0) {
			for (BasicTower t: this.towers) {
				if (t == null) { 
					continue;
					}
				t.MonsterFire(this.enemies, this.gold);
				t.BossFire(this.boss, this.gold);
			}
			
			for (ArcaneTower ar: this.artowers) {
				if (ar == null) { 
					continue;
					}
				ar.MonsterFire(this.enemies, this.gold);
				ar.BossFire(this.boss, this.gold);
			}
			
			for (ArcherTower at: this.attowers) {
				if (at == null) { 
					continue;
					}
				at.MonsterFire(this.enemies, this.gold);
				at.BossFire(this.boss, this.gold);
			}
				
			for (Monster e: this.enemies) {
				e.advance();
				if (e.HasScored()) {
					this.lives.reduceLives(1);
					System.out.println("An enemy has scored and you have lost a life");
					System.out.println("Available lives: "+this.lives.getLives());
					if (this.lives.getLives() == 0) {
						break;
					}
				}
			}
			
			if (this.boss != null) {
				boss.advance();
				if (this.boss.HasScored() && this.lives.getLives() > 0) {
					this.lives.reduceLives(this.lives.getLives());
					System.out.println("The boss has scored and you have lost all your lives");
					System.out.println("Available lives: "+this.lives.getLives());
				}
			}
			
			if (this.lives.getLives() == 0) {
				System.out.println("You have lost the game");
				break;
			}
			
			
			
			if (count == 15) {
				System.out.println("You have won the game");
				break;	
			}
			
			count++;
			
			}
	  }
	
}

	

