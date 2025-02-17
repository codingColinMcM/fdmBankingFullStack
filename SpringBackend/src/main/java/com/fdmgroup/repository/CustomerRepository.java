package com.fdmgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

}
