import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>, Comparator<Student>{
	private String name;
	private int grade;	
	
	public Student() {}
		
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return name + ": " + grade + "\n";
	}

	@Override
	public int compare(Student stud1, Student stud2) {
		if(stud1.getGrade() - stud2.getGrade() != 0)
			return stud1.getGrade() - stud2.getGrade();
		else 
			return stud1.getName().compareTo(stud2.getName());
	}

	@Override
	public int compareTo(Student stud) {
		return (this.getName()).compareTo(stud.getName());
	}	
	
	public static void sortStudents (List<Student> stList) {
		Collections.sort(stList, new Student());
		System.out.println(stList);
	}
	
	public static void main(String[] args) {
		Student st1 = new Student("Pesho", 6);
		Student st2 = new Student("Gosho", 3);
		Student st3 = new Student("Tosho", 4);
		List<Student> list = new ArrayList<Student>();
		list.add(st1);
		list.add(st2);
		list.add(st3);
		sortStudents(list);	
	}

	
}
