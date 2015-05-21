/*
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
public class SeaBattle {
    private char[][] gameField = new char[10][10];
    private char[][] pcGameField = new char[10][10];
    private boolean turn;
    private boolean gameMustGoesOn = true;
    private final char miss = '\u263B';
    private final char ship = '\u2395';
    private final char hittedShip = '\u2588';
    private final char waves = '\u2248';
    private final int maxShips = 20;
    private String direction;
    private int x,y;
    String player;
    
    public void start(){
        for (int i = 0;i<10;i++){ //make sea
            for (int j = 0;j<10;j++){
                gameField[i][j] = waves;
            }
        }
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Як Вас звати?");
        player = reader.next();
        showField();
        makeFleet(reader); //fleet for player
        makeFleet(rand);       //fleet for pc
        turn = rand.nextBoolean(); //throw a coin, who is first?
        do{
            turn = (turn) ? hit(reader) : hit(rand);
            if (countDead(gameField))
                System.out.println("Адмірал " +player+" програв \u2639");
            if (countDead(pcGameField))
                System.out.println("Адмірал "+player+" переміг \u263A");
        }
        while (gameMustGoesOn);
    }
    
    private void showField(){
        System.out.println("x/y0 1 2 3 4 5 6 7 8 9");
        for (int i = 0;i<10;i++){
            System.out.println(i+" "+Arrays.toString(gameField[i])
                    .replace("[", "|").replace("]", "|").replace(",", "|")
                    .replace(" ", ""));
        }
        System.out.println("Адмірал: "+player);
    }
    
    private void showField(String pc){//debugging purpose
        System.out.println("x/y0 1 2 3 4 5 6 7 8 9");
        for (int i = 0;i<10;i++){
            System.out.println(i+" "+Arrays.toString(pcGameField[i])
                    .replace("[", "|").replace("]", "|").replace(",", "|")
                    .replace(" ", "").replace("\u0000"," ").replace(ship, ' '));
        }
        System.out.println("Адмірал: "+pc);
    }
    
    private void makeFleet(Scanner reader){
        for (int i =0;i<4;i++){
            System.out.println("Ведіть координати однопалубного корабля (x y):");
            y = reader.nextInt();
            x = reader.nextInt();
            if ((x > 9 | y > 9) || (gameField[y][x] == ship)){
                i--;
                System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                continue;
            }
            else{
                gameField[y][x] = ship;
                showField();
            }
        }
        for (int i =0;i<3;i++){
            System.out.println("Ведіть координати корми і напрямок (-,|) "
                    + "двопалубного корабля (x y d):");
            y = reader.nextInt();
            x = reader.nextInt();
            direction = reader.next();
            if (direction.contentEquals("-")){
                if ((x > 9 | y > 9 | x+1 > 9) || (gameField[y][x] == ship |
                        gameField[y][x+1] == ship)){
                    i--;
                    System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                    continue;
                }else{
                    gameField[y][x] = ship;
                    gameField[y][x+1] = ship;
                    showField();
                }
            }else{
                if ((x > 9 | y > 9 | y+1 > 9) || (gameField[y][x] == ship |
                        gameField[y+1][x] == ship)){
                    i--;
                    System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                    continue;
                }else{
                    gameField[y][x] = ship;
                    gameField[y+1][x] = ship;
                    showField();
                }
            }
        }
        for (int i =0;i<2;i++){
            System.out.println("Ведіть координати корми і напрямок (-,|) "
                    + "трьохпалубного корабля (x y d):");
            y = reader.nextInt();
            x = reader.nextInt();
            direction = reader.next();
            if (direction.contentEquals("-")){
                if ((x > 9 | y > 9 | x+2 > 9) ||(gameField[y][x] == ship |
                        gameField[y][x+1] == ship | gameField[y][x+2] 
                        == ship)){
                    i--;
                    System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                    continue;
                }else{
                    gameField[y][x] = ship;
                    gameField[y][x+1] = ship;
                    gameField[y][x+2] = ship;
                    showField();
                }
            }else{
                if ((x > 9 | y > 9 | y+2 > 9) ||(gameField[y][x] == ship |
                        gameField[y+1][x] == ship | gameField[y+2][x] 
                        == ship)){
                    i--;
                    System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                    continue;
                }else{
                    gameField[y][x] = ship;
                    gameField[y+1][x] = ship;
                    gameField[y+2][x] = ship;
                    showField();
                }
            }
        }
        for (int i =0;i<1;i++){
            System.out.println("Ведіть координати корми і напрямок (-,|) "
                    + "чотирьохпалубного корабля (x y d):");
            y = reader.nextInt();
            x = reader.nextInt();
            direction = reader.next();
            if (direction.contentEquals("-")){
                if ((x > 9 | y > 9 | x+3 > 9) ||(gameField[y][x] == ship |
                        gameField[y][x+1] == ship | gameField[y][x+2] 
                        == ship | gameField[y][x+3] == ship)){
                    i--;
                    System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                    continue;
                }else{
                    gameField[y][x] = ship;
                    gameField[y][x+1] = ship;
                    gameField[y][x+2] = ship;
                    gameField[y][x+3] = ship;
                    showField();
                }
            }else{
                if ((x > 9 | y > 9 | y+3 > 9) ||(gameField[y][x] == ship |
                        gameField[y+1][x] == ship | gameField[y+2][x] 
                        == ship | gameField[y+3][x] == ship)){
                    i--;
                    System.out.println("Помилкові координати, або зіткнення з "
                        + "існуючим кораблем");
                    continue;
                }else{
                    gameField[y][x] = ship;
                    gameField[y+1][x] = ship;
                    gameField[y+2][x] = ship;
                    gameField[y+3][x] = ship;
                    showField();
                }
            }
        }
    }
    
    private void makeFleet(Random rand){
        boolean direction = false;
        for (int i =0;i<4;i++){
            y = rand.nextInt(10);
            x = rand.nextInt(10);
            if (x > 9 | y > 9 || pcGameField[y][x] == ship){
                i--;
                continue;
            }
            else{
                pcGameField[y][x] = ship;
            }
        }
        for (int i =0;i<3;i++){
            y = rand.nextInt(10);
            x = rand.nextInt(10);
            direction = rand.nextBoolean();
            if (direction){
                if ((x > 9 | y > 9 | x+1 > 9) ||(pcGameField[y][x] == ship |
                        pcGameField[y][x+1] == ship)){
                    i--;
                    continue;
                }else{
                    pcGameField[y][x] = ship;
                    pcGameField[y][x+1] = ship;
                }
            }else{
                if ((x > 9 | y > 9 | y+1 > 9) ||(pcGameField[y][x] == ship |
                        pcGameField[y+1][x] == ship)){
                    i--;
                    continue;
                }else{
                    pcGameField[y][x] = ship;
                    pcGameField[y+1][x] = ship;
                }
            }
        }
        for (int i =0;i<2;i++){
            y = rand.nextInt(10);
            x = rand.nextInt(10);
            direction = rand.nextBoolean();
            if (direction){
                if ((x > 9 | y > 9 | x+2 > 9) ||(pcGameField[y][x] == ship |
                        pcGameField[y][x+1] == ship | pcGameField[y][x+2] 
                        == ship)){
                    i--;
                    continue;
                }else{
                    pcGameField[y][x] = ship;
                    pcGameField[y][x+1] = ship;
                    pcGameField[y][x+2] = ship;
                }
            }else{
                if ((x > 9 | y > 9 | y+2 > 9) ||(pcGameField[y][x] == ship |
                        pcGameField[y+1][x] == ship | pcGameField[y+2][x] 
                        == ship)){
                    i--;
                    continue;
                }else{
                    pcGameField[y][x] = ship;
                    pcGameField[y+1][x] = ship;
                    pcGameField[y+2][x] = ship;
                }
            }
        }
        for (int i =0;i<1;i++){
            y = rand.nextInt(10);
            x = rand.nextInt(10);
            direction = rand.nextBoolean();
            if (direction){
                if ((x > 9 | y > 9 | x+3 > 9) ||(pcGameField[y][x] == ship |
                        pcGameField[y][x+1] == ship | pcGameField[y][x+2] 
                        == ship | pcGameField[y][x+3] == ship)){
                    i--;
                    continue;
                }else{
                    pcGameField[y][x] = ship;
                    pcGameField[y][x+1] = ship;
                    pcGameField[y][x+2] = ship;
                    pcGameField[y][x+3] = ship;
                }
            }else{
                if ((x > 9 | y > 9 | y+3 > 9) ||(pcGameField[y][x] == ship |
                        pcGameField[y+1][x] == ship | pcGameField[y+2][x] 
                        == ship | pcGameField[y+3][x] == ship)){
                    i--;
                    continue;
                }else{
                    pcGameField[y][x] = ship;
                    pcGameField[y+1][x] = ship;
                    pcGameField[y+2][x] = ship;
                    pcGameField[y+3][x] = ship;
                }
            }
        }
        showField("PC");// for debud only
    }
    
    private boolean hit(Scanner scan){//winner shoots twice
        while (true){
            System.out.println("Оберіть координати мішені (x y):");
            y = scan.nextInt();
            x = scan.nextInt();
            if ((x > 9 | y > 9)||(pcGameField[y][x] == miss | 
                    pcGameField[y][x] == hittedShip)){
                System.out.println("Неправильні координати або сюди вже стріляли");
                continue;
            }else{
                if (pcGameField[y][x] == ship){
                    pcGameField[y][x] = hittedShip;
                    showField("PC");
                    return true;
                }else{
                    pcGameField[y][x] = miss;
                    showField("PC");
                    return false;
                }
            }
        }
    }
    
    private boolean hit(Random rand){
        while (true){
            y = rand.nextInt(10);
            x = rand.nextInt(10);
            if ((x > 9 | y > 9)||(gameField[y][x] == miss | 
                    pcGameField[y][x] == hittedShip)){
                continue;
            }else{
                if (gameField[y][x] == ship){
                    gameField[y][x] = hittedShip;
                    showField();
                    return false;
                }else{
                    gameField[y][x] = miss;
                    showField();
                    return true;
                }
            }
        }
    }
    
    private boolean countDead(char[][] inputField){
        int counter = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (inputField[i][j] == hittedShip) counter += 1;
            }
        }
        if (counter == maxShips){
            gameMustGoesOn = false;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        SeaBattle game = new SeaBattle();
        game.start();
    }
}
