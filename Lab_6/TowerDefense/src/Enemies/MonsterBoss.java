package Enemies;

import Map.MapLocation;
import Miscellaneous.Gold;

public interface MonsterBoss {
    void advance();
    MapLocation currentLocation();
    void decrease_health(int damage);
    boolean IsNeutralized();
    boolean IsActive();
    boolean HasScored();
    void killed(Gold g);
}
