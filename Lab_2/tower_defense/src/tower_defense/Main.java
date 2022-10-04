package tower_defense;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
			
		System.out.println("-----------------Tower Defense------------------");
		System.out.println();
		
		
		Map map = new Map(5,5);
		int i, j;
		int[][] mapview = new int[5][5];
		
		System.out.println();
		System.out.println("-----------------Map View------------------");
		System.out.println();
		
		for (i = 0; i<map.getDimensionX(); i++) {
			for (j = 0; j<map.getDimensionY(); j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println();
		
		Gold g = new Gold();
		System.out.println("Starting gold is "+g.getGold());
		
		// Choosing a pathway for the enemy 
		
		System.out.println();
		System.out.println("-----------------Enemy Pathway------------------");
		System.out.println();
		
		MapLocation[] enemy_way = {new MapLocation(0,2,map), new MapLocation(1,2,map), new MapLocation(2,2,map),new MapLocation(3,2,map),new MapLocation(4,2,map)};
		Path path1 = new Path(enemy_way);
		System.out.print("The enemy's path is: ");
		for (i = 0; i<enemy_way.length; i++) {
			System.out.print("("+enemy_way[i].pMap.x+" "+enemy_way[i].pMap.y+") ");
			mapview[enemy_way[i].pMap.x][enemy_way[i].pMap.y] = 2;
		}

		
		// Setting up locations for towers placing
		
		System.out.println();
		System.out.println();
		System.out.println("-----------------Tower & Monster Placements------------------");
		System.out.println();
		
		MapLocation towerLoc1 = new MapLocation(2, 1, map);
		mapview[2][1] = 1;
		MapLocation towerLoc2 = new MapLocation(4, 3, map);
		mapview[4][3] = 1;
		MapLocation towerLoc3 = new MapLocation(6, 7, map);
		MapLocation towerLoc4 = new MapLocation(1, 3, map);
		mapview[1][3] = 1;
		MapLocation bossLoc = enemy_way[3];
		mapview[enemy_way[3].pMap.x][enemy_way[3].pMap.y] = 4;
		
		System.out.println();
		System.out.println("-----------------Building Towers------------------");
		System.out.println();
		
		Tower tower1 = new Tower(towerLoc1, g);
		System.out.println("Remaining gold is "+g.getGold());
		Tower tower2 = new Tower(towerLoc2, g);
		System.out.println("Remaining gold is "+g.getGold());
		Tower tower3 = new Tower(towerLoc3, g);
		
		System.out.println();
		System.out.println("-----------------Spawning Monsters------------------");
		System.out.println();
		
		Enemy enemy1 = new Enemy(enemy_way[0], 1, 100);
		mapview[enemy_way[0].pMap.x][enemy_way[0].pMap.y] = 3;
		Enemy enemy2 = new Enemy(enemy_way[1], 3, 300);
		mapview[enemy_way[1].pMap.x][enemy_way[1].pMap.y] = 3;
		Enemy enemy3 = new Enemy(enemy_way[2], 2, 200);
		mapview[enemy_way[2].pMap.x][enemy_way[2].pMap.y] = 3;
		Enemy[] enemies = {enemy1, enemy2, enemy3};
		
		System.out.println();
		System.out.println("-----------------Spawning a Boss------------------");
		System.out.println();
		
		Boss boss1 = new Boss(bossLoc, 2, 5, 1000);
		
		System.out.println();
		System.out.println("-----------------Updated Map View------------------");
		System.out.println();
		
		for (i = 0; i <map.getDimensionX(); i++) {
			for (j = 0; j<map.getDimensionY(); j++) {
				if (mapview[i][j] == 1) {
					System.out.print(" T ");
				} else if (mapview[i][j] == 2) {
					System.out.print(" || ");
				} else if (mapview[i][j] == 3) {
					System.out.print(" E ");
				} else if (mapview[i][j] == 4) {
					System.out.print(" B ");
				} else {
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
		
	}
 }

