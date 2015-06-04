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
public abstract class Shape {
    protected double[] sides;
    
    protected abstract void draw();
    
    protected abstract double perimeter();
    
    protected abstract double square();
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName()+":\nperimeter = "+perimeter()
                +"\nsquare = "+square();
    }
}
