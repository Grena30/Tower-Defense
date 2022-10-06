package tower_defense;

public class Gold extends Point {
	
	private int resource;
	
	public Gold(int x, int y, int resource, Map map) {
		super(x, y);
		this.resource = resource;
		if (map.OnMap(this.x, this.y) == false) {
			System.out.println("Available gold will be shown at position ("+this.x+" "+this.y+")");
			System.out.println("Starting gold is "+getGold());
		}
	}
	
	public void setGold(int resource) {
		this.resource = resource;
	}
	
	public int getGold() {
		return this.resource;
	}
}
