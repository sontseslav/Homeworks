package ua.com.iteducate.java.basic.homework.l0008.students;

import java.util.Comparator;

public class StudComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student stud1 = (Student)o1;
		Student stud2 = (Student)o2;
		if (stud1.averageMark > stud2.averageMark){
			return 1;
		}else if (stud1.averageMark < stud2.averageMark){
			return -1;
		}
		return 0;
	}

}
