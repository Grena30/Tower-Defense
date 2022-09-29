package tower_defense;

public class Map {
	
	private int width;
	private int height;
	
	public void setDimensions(int x, int y) {
		this.width = x;
		this.height = y;
	}
	
	public boolean OnMap(Point point) {
		if (point.x >= 0 && point.x < width && point.y >= 0 && point.y < height ) {
			return true;
		} else {
			return false;
		}
	}
}
