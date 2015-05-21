/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0002;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Seasons {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть місяць: ");
        String month = scan.next();
        if (month.equalsIgnoreCase("грудень")|month.equalsIgnoreCase("січень")
                |month.equalsIgnoreCase("лютий"))
            System.out.println("Зима");
        else if (month.equalsIgnoreCase("березень")|month.equalsIgnoreCase("квітень")
                |month.equalsIgnoreCase("травень"))
            System.out.println("Весна");
        else if (month.equalsIgnoreCase("червень")|month.equalsIgnoreCase("липень")
                |month.equalsIgnoreCase("серпень"))
            System.out.println("Літо");
        else if (month.equalsIgnoreCase("вересень")|month.equalsIgnoreCase("жовтень")
                |month.equalsIgnoreCase("листопад"))
            System.out.println("Осінь");
        else 
            System.out.println("Немає такого місяця");
    }
}
