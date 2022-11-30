package Enemies;

import Map.MapLocation;
import Map.Path;

public class Monster implements Enemy{

    public int health;
    public int value;
    private int pathStep = 0;
    private final Path path;


    public Monster(Path path, int health, int value) {
        this.value = value;
        this.health = health;
        this.path = path;
        display(false);
    }

    public void display(boolean value) {
        if (!value) {
            System.out.println("A monster has spawned, it has "+this.getHealth()+" health");
        }
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

    public void decrease_health(int dmg) {
        this.health = this.health - dmg;
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

    public int reward() {
        return this.value;
    }
}
