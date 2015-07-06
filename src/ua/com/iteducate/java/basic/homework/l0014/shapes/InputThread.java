/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.shapes;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class InputThread implements Runnable{

    private final Robot robot;
    private final Thread outThread;

    public InputThread(Robot robot, Thread outThread) {
        this.robot = robot;
        this.outThread = outThread;
    }
    
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        boolean isMoreShapes = true;
        System.out.println("Available input format:\n"
                + "Rectangle-(x1,y1)-(x2,y2)\n"
                + "Triangle-(x1,y1)-(x2,y2)-(x3,y3)\n"
                + "Circle-(x1,y1)-(x2,y2)");
        while (isMoreShapes){
            System.out.println("Enter coordinates of Shape:");
            try {
                synchronized(this.robot){
                    robot.addShapes(scan.next());
                }
                System.out.println("More shapes? y/n");
                isMoreShapes = (scan.next().equalsIgnoreCase("y"));
            } catch (IdenticalPointsException ex) {
                System.out.println(ex.getMessage());
            } 
        }
        scan.close();
        synchronized(this.robot){
            this.robot.notifyAll();
        }
        
        try{
            synchronized(this.robot){
            this.robot.wait();
        }
        }catch (InterruptedException ex){
            System.out.println("Interrupted");
        }finally{
            outThread.interrupt();
            System.out.println(Thread.currentThread().getName()+" exited...");
        }
    }
    
}
