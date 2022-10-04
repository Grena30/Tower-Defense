package tower_defense;

public class Map {
	
	private int width;
	private int height;
	
	
	public Map(int x, int y) {
		this.width = x;
		this.height = y;	
		System.out.println("A map with width "+this.width+" and height "+this.height+" was created");
	}
	
	public void setDimensions(int x, int y) {
		this.width = x;
		this.height = y;
	}
	
	public int getDimensionX() {
		return this.width;
	}
	
	public int getDimensionY() {
		return this.height;
	}
	
	public boolean OnMap(Point point) {
		if (point.x >= 0 && point.x < width && point.y >= 0 && point.y < height ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean OnMap(int x, int y) {
		if (x >= 0 && x < this.width && y >= 0 && y < this.height ) {
			return true;
		} else {
			return false;
		}
	}
}
