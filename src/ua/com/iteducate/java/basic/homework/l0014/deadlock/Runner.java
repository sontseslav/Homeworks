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
public class Runner {
    public static void main(String[] args) {
        SomeObject so1 = new SomeObject(123);
        SomeObject so2 = new SomeObject(321);
        Thread2 thread02 = new Thread2(so1,so2);
        Thread1 thread01 = new Thread1(so1,so2);
        System.out.println("GO!");
        thread01.start();
        thread02.start();
        System.out.println("Wait just 5 sec...");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException ex){}
        System.out.println("Closing threads");
        thread01.interrupt();
        thread02.interrupt();
        System.out.println("Done!");
    }
}
