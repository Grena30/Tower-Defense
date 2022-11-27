package Towers;

import Enemies.Boss;
import Enemies.Monster;
import Map.Map;
import Map.MapLocation;
import Miscellaneous.Gold;

public abstract class Tower {

    int cost;
    int damage;
    int range;
    MapLocation place;
    boolean upgraded;

    public abstract void display(Map map, Gold resource, boolean upgraded);
    public abstract void MonsterFire(Monster[] enemies, Gold g);
    public abstract void BossFire(Boss boss, Gold g);

    public boolean placement(int resource, int cost) {
        return (resource - cost > 0) ? true : false;
    }


}
