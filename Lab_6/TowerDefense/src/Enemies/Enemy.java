package Enemies;

import Map.MapLocation;
import Map.Path;

public interface Enemy {

    final int health = 1;
    final int value = 100;
    final Path path = null;
    final int Step = 0;

    void advance();
    MapLocation currentLocation();
    void decrease_health(int damage);
    public boolean IsNeutralized();
    public boolean IsActive();
    public boolean HasScored();
}