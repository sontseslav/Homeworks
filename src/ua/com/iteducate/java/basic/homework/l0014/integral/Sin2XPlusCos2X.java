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
public class Sin2XPlusCos2X extends Function{

    public Sin2XPlusCos2X() {
        super();
    }

    
    @Override
    public double getFunctionValue(int x) {
        return Math.sin(2*x)+Math.cos(2*x)+2;
    }
    
}
