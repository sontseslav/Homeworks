/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.arraycount;

import java.util.Random;

/**
 *
 * @author user
 */
public class ArrayToCount {
    public volatile int[] array;

    public ArrayToCount(int i) {
        this.array = new int[i];
    }
    
    public void setArray(){
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100);
        }
    }
}
