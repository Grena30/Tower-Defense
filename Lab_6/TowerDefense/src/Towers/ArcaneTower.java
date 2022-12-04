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
    private boolean upgraded;


    public boolean getAbility() {
        return this.zap;
    }

    public ArcaneTower(MapLocation loc, Gold resource) {
        this.place = loc;
        display(resource, true);

    }

    public void display(Gold resource, boolean upgraded) {
        if (upgraded) {
            resource.setGold(resource.getGold() - cost);
            System.out.println("An arcane tower was build at location (" + this.place.x + "," + this.place.y + ")");
            System.out.println("It costed " + this.cost + " gold and it has " + this.damage + " damage and " + this.range + " range");
            System.out.println();
        }
    }

    public void MonsterFire(Monster[] enemies, Gold g) {
        int c = 0;
        for (Monster enemy : enemies) {
            c++;
            if (enemy.IsActive() && this.place.InRangeOf(enemy.currentLocation(), this.range)) {
                enemy.decrease_health(c, this.damage);
            }
            enemy.killed(c, g);
        }
    }

    public void BossFire(Boss boss, Gold g) {
        if (boss.IsActive() && this.place.InRangeOf(boss.currentLocation(), this.range)) {
            if (getAbility()) {
                this.zap = false;
                System.out.println("The boss was hit with disintegration and took " + 2 * this.damage + " total damage");
                boss.decrease_armor(2 * this.damage);
            } else if (boss.getArmor() == 0 && getAbility()) {
                this.zap = false;
                System.out.println("The boss was hit with disintegration and took " + 2 * this.damage + " total damage");
                boss.decrease_health(2*this.damage);
            } else if (boss.getArmor() == 0){
                boss.decrease_health(this.damage);
            } else if (boss.getArmor() != 0){
                boss.decrease_armor(this.damage);
            }
        }
    }
}

