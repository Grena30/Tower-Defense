package tower_defense;

public class Path {
	
	private MapLocation[] path;
	public int Length;
	
	public Path(MapLocation[] path) {
		this.path = path;
		this.Length = path.length;
	}
	
	public MapLocation GetLocationAt(int pathStep, MapLocation[] path) {
		
		return (pathStep < path.length) ? path[pathStep] : null;
	}
		
}
