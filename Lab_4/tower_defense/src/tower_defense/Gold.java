package tower_defense;

public class Gold{
	
	private int resource;
	protected int x;
	protected int y;
	
	public Gold(int x, int y, int resource, Map map) {
		this.x = x;
		this.y = y;
		this.resource = resource;
		System.out.println("Starting gold is "+getGold());
		if (map.OnMap(this.x, this.y) == false) {
			//System.out.println("Available gold will be shown at position ("+this.x+" "+this.y+")");
		}
	}
	
	public void setGold(int resource) {
		this.resource = resource;
	}
	
	public int getGold() {
		return this.resource;
	}
}
