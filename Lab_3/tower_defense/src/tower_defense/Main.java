package tower_defense;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
			
		System.out.println("-----------------Tower Defense------------------");
		System.out.println();
		
		
		Map map = new Map(5,5);
		map.displayDimensions();
		int[][] mapview = new int[6][6];
		
		System.out.println();
		System.out.println("-----------------Map View------------------");
		System.out.println();
		
		MapDisplay display = new MapDisplay(map.x,map.y);
		System.out.println();
		
		System.out.println();
		System.out.println("-------------------Gold--------------------");
		System.out.println();
		Gold g = new Gold(5,4,5000, map);
		
		
		// Choosing a pathway for the enemy 
		
		System.out.println();
		System.out.println("-----------------Enemy Pathway------------------");
		System.out.println();
		
		MapLocation[] enemy_way = {new MapLocation(0,2,map), new MapLocation(1,2,map), new MapLocation(2,2,map),new MapLocation(3,2,map),new MapLocation(4,2,map)};
		Path path1 = new Path(map.x,map.y,enemy_way);
		for (int i = 0; i<enemy_way.length; i++) {
			System.out.print("("+enemy_way[i].x+" "+enemy_way[i].y+") ");
			mapview[enemy_way[i].x][enemy_way[i].y] = 2;
		}
		System.out.println();
		
		// Setting up locations for towers placing
		
		
		System.out.println();
		System.out.println("-----------------Building Towers------------------");
		System.out.println();
		
		Tower tower1 = new Tower(2, 1, map, g);
		mapview[2][1] = 1;
		System.out.println("Remaining gold is "+g.getGold());
		System.out.println();
		Tower tower2 = new Tower(4, 3, map, g);
		mapview[4][3] = 1;
		System.out.println("Remaining gold is "+g.getGold());
		System.out.println();
		Tower tower3 = new Tower(6, 7, map, g);
		System.out.println();
		System.out.println("Remaining gold is "+g.getGold());
		System.out.println();
		ArcherTower tower4 = new ArcherTower(3, 1, map, g);
		mapview[3][1] = 5;
		System.out.println("Remaining gold is "+g.getGold());
		System.out.println();
		ArcaneTower tower5 = new ArcaneTower(2, 0, map, g);
		mapview[2][0] = 5;
		System.out.println("Remaining gold is "+g.getGold());
		System.out.println();
		ArtilleryTower tower6 = new ArtilleryTower(2,1, map, g);
		Tower[] towers = {tower1,tower2,tower4,tower5,tower6};
		
		System.out.println();
		System.out.println("-----------------Spawning Monsters------------------");
		System.out.println();
		
		Enemy enemy1 = new Enemy(map.x,map.y,enemy_way, 1, 100);
		enemy1.Stats();
		Enemy enemy2 = new Enemy(map.x,map.y,enemy_way, 3, 300);
		enemy2.Stats();
		Enemy enemy3 = new Enemy(map.x,map.y,enemy_way, 2, 200);
		enemy3.Stats();
		Enemy[] enemies = {enemy1, enemy2, enemy3};
		
		System.out.println();
		System.out.println("-----------------Spawning a Boss------------------");
		System.out.println();
		
		Boss boss1 = new Boss(map.x,map.y,enemy_way, 5, 2, 1000);
		boss1.Stats();
		Boss[] bosses = {boss1};
		
		System.out.println();
		System.out.println("-------------------Rounds--------------------");
		System.out.println();
		Round r = new Round(5,0,enemies,towers,map);
		
		System.out.println();
		System.out.println("-----------------Updated Map View------------------");
		System.out.println();
		
		for (int i = 0; i <map.x; i++) {
			for (int j = 0; j<map.y; j++) {
				if (mapview[i][j] == 1) {
					System.out.print("  T  ");
				} else if (mapview[i][j] == 2) {
					System.out.print("  ||  ");
				} else if (mapview[i][j] == 3){
					System.out.print("  Ar  ");
				} else if (mapview[i][j] == 4){
					System.out.print("  Mg  ");
				} else if (mapview[i][j] == 5){
					System.out.print("  At  ");
				} else {
					System.out.print("  *  ");
				}
			}
			System.out.println();
		}
		System.out.println();
		for (int z = 0; z<map.y; z++) {
			if (z == r.y) {
				System.out.print("Round number 1");
			} else if (z == g.y) {
				System.out.print("Available gold "+g.getGold());
			} else {
				System.out.print(" ");
			}
		}
		System.out.println();
		
	}
 }

