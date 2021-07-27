package HBM.Proj2.persist.JPAMethod.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerPersist {
	
	private int custId;
	private String custName;
	private String custAddr;
	private String custEmail;
	private long custMob;

}
