/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0004;

/**
 *
 * @author user
 */
public class Triangle{
    private double[] sides;
    private Point[] pointStorage;// 3 points
    
    
    public Triangle(int[][] coordinates){
        int l = coordinates.length;
        pointStorage = new Point[l];
        if (l != 3) return;
        for (int i = 0; i<l; i++){
            pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    
    private void countSides(){
        sides = new double[3];
        for (int i = 0; i<2; i++){
            sides[i] = Math.sqrt(Math.pow((pointStorage[i].x-pointStorage[i+1].x), 2)
                    +Math.pow((pointStorage[i].y-pointStorage[i+1].y), 2));
        }
        sides[2] = Math.sqrt(Math.pow((pointStorage[0].x-pointStorage[2].x), 2)
                    +Math.pow((pointStorage[0].y-pointStorage[2].y), 2));
        
    }
    
    private double countSquare(){
        
        double p = countPerimeter();
        return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
    }
    
    private double countPerimeter(){
        return sides[0]+sides[1]+sides[2];
    }
    
    public String getSquareAndPerimeter(){
        countSides();
        return "The square is: " + countSquare() 
                + "\nthe perimeter is: " + countPerimeter();
    }
}
