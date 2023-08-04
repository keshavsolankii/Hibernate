package com.tut.Keshav;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started!" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory fac = cfg.buildSessionFactory();
        
        Student st = new Student();
        st.setId(1);
        st.setName("Keshav");
        st.setCity("Ghaziabad");
        
        //Creating object of Address class
        Address ad = new Address();
        ad.setCity("Noida");
        ad.setOpen(true);
        ad.setX(2.0);
        ad.setStreet("Fortis");
        ad.setAddedDate(new Date());
        
        
        System.out.println(st);
        
        Session ses = fac.openSession();
        
        Transaction tx = ses.beginTransaction(); // Transaction is only needed when we want to save the data
        
        ses.save(st);
        ses.save(ad);
        
        tx.commit();
        ses.close();
        
        
        
     }
}
