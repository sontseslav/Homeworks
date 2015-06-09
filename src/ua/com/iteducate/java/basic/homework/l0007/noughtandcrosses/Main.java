/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0007.noughtandcrosses;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    protected GameField gamefield = GameField.getInstance();
    Gamer player1, player2;
    
    
    public Main(){//insane construcor using
        Scanner scan = new Scanner(System.in);
        player1 = new GamerHuman('X',scan);
        System.out.println("Chose your opponent (PC or human):");
        if (scan.next().equalsIgnoreCase("human")){
            player2 = new GamerHuman('O',scan);
        }else{
            System.out.println("Chose game severity: "
                    +Arrays.toString(Gamer.Severity.values()));
            switch (Gamer.Severity.valueOf(scan.next())){
                case simple:
                    player2 =new GamerPCWeak('O');
                    break;
                case medium:
                    player2 =new GamerPCMedium('O');
                    break;
                case hard:
                    player2 =new GamerPCHard('O');
                    break;
            }
        }
        gamefield.showTurn();
        for(int i = 0; i < 9;i++){
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
