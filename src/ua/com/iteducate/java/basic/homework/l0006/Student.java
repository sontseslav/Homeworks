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
public class Student extends Human{
    protected int year;
    protected double averageMark;
    protected Degree degree;
    protected Group group;

    public Student(String name, String surname, Sex sex, int age, int year) {
        super(name, surname, sex, age);
        this.year = year;
    }
    
    protected String getSurname(){
        return surname;
    }
    
    @Override
    public String toString(){
        return "Student: "+name+" "+surname+"\ngender: "+sex+"\nage: "+age 
                + "\nyear: "+year;
    }
}

enum Degree{bachelor, master, PhD}