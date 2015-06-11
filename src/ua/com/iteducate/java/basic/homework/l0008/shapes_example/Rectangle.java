package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

import sun.security.provider.SHA;

import java.util.Arrays;

/**
 * Created by Администратор on 25.05.2015.
 */
public class Rectangle extends Shape {

    public Rectangle(Point[] points) {
        super(points);
    }

    public double perimeter (){
        double perimeter=0;
        double a=(getPoints()[1].getY()-getPoints()[0].getY());//a=Y.points1-Y.points0
        double b=(getPoints()[3].getX()-getPoints()[0].getX());//b=X.points3-x.points0
        perimeter=(a+b)*2;
       // System.out.println("Perimeter Rectangle: "+perimeter);
        return perimeter;
    }

    public double square (){
        double square=0;
        int a=(getPoints()[1].getY()-getPoints()[0].getY());//a=Y.points1-Y.points0
        int b=(getPoints()[3].getX()-getPoints()[0].getX());//b=X.points3-x.points0
        square=(a*b);
        //System.out.println("Square Rectangle: " +square);
        return square;
    }

    public String toString (){
        return ("Rectangle" + Arrays.deepToString(getPoints()));
    }

    public  static Rectangle parse(String string){
       String [] s=string.split("-");
       Point pt1=Point.parse(s[1]);
       Point pt2=Point.parse(s[2]);
       Point pt3=Point.parse(s[3]);
       Point pt4=Point.parse(s[4]);
       Point [] points={pt1,pt2,pt3, pt4};
       return  new Rectangle(points);
    }
}
