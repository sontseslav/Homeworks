package ua.com.iteducate.java.basic.homework.l0010.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Robot {
	private ArrayList<Shape> shapes = new ArrayList<>();
	private int n = 0;
	
	public Robot() {
		
	}
	
	public void addShapes(String str) throws IdenticalPointsException{
		if (n<=this.shapes.size()){
			this.shapes.add(Shape.parse(str));
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
}