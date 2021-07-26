package com.hs.hbm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
	
	private int custId;
	private String custName;
	private String custAddr;
	private String custEmail;
	private long custMob;
}
