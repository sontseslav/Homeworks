/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0005;

/**
 *
 * @author user
 */
public class Circle extends Shape{
    private double radius;
    
    public Circle(int[][] coordinates){
        int l = coordinates.length;
        if (l != 2) return;
        pointStorage = new Point[l];
        for (int i = 0; i<l; i++){
            pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    @Override
    protected void countSides(){
        radius = Math.sqrt(Math.pow((pointStorage[0].getCoord()[0]-pointStorage[1].getCoord()[0]), 2)
                +Math.pow((pointStorage[0].getCoord()[1]-pointStorage[1].getCoord()[1]), 2));
    }
    @Override
    protected double countSquare(){
        
        return Math.PI*radius*radius;
    }
    @Override
    protected double countPerimeter(){
        return 2*radius*Math.PI;
    }
}
