package Map;


public class MapDisplay extends Map{

    private int i;
    private int j;
    public MapDisplay(int x, int y) {
        super(x,y);
        for (i = 0; i<this.x; i++) {
            for (j = 0; j<this.y; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public void PrintMap(int[][] map) {
        for (i=0; i<this.x; i++) {
            for (j=0; j<this.y; j++) {
                if (map[i][j] == 1) {
                    System.out.print("  ||  ");
                } else if (map[i][j] == 2) {
                    System.out.print("  T  ");
                } else if (map[i][j] == 3) {
                    System.out.print("  Ar  ");
                } else if (map[i][j] == 4) {
                    System.out.print("  At  ");
                } else {
                    System.out.print("  *  ");
                }
            }
            System.out.println();
        }
    }
}
