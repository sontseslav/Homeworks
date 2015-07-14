package ua.com.iteducate.java.basic.homework.l0016.shapes;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Robot rb = new Robot();
		Scanner scan = new Scanner(System.in);
                boolean isMoreShapes = true;
                System.out.println("Available input format:\n"
                        + "Rectangle-(x1,y1)-(x2,y2)\n"
                        + "Triangle-(x1,y1)-(x2,y2)-(x3,y3)\n"
                        + "Circle-(x1,y1)-(x2,y2)");
                while (isMoreShapes){
                    System.out.println("Enter coordinates of Shape:");
                    try {
                        rb.addShapes(scan.next());
                        System.out.println("More shapes? y/n");
                        isMoreShapes = (scan.next().equalsIgnoreCase("y"));
                    } catch (IdenticalPointsException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
		scan.close();
		System.out.println(rb.calsSumS());
		
		SaveToDB stdb = new SaveToDB(rb);
		try{
			stdb.showShapesInDB();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		try{
			stdb.storeToDB();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		try{
			stdb.showShapesInDB();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

}
