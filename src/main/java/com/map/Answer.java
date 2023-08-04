package com.map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Id
	private int answerId;
	private String answer;
	
	
}
