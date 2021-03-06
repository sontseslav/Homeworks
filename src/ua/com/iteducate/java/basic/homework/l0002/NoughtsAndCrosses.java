/*
 * Exceptions have not caught :/
 * 
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
public class NoughtsAndCrosses {
    char[][] gameField = new char[3][3];
    boolean gameMustGoOn = true;
    boolean tie;
    int i,j;
    
    public void game(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть імена гравців:");
        String player1 = scan.next();
        String player2 = scan.next();
        drawGameField();
        //Random rand = new Random();
        //int coin = rand.nextInt(2);
        while(gameMustGoOn){
        //if (coin == 0){
        //    System.out.println(player1 + ", введи координати нулика:");
        //    coin = 1;
        //}else{
        //    System.out.println(player2 + ", введи координати хрестика:");
        //    coin = 0;
        //}
            //Player1:
            System.out.println(player1 + ", введи координати нулика:");
            i = scan.nextInt();
            j = scan.nextInt();
            //if (gameField[i][j] == 'O' || gameField[i][j] == 'X'){
            //    System.out.println("Ця комірка зайнята!");
            //    continue Player1;
            //}
            drawGameField(false);
            if (isWin()){
                if (tie){
                    System.out.println("Перемогла дружба");
                    break;
                }
                System.out.println(player1 + " виграв(ла)");
                break;
            }
            //Player2:
            System.out.println(player2 + ", введи координати хрестика:");
            i = scan.nextInt();
            j = scan.nextInt();
            //if (gameField[i][j] == 'O' || gameField[i][j] == 'X'){
            //    System.out.println("Ця комірка зайнята!");
            //    break Player2;
            //}
            drawGameField(true);
            if (isWin()){
                if (tie){
                    System.out.println("Перемогла дружба");
                    break;
                }
                System.out.println(player2 + " виграв(ла)");
                break;
            }
        }
        scan.close();
    }
    
    private void drawGameField(boolean cross){
    if (cross){
        gameField[i][j] = 'X';
    }else{
        gameField[i][j] = 'O';
    }
    System.out.println(Arrays.toString(gameField[0]).replace("\u0000", ".")+"\n"
        +Arrays.toString(gameField[1]).replace("\u0000", ".")+"\n"
        +Arrays.toString(gameField[2]).replace("\u0000", ".")+"\n");
        
    }
    
    private void drawGameField(){
        System.out.println(" 0 1 2");
        System.out.println("0_|_|_");
        System.out.println("1_|_|_");
        System.out.println("2 | | ");
    }
    
    private boolean isWin(){ //може бути нічия!
        for (int i = 0;i<3;i++){
            if (Arrays.toString(gameField[i]).contentEquals("[O, O, O]")
                    | Arrays.toString(gameField[i]).contentEquals("[X, X, X]")){
                return true;
            }
        }
        for (int j = 0; j<3;j++){
            if ((gameField[0][j] == 'O' & gameField[1][j] == 'O' 
                    & gameField[2][j] == 'O') | (gameField[0][j] == 'X' & 
                    gameField[1][j] == 'X' & gameField[2][j] == 'X')){
                return true;
            }
        }
        if ((gameField[0][0] == 'O' & gameField[1][1] == 'O' & 
                gameField[2][2] == 'O') | (gameField[0][0] == 'X' & 
                gameField[1][1] == 'X' & gameField[2][2] == 'X') |
                (gameField[2][0] == 'O' & gameField[1][1] == 'O' & 
                gameField[0][2] == 'O') | (gameField[2][0] == 'X' & 
                gameField[1][1] == 'X' & gameField[0][2] == 'X')){
            return true;
        }
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                if (gameField[i][j] == 0)
                    return false;
            }
        }
        tie = true;
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoughtsAndCrosses start = new NoughtsAndCrosses();
        start.game();
    }
    
}
