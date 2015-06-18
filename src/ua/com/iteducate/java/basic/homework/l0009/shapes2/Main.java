package ua.com.iteducate.java.basic.homework.l0009.shapes2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Robot rb = new Robot();
		Scanner scan = new Scanner(System.in);
                System.out.println("Available input format:\n"
                        + "Rectangle-(x1,y1)-(x2,y2)\n"
                        + "Triangle-(x1,y1)-(x2,y2)-(x3,y3)\n"
                        + "Circle-(x1,y1)-(x2,y2)");
                do{
                    System.out.println("Enter coordinates of Shape:");
                    try {
                        rb.addShapes(scan.next());
                        break;
                    } catch (IdenticalPointsException ex) {
                        System.out.println(ex.getMessage());
                    }
                }while (true);
                do{
                    System.out.println("Enter coordinates of Shape:");
                    try {
                        rb.addShapes(scan.next());
                        break;
                    } catch (IdenticalPointsException ex) {
                        System.out.println(ex.getMessage());
                    }
                }while (true);
		do{
                    System.out.println("Enter coordinates of Shape:");
                    try {
                        rb.addShapes(scan.next());
                        break;
                    } catch (IdenticalPointsException ex) {
                        System.out.println(ex.getMessage());
                    }
                }while (true);
		scan.close();
		System.out.println(rb.calsSumS());
		
                rb.sortShapesSquare();
                System.out.println("-------------------------------------------"
                        + "------------------------");
                rb.sortShapesPerim();
		
	}

}
