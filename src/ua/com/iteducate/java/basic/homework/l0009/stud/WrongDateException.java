package ua.com.iteducate.java.basic.homework.l0009.stud;

public class WrongDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override 
	public String getMessage(){
		return "Student is too old or too young!";
	}

}
