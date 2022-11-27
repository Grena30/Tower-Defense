package Miscellaneous;

public class Gold{

    private int resource;
    protected int x;
    protected int y;

    public Gold(int resource) {
        this.resource = resource;
        System.out.println("Starting gold is "+getGold());
    }

    public void setGold(int resource) {
        this.resource = resource;
    }

    public int getGold() {
        return this.resource;
    }
}
