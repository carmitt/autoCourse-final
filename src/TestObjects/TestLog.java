package TestObjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.ActionStatus;

public class TestLog {

	int testRunId;

	String testId;

	boolean passed;

	long testRunTime;

	Date testStartTime;

	String env;

	public List<LogStep> steps;

	public List<String[]> properties;

	String testName;

	String failReason;

	String testClass;
	
	boolean testStatus;

	public TestLog() {
		steps = new ArrayList<LogStep>();

	}

	public void addStep(String stepName) {
		steps.add(new LogStep(stepName));
	}

	public LogStep getLastStep() {
		return steps.get(steps.size() - 1);

	}

	public void addAction(String actionName) {

		createFirstStep();

		steps.get(steps.size() - 1).addAction(actionName);

	}

	private void createFirstStep() {
		if (steps.size() == 0) {
			// create 1st step
			steps.add(new LogStep("Init step"));
		}
	}

	public void addAction(String string, boolean passed) {

		createFirstStep();

		if (passed == false) {
			steps.get(steps.size() - 1).addFailedAction(string);
		} else {
			steps.get(steps.size() - 1).addAction(string);
		}

	}

	public void addAScrActionction(String printScreen, String message) {
		createFirstStep();

		steps.get(steps.size() - 1).stepActions.add(new StepAction(printScreen, message, ActionStatus.Screenshot));

	}

	public void assertStrings(String expected, String actual) {

		if (expected.equals(actual) == false) {
			addAction(expected + " and " + actual + " are not equal", false);
		}
	}

	public void assertInts(int expected, int actual) {
		if (expected != actual) {
			addAction(expected + " and " + actual + " are not equal", false);
		}
	}

	public boolean hasFailedActions() {

		for (LogStep step : steps) {

			if (step.stepStatus == false) {
				return true;
			}
			for (StepAction stepAction : step.stepActions) {
				if (stepAction.actionStatus.equals(ActionStatus.Failed)) {
					return true;
				}
			}
		}
		return false;

	}

	public void addProperty(String property, String value) {
		properties.add(new String[] { property, value });

	}

	public void assertTrue(boolean booleanToAssert, String message) {

		if (booleanToAssert == false) {
			addAction(message, false);
		} else {
			addAction("Asserting passed: " + message);
		}

	}

	public void setTestId(String testId) {
		this.testId = testId;

	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public long getTestRunTime() {
		return testRunTime;
	}

	public void setTestRunTime(long testRunTime) {
		this.testRunTime = testRunTime;
	}

	public String getTestId() {
		// TODO Auto-generated method stub
		return this.testId;
	}

	public void setTestFinishDateTime() {
		// TODO Auto-generated method stub

	}

	public Date getStartDateTime() {
		return testStartTime;
	}

	public void setStartDateTime(Date startTime) {
		this.testStartTime = startTime;
	}

	public void setEnv(String env) {
		this.env = env;

	}

	public String getEnv() {
		return this.env;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public int getTestRunId() {
		return testRunId;
	}

	public void setTestRunId(int testRunId) {
		this.testRunId = testRunId;
	}

	public String getTestClass() {
		return testClass;
	}

	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}

	public void setLastStepAsFailed() {
		steps.get(steps.size()).setStepStatus(false);

	}

	public void addFailedStep(String stepDesc) {
		steps.add(new LogStep(stepDesc, false));

	}

	public void addLink(String url) {

		steps.get(steps.size() - 1).stepActions.add(new StepAction(url, "opened url", ActionStatus.Link));

	}

	public boolean hasFailures() {
		for (int i = 0; i < steps.size(); i++) {
			if (steps.get(i).stepStatus == false) {
				return false;
			}
			for (int j = 0; j < steps.get(i).stepActions.size(); j++) {
				if (steps.get(i).stepActions.get(j).actionStatus.equals(ActionStatus.Failed)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isTestStatus() {
		return testStatus;
	}

	public void setTestStatus(boolean testStatus) {
		this.testStatus = testStatus;
	}

}
