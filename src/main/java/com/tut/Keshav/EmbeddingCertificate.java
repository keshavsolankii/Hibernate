package com.tut.Keshav;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;


public class EmbeddingCertificate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fac = cfg.buildSessionFactory();
		
		Student std = new Student();
		std.setId(2);
        std.setName("Raghav");
        std.setCity("Noida");

        Certificate certi = new Certificate();
        certi.setCourse("Java");
        certi.setDuration("6 Months");
        
        std.setCerti(certi);
        
        Session s = fac.openSession();
        
        Transaction trans = s.beginTransaction();
        s.save(std);
        trans.commit();
        s.close();
        
        
	}
	
}
