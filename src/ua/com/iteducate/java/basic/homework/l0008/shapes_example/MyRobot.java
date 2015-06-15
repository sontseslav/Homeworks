package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

//import sun.security.provider.SHA;

/**
 * Created by Java Base on 04.06.2015.
 */
public abstract class MyRobot {
    private static Shape[] shapes = new Shape[100];
    private static int countShape = 0;


    public static boolean  addShapes(String str) {
        boolean add=false;
        if (countShape<shapes.length) {
            shapes[countShape] = Shape.parse(str);
            add=true;
            countShape++;
        }
        return add;
    }

    public static double sumS(){
        double sum=0;
        for (int i = 0; i<countShape ; i++) {
            sum=sum+shapes[i].square();
        }
        return sum;
    }
}
