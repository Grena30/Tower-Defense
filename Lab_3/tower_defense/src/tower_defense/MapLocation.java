package tower_defense;

public class MapLocation {
	
	protected int x;
	protected int y;
	protected Point pMap;
	
	public void setMapLoc(int x, int y, Map map) {
		this.x = x;
		this.y = y;
		if (map.OnMap(x, y) == false) {
			System.out.println("The chosen map coordinates "+ x + "," + y + " are outside of boundaries");
		}
	}
	
	public MapLocation(int x, int y, Map map) {
		pMap = new Point(x,y);
		if (map.OnMap(x, y) == false) {
			System.out.println("The chosen map coordinates "+ x + "," + y + " are outside of boundaries");
		}
	}
	
	public boolean InRangeOf(MapLocation loc_tower, MapLocation loc_enemy, int range) {
	if (loc_tower.pMap.DistanceTo(loc_enemy.pMap) <= range) {
			return true;
	} else {
			return false;
	}
}
}
