/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.myrobot;

/**
 *
 * @author user
 */
public class Rectangle extends Shape{

    protected Rectangle(int[][] coordinates) {
        if (coordinates.length == 4){
            sides = new double[2];
            for (int i = 0; i<sides.length;i++){
                sides[i] = Math.sqrt(Math.pow((coordinates[i+1][0]-coordinates[i][0]), 2)
                        +Math.pow((coordinates[i+1][1]-coordinates[i][1]), 2));
            }
        }
    }
    
    @Override
    protected double perimeter(){
        return 2*(sides[0]+sides[1]);
    }
    
    @Override
    protected double square(){
        return sides[0]*sides[1];
    }

    @Override
    protected void draw() {}
}
