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
public class Triangle extends Shape{
    private double p;
    private double[] sides;
    
    public Triangle(int[][] coordinates){
        int l = coordinates.length;
        pointStorage = new Point[l];
        if (l != 3) return;
        for (int i = 0; i<l; i++){
            pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    @Override
    protected void countSides(){
        sides = new double[3];
        for (int i = 0; i<2; i++){
            sides[i] = Math.sqrt(Math.pow((pointStorage[i].getCoord()[0]-pointStorage[i+1].getCoord()[0]), 2)
                    +Math.pow((pointStorage[i].getCoord()[1]-pointStorage[i+1].getCoord()[1]), 2));
        }
        sides[2] = Math.sqrt(Math.pow((pointStorage[0].getCoord()[0]-pointStorage[2].getCoord()[0]), 2)
                    +Math.pow((pointStorage[0].getCoord()[1]-pointStorage[2].getCoord()[1]), 2));
        
    }
    @Override
    protected double countSquare(){
        
        p = countPerimeter();
        return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
    }
    @Override
    protected double countPerimeter(){
        return sides[0]+sides[1]+sides[2];
    }
    @Override
    public String getSquareAndPerimeter(){
        countSides();
        return "The square is: " + countSquare() 
                + "\nthe perimeter is: " + p;
    }
}
