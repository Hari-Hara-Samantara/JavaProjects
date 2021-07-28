package HBM.Proj3.HibernateUtil.entity;

import lombok.Data;

@Data
public class StudentDetails {
	
	private int stId;
	private String stName;
	private String stDept;
	private long stCont;
	private double stCGPA;
}
