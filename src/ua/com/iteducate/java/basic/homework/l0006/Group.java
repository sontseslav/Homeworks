/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0006;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Group {
    private final int studQuantity = 3;
    private Student[] studInGroup;
    
    protected Group(){
        this.studInGroup = new Student[studQuantity];
    }
    
    protected void fillGroup(){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i<studQuantity;i++){
            System.out.println("Enter student's personal data:"
                    + "\n(name surname sex age year)");
            studInGroup[i] = new Student(scan.next(), scan.next(), 
                    Sex.valueOf(scan.next()), scan.nextInt(), scan.nextInt());
        }
        scan.close();
    }
    
    protected Student findStud(String surname){//surnames are unique
        if (studInGroup[0] == null) return null;
        for (int i = 0; i<studQuantity;i++){
            if (studInGroup[i].getSurname().equals(surname)) return studInGroup[i];
        }
        return null;
    }
}
