package lesson4;

import lesson3.User;

public class Coordinator extends User {

	int defaultTeacherSalary = 6000;

	public Coordinator(String userName, String password) {
		super(userName, password);

	}

	public Teacher addTeacher(String name, String password, int salary) {
		Teacher createdTeacher = new Teacher(name, password, salary);

		return createdTeacher;
	}

	public Teacher addTeacher(String name, String password) {
		return addTeacher(name, password,defaultTeacherSalary);
	}

}
