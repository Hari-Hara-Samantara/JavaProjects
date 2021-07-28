package HBM.Proj3.HibernateUtil.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HBM.Proj3.HibernateUtil.Util.HIbernateUtil;
import HBM.Proj3.HibernateUtil.entity.StudentDetails;

public class StudentDetailsTest {

	public static void main(String[] args) {
		//Get Session object
		Session ses = HIbernateUtil.getSession();
		
		//Prepare Entity class
		StudentDetails stDt = new StudentDetails();
		stDt.setStName("Harihara"); stDt.setStDept("EEE"); stDt.setStCont(9090260398L);
		stDt.setStCGPA(8.0);
		Transaction tx = null;
		boolean flag = false;
		
		try {
			//begin transaction
			tx = ses.beginTransaction();
			ses.persist(stDt);
			flag = true;
		}
		catch(HibernateException he) {
			flag = false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HIbernateUtil.closeSession(ses);
			HIbernateUtil.closeSessionFactory();
		}
		
	}//main method

}//studentDetailsTest
