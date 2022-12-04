package Enemies;

import Map.MapLocation;
import Map.Path;
import Miscellaneous.Gold;

public class Monster implements Enemy{

    public int health;
    public int value;
    private int pathStep = 0;
    final Path path;


    public Monster(Path path, int health, int value) {
        this.value = value;
        this.health = health;
        this.path = path;
        display();
    }

    public void display() {
            System.out.println("A monster has spawned, it has "+this.getHealth()+" health");
    }

    public void advance() {
        pathStep += 1;
    }

    public MapLocation currentLocation() {
        return path.GetLocationAt(pathStep);
    }

    public int getValue() {
        return this.value;
    }

    public int getHealth() {
        return this.health;
    }

    public void decrease_health(int c, int damage) {

        this.health -= damage;
        System.out.println("Monster "+c+" took "+damage+" damage");
    }

    public void Stats() {
        System.out.println("The enemy has "+this.health+" health and will reward "+this.value+" gold");
        System.out.println();
    }

    public boolean IsNeutralized() {
        return this.health <= 0;
    }

    public boolean HasScored() {
        return pathStep >= this.path.Length;
    }

    public boolean IsActive() {
        return !(IsNeutralized() || HasScored());
    }

    public void killed(int c, Gold g){
        if (IsNeutralized()){
            System.out.println("Monster "+c+" was killed and rewarded "+getValue()+" gold");
            g.addGold(getValue());
        } else {
            System.out.println("Remaining health of monster "+c+" is "+getHealth());
        }
    }
}
