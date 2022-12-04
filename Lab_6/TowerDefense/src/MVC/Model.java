package MVC;

import Enemies.Boss;
import Enemies.Monster;
import Map.Map;
import Map.Path;
import Map.MapLocation;
import Miscellaneous.Gold;
import Miscellaneous.Lives;
import Miscellaneous.Round;
import Towers.ArcaneTower;
import Towers.ArcherTower;
import Towers.BasicTower;

import java.util.Random;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class Model {

  private Round r;
  private Monster[] m;
  private Boss b = null;
  private BasicTower[] bt = new BasicTower[15];
  private int bts = 0;
  private ArcaneTower[] ar = new ArcaneTower[15];
  private int art = 0;
  private ArcherTower[] at = new ArcherTower[15];
  private int att = 0;
  private Map m1;
  private Path p1;
  private MapLocation[] ml;
  private int[][] MapCheck;
  private Lives life = new Lives(1);
  private Gold gold = new Gold(500);


  public void addMap(int x, int y) {
    m1 = new Map(x, y);
    MapCheck = new int[x][y];
  }

  public void addLength(int x) {
    ml = new MapLocation[x];
  }

  public void addPath(int x, int y) {
    for (int i = 0; i < ml.length; i++) {
      if (ml[i] == null) {
        ml[i] = new MapLocation(x, y, m1);
        MapCheck[x][y] = 1;
        break;
      }
    }
    p1 = new Path(ml);
  }

  public void addEnemyLength(int x){
    m = new Monster[x];
  }

  public void addEnemy(){
    for (int i = 0; i < m.length; i++) {
      if (m[i] == null){
        Random rand = new Random();
        int hRand = rand.nextInt(10)+1;
        int gRand = hRand*100;
        life.addLives(1);
        m[i] = new Monster(p1, hRand, gRand);
        break;
      }
    }
  }

  public void ansBoss(String ans){
    if (ans.equals("yes") || ans.equals("Yes") || ans.equals("YES")) {
      addBoss();
    }
  }

  public void addBoss(){
    Random rand1 = new Random();
    int hRand = rand1.nextInt(5)+5;
    Random rand2 = new Random();
    int armRand = rand2.nextInt(15);
    int gRand = armRand*50+hRand*100;
    b = new Boss(p1, hRand, armRand, gRand);
  }

  public boolean enoughGold(int num){
    if (num == 1){
      return gold.getGold() >= 500;
    } else {
      return gold.getGold() >= 1500;
    }
  }

  public boolean validPlacings(int x, int y){
    if (m1.OnMap(x, y)){
      return MapCheck[x][y] == 0;
    } else {
      return false;
    }
  }

  public void addBasicTower(int x, int y){
    if (enoughGold(1) && validPlacings(x, y)) {
      MapLocation temp = new MapLocation(x, y, m1);
      bt[bts] = new BasicTower(temp, gold);
      MapCheck[x][y] = 2;
      bts++;
    }
  }

  public void addArcaneTower(int x, int y){
    if (enoughGold(2) && validPlacings(x, y)) {
      MapLocation temp = new MapLocation(x, y, m1);
      ar[art] = new ArcaneTower(temp, gold);
      MapCheck[x][y] = 3;
      art++;
    }
  }

  public void addArcherTower(int x, int y){
    if (enoughGold(2) && validPlacings(x, y)) {
      MapLocation temp = new MapLocation(x, y, m1);
      at[att] = new ArcherTower(temp, gold);
      MapCheck[x][y] = 4;
      att++;
    }
  }

  public void ansLives(int x, int lives){
    if (x == 1){
      addLives(lives);
    }
  }

  public void addLives(int lives){
      life.addLives(lives);
  }

  public void adjustLives(){
    if (life.getLives() > 0){
      life.setLives((life.getLives()/2 + 1));
    }
  }

  public void ansGold(int x, int coins){
    if (x == 1){
      addGold(coins);
    }
  }

  public void addGold(int coins){
      gold.addGold(coins);
  }

  public int[][] getMap(){
    return MapCheck;
  }

  public int getGold(){
    return gold.getGold();
  }

  public int getLives(){
    return life.getLives();
  }

  public void startSimulation() {
    if (b != null) {
      r = new Round(bt, ar, at, m, b, gold, life);
    } else {
      r = new Round(bt, ar, at, m, gold, life);
    }
    r.StartSimulation();
  }
}

