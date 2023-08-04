package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Creating Question
		Question ques1 = new Question();
		ques1.setQuestionId(101);
		ques1.setQuestion("What is Java?");
		
		Question ques2 = new Question();
		ques2.setQuestionId(102);
		ques2.setQuestion("What is Hibernate?");
		
		//Creating answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(555);
		ans1.setAnswer("Java is a Programming language.");
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(655);
		ans2.setAnswer("Hibernate is a framework which simplifies java development.");
		
		ques1.setAnswer(ans1);
		ques2.setAnswer(ans2);
		
		//Creating Session
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(ques1);
		session.save(ques2);
		session.save(ans1);
		session.save(ans2);
		t.commit();
		
		//Fetching the Question and Answer
		Question getQuestion = session.get(Question.class, 101);
		System.out.println("Fetching the data from the table...");
		System.out.println(getQuestion.getQuestion());
		System.out.println(getQuestion.getAnswer().getAnswer());
		
		factory.close();
	}
}
