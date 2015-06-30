/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0012.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author user
 */
public class Main {
    private Map<Integer,String> db;

    public Main() {
        this.db = new HashMap<>();
    }
    
    public void setUser(String user){
        if (db.isEmpty()) db.put(1, user);
        else{
            Set<Integer> keys = db.keySet();
            int keyMax = Collections.max(keys);
            db.put(++keyMax, user);
        }
    }
    
    public void listAllUsers(){
        if (db.isEmpty()) System.out.println("Empty DB");
        else{
            for (int i = Collections.max(db.keySet());db.get(i)!=null && i > 0;i--){
            System.out.println(i+" : "+db.get(i));
            }
        }
    }
    
    public void delUser(int i){
        if (db.containsKey(i)) db.remove(i);
        else System.out.println("Not found");
    }
    
    public String getUser(int i){
        return db.getOrDefault(i, "Not found");
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        //m.listAllUsers();
        m.setUser("Ivan");
        m.setUser("Petro");
        m.setUser("Ignat");
        System.out.println(m.getUser(1));
        //m.listAllUsers();
        m.delUser(2);
        m.delUser(10);
        //m.listAllUsers();
    }
    
    
}
