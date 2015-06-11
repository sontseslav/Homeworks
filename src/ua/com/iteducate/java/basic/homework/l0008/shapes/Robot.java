package ua.com.iteducate.java.basic.homework.l0008.shapes;

import java.util.Arrays;



public class Robot {
	private Shape[] shapes = new Shape[3];
	private int n = 0;
	
	public Robot() {
		
	}
	
	public void addShapes(String str){
		if (n<this.shapes.length){
			this.shapes[n] = Shape.parse(str);
		}
		n++;
	}
	
	public double calsSumS(){
		double sum = 0;
		for(int i = 0;i<n;i++){
			sum += this.shapes[i].calcS();
		}
		return sum;
	}
        
        public void sortShapesSquare(){
            if (n > 0){
                Arrays.sort(shapes);
                for (Shape s:shapes){
                    System.out.println(s);
                }
            }
        }
        
        public void sortShapesPerim(){
            if (n > 0){
                Arrays.sort(shapes, new PerimComparator());
                for (Shape s:shapes){
                    System.out.println(s);
                }
            }
        }
}