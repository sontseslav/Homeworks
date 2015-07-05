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
public class Integral2 implements Runnable{
    private boolean done;
    private Function[] funcEntry;
    private Function f;
    private int startX;
    private int finishX;
    private double S;

    public Integral2(Function[] funcEntry, int startX, int finishX) {
        this.funcEntry = funcEntry;
        this.startX = startX;
        this.finishX = finishX;
    }

    
    
    @Override
    public void run() {
        int j = 0;
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " ready!");
            if (!done){
                synchronized(this){
                S = 0;
                }
                synchronized(this.funcEntry){
                    this.f = this.funcEntry[j++];
                }
                System.out.println(Thread.currentThread().getName()+" counting "
                        +f);
                synchronized(this.funcEntry){
                    for(int i = startX; i < finishX;i++){
                        S = S + f.getFunctionValue(i);
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
            synchronized(this){
                if (j < this.funcEntry.length) this.done = false;
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
}
