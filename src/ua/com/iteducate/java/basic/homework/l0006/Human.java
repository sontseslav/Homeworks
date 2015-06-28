/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0006;

/**
 *
 * @author user
 */
public class Human {
    protected String name;
    protected String surname;
    protected Sex sex;
    protected int age;
    
    protected Human(String name, String surname, Sex sex, int age){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }
    
    @Override
    public String toString(){
        return "Person: "+name+" "+surname+"\ngender: "+sex+"\nage: "+age;
    }
}

enum Sex {male,female}
