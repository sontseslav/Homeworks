package ua.com.iteducate.java.basic.homework.l0017.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="robot")
public class Robot {
	@XmlElement(name="shape")
	private List<Shape> shapes = new ArrayList<>();
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
            //for(int i = 0;i<n;i++){
            for (Shape shape : shapes) {
                sum += shape.calcS();
            }
		//}
		return sum;
	}
        
        public void sortShapesSquare(){
            if (n > 0){
                List shapesToSort = new ArrayList(shapes);
                Collections.sort(shapesToSort);
                for (Shape s:shapes){
                    System.out.println(s);
                }
            }
        }
        
        public void sortShapesPerim(){
            if (n > 0){
                List shapesToSort = new ArrayList(shapes);
                Collections.sort(shapesToSort, new PerimComparator());
                for (Shape s:shapes){
                    System.out.println(s);
                }
            }
        }
}