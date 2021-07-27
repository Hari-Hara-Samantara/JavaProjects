package HBM.Proj2.persist.JPAMethod.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HBM.Proj2.persist.JPAMethod.entity.CustomerPersist;

public class CustomerTest {

	public static void main(String[] args) {
		//Activate/Bootstrap HB
		Configuration cfg = new Configuration();
		//Locate and hold cfg file
		cfg.configure("HBM/Proj2/persist/JPAMethod/cfgs/CustomerPersist-cfg.xml");
		//Create SessionFactory
		SessionFactory factory = cfg.buildSessionFactory();
		//Create Session object
		Session ses = factory.openSession();
		
		//prepare entity class
		CustomerPersist custP = new CustomerPersist();
		custP.setCustName("Harihara"); custP.setCustAddr("Odisha"); 
		custP.setCustEmail("hh.samantara@gmail.com"); custP.setCustMob(9090260398L);
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = ses.beginTransaction();
			ses.persist(custP);
			flag=true;
		}
		catch(HibernateException  hbe) {
			hbe.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Data Persisted successfully.");
			}
			else {
				tx.rollback();
				System.out.println("Data Persisted un-successfully.");
			}
			ses.close();
			factory.close();
		}
	}
}
