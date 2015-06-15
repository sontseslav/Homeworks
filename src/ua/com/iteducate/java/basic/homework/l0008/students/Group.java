/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0008.students;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Group{
    private final int studQuantity = 12;
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
    
    protected void laizyFillGroup(){
        Random rand = new Random();
        studInGroup[0] = new Student("Свирид", "Голохвастов", Sex.valueOf("male"), 32, rand.nextInt(100));
        studInGroup[1] = new Student("Проня", "Голохвастова", Sex.valueOf("female"), 29, rand.nextInt(100));
        studInGroup[2] = new Student("Світлана", "Антонович", Sex.valueOf("female"), 30, rand.nextInt(100));
        studInGroup[3] = new Student("Віолета", "Петрик", Sex.valueOf("female"), 32, rand.nextInt(100));
        studInGroup[4] = new Student("Бадя", "Хрєнова", Sex.valueOf("female"), 31, rand.nextInt(100));
        studInGroup[5] = new Student("Розалія", "Фройд", Sex.valueOf("female"), 28, rand.nextInt(100));
        studInGroup[6] = new Student("Зоя", "Олексієнко", Sex.valueOf("female"), 30, rand.nextInt(100));
        studInGroup[7] = new Student("Ізольда", "Вульф", Sex.valueOf("female"), 30, rand.nextInt(100));
        studInGroup[8] = new Student("Фріда", "Айнс", Sex.valueOf("female"), 30, rand.nextInt(100));
        studInGroup[9] = new Student("Гюльчатай", "Іваненко", Sex.valueOf("female"), 30, rand.nextInt(100));
        studInGroup[10] = new Student("Брнонхільда", "Степаненко", Sex.valueOf("female"), 30, rand.nextInt(100));
        studInGroup[11] = new Student("Юлія", "Грогорович", Sex.valueOf("female"), 30, rand.nextInt(100));
    }
    
    protected Student findStud(String surname){//surnames are unique
        if (studInGroup[0] == null) return null;
        for (int i = 0; i<studQuantity;i++){
            if (studInGroup[i].getSurname().equals(surname)) return studInGroup[i];
        }
        return null;
    }
    
    protected void sortAverageMark() {
		Arrays.sort(studInGroup, new StudComparator());
		for (Student stud : studInGroup){
			System.out.println(stud);
		}
	}

}
