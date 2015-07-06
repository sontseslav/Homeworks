/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.deadlock;

/**
 *
 * @author user
 */
public class SomeObject {
    private volatile int a;

    public SomeObject(int a) {
        this.a = a;
    }
    
    @Override
    public String toString(){
    	return ""+this.a;
    }
}
