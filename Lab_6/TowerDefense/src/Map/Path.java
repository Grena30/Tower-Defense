package Map;

public class Path{

    protected MapLocation[] path;
    public int Length;

    public Path(MapLocation[] locations) {
            this.path = locations;
            this.Length = locations.length;
    }

    public MapLocation GetLocationAt(int pathStep) {
        return (pathStep < this.path.length) ? path[pathStep] : null;
    }
}
