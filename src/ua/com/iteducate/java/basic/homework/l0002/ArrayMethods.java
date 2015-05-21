/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0002;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/**
 *
 * @author user
 */
public class ArrayMethods {
    final static int n = 300;//static - 'cause using static context
    
    public static void main(String[] args){
        int[] array = new int[n];
        Random rand = new Random();
        //fill array by positive and negative numbers [-32768;32767]
        for (int i = 0; i < n; i++){
            array[i] = rand.nextInt(65535) - 32768;
        }
        System.out.println("Середнє значення масиву:\n"+mean(array));
        System.out.println("Мода в масиві:\n"+mode(array));
        System.out.println("Медіана в масиві:\n"+median(array));
        System.out.println("Послідовність чисел, що дають в сумі 0:\n" 
                + sumZero(array));
        System.out.println("Масив:\n"+Arrays.toString(array));
    }
    
    static double mean(int[] inArray){
        return (double)sum(inArray)/n;
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
    
    static String mode(int[]inArray){//some sort of magic
        String result = "";
        Arrays.sort(inArray);//double-pivot QuickSort
        //smth like pythonic dict
        HashMap<Integer,Integer> dict = new HashMap<>();
        int save = 0;
        for (int i:inArray){
            if (i == save){
                if (dict.containsKey(i)){
                    Integer val = dict.get(i);
                    dict.put(i, val + 1);
                }else{
                    dict.put(i, 1);
                }
            }else{
                save = i;
            }
        }
        if (dict.isEmpty()) 
            return "відсутня";
        int maxValue = Collections.max(dict.values());
        if (maxValue == 1)
            return "відсутня";
        for (Entry<Integer,Integer> entry:dict.entrySet()){
            if (entry.getValue() == maxValue)
                result += entry.getKey()+":"+entry.getValue()+"\n";
        }
        return result;
    }
    
    static int median(int[] inArray){
        if (n%2 == 0)
            return (inArray[n/2]+inArray[n/2+1])/2;
        return (inArray[n/2]);
    }
    
    static String sumZero(int[] inArray){
        String result = "";
        for (int i = 0; i < n-2; i++){
            for (int j = i+1; j < n-1; j++){
                int sumOf2 = (inArray[i]+inArray[j])-2*(inArray[i]+inArray[j]);
                int thirdElement = binSearch(sumOf2, inArray, j+1, n);
                if (thirdElement > j + 1)
                    result += inArray[i]+", "+inArray[j]+", "
                                +inArray[thirdElement] + "\n";
            }
        }
        if (result.isEmpty())
            result = "відсутня";
        return result;
    }
    
    static int binSearch(int key,int[] inArray, int first, int last){
        if (last <= first) return -1;
        int mid = first + (last - first) / 2;
        if (key < inArray[mid]) return binSearch(key, inArray, first, mid);
        else if (inArray[mid] < key) return binSearch(key, inArray, mid+1, last);
        else return mid;
    }

}
