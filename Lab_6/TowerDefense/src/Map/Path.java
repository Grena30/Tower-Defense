package Map;

public class Path extends Map{

    protected MapLocation[] path;
    public int Length;

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
            this.Length = locations.length;
        }
    }

    public MapLocation GetLocationAt(int pathStep) {

        return (pathStep < this.path.length) ? path[pathStep] : null;
    }

}
