package tower_defense;

public abstract class Tower {
	
	int cost;
	int damage;
	int range;
	MapLocation place;
	boolean upgraded;
	
	public abstract void display(Map map, Gold resource, boolean upgraded);
	public abstract void MonsterFire(Monster[] enemies, Gold g, int terminate);
	public abstract void BossFire(Boss boss, Gold g, int terminate);
	
	public int addition(int num) {
		return num+1;
	}
	
	public boolean placement(int resource, int cost) {
		return (resource - cost > 0) ? true : false;
	}
	
	
}
