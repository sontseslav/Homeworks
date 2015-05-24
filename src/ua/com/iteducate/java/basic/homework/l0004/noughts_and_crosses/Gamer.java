/*
 * 
 */
package ua.com.iteducate.java.basic.homework.l0004.noughts_and_crosses;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Gamer {
    private int t;
    private Scanner scan;
    private char player;
    private GameField instance;
    
    public Gamer(char player, GameField instance){
        this.player = player;
        this.scan = new Scanner(System.in);
        this.instance = instance;
    }
    
    public void takeTurn(){//g - player
	do{
            System.out.println("player_"+player);
            t = scan.nextInt();	
	}while(t < 0 || t>8 ||instance.getPole()[t] != ' ');
	instance.setPole(t, player);
    }
}
