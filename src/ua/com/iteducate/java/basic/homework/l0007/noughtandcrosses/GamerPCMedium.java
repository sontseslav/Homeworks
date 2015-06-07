/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0007.noughtandcrosses;

import java.util.Random;

/**
 *
 * @author user
 */
public class GamerPCMedium extends Gamer{

    protected GamerPCMedium(char player) {
        this.player = player;
    }
    
    

    @Override
    public void takeTurn() {
        for (int i = 0; i < 7; i += 3) {
            if (instance.getPole()[i] == 'X' && instance.getPole()[i + 1] == 'X' && instance.getPole()[i + 2] == ' ') {
                t = i + 2;
                instance.setPole(t, player);
                return;
            } else if (instance.getPole()[i + 1] == 'X' && instance.getPole()[i + 2] == 'X' && instance.getPole()[i] == ' ') {
                t = i;
                instance.setPole(t, player);
                return;
            } else if (instance.getPole()[i] == 'X' && instance.getPole()[i + 2] == 'X' && instance.getPole()[i + 1] == ' ') {
                t = i + 1;
                instance.setPole(t, player);
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (instance.getPole()[i] == 'X' && instance.getPole()[i + 3] == 'X' && instance.getPole()[i + 6] == ' ') {
                t = i + 6;
                instance.setPole(t, player);
                return;
            } else if (instance.getPole()[i + 3] == 'X' && instance.getPole()[i + 6] == 'X' && instance.getPole()[i] == ' ') {
                t = i;
                instance.setPole(t, player);
                return;
            } else if (instance.getPole()[i] == 'X' && instance.getPole()[i + 6] == 'X' && instance.getPole()[i + 3] == ' ') {
                t = i + 3;
                instance.setPole(t, player);
                return;
            }
        }
        if (instance.getPole()[0] == 'X' && instance.getPole()[4] == 'X' && instance.getPole()[8] == ' ') {
            t = 8;
            instance.setPole(t, player);
            return;
        } else if (instance.getPole()[4] == 'X' && instance.getPole()[8] == 'X' && instance.getPole()[0] == ' ') {
            t = 0;
            instance.setPole(t, player);
            return;
        } else if (instance.getPole()[2] == 'X' && instance.getPole()[4] == 'X' && instance.getPole()[6] == ' ') {
            t = 6;
            instance.setPole(t, player);
            return;
        } else if (instance.getPole()[4] == 'X' && instance.getPole()[6] == 'X' && instance.getPole()[2] == ' ') {
            t = 2;
            instance.setPole(t, player);
            return;
        } else if ((instance.getPole()[0] == 'X' && instance.getPole()[8] == 'X' && instance.getPole()[4] == ' ')
                || (instance.getPole()[2] == 'X' && instance.getPole()[6] == 'X' && instance.getPole()[4] == ' ')) {
            t = 4;
            instance.setPole(t, player);
            return;
        } else {
            do {
                Random rand = new Random();
                t = rand.nextInt(9);
            } while (instance.getPole()[t] != ' ');
        }
        instance.setPole(t, player);
    }

    @Override
    public char getPlayer() {
        return this.player;
    }
}
