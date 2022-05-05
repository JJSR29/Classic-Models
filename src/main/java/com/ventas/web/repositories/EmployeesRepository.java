package com.ventas.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ventas.web.entities.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
	
	@Query(value="SELECT EMPLOYEENUMBER, LASTNAME, FIRSTNAME, O.OFFICECODE, CITY, STATE, COUNTRY "
			+ "FROM EMPLOYEES E INNER JOIN OFFICES O ON (E.OFFICECODE=O.OFFICECODE)",nativeQuery=true)
	public List<Object []> consultarEmpleadosOficinas();

}
