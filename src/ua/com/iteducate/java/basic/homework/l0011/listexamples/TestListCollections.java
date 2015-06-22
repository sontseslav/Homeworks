/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0011.listexamples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author user
 */
public class TestListCollections {
    
    protected class Test{
        
        public long getItems(List list,int whereGet, int countGet){
            long tStart = System.currentTimeMillis();
            for (int i = 0; i<countGet;i++){
                list.get(whereGet+i);
            }
            return System.currentTimeMillis() - tStart;
        }
        
        public long setItems(List list,int whereSet, int countSet){
            long tStart = System.currentTimeMillis();
            for (int i = 0; i<countSet;i++){
                list.set(whereSet+i,i);
            }
            return System.currentTimeMillis() - tStart;
        }
        
        public long addItems(List list,int whereAdd, int countAdd){
            long tStart = System.currentTimeMillis();
            for (int i = 0; i<countAdd;i++){
                list.add(whereAdd+i,i);
            }
            return System.currentTimeMillis() - tStart;
        }
    }
    
    protected class TestALists <T> extends Test{
        protected ArrayList<T> aList = new ArrayList<>();
        protected int count;
        
        public TestALists(T invar, int count) {
            this.count = count;
            for (int i = 0; i < this.count; i++){
                this.aList.add(invar);
            }
        }
    }
    
    protected class TestLList<T> extends Test{
        protected LinkedList<T> lList = new LinkedList<>();
        protected int count;

        public TestLList(T invar, int count) {
            this.count = count;
            for (int i = 0; i < this.count; i++){
                this.lList.add(invar);
            }
        }
    }
    
    public static void main(String[] args) {
        String str = "MyStr";
        int mycount = 100000;
        int mycountGet = 100;
        TestListCollections tlc = new TestListCollections();
        TestListCollections.TestALists tal = tlc.new TestALists(str, mycount);
        TestListCollections.TestLList tll = tlc.new TestLList(str, mycount);
        System.out.println("Testing element "+str);
        System.out.println("----------------------------------------------------");
        System.out.println("GET method:");
        System.out.println("----------------------------------------------------");
        System.out.println("Getting one first item from ArrayList: "
                +tal.getItems(tal.aList, 0, 1));
        System.out.println("Getting one first item from LinkedList: "
                +tll.getItems(tll.lList, 0, 1));
        System.out.println("Getting one middle item from ArrayList: "
                +tal.getItems(tal.aList, mycount/2, 1));
        System.out.println("Getting one middle item from LinkedList: "
                +tll.getItems(tll.lList, mycount/2, 1));
        System.out.println("Getting one last item from ArrayList: "
                +tal.getItems(tal.aList, mycount-1, 1));
        System.out.println("Getting one last item from LinkedList: "
                +tll.getItems(tll.lList, mycount-1, 1));
        System.out.println("----------------------------------------------------");
        System.out.printf("Getting %s first items from ArrayList: %s%n",
                mycountGet,tal.getItems(tal.aList, 0, mycountGet));
        System.out.printf("Getting %s first items from LinkedList: %s%n",
                mycountGet,tll.getItems(tll.lList, 0, mycountGet));
        System.out.printf("Getting %s middle items from ArrayList: %s%n",
                mycountGet,tal.getItems(tal.aList, mycount/2, mycountGet));
        System.out.printf("Getting %s middle items from LinkedList: %s%n"
                ,mycountGet,tll.getItems(tll.lList, mycount/2, mycountGet));
        System.out.printf("Getting %s last items from ArrayList: %s%n"
                ,mycountGet,tal.getItems(tal.aList, mycount-1-mycountGet, mycountGet));
        System.out.printf("Getting %s last items from LinkedList: %s%n"
                ,mycountGet,tll.getItems(tll.lList, mycount-1-mycountGet, mycountGet));
        System.out.println("----------------------------------------------------");
        System.out.println("SET method:");
        System.out.println("----------------------------------------------------");
        System.out.println("Setting one first item from ArrayList: "
                +tal.setItems(tal.aList, 0, 1));
        System.out.println("Setting one first item from LinkedList: "
                +tll.setItems(tll.lList, 0, 1));
        System.out.println("Setting one middle item from ArrayList: "
                +tal.setItems(tal.aList, mycount/2, 1));
        System.out.println("Setting one middle item from LinkedList: "
                +tll.setItems(tll.lList, mycount/2, 1));
        System.out.println("Setting one last item from ArrayList: "
                +tal.setItems(tal.aList, mycount-1, 1));
        System.out.println("Setting one last item from LinkedList: "
                +tll.setItems(tll.lList, mycount-1, 1));
        System.out.println("----------------------------------------------------");
        System.out.printf("Setting %s first items from ArrayList: %s%n"
                ,mycountGet,tal.setItems(tal.aList, 0, mycountGet));
        System.out.printf("Setting %s first items from LinkedList: %s%n"
                ,mycountGet,tll.setItems(tll.lList, 0, mycountGet));
        System.out.printf("Setting %s middle items from ArrayList: %s%n"
                ,mycountGet,tal.setItems(tal.aList, mycount/2, mycountGet));
        System.out.printf("Setting %s middle items from LinkedList: %s%n"
                ,mycountGet,tll.setItems(tll.lList, mycount/2, mycountGet));
        System.out.printf("Setting %s last items from ArrayList: %s%n"
                ,mycountGet,tal.setItems(tal.aList, mycount-1-mycountGet, mycountGet));
        System.out.printf("Setting %s last items from LinkedList: %s%n"
                ,mycountGet,tll.setItems(tll.lList, mycount-1-mycountGet, mycountGet));
        System.out.println("----------------------------------------------------");
        System.out.println("ADD method:");
        System.out.println("----------------------------------------------------");
        System.out.println("Adding one first item from ArrayList: "
                +tal.addItems(tal.aList, 0, 1));
        System.out.println("Adding one first item from LinkedList: "
                +tll.addItems(tll.lList, 0, 1));
        System.out.println("Adding one middle item from ArrayList: "
                +tal.addItems(tal.aList, mycount/2, 1));
        System.out.println("Adding one middle item from LinkedList: "
                +tll.addItems(tll.lList, mycount/2, 1));
        System.out.println("Adding one last item from ArrayList: "
                +tal.addItems(tal.aList, mycount, 1));
        System.out.println("Adding one last item from LinkedList: "
                +tll.addItems(tll.lList, mycount, 1));
        System.out.println("----------------------------------------------------");
        System.out.printf("Adding %s first items from ArrayList: %s%n"
                ,mycountGet,tal.addItems(tal.aList, 0, mycountGet));
        System.out.printf("Adding %s first items from LinkedList: %s%n"
                ,mycountGet,tll.addItems(tll.lList, 0, mycountGet));
        System.out.printf("Adding %s middle items from ArrayList: %s%n"
                ,mycountGet,tal.addItems(tal.aList, mycount/2, mycountGet));
        System.out.printf("Adding %s middle items from LinkedList: %s%n"
                ,mycountGet,tll.addItems(tll.lList, mycount/2, mycountGet));
        System.out.printf("Adding %s last items from ArrayList: %s%n"
                ,mycountGet,tal.addItems(tal.aList, mycount, mycountGet));
        System.out.printf("Adding %s last items from LinkedList: %s%n"
                ,mycountGet,tll.addItems(tll.lList, mycount, mycountGet));
    }
}
