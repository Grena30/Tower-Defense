package tower_defense;

import java.util.Scanner;
import java.util.Random;

public class Main {
	
	public static void BeginGame() throws InterruptedException {
		
		System.out.println("----------------------------TOWER DEFENSE----------------------------");
		System.out.println();
		System.out.println("Beginning the game");
		System.out.println();
		
		
		// class variables
		ArcaneTower[] Arcs = new ArcaneTower[5];
		ArcherTower[] Arts = new ArcherTower[5];
		BasicTower[] Bts = new BasicTower[15];
		Round[] r = new Round[100];
		int bt=0, art=0, arc=0;
		int round = 0;
		int i,j,gold = 500, bCheck = 0;
		float lives = 1;
		Boss b1 = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the coordinates of the map: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println();
		Map m1 = new Map(x,y);
		int [][] mapCheck = new int[x][y];
		m1.displayDimensions();
		System.out.println();
		MapDisplay mDisp = new MapDisplay(x,y);
		System.out.println();
		System.out.print("Choose the enemy pathway length: ");
		int len = sc.nextInt();
		MapLocation[] pathway = new MapLocation[len];
		for (i=0; i<len; i++) {
			System.out.print("Enter the coordinates for the cell "+(i+1)+": ");
			int xp = sc.nextInt();
			int yp = sc.nextInt();
			mapCheck[xp][yp] = 1;
			pathway[i]= new MapLocation(xp,yp,m1);
		}
		System.out.println();
		Path p1 = new Path(5,5,pathway);
		System.out.print("Choose the number of enemies you want to spawn: ");
		int lenE = sc.nextInt();
		System.out.println();
		Monster[] monsters = new Monster[lenE];
		for (i=0; i<lenE; i++) {
			Random rand = new Random();
			int hRand = rand.nextInt(10)+1;
			int gRand = hRand*100;
			lives = (float) (lives + 0.5);
			monsters[i] = new Monster(p1,hRand,gRand);
		}
		gold = gold + lenE*50;
		System.out.println();
		System.out.print("Choose if you want to spawn a boss: ");
		String ans = sc.next();
		System.out.println();
		if (ans.equals("yes") || ans.equals("Yes") || ans.equals("YES")) {
			Random rand1 = new Random();
			int hRand = rand1.nextInt(5)+5;
			Random rand2 = new Random();
			int armRand = rand2.nextInt(15);
			int gRand = armRand*50+hRand*100;
			b1 = new Boss(p1, hRand, armRand, gRand);
			bCheck = 1;
			gold = gold + 300;
			System.out.println();
		}
		Gold g1 = new Gold(gold);
		Lives l1 = new Lives((int) Math.floor(lives));
		
		while(true) {
			System.out.println("----------------------------MAIN MENU----------------------------");
			System.out.println();
			System.out.println("1.Start simulation");
			System.out.println("2.Build a tower");
			System.out.println("3.Check gold");
			System.out.println("4.Check lives");
			System.out.println("5.Display map");
			System.out.println("6.Quit game");
			System.out.println();
			System.out.print("Choice: ");
			int num = sc.nextInt();
			switch(num) {
				case 1:
					if (bCheck == 1) {
						System.out.println();
						r[round] = new Round(Bts, Arcs, Arts, monsters, b1, g1, l1);
						r[round].StartSimulation();
						
					} else {
						System.out.println();
						r[round] = new Round(Bts, Arcs, Arts, monsters, g1, l1);
						r[round].StartSimulation();
					}
					System.out.println();
					System.out.println("----------------------------SIMULATION ENDED----------------------------");
					System.out.println();
					System.out.println("1. Quit");
					int sim = sc.nextInt();
					switch(sim) {
						case 1:
							System.exit(0);
							break;
						default:
							System.exit(0);
							break;
					}
					break;
				case 2:
					System.out.println("----------------------------TOWERS----------------------------");
					System.out.println("1. Basic tower");
					System.out.println("2. Arcane tower");
					System.out.println("3. Archer tower");
					System.out.println();
					System.out.print("Choice: ");
					int tow = sc.nextInt();
					switch(tow) {
						case 1:
							while(true) {
								
							if (g1.getGold() < 500) {
								System.out.println();
								System.out.println("You do not have enough gold");
								System.out.println();
								break;
							}
							System.out.print("Choose the location of your tower: ");
							int xp = sc.nextInt();
							int yp = sc.nextInt();
							if (mapCheck[xp][yp] != 0 || m1.OnMap(xp,yp) == false) {
								System.out.println("These coordinates are invalid");
								System.out.println();
								continue;
				
							} else {
								MapLocation temp = new MapLocation(xp,yp,m1);
								mapCheck[xp][yp] = 2;
								Bts[bt] = new BasicTower(temp,m1,g1);
								bt++;
								break;
							}
							}
							break;
						case 2:
							while(true) {
								
								if (g1.getGold() < 1500) {
									System.out.println();
									System.out.println("You do not have enough gold");
									System.out.println();
									break;
								}
								System.out.print("Choose the location of your arcane tower: ");
								int xp = sc.nextInt();
								int yp = sc.nextInt();
								if (mapCheck[xp][yp] != 0 || m1.OnMap(xp,yp) == false) {
									System.out.println("These coordinates are invalid");
									System.out.println();
									continue;
					
								} else {
									MapLocation temp = new MapLocation(xp,yp,m1);
									mapCheck[xp][yp] = 3;
									Arcs[arc] = new ArcaneTower(temp,m1,g1);
									arc++;
									break;
								}
								}
							break;
						case 3:
							while(true) {
								
								if (g1.getGold() < 1500) {
									System.out.println();
									System.out.println("You do not have enough gold");
									System.out.println();
									break;
								}
								System.out.print("Choose the location of your archer tower: ");
								int xp = sc.nextInt();
								int yp = sc.nextInt();
								if (mapCheck[xp][yp] != 0 || m1.OnMap(xp,yp) == false) {
									System.out.println("These coordinates are invalid");
									System.out.println();
									continue;
					
								} else {
									MapLocation temp = new MapLocation(xp,yp,m1);
									mapCheck[xp][yp] = 4;
									Arts[bt] = new ArcherTower(temp,m1,g1);
									art++;
									break;
								}
								}
							break;
						default:
							break;
					}
					break;
				case 3:
					System.out.println();
					System.out.println("Available gold is "+g1.getGold());
					System.out.println();
					System.out.println("1. Would you like to add 2000 gold");
					System.out.println("2. Leave");
					int addGold = sc.nextInt();
					switch(addGold) {
						case 1:
							g1.setGold(g1.getGold()+2000);
							break;
						case 2:
								break;
							default:
								break;
					}
					break;
				case 4:
					System.out.println();
					System.out.println("Available lives is "+l1.getLives());
					System.out.println();
					System.out.println("1. Would you like to add 5 lives");
					System.out.println("2. Leave");
					int addLives = sc.nextInt();
					switch(addLives) {
						case 1:
							l1.reduceLives(-5);
							break;
						case 2:
								break;
							default:
								break;
					}
					break;
				case 5:
					System.out.println();
					mDisp.PrintMap(mapCheck);
					break;
				case 6:
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----------------------------MAIN MENU----------------------------");
			System.out.println();
			System.out.println("1.Start Game");
			System.out.println("2.Quit");
			System.out.println();
			System.out.print("Choice: ");
			int num = sc.nextInt();
			switch (num) {
				case 1:
					System.out.println();
					BeginGame();
					break;
				case 2:
					System.out.println();
					System.out.println("Game exit");
					System.exit(0);
					break;
				default:
					System.out.println();
					System.out.println("Unknown decision was chosen");
					System.out.println();
					break;
				}
			
			}
		}
	}
