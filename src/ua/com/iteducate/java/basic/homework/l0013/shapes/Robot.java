package ua.com.iteducate.java.basic.homework.l0013.shapes;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Robot  implements Serializable, Cloneable{
    private static final long serialVersionUID = 1L;
    private LinkedList<Shape> shapes = new LinkedList<>();
    private int n = 0;

    public Robot() {

    }

    public void addShapes(String str) throws IdenticalPointsException{
            if (n<=this.shapes.size()){
                    this.shapes.add(0,Shape.parse(str));
            }
            n++;
    }

    public double calsSumS(){
            double sum = 0;
            for(int i = 0;i<n;i++){
                    sum += this.shapes.get(i).calcS();
            }
            return sum;
    }

    public void sortShapesSquare(){
        if (n > 0){
            Collections.sort(shapes);
            for (Shape s:shapes){
                System.out.println(s);
            }
        }
    }

    public void sortShapesPerim(){
        if (n > 0){
            Collections.sort(shapes, new PerimComparator());
            for (Shape s:shapes){
                System.out.println(s);
            }
        }
    }

    public void draw(){
        for (Shape shape : shapes){
            System.out.println(shape.toString());
        }
    }

    public void saveShapesToFile(){
        StringBuilder sb = new StringBuilder();
        for (Shape shape : shapes){
            sb.append(shape.toString()).append("\n");
        }
        sb.append("\nTotal square of objects is: ").append(calsSumS());
        SaveToFile saver = new SaveToFile(sb.toString(), "SavedShapes.txt");
        try{
            saver.doSave();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}