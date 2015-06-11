package ua.com.iteducate.java.basic.homework.l0008.shapes_example;

/**
 * Homework_Week_2_ITEduction_21:45
 */
public class Car {
    private String name;
    private String color;
    private int speed;
    private int year;

    public Car(String name, String color, int speed, int year) {
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed>=40 & speed<300)  {
        this.speed = speed;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year>=1880 & year<=2015)
        this.year = year;
    }

    public void run (){
        System.out.println(this.name+" run to street");
    }

    public void brush (Car car){
        String tempColor=car.getColor();
        car.setColor(this.getColor());
        this.setColor(tempColor);
    }

   public void show (){
       System.out.format("      Name      |       Color      |      Speed      |      Year      |\n " +
               "%12s    %12s   %15d   %15d\n"
               , name, color, speed, year);
   }

}
