/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0010.itcompany;

/**
 *
 * @author user
 */
public class PM extends Employee{

    public PM(String name, String surname, int stage, double salary, 
            double halfYearMark) {
        super(name, surname, stage, salary, halfYearMark);
    }

    @Override
    public double calcIncome() {
        return this.salary*(1 + 0.2*this.stage + 0.2*this.halfYearMark 
                + 0.3*this.getProjectInvolvement());
    }
    
}
