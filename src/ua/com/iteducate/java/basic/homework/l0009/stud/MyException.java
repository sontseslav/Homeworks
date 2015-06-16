package ua.com.iteducate.java.basic.homework.l0009.stud;

public class MyException extends Exception {
	@Override
	public String getMessage(){
		return "Students group is already full!";
	}
}
