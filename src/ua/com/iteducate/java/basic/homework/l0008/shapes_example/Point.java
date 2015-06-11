package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

/**
 * Created by Администратор on 25.05.2015.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString (){
        return ("(" + getX()+","
                 + getY()+")"
        );
    }

    public double calcDist(Point point){
        double hypotenuse=Math.sqrt((Math.pow((this.getX()-point.getX()),2)+
                Math.pow((this.getY()-point.getY()),2)));//c=hypotenuse=Math.sqrt(X.point2-X.point1)^2+(Y.point2-Y.point1)^2
        return  hypotenuse;
    }

    public static Point parse(String string){
        String [] s= string.split(",");
        int x=Integer.parseInt(s[0].substring(1));
        int y=Integer.parseInt(s[1].substring(0,s[1].length()-1));
        return  new Point (x,y);
    }


}
