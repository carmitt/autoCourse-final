package ClassDrill1;

public class main {

	public static void main(String[] args) throws InterruptedException {
		Phone phone=new Phone("089999999");
		
		phone.incomingCall("07888888");
		
		phone.acceptCall();
		
//		Thread.sleep(10000);
		phone.endCall();
		
		phone.outgoingCall("");
		
//		phone.incomingCall("08888888");

	}

}
