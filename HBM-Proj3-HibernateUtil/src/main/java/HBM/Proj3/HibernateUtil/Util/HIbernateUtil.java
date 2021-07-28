package HBM.Proj3.HibernateUtil.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try {
			//Bootstrap Hibernate
			Configuration cfg = new Configuration();
			//Locate and hold the cfg file
			cfg.configure("HBM/Proj3/HIbernateUtil/cfgs/StudentDetails-cfg.xml");
			//create SessionFactory object
			factory= cfg.buildSessionFactory();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static block
	
	//Create Session object
	public static Session getSession() {
		Session ses = null;
		if(factory!=null)
			ses= factory.openSession();
		
		return ses;
	}
	
	//Close Session object
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	//Close SessionFactory object
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
