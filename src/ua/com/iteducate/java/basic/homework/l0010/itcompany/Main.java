/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0010.itcompany;

/**
 *
 * @author user
 * 
 */
public class Main {
    
    public static void main(String[] args) {
    
        try {
            Company.hireEmployees();
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        
    
    }
}
