/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0010.itcompany;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Project {
    protected final String name;
    protected ArrayList<Employee> participants = new ArrayList<>();
    private double budget;
    private static int projCounter;

    public Project(String name) {
        this.name = name;
        projCounter++;
    }

    public static int getProjCounter() {
        return projCounter;
    }

    public String getParticipantsList() {
        StringBuilder sb = new StringBuilder();
        for (Employee empl : participants){
            sb.append(empl.name);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void add2Participants(Employee empl) {
        this.participants.add(empl);
    }
    
    public void calcBudget(){
        for (Employee empl : participants){
            this.budget += empl.calcIncome();
        }
    }
}
