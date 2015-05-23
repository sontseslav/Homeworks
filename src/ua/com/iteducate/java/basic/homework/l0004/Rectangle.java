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
public class Rectangle{
    private double[] sides;
    private Point[] pointStorage;// 4 points
    
    
    public Rectangle(int[][] coordinates){
        int l = coordinates.length;
        if (l != 4) return;
        for (int i = 0; i<l; i++){
            this.pointStorage[i] = new Point(coordinates[i][0],coordinates[i][1]);
        }
    }
    
    private void countSides(){
        for (int i = 1; i<pointStorage.length - 1; i++){// only 3 points needed
            sides[i-1] = Math.sqrt(Math.pow((this.pointStorage[i-1].x-this.pointStorage[i].x), 2)
                    +Math.pow((this.pointStorage[i-1].y-this.pointStorage[i].y), 2));
        }
    }
    
    private double countSquare(){
        this.countSides();
        return this.sides[0]*this.sides[1];
    }
    
    private double countPerimeter(){
        return 2*(this.sides[0]+this.sides[1]);
    }
    
    public String getSquareAndPerimeter(){
        return "The square is: " + this.countSquare() 
                + "\n the perimeter is: " + this.countPerimeter();
    }
}
