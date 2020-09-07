package com.bank.demo.entity;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Account implements Serializable {
	
	private static final long serialVersionUID = 6911455408295304184L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private int customerId;
	private int accountNumber;
	private double balance;
	private String accountType;
	

}