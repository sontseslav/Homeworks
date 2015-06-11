package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

import java.util.Arrays;

/**
 * Created by Администратор on 25.05.2015.
 */
public class Circle extends Shape {
    private Point centre;
    private int radius;

    public Circle(Point [] points, Point centre, int radius) {
        super(points);
        this.centre = centre;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public String toString (){
        System.out.print("Circle: ");
        return ("Centre: " + getCentre()
                + ", Radius = " + getRadius()
        );
    }

    @Override
    public double perimeter() {
        int perimeter= (int) (2*Math.PI*getRadius());//P=2PR
        return perimeter;
    }

    @Override
    public double square (){
        double square=(Math.PI*Math.pow(this.getRadius(),2));//S=π*r2
        return square;
    }

    public static Shape parse(String string){
        //    Circle circle=new Circle(points,points[0],5);
        String []str=string.split("-");
        Point centre=Point.parse(str[1]);
        int radius=Integer.parseInt(str[2]);
        return new Circle(null,centre,radius);
    }

}
