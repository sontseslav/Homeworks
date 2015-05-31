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
public class Rectangle{
    private double[] sides;
    private Point[] pointStorage;// 4 points
    
    
    public Rectangle(int[][] coordinates){
        int l = coordinates.length;
        pointStorage = new Point[l];
        if (l != 4) return;
        for (int i = 0; i<l; i++){
            pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    
    private void countSides(){
        sides = new double[2];
        for (int i = 1; i<pointStorage.length - 1; i++){// only 3 points needed
            sides[i-1] = Math.sqrt(Math.pow((pointStorage[i-1].x-pointStorage[i].x), 2)
                    +Math.pow((pointStorage[i-1].y-pointStorage[i].y), 2));
        }
    }
    
    private double countSquare(){

        return sides[0]*sides[1];
    }
    
    private double countPerimeter(){
        return 2*(sides[0]+sides[1]);
    }
    
    public String getSquareAndPerimeter(){
        countSides();
        return "The square is: " + countSquare() 
                + "\nthe perimeter is: " + countPerimeter();
    }
}
