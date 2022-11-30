package Towers;

import Enemies.Boss;
import Enemies.Monster;
import Map.Map;
import Map.MapLocation;
import Miscellaneous.Gold;

public class ArcaneTower extends Tower {

    protected boolean zap = true;
    private int cost = 1500;
    private int damage = 3;
    public int range = 3;
    public MapLocation place;
    private boolean upgraded = true;


    public boolean getAbility() {
        return this.zap;
    }

    public ArcaneTower(MapLocation loc, Map map, Gold resource) {
        this.place = loc;
        display(map, resource, this.upgraded);

    }

    public void display(Map map, Gold resource, boolean upgraded) {
        if (upgraded) {
            if (placement(resource.getGold(), cost)) {
                resource.setGold(resource.getGold()-cost);
                System.out.println("An arcane tower was build at location ("+this.place.x +","+this.place.y+")");
                System.out.println("It costed "+this.cost+" gold and it has "+this.damage+" damage and "+this.range+" range");
                System.out.println();
            } else {
                System.out.println("Required cost for an arcane tower is "+cost+" while you have "+resource.getGold());
                System.out.println();
            }
        }
    }

    public void MonsterFire(Monster[] enemies, Gold g) {
        int c = 0;
        for (Monster enemy:enemies) {
            c++;
            if (enemy.IsActive() && this.place.InRangeOf(enemy.currentLocation(), this.range)) {
                enemy.decrease_health(this.damage);
                System.out.println("Monster "+c+" took "+this.damage+" damage");
                if (enemy.IsNeutralized()) {
                    System.out.println("Monster "+c+" was killed and rewarded "+enemy.value+" gold");
                    g.setGold(g.getGold() + enemy.reward());
                } else {
                    System.out.println("Remaining health of monster "+c+" is "+enemy.health);
                }
            }
        }
    }

    public void BossFire(Boss boss, Gold g) {
        if (boss.IsActive() && this.place.InRangeOf(boss.currentLocation(), this.range)) {
            if (this.getAbility()) {
                this.zap = false;
                System.out.println("The boss was hit with disintegration and took "+2*this.damage+" total damage");
                boss.decrease_armor(2*this.damage);
            }
            else if (boss.getArmor() == 0) {
                boss.decrease_health(this.damage);
                System.out.println("The boss took "+this.damage+" damage");
            } else {
                boss.decrease_armor(this.damage);
            }
            if (boss.IsNeutralized()) {
                System.out.println("The boss was killed");
                g.setGold(g.getGold() + boss.reward());
            } else {
                if (boss.getArmor() == 0) {
                    System.out.println("Remaining health of the boss is "+boss.health);
                } else {
                    System.out.println("Remaining health of the boss is "+boss.health+" and armor is "+boss.getArmor());
                }
            }
        }
    }

}

