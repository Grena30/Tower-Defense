package Map;

public class MapLocation extends Point {


    public MapLocation(int x, int y, Map map) {
        super(x,y);
        if (!map.OnMap(this.x, this.y)) {
            System.out.println("The chosen map coordinates "+ this.x + "," + this.y + " are outside of boundaries");
        }
    }

    public boolean InRangeOf(MapLocation loc_enemy, int range) {
        return DistanceTo(loc_enemy) <= range;
    }
}
