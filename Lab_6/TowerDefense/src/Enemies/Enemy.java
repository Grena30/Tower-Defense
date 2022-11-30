package Enemies;

import Map.MapLocation;

public interface Enemy {

    void advance();
    MapLocation currentLocation();
    void decrease_health(int damage);
    boolean IsNeutralized();
    boolean IsActive();
    boolean HasScored();
}