package lesson3;

public class While {
	
	
	public void doWhile() throws Exception{
		boolean dbUpdated = false;
		int elapsedTime=0;
		while (dbUpdated==false) {	
			if(elapsedTime>60){
				break;
			}
			System.out.println("Wait for db update");
			Thread.sleep(5000);
		}
	}

}
