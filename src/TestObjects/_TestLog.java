package TestObjects;

import java.util.ArrayList;
import java.util.List;

public class _TestLog {
	
	
	
	String testId;
	
	String testName;
	
	boolean status;
	
	List<_LogStep>steps;
	
	public _TestLog(){
		steps=new ArrayList<_LogStep>();
	}
	
	public void addStep(String stepName){
		_LogStep logStep=new _LogStep(stepName, true);
		
		steps.add(logStep);
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
