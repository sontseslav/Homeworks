/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0002;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class NoughtsAndCrossesWithPC03 {

    static char[] pole = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        char player1 = 'X';
        char player2 = 'O';
        showTurn();
        for (int i = 0; i < 9; i++) {
            i &= 0b00000001;
            if (i == 0) {//
                takeTurn(player1);
            } else {
                takeTurnPC(player2);
            }
            showTurn();
            char w = checkWin();
            if ((w == 'X') || (w == 'O')) {
                System.out.println("Game over! Gamer " + w + " wins!");
                break;
            } else if (w == 'T') {
                System.out.println("Game over! No one wins!");
                break;
            }
        }
    }

    public static void showTurn() {
        for (int i = 0; i < 9; i += 3) {
            System.out.println("-------");
            System.out.printf("|%s|%s|%s|\r\n", pole[i], pole[i + 1], pole[i + 2]);
        }
        System.out.println("-------");
    }

    public static void takeTurn(char g) {//g - player X
        int t = -1;
        do {
            System.out.println("player_" + g);
            t = scan.nextInt();
        } while (t < 0 || t > 8 || pole[t] != ' ');
        pole[t] = g;
    }

    public static void takeTurnPC(char g) {//player O
        int t = -1;
        for (int i = 0; i < 7; i += 3) {
            if (pole[i] == g && pole[i + 1] == g && pole[i + 2] == ' ') {
                t = i + 2;
                pole[t] = g;
                return;
            } else if (pole[i + 1] == g && pole[i + 2] == g && pole[i] == ' ') {
                t = i;
                pole[t] = g;
                return;
            } else if (pole[i] == g && pole[i + 2] == g && pole[i + 1] == ' ') {
                t = i + 1;
                pole[t] = g;
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (pole[i] == g && pole[i + 3] == g && pole[i + 6] == ' ') {
                t = i + 6;
                pole[t] = g;
                return;
            } else if (pole[i + 3] == g && pole[i + 6] == g && pole[i] == ' ') {
                t = i;
                pole[t] = g;
                return;
            } else if (pole[i] == g && pole[i + 6] == g && pole[i + 3] == ' ') {
                t = i + 3;
                pole[t] = g;
                return;
            }
        }
        if (pole[0] == g && pole[4] == g && pole[8] == ' ') {
            t = 8;
            pole[t] = g;
            return;
        } else if (pole[4] == g && pole[8] == g && pole[0] == ' ') {
            t = 0;
            pole[t] = g;
            return;
        } else if (pole[2] == g && pole[4] == g && pole[6] == ' ') {
            t = 6;
            pole[t] = g;
            return;
        } else if (pole[4] == g && pole[6] == g && pole[2] == ' ') {
            t = 2;
            pole[t] = g;
            return;
        } else if ((pole[0] == g && pole[8] == g && pole[4] == ' ')
                || (pole[2] == g && pole[6] == g && pole[4] == ' ')) {
            t = 4;
            pole[t] = g;
            return;
        } else {
            do {
                t = rand.nextInt(9);
            } while (pole[t] != ' ');
        }
        pole[t] = g;
    }

    public static char checkWin() {
        for (int i = 0; i < 7; i += 3) {
            if (pole[i] == 'X' && pole[i + 1] == 'X' && pole[i + 2] == 'X') {
                return 'X';
            } else if (pole[i] == 'O' && pole[i + 1] == 'O' && pole[i + 2] == 'O') {
                return 'O';
            }
        }
        for (int i = 0; i < 3; i++) {
            if (pole[i] == 'X' && pole[i + 3] == 'X' && pole[i + 6] == 'X') {
                return 'X';
            } else if (pole[i] == 'O' && pole[i + 3] == 'O' && pole[i + 6] == 'O') {
                return 'O';
            }
        }
        if ((pole[0] == 'X' && pole[4] == 'X' && pole[8] == 'X')
                || (pole[2] == 'X' && pole[4] == 'X' && pole[6] == 'X')) {
            return 'X';
        }
        if ((pole[0] == 'O' && pole[4] == 'O' && pole[8] == 'O')
                || (pole[2] == 'O' && pole[4] == 'O' && pole[6] == 'O')) {
            return 'O';
        }
        //no one wins - tie
        if (checkTie()) {
            return 'T';
        }
        return ' ';
    }

    public static boolean checkTie() {
        for (int i = 0; i < 9; i++) {
            if (pole[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}
