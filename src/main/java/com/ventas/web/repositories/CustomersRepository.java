package com.ventas.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.web.entities.Customers;


public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
