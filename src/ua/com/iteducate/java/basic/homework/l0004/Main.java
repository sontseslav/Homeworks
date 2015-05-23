/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0004;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    public static Rectangle rectangle1;
    public static Triangle triangle1;
    public static Circle circle1;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter rectangle coordinates (4 points):");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        int x4 = scan.nextInt();
        int y4 = scan.nextInt();
        rectangle1 = new Rectangle(new int[][]{{x1,y1},{x2,y2},{x3,y3},{x4,y4}});
        System.out.println("Results");
        rectangle1.getSquareAndPerimeter();
        System.out.println("Enter triangle coordinates (3 points):");
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        x2 = scan.nextInt();
        y2 = scan.nextInt();
        x3 = scan.nextInt();
        y3 = scan.nextInt();
        triangle1 = new Triangle(new int[][]{{x1,y1},{x2,y2},{x3,y3}});
        System.out.println("Results");
        triangle1.getSquareAndPerimeter();
        System.out.println("Enter circle coordinates (2 points):");
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        x2 = scan.nextInt();
        y2 = scan.nextInt();
        circle1 = new Circle(new int[][]{{x1,y1},{x2,y2}});
        System.out.println("Results");
        circle1.getSquareAndPerimeter();
        scan.close();
    }
}
