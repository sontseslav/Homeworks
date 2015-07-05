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
public class SinSqrXPlusCosSqrX extends Function{

    public SinSqrXPlusCosSqrX() {
        super();
    }
    
    @Override
    public double getFunctionValue(int x) {
        return Math.pow(Math.sin(x),2)+Math.pow(Math.cos(x),2);
    }
    
}
