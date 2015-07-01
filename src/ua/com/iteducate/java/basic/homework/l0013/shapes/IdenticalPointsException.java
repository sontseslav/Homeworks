/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0013.shapes;

/**
 *
 * @author user
 */
public class IdenticalPointsException extends Exception{
    
    @Override
    public String getMessage(){
        return "Identical points found! Please, check coordinates!";
    }
}
