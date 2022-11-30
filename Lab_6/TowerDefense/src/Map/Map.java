package Map;

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

    public boolean OnMap(int x, int y) {
        return x >= 0 && x < this.x && y >= 0 && y < this.y;
    }
}