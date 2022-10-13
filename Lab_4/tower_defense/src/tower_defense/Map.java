package tower_defense;

public class Map{
	
	protected int x;
	protected int y;
	
	public Map(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void displayDimensions() {
		System.out.println("A map with width "+this.x+" and height "+this.y+" was created");
	}
	
	public boolean OnMap(Point point) {
		if (point.x >= 0 && point.x < this.x && point.y >= 0 && point.y < this.y ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean OnMap(int x, int y) {
		if (x >= 0 && x < this.x && y >= 0 && y < this.y ) {
			return true;
		} else {
			return false;
		}
	}
}
