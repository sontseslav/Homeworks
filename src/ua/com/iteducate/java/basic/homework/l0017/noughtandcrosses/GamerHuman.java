/*
 * 
 */
package ua.com.iteducate.java.basic.homework.l0017.noughtandcrosses;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class GamerHuman extends Gamer{
    private Scanner scan;
    
    public GamerHuman(char player, Scanner scan){
        this.player = player;
        this.scan = scan;
    }
    
    @Override
    public void takeTurn(){//g - player
	do{
            System.out.println("player: "+player);
            t = scan.nextInt();	
	}while(t < 0 || t>8 ||instance.getPole()[t] != ' ');
	instance.setPole(t, player);
    }

    @Override
    public char getPlayer() {
        return this.player;
    }
}
