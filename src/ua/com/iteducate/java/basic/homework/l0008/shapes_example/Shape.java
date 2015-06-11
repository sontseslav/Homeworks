package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

/**
 * Created by Администратор on 25.05.2015.
 */
public abstract class Shape {
    protected Point[]points;

    public Shape(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public abstract double perimeter();

    public abstract double square ();

    //polymorphism java
    public final void  show (Shape shape){
        System.out.println("Test Polymorphism. This method got shape - "+shape.getClass().getSimpleName());
    }

    public static Shape parse (String str){
        Shape result;
        String[]s=str.split("-");
        switch (s[0]){
            case "Rectangle": {
                return Rectangle.parse(str);
            }
            case "Triangle": {
                return  Triangle.parse(str);
            }
            case "Circle": {
                return  Circle.parse(str);
            }
            default: return null;
        }

    }
}
