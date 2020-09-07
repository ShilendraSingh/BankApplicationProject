package com.bank.demo.entity;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer implements Serializable {
	

	private static final long serialVersionUID = -8774775141489381504L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private int age;
	private String mobileNumber;
	private String gender;
	private String password;

}