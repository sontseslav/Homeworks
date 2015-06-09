package ua.com.iteducate.java.basic.homework.l0007.robotnew;

public class Robot {
	private Shape[] shapes = new Shape[100];
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
}
