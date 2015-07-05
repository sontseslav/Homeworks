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
public class Main2 extends Thread{
    public static void main(String[] args) {
        Function func1 = new SinSqrXPlusCosSqrX();
        Function func2 = new Sin2XPlusCos2X();
        Function func3 = new SophisticatedFunction();
        Function[] container = new Function[]{func1,func2,func3};
        Integral2 int1 = new Integral2(container,0, 100);
        Integral2 int2 = new Integral2(container,100, 200);
        Integral2 int3 = new Integral2(container,200, 300);
        Thread thread01 = new Thread(int1);
        Thread thread02 = new Thread(int2);
        Thread thread03 = new Thread(int3);

        thread01.start();
        thread02.start();
        thread03.start();
        for(int i = 0; i < container.length;i++){
            while (!int1.isDone() | !int2.isDone() | !int3.isDone()){//false+false+false
                try{
                 Thread.sleep(100);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.printf("Integral of %s on segment [%d-%d] is %.3f%n",
                    container[i],0,300,(int1.getS()+int2.getS()+int3.getS()));


            System.out.println("synchronizing...");
            synchronized(container){
                container.notifyAll();
            }
            System.out.println("Go!");
        }
        System.out.println("Interrupting...");
        thread01.interrupt();
        thread02.interrupt();
        thread03.interrupt();
    }
}
