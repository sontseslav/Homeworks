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
        for (int i = 0; i<l; i++){
            this.pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    
    private void countRadius(){
        radius = Math.sqrt(Math.pow((this.pointStorage[0].x-this.pointStorage[1].x), 2)
                +Math.pow((this.pointStorage[0].y-this.pointStorage[1].y), 2));
    }
    
    private double countSquare(){
        this.countRadius();
        return Math.PI*radius*radius;
    }
    
    private double countPerimeter(){
        return 2*radius*Math.PI;
    }
    
    public String getSquareAndPerimeter(){
        return "The square is: " + this.countSquare() 
                + "\n the perimeter is: " + this.countPerimeter();
    }
}
