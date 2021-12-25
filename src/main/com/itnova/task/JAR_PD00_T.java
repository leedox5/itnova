package com.itnova.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRMTASK")
public class JAR_PD00_T {
	private int taskId;
	private String programId;
	private String programUser;
	private String programStatus;
	private String startTime;
	private String endTime;
	private String resultCode;
	private String resultMessage;
	
	@Id
	@GeneratedValue
	@Column(name="TASK_TASK_IDTY")
	public int getTaskId() {
		return this.taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Column(name="TASK_PRGM_NAME")
	public String getProgramId() {
		return this.programId;
	}
	
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	
	@Column(name="TASK_PRGM_STAT")
	public String getProgramStatus() {
		return this.programStatus;
	}
	
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	
	@Column(name="TASK_FROM_TIME")
	public String getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@Column(name="TASK_END0_TIME")
	public String getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="TASK_COMT_CODE")
	public String getResultCode() {
		return this.resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	@Column(name="TASK_COMT_MESG")
	public String getResultMessage() {
		return this.resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	@Column(name="TASK_PRGM_USER")
	public String getProgramUser() {
		return programUser;
	}

	public void setProgramUser(String programUser) {
		this.programUser = programUser;
	}
}
