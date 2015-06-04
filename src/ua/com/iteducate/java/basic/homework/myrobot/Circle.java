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
public class Circle extends Shape{
    
    protected Circle(int[][] coordinates){
        if (coordinates.length == 2){
            sides = new double[1];
            sides[0] = Math.sqrt(Math.pow((coordinates[1][0]-coordinates[0][0]), 2)
                        +Math.pow((coordinates[1][1]-coordinates[0][1]), 2));
        }
    }

    @Override
    protected double perimeter(){
        return 2*Math.PI*sides[0];
    }
    
    @Override
    protected double square(){
        return Math.PI*Math.pow(sides[0],2);
    }
    
    @Override
    protected void draw() {}
}
