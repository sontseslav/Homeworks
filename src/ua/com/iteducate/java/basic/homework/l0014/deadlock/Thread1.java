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
public class Thread1 extends Thread{
    private final Thread pointer;
    private final SomeObject so;

    public Thread1(Thread pointer, SomeObject so) {
        this.pointer = pointer;
        this.so = so;
    }
    
    @Override
    public void run(){
        while(!isInterrupted()){
            try{
                System.out.println("wainig");
                synchronized(this.so){
                    this.so.wait();
                    System.out.println("wainig no more");
                }
            }catch (InterruptedException ex){
                System.out.println("Interrupted");
            }
            System.out.println(getName()+" resumed");
//            synchronized(this.so){
//                this.pointer.interrupt();
//            }
        }
        System.out.println(getName()+" exiting...");
    }
}
