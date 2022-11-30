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

public class Model {

  private Round r;
  private Monster[] m;
  private Boss b = null;
  private BasicTower[] bt = new BasicTower[15];
  private ArcaneTower[] ar = new ArcaneTower[15];
  private ArcherTower[] at = new ArcherTower[15];
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
  }

  public void definePath(){
    p1 = new Path(m1, ml);
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

  public void addBoss(){
    Random rand1 = new Random();
    int hRand = rand1.nextInt(5)+5;
    Random rand2 = new Random();
    int armRand = rand2.nextInt(15);
    int gRand = armRand*50+hRand*100;
    b = new Boss(p1, hRand, armRand, gRand);
  }

  public void addBasicTower(int x, int y){

  }

  public void addArcaneTower(int x, int y){

  }

  public void addArcherTower(int x, int y){

  }

  public void addLives(int x){
    life.addLives(x);
  }

  public void addGold(int x){
    gold.addGold(x);
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

  public void startSimulation(){
    if (b != null) {
      r = new Round(bt, ar, at, m, b, gold, life);
    }
    else {
      r = new Round(bt, ar, at, m, gold, life);
    }
    r.StartSimulation();

    // Add more rounds
    // Increased health per round
    // Boss every x rounds
  }

}

