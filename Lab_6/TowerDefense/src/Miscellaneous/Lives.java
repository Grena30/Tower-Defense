package Miscellaneous;

public class Lives {

    int lives;

    public Lives(int l) {
        this.lives = l;
        System.out.println("Starting lives are "+this.lives);
    }

    public void reduceLives(int lost) {
        this.lives -= lost;
    }

    public int getLives() {
        return this.lives;
    }
}
