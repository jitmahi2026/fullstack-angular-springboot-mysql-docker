package com.ganagama.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ganagama.pg.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
