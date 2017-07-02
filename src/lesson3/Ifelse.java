package lesson3;

public class Ifelse {
	
	boolean userExist = getUserExist();

	boolean userLoggedIn = getUserLoggedIn();

	public void ifelse() {

		

		if (userExist == false) {
			// create new user
		} else if (userLoggedIn == false) {
			//perform login
		}

	}
	
	
	public void nestedIfelse(int counter,boolean update){
		
		if(counter==0){
			if(update==true){
				//perform update
			}
			else{
				//delete
			}
		}
		else if(counter==3){
			//do action 3
		}
		
	}

	private boolean getUserLoggedIn() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean getUserExist() {
		// TODO Auto-generated method stub
		return false;
	}

}
