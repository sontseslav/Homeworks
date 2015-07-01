package ua.com.iteducate.java.basic.homework.l0009.shapes;


public class Circle extends Shape{
	
	public Circle(Point pt1, Point pt2) {
		this.points = new Point[]{pt1,pt2};
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcS() throws ZeroDistanceException {
		return Math.PI*Math.pow(points[0].calcDist(points[1]),2);
	}
	
	public static Circle parse(String[] str) {
		Point pt1 = Point.parse(str[1]);
		Point pt2 = Point.parse(str[2]);
		return new Circle(pt1, pt2);
	}

        @Override
        public double calcPerim() throws ZeroDistanceException {
            return 2*Math.PI*Math.pow(points[0].calcDist(points[1]),2);
        }


		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

}
