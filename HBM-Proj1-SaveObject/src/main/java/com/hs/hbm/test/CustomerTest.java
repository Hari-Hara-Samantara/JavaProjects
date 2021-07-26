package com.hs.hbm.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hs.hbm.entity.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		//Bootstrap Hibernate
		Configuration cfg = new Configuration();
		//Name and location of cfg file
		cfg.configure("com/hs/hbm/cfgs/Customer-cfg.xml");
		//Create HB SessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();
		//Create HB Session Object
		Session ses = factory.openSession();
		
		//Prepare Entity Object
		Customer cust = new Customer();
		cust.setCustName("Harihara"); cust.setCustAddr("Odisha");
		cust.setCustEmail("hh.samantara@gmail.com"); cust.setCustMob(9090260398L);
		
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = ses.beginTransaction();
			ses.save(cust);
			flag=true;
		}catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Customer Object Saved Successfully.");
			}
			else {
				tx.rollback();
				System.out.println("Customer Object Saved Un-successfully.");
			}
			//close session object
			ses.close();
			//close sessionfactory
			factory.close();
		}
	}

}
