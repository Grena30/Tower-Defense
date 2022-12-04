package Towers;

import Enemies.Boss;
import Enemies.Monster;
import Map.Map;
import Map.MapLocation;
import Miscellaneous.Gold;

public class BasicTower extends Tower{

    private int cost = 500;
    public int damage = 1;
    public int range = 2;
    public MapLocation place;
    private boolean upgraded;


    public BasicTower(MapLocation loc, Gold resource) {
        this.place = loc;
        display(resource, false);
    }


    public void display(Gold resource, boolean upgraded) {
        if (!upgraded) {
            resource.setGold(resource.getGold()-cost);
            System.out.println("A tower was build at location ("+this.place.x +","+this.place.y+")");
            System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
            System.out.println();
        }
    }

    public void MonsterFire(Monster[] enemies, Gold g) {
        int c = 0;
        for (Monster enemy:enemies) {
            c++;
            if (enemy.IsActive() && this.place.InRangeOf(enemy.currentLocation(), this.range)) {
                enemy.decrease_health(c, this.damage);
            }
            enemy.killed(c, g);
        }
    }

    public void BossFire(Boss boss, Gold g) {
        if (boss.IsActive() && this.place.InRangeOf(boss.currentLocation(), this.range)) {
            if (boss.getArmor() == 0) {
                boss.decrease_health(this.damage);
            } else {
                boss.decrease_armor(this.damage);
            }
            boss.killed(g);
        }
    }
}
