package TestObjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Services.Utils.fileUtils;
import enums.ActionStatus;




public class LogStep {

	public LogStep(String desc) {
		this.desc = desc;
		this.stepStartTime = fileUtils.getCurrentDateTime();

		this.stepActions = new ArrayList<StepAction>();
		this.stepStatus = true;
	}

	public LogStep(String desc, boolean stepStatus) {

		this.stepActions = new ArrayList<StepAction>();
		this.desc = desc;

		this.stepStartTime = fileUtils.getCurrentDateTime();

		this.stepStatus = stepStatus;
	}

	public String desc;

	boolean stepStatus;

	String stepStartTime;

	String stepFinishTime;

	public List<StepAction> stepActions;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean getStepStatus() {
		return stepStatus;
	}

	public void setStepStatus(boolean stepStatus) {
		this.stepStatus = stepStatus;
	}

	public String getStepStartTime() {
		return stepStartTime;
	}

	public void setStepStartTime(String stepStartTime) {
		this.stepStartTime = stepStartTime;
	}

	public String getStepFinishTime() {
		return stepFinishTime;
	}

	public void setStepFinishTime(String stepFinishTime) {
		this.stepFinishTime = stepFinishTime;
	}

	public List<StepAction> getStepActions() {
		return stepActions;
	}

	public void setStepActions(List<StepAction> stepActions) {
		this.stepActions = stepActions;
	}

	public void addAction(String actionName) {
		stepActions.add(new StepAction(actionName));

	}
	
	public void addFailedAction(String failReason) {
		stepActions.add(new StepAction(failReason, ActionStatus.Failed));

	}

	
}
