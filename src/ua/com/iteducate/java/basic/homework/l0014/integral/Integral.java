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
public class Integral implements Runnable{

    private boolean done;
    private Function funcEntry;
    private int startX;
    private int finishX;
    private double S;

    public Integral(Function funcEntry, int startX, int finishX) {
        this.funcEntry = funcEntry;
        this.startX = startX;
        this.finishX = finishX;
    }

    
    
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            S = 0;
            System.out.println(Thread.currentThread().getName() + " ready!");
            if (!done){
                System.out.println(Thread.currentThread().getName()+" counting "
                        +this.funcEntry);
                synchronized(this.funcEntry){
                    for(int i = startX; i < finishX;i++){
                        S = S + this.funcEntry.getFunctionValue(i);
                    }
                }
                this.done = true;
            }
            try {
                synchronized(this.funcEntry){
                    System.out.println(Thread.currentThread().getName()+" waiting...");
                    this.funcEntry.wait();
                    System.out.println(Thread.currentThread().getName()+" resumed...");
                }
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
                break;
            }
        }
        System.out.println(Thread.currentThread().getName()+" gone");
    }
    
    public boolean isDone() {
        return done;
    }
    
    public double getS() {
        return S;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setFuncEntry(Function funcEntry) {
        this.funcEntry = funcEntry;
    }
    
}
