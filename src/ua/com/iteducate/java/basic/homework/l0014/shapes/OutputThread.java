/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.shapes;

/**
 *
 * @author user
 */
public class OutputThread implements Runnable{
    
    private final Robot robot;
    
    public OutputThread(Robot robot){
        this.robot = robot;
    }
    
    @Override
    public void run(){
        while(!Thread.interrupted()){
            try{
                synchronized(this.robot){
                this.robot.wait();
            }
            }catch (InterruptedException ex){
                System.out.println("Interrupted");
                break;
            }
            synchronized(this.robot){
                robot.drawItAll();
            }
            synchronized(this.robot){
            this.robot.notifyAll();
            }
        }
        System.out.println(Thread.currentThread().getName()+" exited");
    }
    
}
