package ua.com.iteducate.java.basic.homework.l0009.shapes;



public class Rectangle extends Shape{

	public Rectangle(Point pt1, Point pt2) {
		this.points = new Point[]{pt1,pt2};//diagonal
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcS() throws ZeroDistanceException {
		double sqr = (points[0].getX()-points[1].getX())*
				(points[0].getY()-points[1].getY());
		if (sqr == 0) throw new ZeroDistanceException();
		return sqr;
	}
	
	//public String toString(){
	//	return String.format("Rectangle-%s-%s", points[0].toString(),points[1].toString());
	//}
	
	public static Rectangle parse(String[] str){
		//String[] s = str.split("-");
		Point pt1 = Point.parse(str[1]);
		Point pt2 = Point.parse(str[2]);
		return new Rectangle(pt1, pt2);
	}

        @Override
        public double calcPerim() throws ZeroDistanceException {
            double perim = (points[1].getX()-points[0].getX())
            		+(points[1].getY()-points[0].getY());
            if (perim == 0) throw new ZeroDistanceException();
            return perim;
        }
}
