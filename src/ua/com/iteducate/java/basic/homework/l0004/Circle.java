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
public class Circle{
    private double radius;
    private Point[] pointStorage;// 1 point
    
    
    public Circle(int[][] coordinates){
        int l = coordinates.length;
        if (l != 2) return;
        pointStorage = new Point[l];
        for (int i = 0; i<l; i++){
            pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    
    private void countRadius(){
        radius = Math.sqrt(Math.pow((pointStorage[0].x-pointStorage[1].x), 2)
                +Math.pow((pointStorage[0].y-pointStorage[1].y), 2));
    }
    
    private double countSquare(){
        this.countRadius();
        return Math.PI*radius*radius;
    }
    
    private double countPerimeter(){
        return 2*radius*Math.PI;
    }
    
    public String getSquareAndPerimeter(){
        return "The square is: " + countSquare() 
                + "\nthe perimeter is: " + countPerimeter();
    }
}
