package ua.com.iteducate.java.basic.homework.l0007.robotnew;

public class Rectangle extends Shape{

	public Rectangle(Point pt1, Point pt2) {
		this.points = new Point[]{pt1,pt2};//diagonal
	}
	
	@Override
	public void drow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcS() {
		
		return (points[0].getX()-points[1].getX())*(points[0].getY()-points[1].getY());
	}
	
	public String toString(){
		return String.format("Rectangle-%s-%s", points[0].toString(),points[1].toString());
	}
	
	public static Rectangle parse(String[] str){
		//String[] s = str.split("-");
		Point pt1 = Point.parse(str[1]);
		Point pt2 = Point.parse(str[2]);
		return new Rectangle(pt1, pt2);
	}
}
