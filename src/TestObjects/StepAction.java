package TestObjects;

import Services.Utils.fileUtils;
import enums.ActionStatus;

public class StepAction {

	String actionTime;

	String actionDesc;

	String actionScreenShot;
	
	ActionStatus actionStatus;

	String linkText;

	public StepAction(String desc) {
		this.actionDesc = desc;

		this.actionTime = fileUtils.getCurrentDateTime();

		this.actionStatus = ActionStatus.Passed;
	}

	public StepAction(String link, String message, ActionStatus actionStatus) {
		this.actionDesc = message;
		this.linkText = link;
		this.actionStatus = actionStatus;

		if (actionStatus.equals(ActionStatus.Screenshot)) {
			this.actionScreenShot = link;
		}
	}

	public StepAction(String desc, ActionStatus actionStatus) {
		this.actionDesc = desc;

		this.actionTime = fileUtils.getCurrentDateTime();

		this.actionStatus = actionStatus;

	}

	public StepAction(String message, String printScreen) {
		this.actionDesc = message;
		this.actionScreenShot = printScreen;
		this.actionTime = fileUtils.getCurrentDateTime();
		this.actionStatus = ActionStatus.Passed;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public String getActionScreenShot() {
		return actionScreenShot;
	}

	public void setActionScreenShot(String actionScreenShot) {
		this.actionScreenShot = actionScreenShot;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getActionStatus() {
		return this.actionStatus.toString();
	}
}
