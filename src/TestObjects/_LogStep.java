package TestObjects;

import java.util.ArrayList;
import java.util.List;

public class _LogStep {
	
	String description;
	
	boolean status;//passed or failed
	
	String stepStartTime;

	String stepFinishTime;
	
	List<_StepAction>actions;

	
	
	public _LogStep(String description,boolean status){
		this.description=description;
		
		this.status=status;
		
		actions=new ArrayList<_StepAction>();
	}
	//adding an action to the step
	public void addAction(String actionName){
		_StepAction _stepAction=new _StepAction(actionName);
		actions.add(_stepAction);
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
	
	

}
