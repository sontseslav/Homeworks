package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 23.05.2015
 * Time: 22:02:36
 * To change this template use File | Settings | File Templates.
 */
public class TestCar {
    public static void main (String [] arg){
        Car car1=new Car ("Deawoo Lanos", "Gray", 120, 2011);
        Car car2=new Car ("Chevrolet Lachetti", "Black", 160, 2007);
        car1.brush(car2);
        car1.show();
        car1.run();
    }
}
