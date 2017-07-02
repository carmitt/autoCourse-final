package JunitLesson2;

import java.util.ArrayList;
import java.util.List;

import enums.ActionStatus;

public class TestLog {

	List<LogStep> logSteps;

	public TestLog() {

		logSteps = new ArrayList<LogStep>();

	}

	public void addStep(String stepDescription) {
		this.logSteps.add(new LogStep(stepDescription));
	}

	public boolean hasFailedActions() {
		for (int i = 0; i < logSteps.size(); i++) {
			for (int j = 0; j < logSteps.get(i).stepActions.size(); j++) {
				if (logSteps.get(i).stepActions.get(j).status.equals(ActionStatus.Failed)) {
					return true;
				}
			}
		}
		return false;
	}

}
