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
public class Rectangle extends Shape{
    private double[] sides;
    
    public Rectangle(int[][] coordinates){
        int l = coordinates.length;
        pointStorage = new Point[l];
        if (l != 4) return;
        for (int i = 0; i<l; i++){
            pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    @Override
    protected void countSides(){
        sides = new double[2];
        for (int i = 1; i<pointStorage.length - 1; i++){// only 3 points needed
            sides[i-1] = Math.sqrt(Math.pow((pointStorage[i-1].getCoord()[0]
                    -pointStorage[i].getCoord()[0]), 2)
                    +Math.pow((pointStorage[i-1].getCoord()[1]
                    -pointStorage[i].getCoord()[1]), 2));
        }
    }
    @Override
    protected double countSquare(){

        return sides[0]*sides[1];
    }
    @Override
    protected double countPerimeter(){
        return 2*(sides[0]+sides[1]);
    }
    @Override
    public String getSquareAndPerimeter(){
        countSides();
        return "The square is: " + countSquare() 
                + "\nthe perimeter is: " + countPerimeter();
    }
}
