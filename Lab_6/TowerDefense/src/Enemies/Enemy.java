package Enemies;

import Map.MapLocation;
import Miscellaneous.Gold;

public interface Enemy {

    void advance();
    MapLocation currentLocation();
    void decrease_health(int number, int damage);
    boolean IsNeutralized();
    boolean IsActive();
    boolean HasScored();
    void killed(int number, Gold g);
}