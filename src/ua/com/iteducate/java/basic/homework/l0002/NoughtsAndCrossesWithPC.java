/*
 * Exceptions have not caught
 * Game for little kids only :)
 * 
 */
package ua.com.iteducate.java.basic.homework.l0002;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class NoughtsAndCrossesWithPC {
    char[][] gameField = new char[3][3];
    boolean gameMustGoesOn = true;
    boolean tie;
    int i,j;
    String result;
    
    public void start(){//Only one instance - Singleton pattern shoul be used?
        Scanner scan = new Scanner(System.in);
        System.out.println("Як тебе звуть?");
        String player = scan.next();
        drawGameField();
        result = game(scan, player, "ПК");
        scan.close();
        System.out.println(result);
    }
    
    private String game(Scanner scan, String player, String pc){
        Random rand = new Random();
        do{                 //cycles for type errors handling
        while(gameMustGoesOn){
            System.out.println(player + ", введи координати нулика:");
            i = scan.nextInt();
            j = scan.nextInt();
            if (i > 2 || j > 2 || gameField[i][j] == 'O' | gameField[i][j] == 'X'){
                System.out.println("Комірка зайнята або вихід за межі поля!");
                continue;
            }
            drawGameField(false);
            if (isWin()){
                if (tie){
                    return "Перемогла дружба";
                }
                return player + " виграв(ла)";
            }
            break;
        }
            while(gameMustGoesOn){ //PC turn
            i = rand.nextInt(3); //stupid PC logic
            j = rand.nextInt(3);
            if (gameField[i][j] == 'O' | gameField[i][j] == 'X'){
                continue;
            }
            drawGameField(true);
            if (isWin()){
                if (tie){
                    return "Перемогла дружба";
                }
                return pc + " виграв";
            }
            break;
        }
    }while (gameMustGoesOn);
            return ""; //never be executed
    }
    
    private void drawGameField(boolean cross){
        if (cross){
            gameField[i][j] = 'X';
        }else{
            gameField[i][j] = 'O';
        }
        System.out.println("  0 1 2");// Arrays.toString May be overriden
        System.out.println(("0:"+Arrays.toString(gameField[0])+"\n"
                +"1:"+Arrays.toString(gameField[1]))
                .replace("[", "").replace("]", "").replace(",", "|")
                .replace("\u0000", "_").replace(" ", ""));
        System.out.println(("2:"+Arrays.toString(gameField[2])+"\n")
                .replace("[", "").replace("]", "").replace(",", "|")
                .replace(" ", "").replace("\u0000", " "));
    }
    
    private void drawGameField(){
        System.out.println("  0 1 2");
        System.out.println("0 _|_|_");
        System.out.println("1 _|_|_");
        System.out.println("2  | | ");
    }
    
    private boolean isWin(){
        for (int i = 0;i<3;i++){//checking rows
            if (Arrays.toString(gameField[i]).contentEquals("[O, O, O]")
                    | Arrays.toString(gameField[i]).contentEquals("[X, X, X]")){
                return true;
            }
        }
        for (int j = 0; j<3;j++){//checking columns
            if ((gameField[0][j] == 'O' & gameField[1][j] == 'O' 
                    & gameField[2][j] == 'O') | (gameField[0][j] == 'X' & 
                    gameField[1][j] == 'X' & gameField[2][j] == 'X')){
                return true;
            }
        }
        //check diagonals
        if ((gameField[0][0] == 'O' & gameField[1][1] == 'O' & 
                gameField[2][2] == 'O') | (gameField[0][0] == 'X' & 
                gameField[1][1] == 'X' & gameField[2][2] == 'X') |
                (gameField[2][0] == 'O' & gameField[1][1] == 'O' & 
                gameField[0][2] == 'O') | (gameField[2][0] == 'X' & 
                gameField[1][1] == 'X' & gameField[0][2] == 'X')){
            return true;
        }
        //is this tie? (no free space left)
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                if (gameField[i][j] == 0)
                    return false; //noone wins, not tie, game must goes on
            }
        }
        tie = true;
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoughtsAndCrossesWithPC game = new NoughtsAndCrossesWithPC();
        game.start();
    }
    
}
