package ua.com.iteducate.java.basic.homework.l0009.stud;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student {
	private String name;
	private String surnme;
	private Date birthdate;
	
	private Student(String name, String surname, Date birthdate){
		this.name = name;
		this.surnme = surname;
		this.birthdate = birthdate;
	}
	
	public static Student getNewStudent(String name, String surname, String birthdate) throws Exception {//Fabric method
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = format.parse(birthdate);
		DateFormat dYear = new SimpleDateFormat("yyyy");
		int year = Integer.parseInt(dYear.format(birthDate));
		Calendar now = Calendar.getInstance();
		int presentYear = now.get(Calendar.YEAR);
		if ((presentYear - year < 16) || (presentYear - year > 75)){
			throw new WrongDateException();
		}
		return new Student(name, surname, birthDate);
	}
	
	/*public static void main(String[] args) {
		try{
			Student s = Student.getNewStudent(12000);
		}catch(Exception ex){
			System.out.println(ex.getClass().getSimpleName());
			ex.printStackTrace();
		}
	}*/
}
