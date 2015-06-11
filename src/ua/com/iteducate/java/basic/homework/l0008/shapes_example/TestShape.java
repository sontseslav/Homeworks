package ua.com.iteducate.java.basic.homework.l0008.shapes_example;


import java.awt.*;

/**
 * Created by Администратор on 25.05.2015.
 */
public class TestShape {
    public static void main(String[] args) {
        Point point1=new Point(0,0);
        Point point2=new Point(0,4);
        Point point3=new Point(8,4);
        Point point4=new Point(8,0);
        Point[] points={point1,point2,point3,point4};

        Rectangle rectangle =new Rectangle(points);
        Circle circle=new Circle(points,points[0],5);
        Triangle triangle=new Triangle(points);

        System.out.println(rectangle);
        System.out.println(triangle);
        System.out.println(circle);

        System.out.println("Perimeter r: "+rectangle.perimeter());//24
        System.out.println("Perimeter t: "+triangle.perimeter());//20
        System.out.println("Perimeter c: "+circle.perimeter());//31

        System.out.println("Square r: "+rectangle.square());//32
        System.out.println("Square t: "+triangle.square());//10
        System.out.println("Square c: "+circle.square());//78

        rectangle.show(rectangle);//polymorphism java
        rectangle.show(circle);//polymorphism java

        MyRobot.addShapes("Rectangle-(0,0)-(0,4)-(8,4)-(8,0)");
        MyRobot.addShapes("Triangle-(0,0)-(0,4)-(8,4)");
        MyRobot.addShapes("Circle-(0,0)-5");

        double sumSquare= MyRobot.sumS();
        System.out.println(sumSquare);
    }
}
