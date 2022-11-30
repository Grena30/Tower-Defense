package MVC;

import java.util.Scanner;

public class View {

    /*
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
     */

    public void printBegin() {
        System.out.println("----------------------------TOWER DEFENSE----------------------------");
        System.out.println();
        System.out.println("Beginning the game");
        System.out.println();
    }

    public int[] enterMap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the coordinates of the map: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new int[]{x,y};
    }

    public int enterPath(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the enemy pathway length: ");
        return sc.nextInt();
    }


    public int[] enterCell(int i){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coordinates for the cell "+(i+1)+": ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new int[]{x,y};
    }

    public void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
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

    public int enterEnemy(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the number of enemies you want to spawn: ");
        return sc.nextInt();
    }

    public String enterBoss(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose if you want to spawn a boss: ");
        return sc.next();
    }

    public int printMenu(){
        System.out.println("----------------------------MAIN MENU----------------------------");
        System.out.println();
        System.out.println("1.Start Game");
        System.out.println("2.Quit");
        System.out.println();
        System.out.print("Choice: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int printLives(int lives){
        System.out.println();
        System.out.println("Available lives is " + lives);
        System.out.println();
        System.out.println("1. Would you like to add 5 lives");
        System.out.println("2. Leave");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int printGold(int gold){
        System.out.println();
        System.out.println("Available gold is " + gold);
        System.out.println();
        System.out.println("1. Would you like to add 2000 gold");
        System.out.println("2. Leave");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int printMenuGame(){
        System.out.println("----------------------------MAIN MENU----------------------------");
        System.out.println();
        System.out.println("1.Start simulation");
        System.out.println("2.Build a tower");
        System.out.println("3.Check gold");
        System.out.println("4.Check lives");
        System.out.println("5.Display map");
        System.out.println("6.Quit game");
        System.out.println();
        System.out.print("Choice: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


}