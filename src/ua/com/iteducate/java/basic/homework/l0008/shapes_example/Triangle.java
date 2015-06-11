package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

import java.util.Arrays;

/**
 * Created by Администратор on 25.05.2015.
 */
public class Triangle extends Shape{
    double cathetusFirst=(getPoints()[0].calcDist(getPoints()[1]));//a=cathetusFirst=Y.points1-Y.points0
    double cathetusSecond=(getPoints()[1].calcDist(getPoints()[2]));//b=cathetusSecond=X.points3-X.points0
    double hypotenuse=(int)Math.sqrt((Math.pow(cathetusFirst, 2)+Math.pow(cathetusSecond, 2)));//c=hypotenuse=X.points3-X.points0
    double poluperimeter=((cathetusFirst+cathetusSecond+hypotenuse)/2); //p=(a+b+c)/2
    int radius=(int)Math.sqrt((((poluperimeter-cathetusFirst)*(poluperimeter-cathetusSecond)*(poluperimeter-hypotenuse))/poluperimeter));//	r=Math.sqrt(((p−a)(p−b)(p−c))/p)

    public Triangle(Point[] points) {
        super(points);
    }

    public double perimeter (){
        double perimeter=0;
        perimeter=(cathetusFirst+cathetusSecond+hypotenuse);
        //System.out.println("Perimeter Triangle: "+perimeter);
        return perimeter;
    }

    public double square (){
        double square=0;
        square=(poluperimeter*radius);
        return square;
    }

    public String toString (){
        return ("Triangle" + Arrays.deepToString(getPoints()));
    }

    public  static Triangle parse(String string){
        String [] s=string.split("-");
        Point pt1=Point.parse(s[1]);
        Point pt2=Point.parse(s[2]);
        Point pt3=Point.parse(s[3]);
        Point []points={pt1,pt2,pt3};
        return  new Triangle(points);
    }

}
