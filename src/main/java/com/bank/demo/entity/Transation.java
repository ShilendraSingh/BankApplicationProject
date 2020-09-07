package com.bank.demo.entity;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Transation implements Serializable{
	

	private static final long serialVersionUID = 3963411852888387174L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long transationId;
	private int toAccount;
	private int fromAccount;
	private double amount;
	private LocalDate transactionDate;
	private String transactionType;

}