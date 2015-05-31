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
public abstract class Shape {
    protected Point[] pointStorage;
    
    protected abstract void countSides();
    
    protected abstract double countSquare();
    
    protected abstract double countPerimeter();
    
    protected String getSquareAndPerimeter(){
        countSides();
        return "The square is: " + countSquare() 
                + "\nthe perimeter is: " + countPerimeter();
    }
}
