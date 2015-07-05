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
public class Main extends Thread{
    public static void main(String[] args) {
        Function func1 = new SinSqrXPlusCosSqrX();
        Integral int1 = new Integral(func1, 0, 100);
        Integral int2 = new Integral(func1, 100, 200);
        Integral int3 = new Integral(func1, 200, 300);
        Thread thread01 = new Thread(int1);
        Thread thread02 = new Thread(int2);
        Thread thread03 = new Thread(int3);
        thread01.start();
        thread02.start();
        thread03.start();
        while (!int1.isDone() | !int2.isDone() | !int3.isDone()){//false+false+false
            System.out.println(!int1.isDone() + " " + !int2.isDone() +" "+ !int3.isDone());
            try{
             Thread.sleep(100);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.printf("Integral of %s on segment [%d-%d] is %.3f%n",func1,0,300,
                (int1.getS()+int2.getS()+int3.getS()));
        synchronized(func1){
            func1.notifyAll();
        }
        try{
             Thread.sleep(5000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("Interrupting...");
        thread01.interrupt();
        thread02.interrupt();
        thread03.interrupt();
    }
}
