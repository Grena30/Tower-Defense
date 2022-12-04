package Enemies;

import Map.MapLocation;
import Map.Path;
import Miscellaneous.Gold;

public class Boss implements MonsterBoss{

    private int armor;
    private int health;
    private int value;
    private int pathStep = 0;
    private Path path;

    public Boss(Path path, int health, int armor, int value) {
        this.path = path;
        this.armor = armor;
        this.health = health;
        this.value = value;
        display();
    }

    public void display() {
            System.out.println("The boss has spawned, it has "+this.health+" health and "+this.armor+" armor");
    }

    public void advance() {
        pathStep += 1;
    }

    public MapLocation currentLocation() {
        return path.GetLocationAt(pathStep);
    }

    public void Stats() {
        System.out.println("The boss has "+this.getHealth()+" health and "+this.getArmor()+" armor and will reward "+getValue()+" gold");
    }

    public int getValue() {
        return this.value;
    }

    public int getHealth() {
        return this.health;
    }

    public int getArmor() {
        return this.armor;
    }

    public void decrease_armor(int damage) {
        if (damage > this.armor) {
            System.out.println("The boss took "+this.armor+" armor damage and lost "+(damage -this.armor)+" health points");
            this.health = this.health - (damage - this.armor);
            this.armor = 0;
        } else {
            this.armor = this.armor - damage;
            System.out.println("The boss took "+damage+" armor damage");
        }
    }

    public void decrease_health(int damage) {
        if (damage > this.health) {
            this.health = 0;
        } else {
            this.health = this.health - damage;
        }
        System.out.println("The boss took "+damage+" health damage");
    }

    public boolean IsNeutralized() {
        return this.health <= 0;
    }

    public boolean IsActive() {
        return !(IsNeutralized() || HasScored());
    }

    public boolean HasScored() {
        return this.pathStep >= this.path.Length;
    }

    public void killed(Gold g){
        if (IsNeutralized()){
            System.out.println("The boss was killed and rewarded "+getValue()+" gold");
            g.addGold(getValue());
        } else if (getArmor() <= 0){
            System.out.println("Remaining health of the boss is "+getHealth());
        } else{
            System.out.println("Remaining health of the boss is "+getHealth()+" and armor is "+getArmor());
        }
    }
}
