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
public class Triangle extends Shape{
    private double perim;
    
    protected Triangle(int[][] coordinates){
        if (coordinates.length == 3){
            sides = new double[3];
            for (int i = 0; i<sides.length-1;i++){
                sides[i] = Math.sqrt(Math.pow((coordinates[i+1][0]-coordinates[i][0]), 2)
                        +Math.pow((coordinates[i+1][1]-coordinates[i][1]), 2));
            }
            sides[2] = Math.sqrt(Math.pow((coordinates[2][0]-coordinates[0][0]), 2)
                        +Math.pow((coordinates[2][1]-coordinates[0][1]), 2));
        }
    }

    @Override
    protected double perimeter(){
        perim = sides[0]+sides[1]+sides[3];
        return perim;
    }
    
    @Override
    protected double square(){
        perim /= 2;
        return Math.sqrt(perim*(perim-sides[0])*(perim-sides[1])*(perim-sides[2]));
    }
    
    @Override
    protected void draw() {}
    
}