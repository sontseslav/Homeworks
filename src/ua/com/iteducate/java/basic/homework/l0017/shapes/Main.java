package ua.com.iteducate.java.basic.homework.l0017.shapes;

import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
		
		File file = new File("robot.xml");
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Robot.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(rb, file);
			marshaller.marshal(rb, System.out);
		}catch(JAXBException ex){
			ex.printStackTrace();
		}
                
		
	}

}
