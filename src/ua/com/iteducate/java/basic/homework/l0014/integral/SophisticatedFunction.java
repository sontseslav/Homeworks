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
public class SophisticatedFunction extends Function{

    public SophisticatedFunction() {
        super();
    }

    @Override
    public double getFunctionValue(int x) {
        int A = 4;
        double C = 4.5;
        double P = 150.666666;
        double a = P/4 + P/100;
        double w = 2*Math.PI/P;
        return A*Math.sin(w*(x-a))+C;
    }
    
}
