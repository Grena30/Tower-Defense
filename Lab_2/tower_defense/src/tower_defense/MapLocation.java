package tower_defense;

public class MapLocation {
	
	private int x;
	private int y;
	Point point = new Point();
	
	public void setMapLoc(int x, int y) {
		point.setPoint(x,y);
	}
	
	
	public MapLocation(int x, int y, Map map) {
		if (map.OnMap(point) == false) {
			System.out.println(point.x + "," + this.y + " is outside of boundaries");
		}
	}
	
	public boolean InRangeOF(Point point, int range) {
	if (point.DistanceTo(point.x, point.y) <= range) {
			return true;
	} else {
			return false;
	}
}
}
