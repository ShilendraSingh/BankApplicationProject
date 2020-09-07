package com.bank.demo.repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerIdAndPassword(int customerId,String password);

