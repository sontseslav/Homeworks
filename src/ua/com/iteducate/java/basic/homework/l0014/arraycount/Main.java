/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.arraycount;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        int n = 30000000;
        ArrayToCount atc = new ArrayToCount(n);
        atc.setArray();
        System.out.println("Go!");
        long S = 0;
        long tStart = System.currentTimeMillis();
        for(int i = 0; i < atc.array.length; i++){
            S += atc.array[i];
        }
        long tEnd = System.currentTimeMillis();
        System.out.println("Simple counting: "+S+" \ntime: "+(tEnd-tStart));
        
//        tStart = System.currentTimeMillis();
//        S = sum(atc.array);
//        tEnd = System.currentTimeMillis();
//        System.out.println("Recursive counting: "+S+" \ntime: "+(tEnd-tStart));
        
        int m = n/2;
        tStart = System.currentTimeMillis();
        Counter c1 = new Counter(atc, 0, m);
        Counter c2 = new Counter(atc, m, 2*m);
        c1.start();
        c2.start();
        tEnd = System.currentTimeMillis();
        while(!c1.isDone() | !c2.isDone()){
            try{
                Thread.sleep(1);
            }catch (InterruptedException ex){}
        }
        S = c1.getS()+c2.getS();
        System.out.println("Thread counting: "+S+" \ntime: "
                +(System.currentTimeMillis()-tEnd));
        c1.interrupt();
        c2.interrupt();
        tEnd = System.currentTimeMillis();
        System.out.println("Thread counting overall: "+S+" \ntime: "+(tEnd-tStart));
    }
    
    static int sum(int[] inArray){//summarize recursively
        int l = inArray.length;
        if (l > 1){
            int[] firstHalf = Arrays.copyOfRange(inArray, 0, l/2);
            int[] secondHalf = Arrays.copyOfRange(inArray, l/2, l);
            return sum(firstHalf)+sum(secondHalf);
        }
        return inArray[0];
    }
}
