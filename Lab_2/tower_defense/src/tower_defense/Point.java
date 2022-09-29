package tower_defense;

public class Point {
	
	protected int x;
	protected int y;
	
	
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int DistanceTo(int x, int y) {
		int dist;
		dist = (int) (Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)));
		return dist;
	}
}
