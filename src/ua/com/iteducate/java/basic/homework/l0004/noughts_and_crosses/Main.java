/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0004.noughts_and_crosses;

import java.lang.reflect.Field;

/**
 *
 * @author user
 */
public class Main {
    GameField gamefield = new GameField();
    Gamer player1 = new Gamer('X', gamefield);
    Gamer player2 = new Gamer('O', gamefield);
    
    public Main(){//insane construcor using
        gamefield.showTurn();
        for(int i = 0; i<9;i++){
            i &= 0b00000001;
            if (i == 0) {//
                player1.takeTurn();
            } else {
                player2.takeTurn();
            }
            gamefield.showTurn();
            char w = gamefield.checkWin();
            if ((w == 'X') || (w == 'O')) {
                System.out.println("Game over! Gamer " + w + " wins!");
                break;
            } else if (w == 'T') {
                System.out.println("Game over! No one wins!");
                break;
            }
        }
    }
    
    public static void main(String[] args){
        new Main();
    }
}
