package ua.com.iteducate.java.basic.homework.l0009.shapes2;


public class Point {
	private final int x;
	private final int y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcDist(Point pt2){
		//check if x=y ||y=y for optimization
		return Math.sqrt(Math.pow(this.x-pt2.x,2)
				+Math.pow(this.y-pt2.y, 2));
	}
	
        @Override
	public String toString(){
		return String.format("(%s,%s)", x,y);
	}
	
	public static Point parse(String str){//str to int
		String[] s = str.split(",");
		int x = Integer.parseInt(s[0].substring(1));
		int y = Integer.parseInt(s[1].substring(0,s[1].length()-1));
		return new Point(x, y);
	}
}
