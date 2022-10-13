package tower_defense;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("----------------------------TOWER DEFENSE----------------------------");
		System.out.println();
		
		
		int i,j;
		Map m1 = new Map(5,5);
		m1.displayDimensions();
		System.out.println();
		int[][] mapview = new int[5][5];

		
		System.out.println("----------------------------MAP VIEW----------------------------");
		System.out.println();
		
	
		MapDisplay md1 = new MapDisplay(5,5);
		System.out.println();
		Gold g1 = new Gold(6,6,10000,m1);
		System.out.println();
		
		
		MapLocation[] pathway = {new MapLocation(0,2,m1), new MapLocation(1,2,m1), new MapLocation(2,2,m1), new MapLocation(3,2,m1), new MapLocation(4,2,m1)};
		Path p1 = new Path(5,5,pathway);
		
		System.out.print("Enemies' pathway ");
		for (i=0; i<p1.Length; i++) {
			System.out.print("("+pathway[i].x+" "+pathway[i].y+") ");
			mapview[pathway[i].x][pathway[i].y] = 2;
		}
		System.out.println();
		System.out.println();
		System.out.println("----------------------------SCENARIO ONE----------------------------");
		System.out.println();
		
		
		MapLocation ml1 = new MapLocation(3,3, m1);
		BasicTower t1 = new BasicTower(ml1,m1,g1);
		mapview[3][3] = 1;
		System.out.println("Available gold "+g1.getGold());
		System.out.println();
		
		Monster e1 = new Monster(p1,5,500);
		Monster e2 = new Monster(p1,2,150);
		Monster e3 = new Monster(p1,3,250);
		Monster e4 = new Monster(p1,6,250);
		System.out.println();
		Monster[] ens1 = {e1,e2,e3,e4};
		
		int terminate = 0;
		for (i=0; i<6; i++) {
			t1.MonsterFire(ens1, g1, terminate);
		}
		System.out.println();
		System.out.println("Available gold "+g1.getGold());
		System.out.println();
		System.out.println("----------------------------SCENARIO TWO----------------------------");
		System.out.println();
		
		
		MapLocation ml2 = new MapLocation(2,3, m1);
		ArcherTower ar1 = new ArcherTower(ml2,m1,g1);
		mapview[2][3] = 5;
		System.out.println("Available gold "+g1.getGold());
		System.out.println();
		Monster e5 = new Monster(p1,3,300);
		Monster e6 = new Monster(p1,4,450);
		Boss b1 = new Boss(p1,5,5,1500);
		System.out.println();
		Monster[] ens2 = {e5,e6};
		
		for (i=0; i<10; i++) {
			ar1.MonsterFire(ens2, g1, terminate);
			ar1.BossFire(b1, g1, terminate);
		}
		
		System.out.println();
		System.out.println("Available gold "+g1.getGold());
		System.out.println();
		System.out.println("----------------------------SCENARIO THREE----------------------------");
		System.out.println();
		
		
		MapLocation ml3 = new MapLocation(3,1, m1);		
		ArcaneTower ac1 = new ArcaneTower(ml3,m1,g1);
		mapview[3][1] = 6;
		System.out.println("Available gold "+g1.getGold());
		System.out.println();
		Monster e7 = new Monster(p1,2,150);
		Monster e9 = new Monster(p1,4,350);
		Monster e8 = new Monster(p1,1,100);
		Boss b2 = new Boss(p1,10,0,1500);
		Monster[] ens3 = {e7,e8,e9};
		System.out.println();
		
		
		for (i=0; i<10; i++) {
			ac1.MonsterFire(ens3, g1, terminate);
			ac1.BossFire(b2, g1, terminate);
		}
		
		System.out.println();
		System.out.println("Available gold "+g1.getGold());
		System.out.println();
		
		
		
		System.out.println();
		System.out.println("----------------------------UPDATED MAP VIEW----------------------------");
		System.out.println();
		
		
		for (i = 0; i <m1.x; i++) {
			for (j = 0; j<m1.y; j++) {
				if (mapview[i][j] == 1) {
					System.out.print("  T  ");
				} else if (mapview[i][j] == 2) {
					System.out.print("  ||  ");
				} else if (mapview[i][j] == 5){
					System.out.print("  Ar  ");
				} else if (mapview[i][j] == 6){
					System.out.print("  Mg  ");
				} else if (mapview[i][j] == 7){
					System.out.print("  At  ");
				} else {
					System.out.print("  *  ");
				}
			}
			System.out.println();
		}
		
	}
}

