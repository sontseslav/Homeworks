package ua.com.iteducate.java.basic.homework.l0009.shapes;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Robot rb = new Robot();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter coords of rectangle's diagonal\n"
				+ "(e.g.:\"Rectangle-(x1,y2)-(x2,y2)\"):");
		rb.addShapes(scan.next());
		System.out.println("Enter coords of triangle's peaks\n"
				+ "(e.g.:\"Triangle-(x1,y2)-(x2,y2)-(x3,y3)\"):");
		rb.addShapes(scan.next());
		System.out.println("Enter coords of circle's radius\n"
				+ "(e.g.:\"Circle-(x1,y2)-(x2,y2)\"):");
		rb.addShapes("Circle-(10,12)-(10,15)");
		scan.close();
		try {
			System.out.println(rb.calsSumS());
		} catch (ZeroDistanceException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
                /*rb.sortShapesSquare();
                System.out.println("-------------------------------------------"
                        + "------------------------");
                rb.sortShapesPerim();*/
	}

}
