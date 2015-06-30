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
    
    protected int myHashCode(Student stud){
    	final int prime = 31;
    	int result = 1;
    	result = prime*result + stud.name.hashCode();
    	result = prime*result + stud.surname.hashCode();
    	result = prime*result + stud.year;
		return 0;
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this == obj) return true;
    	if (obj == null) return false;
    	if (getClass() != obj.getClass()) return false;
    	Student other = (Student) obj;
    	if (this.myHashCode(this) != other.myHashCode(other)) return false;
    	if (this.surname == other.surname && this.name == other.name 
    			&& this.year == other.year) return true;
    	return false;
    }
    
}

enum Degree{bachelor, master, PhD}