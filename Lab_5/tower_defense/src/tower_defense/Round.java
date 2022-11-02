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
	
	
	public void StartSimulation() throws InterruptedException {
		int count = 0, enem = 0;
		while (this.lives.getLives() != 0) {
			int bT = 0, aR = 0, aT = 0;
			for (BasicTower t: this.towers) {
				if (t == null) { 
					continue;
					}
				
				if (this.enemies != null) {
					int killed = 0;
					for (int i = 0; i<this.enemies.length; i++) {
						if (enemies[i].IsNeutralized() == true)
						killed++;
					}
					if (killed == this.enemies.length) {
						break;
					}
					if (this.boss != null) {
						if(this.boss.IsNeutralized() == true) {
							break;
						}
					}
					System.out.println();
					//Thread.sleep(200);
					System.out.println("Basic tower "+(bT+1)+" is shooting");
					System.out.println();
					t.MonsterFire(this.enemies, this.gold);
				}
				if (this.boss != null && this.boss.IsNeutralized() != true) {
					t.BossFire(this.boss, this.gold);
				}
				bT++;
				
			}
			
			for (ArcaneTower ar: this.artowers) {
				if (ar == null) { 
					continue;
					}
				
				if (this.enemies != null) {
					ar.MonsterFire(this.enemies, this.gold);
				}
				if (this.boss != null) {
				ar.BossFire(this.boss, this.gold);
				}
			}
			
			for (ArcherTower at: this.attowers) {
				if (at == null) { 
					continue;
					}
				
				if (this.enemies != null) {
					at.MonsterFire(this.enemies, this.gold);
					}
				if (this.boss != null) {
				at.BossFire(this.boss, this.gold);
				}
			}
				
			for (Monster e: this.enemies) {
				e.advance();
				if (e.HasScored() && e.IsNeutralized() != true) {
					enem++;
					this.lives.reduceLives(1);
					System.out.println("An enemy has scored and you have lost a life");
					System.out.println("Available lives: "+this.lives.getLives());
					if (this.lives.getLives() == 0) {
						break;
					}
				}
			}
			
			if (this.boss != null && this.boss.IsNeutralized() != true) {
				boss.advance();
				if (this.boss.HasScored() && this.lives.getLives() > 0) {
					this.lives.reduceLives(this.lives.getLives());
					System.out.println("The boss has scored and you have lost all your lives");
					System.out.println("Available lives: "+this.lives.getLives());
				}
			}
			
			if (this.lives.getLives() == 0) {
				System.out.println();
				System.out.println("You have lost the game!");
				break;
			}
			
			if (this.boss == null) {
				if (count == 50 || enem == this.enemies.length) {
					System.out.println();
					System.out.println("You have won the game!");
					break;	
				}
			} else if (this.boss != null) {
				if (count == 50 || enem == this.enemies.length && this.boss.IsNeutralized() == true) {
					System.out.println();
					System.out.println("You have won the game!");
					break;	
				}
			}
			count++;
			
			}
	  }
	
}

	

