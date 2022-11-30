package Map;

public class Path{

    protected MapLocation[] path;
    public int Length;

    public Path(Map m1, MapLocation[] locations) {
        int check = 0;
        for (MapLocation l: locations) {
            if (m1.OnMap(l.x, l.y)) {
                check += 1;
            }
        }
        if (check == locations.length) {
            this.path = locations;
            this.Length = locations.length;
        }
    }

    public MapLocation GetLocationAt(int pathStep) {

        return (pathStep < this.path.length) ? path[pathStep] : null;
    }

}
