package ua.com.iteducate.java.basic.homework.l0007.robotnew;

public class Triangle extends Shape{

	public Triangle(Point pt1, Point pt2, Point pt3) {
		this.points = new Point[]{pt1,pt2,pt3};
	}
	
	
	@Override
	public void drow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcS() {
		double a = points[0].calcDist(points[1]);
		double b = points[1].calcDist(points[2]);
		double c = points[0].calcDist(points[2]);
		double perim = a+b+c;
		perim /=2;
		return Math.sqrt((perim)*(perim-a)*(perim-b)*(perim-c));
	}
	
	public static Triangle parse(String[] str){
		//String[] s = str.split("-");
		Point pt1 = Point.parse(str[1]);
		Point pt2 = Point.parse(str[2]);
		Point pt3 = Point.parse(str[3]);
		return new Triangle(pt1, pt2, pt3);
	}

}
