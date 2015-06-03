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
public class HumanRunner {
    public static void main(String[] args) {
        Human person = new Human("Ivan", "Ivanenko", Sex.male, 25);
        System.out.println(person);
        Student ivan = new Student("Ivan", "Ivanenko", Sex.male, 25, 4);
        System.out.println(ivan);
        Human iryna = new Student("Iryna", "Petrenko", Sex.female, 24, 3);
        //despite of type uses Student method
        System.out.println(iryna);
        Group mzd = new Group();
        //null
        System.out.printf("Found student with surname %s %n"
                +mzd.findStud("Ivanenko")+"\n","Ivanenko");
        mzd.fillGroup();
        System.out.printf("Found student with surname %s %n"
                +mzd.findStud("Ivanenko")+"\n","Ivanenko");
    }
}
