/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0017.noughtandcrosses;

import java.util.Random;

/**
 *
 * @author user
 */
public class GamerPCWeak extends Gamer{

    protected GamerPCWeak(char player) {
        this.player = player;
    }
    
    

    @Override
    public void takeTurn() {
	do{
            Random rand = new Random();
            t = rand.nextInt(9);	
	}while(t < 0 || t>8 ||instance.getPole()[t] != ' ');
	instance.setPole(t, player);
    }

    @Override
    public char getPlayer() {
        return this.player;
    }
    
}
