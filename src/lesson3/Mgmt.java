package lesson3;

import lesson4.Coordinator;
import lesson4.Student;
import lesson4.Teacher;

public class Mgmt {

	public static void main(String[] args) {

		// creating admin object
		Admin admin = new Admin("omer", "1234");

		// User object created by the admin (by the createUser method)
		User user1 = admin.createUser("user1", "qwerty");

		// running the login method on user1 object
		user1.login(user1.getUsername(), user1.getPassword());

		Teacher teacher1 = new Teacher("bella", "assddff",2000);
		Student sami = teacher1.createStudent("sami", "123456");

		Coordinator coordinator = new Coordinator("baba", "ali");

		coordinator.addTeacher("nnnn", "aaaa");
	}

}
