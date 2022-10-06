package tower_defense;

public class Path extends Map{
	
	protected MapLocation[] path;
	
	public Path(int x, int y, MapLocation[] locations) {
		super(x,y);
		int check = 0;
		for (MapLocation l: locations) {
			if (OnMap(l.x,l.y) == true) {
				check += 1;
			}
		}
		if (check == locations.length) {
			this.path = locations;
		}
	}
	
	public MapLocation GetLocationAt(int pathStep, MapLocation[] path) {
		
		return (pathStep < path.length) ? path[pathStep] : null;
	}
		
}
