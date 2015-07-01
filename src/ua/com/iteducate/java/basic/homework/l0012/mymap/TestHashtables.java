/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0012.mymap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class TestHashtables {
    
    protected class Test{
        
        public long getItems(Map map,int whereGet, int countGet){
            long tStart = System.currentTimeMillis();
            for (int i = 0; i<countGet;i++){
                map.get(i);
                //list.get(whereGet+i);
            }
            return System.currentTimeMillis() - tStart;
        }
        
        public long setItems(Map map,int whereSet, int countSet){
            long tStart = System.currentTimeMillis();
            for (int i = 0; i<countSet;i++){
                map.put(i, "String");
                //list.set(whereSet+i,i);
            }
            return System.currentTimeMillis() - tStart;
        }
    }
    
    protected class TestMyHashMap extends Test{
        protected MyHashMap<Integer,String> myHashMap = new MyHashMap<>();
        protected int count;
        
        public TestMyHashMap(String var, int count) {
            this.count = count;
            for (int i = 0; i < this.count; i++){
                this.myHashMap.put(i, var);
            }
        }
    }
    
    protected class TestHashMap extends Test{
        protected HashMap<Integer,String> hashMap = new HashMap<>();
        protected int count;

        public TestHashMap(String var, int count) {
            this.count = count;
            for (int i = 0; i < this.count; i++){
                this.hashMap.put(i, var);
            }
        }
    }
    
    public static void main(String[] args) {
        String str = "MyStr";
        int mycount = 10000;
        int mycountGet = 100;
        TestHashtables tht = new TestHashtables();
        long tStart = System.currentTimeMillis();
        TestHashtables.TestMyHashMap testMy = tht.new TestMyHashMap("MyHashMap",mycount);
        System.out.println("MyHashMap reating time: "+(System.currentTimeMillis()-tStart));
        tStart = System.currentTimeMillis();
        TestHashtables.TestHashMap test = tht.new TestHashMap("HashMap", mycount);
        System.out.println("Native HashMap creating time: "+(System.currentTimeMillis()-tStart));
        System.out.println("Testing element "+str);
        System.out.println("----------------------------------------------------");
        System.out.println("GET method:");
        System.out.println("----------------------------------------------------");
        System.out.println("Getting one first item from myHashMap: "
                +testMy.getItems(testMy.myHashMap, 0, 1));
        System.out.println("Getting one first item from native hashMap: "
                +test.getItems(test.hashMap, 0, 1));
        System.out.println("Getting one middle item from myHashMap: "
                +testMy.getItems(testMy.myHashMap, mycount/2, 1));
        System.out.println("Getting one middle item from native hashMap: "
                +test.getItems(test.hashMap, mycount/2, 1));
        System.out.println("Getting one last item from myHashMap: "
                +testMy.getItems(testMy.myHashMap, mycount-1, 1));
        System.out.println("Getting one last item from native hashMap: "
                +test.getItems(test.hashMap, mycount-1, 1));
        System.out.println("----------------------------------------------------");
        System.out.printf("Getting %s first items from myHashMap: %s%n",
                mycountGet,testMy.getItems(testMy.myHashMap, 0, mycountGet));
        System.out.printf("Getting %s first items from native hashMap: %s%n",
                mycountGet,test.getItems(test.hashMap, 0, mycountGet));
        System.out.printf("Getting %s middle items from myHashMap: %s%n",
                mycountGet,testMy.getItems(testMy.myHashMap, mycount/2, mycountGet));
        System.out.printf("Getting %s middle items from native hashMap: %s%n"
                ,mycountGet,test.getItems(test.hashMap, mycount/2, mycountGet));
        System.out.printf("Getting %s last items from myHashMap: %s%n"
                ,mycountGet,testMy.getItems(testMy.myHashMap, mycount-1-mycountGet, mycountGet));
        System.out.printf("Getting %s last items from native hashMap: %s%n"
                ,mycountGet,test.getItems(test.hashMap, mycount-1-mycountGet, mycountGet));
        System.out.println("----------------------------------------------------");
        System.out.println("SET method:");
        System.out.println("----------------------------------------------------");
        System.out.println("Setting one first item to myHashMap: "
                +testMy.setItems(testMy.myHashMap, 0, 1));
        System.out.println("Setting one first item to native hashMap: "
                +test.setItems(test.hashMap, 0, 1));
        System.out.println("Setting one middle item to myHashMap: "
                +testMy.setItems(testMy.myHashMap, mycount/2, 1));
        System.out.println("Setting one middle item to native hashMap: "
                +test.setItems(test.hashMap, mycount/2, 1));
        System.out.println("Setting one last item to myHashMap: "
                +testMy.setItems(testMy.myHashMap, mycount-1, 1));
        System.out.println("Setting one last item to native hashMap: "
                +test.setItems(test.hashMap, mycount-1, 1));
        System.out.println("----------------------------------------------------");
        System.out.printf("Setting %s first items to myHashMap: %s%n"
                ,mycountGet,testMy.setItems(testMy.myHashMap, 0, mycountGet));
        System.out.printf("Setting %s first items to native hashMap: %s%n"
                ,mycountGet,test.setItems(test.hashMap, 0, mycountGet));
        System.out.printf("Setting %s middle items to myHashMap: %s%n"
                ,mycountGet,testMy.setItems(testMy.myHashMap, mycount/2, mycountGet));
        System.out.printf("Setting %s middle items to native hashMap: %s%n"
                ,mycountGet,test.setItems(test.hashMap, mycount/2, mycountGet));
        System.out.printf("Setting %s last items to myHashMap: %s%n"
                ,mycountGet,testMy.setItems(testMy.myHashMap, mycount-1-mycountGet, mycountGet));
        System.out.printf("Setting %s last items to native hashMap: %s%n"
                ,mycountGet,test.setItems(test.hashMap, mycount-1-mycountGet, mycountGet));
        
    }
}
