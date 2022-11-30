package Miscellaneous;

import Enemies.Boss;
import Enemies.Monster;
import Towers.ArcaneTower;
import Towers.ArcherTower;
import Towers.BasicTower;

public class Round{

    private Monster[] enemies;
    private BasicTower[] towers;
    private ArcherTower[] attowers;
    private ArcaneTower[] artowers;
    private Boss boss;
    private Gold gold;
    private Lives lives;

    public Round(BasicTower[] towers_, ArcaneTower[] artowers_, ArcherTower[] attowers_, Monster[] enemies_, Boss boss_, Gold gold_, Lives lives_) {
        this.towers = towers_;
        this.attowers = attowers_;
        this.artowers = artowers_;
        this.enemies = enemies_;
        this.boss = boss_;
        this.gold = gold_;
        this.lives = lives_;
    }

    public Round(BasicTower[] towers_, ArcaneTower[] artowers_, ArcherTower[] attowers_, Monster[] enemies_, Gold gold_, Lives lives_) {
        this.towers = towers_;
        this.attowers = attowers_;
        this.artowers = artowers_;
        this.enemies = enemies_;
        this.gold = gold_;
        this.lives = lives_;
    }

    public void TowerShooting(String tower, int tow){
        for (BasicTower t: this.towers) {
            if (t == null) {
                continue;
            }

            if (this.enemies != null && this.enemies.length > 0) {
                int killed = 0;
                for (Monster enemy : this.enemies) {
                    if (enemy.IsNeutralized())
                        killed++;
                }

                if(killed != this.enemies.length && t.place.InRangeOf(this.enemies[0].currentLocation(), t.range)) {



                    System.out.println();
                    System.out.println("Basic tower "+(tow+1)+" is shooting at the enemies");
                    System.out.println();
                    t.MonsterFire(this.enemies, this.gold);
                }
            }

            if (this.boss != null && this.boss.IsNeutralized() && t.place.InRangeOf(boss.currentLocation(), t.range)) {
                System.out.println();
                System.out.println("Basic tower "+(tow+1)+" is shooting at the boss");
                System.out.println();
                t.BossFire(this.boss, this.gold);
            }
            tow++;

        }
    }

    public void StartSimulation()   {
        int count = 0, enem = 0;
        while (this.lives.getLives() != 0) {
            int bT = 0, aR = 0, aT = 0;

            for (BasicTower t: this.towers) {
                if (t == null) {
                    continue;
                }

                if (this.enemies != null && this.enemies.length > 0) {
                    int killed = 0;
                    for (Monster enemy : this.enemies) {
                        if (enemy.IsNeutralized())
                            killed++;
                    }

                    if(killed != this.enemies.length && t.place.InRangeOf(this.enemies[0].currentLocation(), t.range)) {



                        System.out.println();
                        System.out.println("Basic tower "+(bT+1)+" is shooting at the enemies");
                        System.out.println();
                        t.MonsterFire(this.enemies, this.gold);
                    }
                }

                if (this.boss != null && this.boss.IsNeutralized() && t.place.InRangeOf(boss.currentLocation(), t.range)) {
                    System.out.println();
                    System.out.println("Basic tower "+(bT+1)+" is shooting at the boss");
                    System.out.println();
                    t.BossFire(this.boss, this.gold);
                }
                bT++;

            }

            for (ArcaneTower ar: this.artowers) {
                if (ar == null) {
                    continue;
                }

                if (this.enemies != null && this.enemies.length > 0) {
                    int killed = 0;
                    for (Monster enemy : this.enemies) {
                        if (enemy.IsNeutralized())
                            killed++;
                    }

                    if(killed != this.enemies.length && ar.place.InRangeOf(this.enemies[0].currentLocation(), ar.range)) {


                        System.out.println();
                        System.out.println("Arcane tower "+(aR+1)+" is shooting");
                        System.out.println();
                        ar.MonsterFire(this.enemies, this.gold);

                    }
                }
                if (this.boss != null && !this.boss.IsNeutralized() && ar.place.InRangeOf(boss.currentLocation(), ar.range)) {
                    System.out.println();
                    System.out.println("Arcane tower "+(aR+1)+" is shooting at the boss");
                    System.out.println();
                    ar.BossFire(this.boss, this.gold);
                }
                aR++;
            }

            for (ArcherTower at: this.attowers) {
                if (at == null) {
                    continue;
                }

                if (this.enemies != null && this.enemies.length > 0) {
                    int killed = 0;

                    for (Monster enemy : this.enemies) {
                        if (enemy.IsNeutralized())
                            killed++;
                    }

                    if (killed != this.enemies.length && at.place.InRangeOf(this.enemies[0].currentLocation(), at.range)) {


                        System.out.println();
                        //Thread.sleep(2500);
                        System.out.println("Archer tower "+(aT+1)+" is shooting");
                        System.out.println();
                        at.MonsterFire(this.enemies, this.gold);
                    }
                }

                if (this.boss != null && !this.boss.IsNeutralized() && at.place.InRangeOf(boss.currentLocation(), at.range)) {
                    System.out.println();
                    System.out.println("Archer tower "+(aT+1)+" is shooting at the boss");
                    System.out.println();
                    at.BossFire(this.boss, this.gold);
                }
                aT++;
            }

            for (Monster e: this.enemies) {
                e.advance();
                int killed = 0;
                for (Monster enemy : this.enemies) {
                    if (enemy.IsNeutralized()) {
                        killed++;
                    }
                }

                if (killed == this.enemies.length) {
                    break;
                }

                if (e.HasScored() && !e.IsNeutralized()) {
                    if (enem + killed == this.enemies.length) {
                        //enem = enem + killed;
                        break;
                    }
                    enem++;
                    this.lives.reduceLives(1);
                    System.out.println("An enemy has scored and you have lost a life");
                    System.out.println("Available lives: "+this.lives.getLives());
                    if (this.lives.getLives() == 0) {
                        break;
                    }
                }
            }

            if (this.boss != null && !this.boss.IsNeutralized()) {
                boss.advance();
                if (this.boss.HasScored() && this.lives.getLives() > 0) {
                    this.lives.reduceLives(this.lives.getLives());
                    System.out.println("The boss has scored and you have lost all your lives");
                    System.out.println("Available lives: "+this.lives.getLives());
                }
            }

            if (this.lives.getLives() == 0) {
                System.out.println();
                System.out.println("You have lost the game!");
                break;
            }

            if (this.boss == null) {
                if (count == 50 || enem == this.enemies.length) {
                    System.out.println();
                    System.out.println("You have won the game!");
                    break;
                }
            } else if (this.boss != null) {
                if (count == 50 || enem == this.enemies.length && this.boss.IsNeutralized()) {
                    System.out.println();
                    System.out.println("You have won the game!");
                    break;
                }
            }
            count++;

        }
    }

}
