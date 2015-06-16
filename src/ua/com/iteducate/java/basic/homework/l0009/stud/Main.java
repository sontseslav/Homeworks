package ua.com.iteducate.java.basic.homework.l0009.stud;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Group grp = new Group();
		Scanner scan = new Scanner(System.in);
		for (int i = 1;i < 19;i++){//only 12 studs allowed
			System.out.println("Adding student №"+i+"...");
			try {
				System.out.println("Enter name, surname and birthday "
						+ "in format dd/MM/yyyy:");
				grp.addStudToGroup(Student.getNewStudent(scan.next(), scan.next(), scan.next()));
			} catch (Exception e) {//All exceptions catched
				e.getMessage();
				e.printStackTrace();
				break;
			}
			System.out.println("Done!");
		}

	}

}
