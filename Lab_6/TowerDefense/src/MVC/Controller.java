package MVC;


public class Controller {

    private Model model;
    private final View view = new View();

    public void startGame(){

        initGame();
        model = new Model();
        initMap();
        initPath();
        initEnemies();
        initSimulation();

    }

    public void initGame(){

        switch (view.printMenu()) {

            case 1 -> view.printBegin();

            case 2 -> System.exit(0);
        }
    }

    public void initMap(){

        int[] arr = view.enterMap();
        model.addMap(arr[0], arr[1]);
    }

    public void initPath(){
        int len = view.enterPath();
        model.addLength(len);

        for (int i = 0; i<len; i++){
            int[] arr = view.enterCell(i);
            model.addPath(arr[0], arr[1]);
        }
    }

    public void initEnemies(){

        int len = view.enterEnemy();
        model.addEnemyLength(len);

        for (int i = 0; i<len; i++){
            model.addEnemy();
        }
        model.adjustLives();
        model.ansBoss(view.enterBoss());
    }

    public void initSimulation(){

        while(true) {

            int num = view.printMenuGame();
            switch (num) {
                case 1 -> model.startSimulation();

                case 2 -> initTowerBuilding();

                case 3 -> {
                    int choice = view.printGold(model.getGold());
                    model.ansGold(choice,2000);
                }

                case 4 -> {
                    int choice = view.printLives(model.getLives());
                    model.ansLives(choice,5);
                }

                case 5 -> view.printMap(model.getMap());

                case 6 -> System.exit(0);

                default -> view.printErrorChoice();
            }
        }
    }

    public void initTowerBuilding(){

        int num = view.printTowerMenu();
        switch (num){
            case 1 -> {
                if(!model.enoughGold(1)){
                    view.printErrorGold();
                    break;
                }
                int[] loc = view.enterTowerPlacement();
                while(!model.validPlacings(loc[0], loc[1])){
                    view.printErrorPlace();
                    loc = view.enterTowerPlacement();
                }
                model.addBasicTower(loc[0], loc[1]);
            }

            case 2 -> {
                while(true) {
                    if(!model.enoughGold(2)){
                        view.printErrorGold();
                        break;
                    }
                    int[] loc = view.enterTowerPlacement();
                    while(!model.validPlacings(loc[0], loc[1])){
                        view.printErrorPlace();
                        loc = view.enterTowerPlacement();
                    }
                    model.addArcaneTower(loc[0], loc[1]);
                }
            }

            case 3 -> {
                if(!model.enoughGold(2)){
                    view.printErrorGold();
                    break;
                }
                int[] loc = view.enterTowerPlacement();
                while(!model.validPlacings(loc[0], loc[1])){
                    view.printErrorPlace();
                    loc = view.enterTowerPlacement();
                }
                model.addArcherTower(loc[0], loc[1]);
            }

            default -> view.printErrorChoice();
        }
    }
}
