package JunitLesson2;

import java.util.List;

public class LogStep {
	
	
	String testId;
	
	String testRunId;
	
	boolean status;
	
	String description;
	
	List<StepAction>stepActions;
	
	public LogStep(String description){
		this.description=description;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestRunId() {
		return testRunId;
	}

	public void setTestRunId(String testRunId) {
		this.testRunId = testRunId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<StepAction> getStepActions() {
		return stepActions;
	}

	public void setStepActions(List<StepAction> stepActions) {
		this.stepActions = stepActions;
	}

}
