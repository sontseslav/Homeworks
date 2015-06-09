package ua.com.iteducate.java.basic.homework.l0007.robotnew;

public abstract class Shape {
	protected Point[] points;
	private enum Shapes {Circle, Triangle, Rectangle};
	
	public abstract void drow();
	public abstract double calcS();
	
	public static Shape parse(String str){
		String [] s = str.split("-");
		
		switch(Shapes.valueOf(s[0])){
		case Rectangle: return Rectangle.parse(s);//rect returns as shape
		case Triangle: return Triangle.parse(s);
		case Circle: return Circle.parse(s);
		default: return null;
		}
		
	}
}
