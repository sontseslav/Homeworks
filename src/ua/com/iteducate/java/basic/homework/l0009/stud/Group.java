package ua.com.iteducate.java.basic.homework.l0009.stud;


public class Group {
	private Student[] group;
	private int n;
	
	public Group() {
		group = new Student[12];
	}
	
	public void addStudToGroup(Student stud) throws Exception {
		if (group.length == n){
			throw new MyException();
		}
		group[n] = stud;
		n++;
	}
}
