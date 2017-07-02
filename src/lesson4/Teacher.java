package lesson4;

import lesson3.User;

public class Teacher extends User {

	private int salary;

	public Teacher(String userName, String password, int salary) {
		super(userName, password);
		this.salary = salary;

	}

	// this method accepts username and password and creates a Student abject

	public Student createStudent(String username, String password) {
		Student cretaedStudent = new Student(username, password);
		return cretaedStudent;

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
