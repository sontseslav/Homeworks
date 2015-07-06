package ua.com.iteducate.java.basic.homework.l0008.students;

import java.util.HashMap;

public class Main {
	
	
	   public static void main(String[] args) {
                Student st1 = new Student("Vova", "Ivanov", Sex.male, 20, 0);
                Student st2 = new Student("Ivan", "Vovanov", Sex.male, 20, 0);
                HashMap<Student, String> hm1 = new HashMap<>();

                hm1.put(st1,"JavaBase1");
                hm1.put(st2,"JavaBase1");

                System.out.println(hm1);
           }
	
}