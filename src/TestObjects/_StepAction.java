package TestObjects;

import enums.ActionStatus;

public class _StepAction {
	
	String actionName;
	
	ActionStatus actionStatus;
	
	String actionScreenshot;
	
	String link;
	
	public _StepAction(String actionName){
		this.actionName=actionName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public ActionStatus getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(ActionStatus actionStatus) {
		this.actionStatus = actionStatus;
	}

	public String getActionScreenshot() {
		return actionScreenshot;
	}

	public void setActionScreenshot(String actionScreenshot) {
		this.actionScreenshot = actionScreenshot;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
