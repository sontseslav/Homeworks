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
public class Thread2 extends Thread{
	private final SomeObject so1;
    private final SomeObject so2;

    public Thread2(SomeObject so1,SomeObject so2) {
        this.so1 = so1;
        this.so2 = so2;
    }          
    @Override
    public void run(){
        while(!isInterrupted()){
        	synchronized(this.so2){
                System.out.println(getName()+" takes "+so2);
                synchronized(this.so1){
                	System.out.println(getName()+" takes "+so1);
                }
        	}
        }
        System.out.println(getName()+" exiting...");
    }
}
