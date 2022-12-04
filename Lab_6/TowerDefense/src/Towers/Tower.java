package Towers;

import Enemies.Boss;
import Enemies.Monster;
import Map.Map;
import Miscellaneous.Gold;

public abstract class Tower {

    public abstract void display(Gold resource, boolean upgraded);
    public abstract void MonsterFire(Monster[] enemies, Gold g);
    public abstract void BossFire(Boss boss, Gold g);
}
