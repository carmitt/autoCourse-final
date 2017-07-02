package lesson3;

public class Admin extends User {

	public Admin(String userName, String password) {
		super(userName, password);

	}

	public User createUser(String userName, String password) {

		// check if user name already exist

		// check if password is valid

		User createdUser = new User(userName, password);

		return createdUser;
	}

}
