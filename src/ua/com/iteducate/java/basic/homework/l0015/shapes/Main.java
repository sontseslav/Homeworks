package ua.com.iteducate.java.basic.homework.l0015.shapes;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
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
                        isMoreShapes = (scan.next().equalsIgnoreCase("y"))? true : false;
                    } catch (IdenticalPointsException ex) {
                        System.out.println(ex.getMessage());
                    }
                };
		scan.close();
		System.out.println(rb.calsSumS());
		
		int port = 12345;
		
		try {
			Socket socket = new Socket("localhost", port);
			OutputStream os = socket.getOutputStream();
			rb.serialise(os);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
