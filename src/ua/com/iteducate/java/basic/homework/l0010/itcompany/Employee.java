/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0010.itcompany;

import java.util.ArrayList;
//import java.util.Random;

/**
 *
 * @author user
 * 
 */
public class Employee  {

    protected String name;
    protected String surname;
    protected double halfYearMark;
    protected ArrayList<Project> projectList = new ArrayList<>();
    protected double salary;
    protected int stage; //job seniority
    protected double income;

    public Employee(String name, String surname, int stage, double salary, 
            double halfYearMark) {
        this.name = name;
        this.surname = surname;
        this.stage = stage;
        this.salary = salary;
        this.halfYearMark = halfYearMark;
    }

    public String getProjectList() {
        StringBuilder sb = new StringBuilder();
        for (Project proj : projectList){
            sb.append(proj.name);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void add2ProjectList(Project proj) {
        this.projectList.add(proj);
    }
    
    public int getProjectInvolvement(){
        return this.projectList.size();
    }
    
    public static <T extends Employee> T createEmployee(String name, 
            String surname, int stage, double salary, double halfYearMark){
        return (T) new Employee(name, surname, stage, salary, halfYearMark);
    }
    
    public double calcIncome(){
        return 0;
    }
    
    
    
//    @Override
//    public String toString(){
//        
//    }
}
