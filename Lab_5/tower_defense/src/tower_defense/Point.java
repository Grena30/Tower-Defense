package tower_defense;

public class Point extends Map{

	
	public Point(int x, int y) {
		super (x,y);
	}
	
	public int DistanceTo(int x, int y) {
		int dist;
		dist = (int) (Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)));
		return dist;
	}
	public int DistanceTo(Point point) {
		if (point != null) {
		return DistanceTo(point.x, point.y);
		} else {
			return 10000;
		}
	}
}
