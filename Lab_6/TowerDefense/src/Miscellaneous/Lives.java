package Miscellaneous;

public class Lives {

    private int lives;

    public Lives(int l) {
        this.lives = l;
        System.out.println("Starting lives are "+this.lives);
    }

    public void reduceLives(int lost) {
        this.lives -= lost;
    }

    public void addLives(int l){ this.lives += l;}

    public void setLives(int l){
        this.lives = l;
    }

    public int getLives() {
        return this.lives;
    }
}
