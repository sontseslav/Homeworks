/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.myrobot;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    protected Shape[] shapeStorage;
    private int figuresQuant;
    private enum Shapes {circle, triangle, rectangle};
    
    protected Main(){
        businessLogic();
    }
    
    private void businessLogic(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter quantity of figures:");
        figuresQuant = scan.nextInt();
        shapeStorage = new Shape[figuresQuant];
        for(int i = 0; i<figuresQuant; i++){
            System.out.println("Chose type of figure: "+Arrays.toString(Shapes.values()));
            switch (Shapes.valueOf(scan.next())){
                case circle:
                    System.out.println("Enter coordinates of "+Shapes.circle+":");
                    Shape circle = new Circle(new int[][]{{scan.nextInt(),
                        scan.nextInt()},{scan.nextInt(),scan.nextInt()}});
                    shapeStorage[i] = circle;
                    break;
                case triangle:
                    System.out.println("Enter coordinates of "+Shapes.triangle+":");
                    Shape triangle = new Triangle(new int[][]{{scan.nextInt(),
                        scan.nextInt()},{scan.nextInt(),scan.nextInt()},
                        {scan.nextInt(),scan.nextInt()}});
                    shapeStorage[i] = triangle;
                    break;
                case rectangle:
                    System.out.println("Enter coordinates of "+Shapes.rectangle+":");
                    Shape rectangle = new Rectangle(new int[][]{{scan.nextInt(),
                        scan.nextInt()},{scan.nextInt(),scan.nextInt()},{scan.nextInt(),
                        	scan.nextInt()},{scan.nextInt(),scan.nextInt()}});
                    shapeStorage[i] = rectangle;
                    break;
            }
        }
        Robot robot = new Robot(shapeStorage);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
