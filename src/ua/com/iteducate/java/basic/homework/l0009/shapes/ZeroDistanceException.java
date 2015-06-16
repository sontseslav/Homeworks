package ua.com.iteducate.java.basic.homework.l0009.shapes;

public class ZeroDistanceException extends Exception{

	/**
	 * What is this?
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "Two points cannot have the same coordinates!";
	}

}
