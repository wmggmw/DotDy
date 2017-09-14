package com.wmg.ddd.dotdy.entity;

public class TaskSteps {
	
	private String step_id;
	private String step_des;
	
	public String getStepId(){
		return step_id;
	}
	public void setStepId(String id){
		step_id = id;
	}
	
	public String getStepDes(){
		return step_des;
	}
	public void setStepDes(String des){
		step_des = des;
	}
}