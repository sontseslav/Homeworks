package ua.com.iteducate.java.basic.homework.l0009.shapes;

import java.util.Comparator;



public abstract class Shape implements Comparable{
	protected Point[] points;

        /*@Override
        public int compareTo(Object t) {
            Shape shape = (Shape) t;
            if (this.calcS() > shape.calcS()) {
                return 1;
            } else if (this.calcS() < shape.calcS()) {
                return -1;
            }
            return 0;
        }*/
        
        @Override
        public String toString(){
        	double a = 0, b = 0;
        	try{
        		a = this.calcS();
        		b = this.calcPerim();
        	}catch (ZeroDistanceException e){
        		e.printStackTrace(System.out);
        	}
            return String.format("Shape of %s: it's square is %.4f, perimeter - %.2f", 
                    this.getClass().getSimpleName(), a, b);
        }
        
	private enum Shapes {Circle, Triangle, Rectangle};
	
	public abstract void draw();
	public abstract double calcS() throws ZeroDistanceException;
    public abstract double calcPerim() throws ZeroDistanceException;
	
	public static Shape parse(String str){
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
        double a = 0, b = 0;
    	try{
    		a = shape1.calcS();
    		b = shape2.calcPerim();
    	}catch (ZeroDistanceException e){
    		e.printStackTrace(System.out);
    	}
        if (a > b){
            return 1;
        }else if (a < b){
            return -1;
        }
        return 0;
    }

}