/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.integral;

/**
 *
 * @author user
 */
public abstract class Function {
    public Function() {}
    
    public abstract double getFunctionValue(int x);
    
    @Override
    public String toString(){
        return ""+this.getClass().getSimpleName();
    }
}
