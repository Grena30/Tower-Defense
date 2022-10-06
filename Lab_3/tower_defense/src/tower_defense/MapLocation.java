package tower_defense;

public class MapLocation extends Point {
	
	private Map map;
	
	public MapLocation(int x, int y, Map map) {
		super(x,y);
		this.map = map;
		if (this.map.OnMap(this.x, this.y) == false) {
			System.out.println("The chosen map coordinates "+ this.x + "," + this.y + " are outside of boundaries");
		}
	}
	
	public boolean InRangeOf(MapLocation loc_enemy, int range) {
	if (DistanceTo(loc_enemy) <= range) {
			return true;
	} else {
			return false;
	}
}
}
