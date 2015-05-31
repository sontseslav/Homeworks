/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0002;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class NoughtsAndCrosses03 {
    static char[] pole = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	char player1 = 'X';
	char player2 = 'O';
	showTurn();
	for(int i=0;i<9;i++){
            i &= 0b00000001;
            if(i==0){//
		takeTurn(player1);
            }else{
		takeTurn(player2);
            }
            showTurn();
            char w = checkWin();
            if ((w == 'X')||(w == 'O')){
		System.out.println("Game over! Gamer "+w+" wins!");
		break;
            }else if (w == 'T'){
		System.out.println("Game over! No one wins!");
		break;
            }
	}
    }
	
    public static void showTurn(){
	for (int i = 0; i<9; i+=3){
            System.out.println("-------");
            System.out.printf("|%s|%s|%s|\r\n",pole[i],pole[i+1],pole[i+2]);
	}
	System.out.println("-------");
    }
	
    public static void takeTurn(char g){//g - player
	int t = -1;
	do{
            System.out.println("player_"+g);
            t = scan.nextInt();	
	}while(t < 0 || t>8 ||pole[t] != ' ');
	pole[t]=g;
    }
	
    public static char checkWin(){
	for (int i = 0;i<6;i+=3){
            if (pole[i] == 'X' && pole[i+1] == 'X' && pole[i+2]=='X'){
		return 'X';
            }else if (pole[i] == 'O' && pole[i+1] == 'O' && pole[i+2]=='O'){
		return 'O';
            }
	}
	for (int i = 0;i<3;i++){
            if (pole[i] == 'X' && pole[i+3] == 'X' && pole[i+6]=='X'){
		return 'X';
            }else if (pole[i] == 'O' && pole[i+3] == 'O' && pole[i+6]=='O'){
		return 'O';
            }
	}
	if ((pole[0] == 'X' && pole[4] == 'X' && pole[8] == 'X')
		||(pole[2] == 'X' && pole[4] == 'X' && pole[6] == 'X')){
            return 'X';
	}
	if ((pole[0] == 'O' && pole[4] == 'O' && pole[8] == 'O')
		||(pole[2] == 'O' && pole[4] == 'O' && pole[6] == 'O')){
            return 'O';
	}
	//no one wins - tie
	if (checkTie()){
            return 'T';
	}
	return ' ';
    }
	
    public static boolean checkTie(){
	for (int i = 0; i<9; i++){
            if (pole[i] == ' ')
		return false;
            }
	return true;
    }
}
