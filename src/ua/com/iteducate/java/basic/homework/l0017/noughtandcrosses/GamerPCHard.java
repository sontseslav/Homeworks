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
public class GamerPCHard extends Gamer{

    protected GamerPCHard(char player) {
        this.player = player;
        System.out.println("Not realised jet...");
        System.exit(0);
    }
    
    

    @Override
    public void takeTurn() {
	
    }

    @Override
    public char getPlayer() {
        return this.player;
    }
}
