package Miscellaneous;

public class Gold{

    private int resource;

    public Gold(int resource) {
        this.resource = resource;
        System.out.println("Starting gold is "+getGold());
    }

    public void setGold(int resource) {
        this.resource = resource;
    }

    public void addGold(int resource){ this.resource += resource;}

    public int getGold() {
        return this.resource;
    }
}
