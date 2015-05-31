/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0004.shapes;

/**
 *
 * @author user
 */
public class Point {
    protected int x;
    protected int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int[] getCoord(){//private case
        return new int[]{x, y};
    }
}