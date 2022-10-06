package tower_defense;

public class MapDisplay extends Map{
	
	private Tower[] towers;
	private Enemy[] enemies;
	private Boss[] bosses;
	
	
	public MapDisplay(int x, int y) {
		super(x,y);
		for (int i = 0; i<this.x; i++) {
			for (int j = 0; j<this.y; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}
	
	public MapDisplay(int x, int y, Tower[] towers, MapLocation[] locations ,Round round, Gold gold) {
		super(x,y);
		for (int i = 0; i<this.x; i++) {
			for (int j = 0; j<this.y; j++) {
				System.out.print("  *  ");
				for (Tower t: towers) {
					if (i == t.x && j == t.y) {
						System.out.print("  T  ");
					}
				}
				for (MapLocation l: locations) {
					if (i == l.x && j == l.y) {
						System.out.print("  ||  ");
					}
				}
				
			}
			System.out.println();
		}
		for (int i = this.x; i<this.x+1; i++) {
			for (int j = this.y; j<this.y+1; j++) {
				if (i == round.x && j == round.y) {
					System.out.print("Round number 1");
				} else if (i == gold.x && j == gold.y) {
					System.out.print("Available gold "+gold.getGold());
				}
			}
		}
		
	}
}
