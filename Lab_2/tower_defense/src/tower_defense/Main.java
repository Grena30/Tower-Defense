package tower_defense;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Map m1 = new Map();
		m1.setDimensions(3, 3);
		Gold g1 = new Gold();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the available gold: ");
		g1.setGold(sc.nextInt());
		Enemy e1 = new Enemy();
		e1.setHealth(2);
		e1.setValue(55);
		Tower t1 = new Tower();
		t1.setRange(2);
		System.out.println("Available gold: " + g1.getGold());
		System.out.println("Tower cost: " + t1.getCost());
		System.out.println("Can you place a tower? "+t1.placement(g1.resource, t1.getCost()));
		g1.setGold(g1.getGold() - t1.getCost());
		System.out.println("Available gold: "+g1.getGold());
		System.out.println("Tower damage: "+ t1.getDmg());
		System.out.println("Tower range: "+ t1.getRange());
		System.out.println("Enemy health: "+e1.getHealth());
		System.out.println("Enemy value: "+e1.getValue());
		e1.decrease_health(t1.getDmg());
		System.out.println("Enemy health's decreases to "+e1.getHealth());
		e1.decrease_health(t1.getDmg());
		System.out.println("Enemy health's decreases to "+e1.getHealth());
		System.out.println("Is the enemy dead? "+e1.IsNeutralized());
		System.out.println("Is the enemy still active? "+e1.IsActive());
		g1.setGold(g1.getGold() + e1.reward());
		System.out.println("Available gold: "+g1.getGold());
		

	}

}
