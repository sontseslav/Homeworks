package ua.com.iteducate.java.basic.homework.l0010.shapes;

public class Triangle extends Shape{
        private double perim;
    
	public Triangle(Point pt1, Point pt2, Point pt3) {
		this.points = new Point[]{pt1,pt2,pt3};
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcS() {
            double a = points[0].calcDist(points[1]);
            double b = points[1].calcDist(points[2]);
            double c = points[0].calcDist(points[2]);
            perim = a + b + c;
            return Math.sqrt((perim/2) * (perim/2 - a) * (perim/2 - b) * (perim/2 - c));
        }
	
	public static Triangle parse(String[] str) throws IdenticalPointsException{
		//String[] s = str.split("-");
		Point pt1 = Point.parse(str[1]);
		Point pt2 = Point.parse(str[2]);
		Point pt3 = Point.parse(str[3]);
                checkIdenticalPoints(pt1, pt2, pt3);
		return new Triangle(pt1, pt2, pt3);
	}

        @Override
        public double calcPerim() {
            if (perim != 0) return perim;
            double a = points[0].calcDist(points[1]);
            double b = points[1].calcDist(points[2]);
            double c = points[0].calcDist(points[2]);
            perim = a + b + c;
            return perim;
        }
        
        public static void checkIdenticalPoints(Point pt1, Point pt2, Point pt3) 
                throws IdenticalPointsException{
            if (pt1.getX() == pt2.getX() && pt1.getY() == pt2.getY() 
                    || pt1.getX() == pt3.getX() && pt1.getY() == pt3.getY()
                    || pt3.getX() == pt2.getX() && pt3.getY() == pt2.getY()){
                throw new IdenticalPointsException();
            }
        }

}
