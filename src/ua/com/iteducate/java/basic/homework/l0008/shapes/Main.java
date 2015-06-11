package ua.com.iteducate.java.basic.homework.l0008.shapes;


public class Main {

	public static void main(String[] args) {
		Robot rb = new Robot();
		
		rb.addShapes("Rectangle-(10,20)-(22,44)");
		rb.addShapes("Triangle-(1,2)-(12,14)-(10,9)");
		rb.addShapes("Circle-(10,12)-(10,15)");
		
		System.out.println(rb.calsSumS());
		
                rb.sortShapesSquare();
                System.out.println("-------------------------------------------"
                        + "------------------------");
                rb.sortShapesPerim();
		/*
		Point pt1 = new Point(10,20);
		Point pt2 = new Point(22, 44);
		double dist = pt1.calcDist(pt2);
		System.out.println(dist);
		System.out.println(pt1);
		System.out.println(pt2);
		Rectangle r1 = new Rectangle(pt1, pt2);
		System.out.println(r1.calcS());
		System.out.println(r1);
		Point ppp = Point.parse("(22,44)");
		
		Shapes rrr = Shapes.parse("Rectangle-(10,20)-(22,44)");
		
		System.out.println(rrr);
		*/
	}

}
