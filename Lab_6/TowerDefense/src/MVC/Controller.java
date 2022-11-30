package MVC;

import Map.MapLocation;
import Miscellaneous.Round;
import Towers.ArcaneTower;
import Towers.ArcherTower;
import Towers.BasicTower;

public class Controller {

    private Model model;
    private View view = new View();

    public void start(){

        while(true) {
            int num = view.printMenu();
            switch (num) {
                case 1 -> {
                    break;
                }
                case 2 -> {
                    System.exit(0);
                }
            }
            break;
        }

        model = new Model();
        view.printBegin();

        int[] arr = view.enterMap();
        model.addMap(arr[0], arr[1]);

        int len = view.enterPath();
        model.addLength(len);

        for (int i = 0; i<len; i++){
            arr = view.enterCell(i);
            model.addPath(arr[0], arr[1]);
        }
        model.definePath();

        len = view.enterEnemy();
        model.addEnemyLength(len);

        for (int i = 0; i<len; i++){
            model.addEnemy();
        }

        String ans = view.enterBoss();
        if (ans.equals("yes") || ans.equals("Yes") || ans.equals("YES")) {
            model.addBoss();
        }
        while(true) {

            int num = view.printMenuGame();
            switch (num) {
                case 1 -> {
                    model.startSimulation();
                }
                case 2 -> {

                }
                case 3 -> {
                    int gold = model.getGold();
                    gold = view.printGold(gold);
                    if (gold == 1)
                        model.addGold(2000);
                }
                case 4 -> {
                    int lives = model.getLives();
                    lives = view.printLives(lives);
                    if (lives == 1)
                        model.addLives(5);
                }

                case 5 -> {
                    int[][] arr2d = model.getMap();
                    view.printMap(arr2d);
                }
                case 6 -> System.exit(0);
                default -> {}
            }
        }



    }
}
