/*
 * 
 */
package ua.com.iteducate.java.basic.homework.l0004.noughts_and_crosses;

/**
 *
 * @author user
 */
public class GameField {
    //private static GameField instance = null;
    private char[] pole = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
    
    //private GameField(){}
    
    //public static GameField getInstance(){
    //    if (instance == null){
    //        instance = new GameField();
    //    }
    //    return instance;
    //}
    
    public char[] getPole(){
        return pole;
    }
    
    public void setPole(int index,char player){
        pole[index]=player;
    }
    
    public void showTurn(){
	for (int i = 0; i<9; i+=3){
            System.out.println("-------");
            System.out.printf("|%s|%s|%s|\r\n",pole[i],pole[i+1],pole[i+2]);
	}
	System.out.println("-------");
    }
    
    public char checkWin(){
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
	
    public boolean checkTie(){
	for (int i = 0; i<9; i++){
            if (pole[i] == ' ')
		return false;
            }
	return true;
    }
}
