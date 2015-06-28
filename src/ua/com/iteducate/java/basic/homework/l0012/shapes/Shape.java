package ua.com.iteducate.java.basic.homework.l0012.shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable{
	protected Point[] points;

        @Override
        public int compareTo(Object t) {
            Shape shape = (Shape) t;
            if (this.calcS() > shape.calcS()) {
                return 1;
            } else if (this.calcS() < shape.calcS()) {
                return -1;
            }
            return 0;
        }
        
        @Override
        public String toString(){
            return String.format("Shape of %s: it's square is %.4f, perimeter - %.2f", 
                    this.getClass().getSimpleName(), this.calcS(), this.calcPerim());
        }
        
	private enum Shapes {Circle, Triangle, Rectangle};
	
	public abstract void draw();
	public abstract double calcS();
        public abstract double calcPerim();
	
        public static void checkIdenticalPoints(Point pt1, Point pt2) 
                throws IdenticalPointsException{
            if (pt1.getX() == pt2.getX() && pt1.getY() == pt2.getY()){
                throw new IdenticalPointsException();
            }
        }
        
	public static Shape parse(String str) throws IdenticalPointsException{
		String [] s = str.split("-");
		
		switch(Shapes.valueOf(s[0])){
		case Rectangle: return Rectangle.parse(s);//rect returns as shape
		case Triangle: return Triangle.parse(s);
		case Circle: return Circle.parse(s);
		default: return null; //never been executed
		}
		
	}
}

class PerimComparator implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        Shape shape1 = (Shape)t;
        Shape shape2 = (Shape)t1;
        if (shape1.calcPerim() > shape2.calcPerim()){
            return 1;
        }else if (shape1.calcPerim() < shape2.calcPerim()){
            return -1;
        }
        return 0;
    }

}