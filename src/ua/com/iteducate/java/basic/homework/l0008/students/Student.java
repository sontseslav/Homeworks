/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0008.students;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class Student extends Human{
    private Student[] studInGroup;
    protected int year;
    protected double averageMark;
    protected Degree degree;
    protected Group group;

    public Student(String name, String surname, Sex sex, int age, int averageMark) {
        super(name, surname, sex, age);
        this.averageMark = averageMark;
    }
    
    protected String getSurname(){
        return surname;
    }
    
    public double getAverageMark(){
        return this.averageMark;
    }
    
    @Override
    public String toString(){
        return String.format("Student %s %s %s %d average mark is %.3f", this.name, this.surname, this.sex, this.age, this.averageMark);
    }

    protected void surnameSort(){
        Student stud1 = new Student("Ivan", "Ivanenko", Sex.male, 25, 4);
        Student stud2 = new Student("Iryna", "Petrenko", Sex.female, 24, 3);
        String[] surnames = new String[]{stud1.getSurname(),stud2.getSurname()};
        Arrays.sort(surnames);
        for (String stud:surnames){
            System.out.println(stud);
        }
    }
    
    
}

enum Degree{bachelor, master, PhD}