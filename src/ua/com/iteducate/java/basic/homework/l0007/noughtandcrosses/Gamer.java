/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0007.noughtandcrosses;

import java.util.Scanner;

/**
 *
 * @author user
 */
public abstract class Gamer {
    protected int t;
    protected char player;
    //protected Scanner scan;
    protected enum Severity {simple, medium, hard};
    protected GameField instance = GameField.getInstance();
    
    public abstract void takeTurn();
    
    public abstract char getPlayer();
}
