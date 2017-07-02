package ClassDrill1;

import java.util.Random;

public class Phone {

	private String phoneNumber;

	private String incomingNumber;

	private boolean isRinging;

	private boolean hasLine;

	private boolean inCall;

	public Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.hasLine = true;
		this.inCall = false;
	}

	public void incomingCall(String incomingPhoneNumber) {
		if (hasLine == true && inCall == false) {
			isRinging = true;
			incomingNumber = incomingPhoneNumber;

			System.out.println("Accepting call");
		} else {
			System.out.println("Not accepting call");
		}
		
		
		
	}

	public void outgoingCall(String outgoingNumber) throws InterruptedException {
		boolean callAccepted = false;

		int numberOfRings = 0;

		int mockNumberOfRings = getRandomNumber();
		
		System.out.println("Mock: "+mockNumberOfRings);

		if (hasLine == true) {

			while (numberOfRings < 5) {
				if (numberOfRings==mockNumberOfRings) {
					System.out.println("Call accepted");
					callAccepted = true;
					break;
				} else {

					System.out.println("Waiting for call answer");
					numberOfRings++;
					Thread.sleep(1000);
				}
			}
			System.out.println("Is call accepted? " + callAccepted);
		}
	}

	private int getRandomNumber() {
		Random random = new Random();

		return Math.abs(random.nextInt(10));
	}

	public void acceptCall() {
		isRinging = false;
		inCall = true;
		hasLine = false;

		System.out.println("In call");
		displyaNumber();
	}

	public void displyaNumber() {

		System.out.println("Incoming number: " + incomingNumber);

	}

	public void endCall() {
		inCall = false;
		hasLine = true;

		System.out.println("call ended");
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isRinging() {
		return isRinging;
	}

	public void setRinging(boolean isRinging) {
		this.isRinging = isRinging;
	}

	public boolean isHasLine() {
		return hasLine;
	}

	public void setHasLine(boolean hasLine) {
		this.hasLine = hasLine;
	}

	public boolean isInCall() {
		return inCall;
	}

	public void setInCall(boolean inCall) {
		this.inCall = inCall;
	}

}
