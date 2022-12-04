package Towers;

import Enemies.Boss;
import Enemies.Monster;
import Map.Map;
import Map.MapLocation;
import Miscellaneous.Gold;

public class ArcherTower extends Tower{

    private boolean armor_penetration = true;
    private int cost = 1500;
    private int damage = 2;
    public int range = 5;
    public MapLocation place;
    private boolean upgraded = true;


    public boolean getAbility() {
        return this.armor_penetration;
    }

    public ArcherTower(MapLocation loc, Gold resource) {
        this.place = loc;
        display(resource, true);

    }

    public void display(Gold resource, boolean upgraded) {
        if (upgraded) {
            resource.setGold(resource.getGold()-cost);
            System.out.println("An archer tower was build at location ("+this.place.x +","+this.place.y+")");
            System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
            System.out.println("The poisonous arrows bypass armor");
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
            boss.decrease_health(this.damage);
            boss.killed(g);
        }
    }
}
