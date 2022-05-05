package com.ventas.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.web.dto.EmployeesDto;
import com.ventas.web.dto.OfficesDto;
import com.ventas.web.entities.Employees;
import com.ventas.web.repositories.EmployeesRepository;
import com.ventas.web.services.EmployeesServices;

@Service

public class EmployeesSevicesImpl implements EmployeesServices {
	@Autowired
	private EmployeesRepository employeesRepo;
	@Override
	public List<EmployeesDto> consultarEmpleadosOficinas() {
		
		List<Object [] > lstTemp=employeesRepo.consultarEmpleadosOficinas();
		List<EmployeesDto> lstEmpleados= new ArrayList<EmployeesDto>();
		
		for (Object [] o: lstTemp) {
			EmployeesDto e= new EmployeesDto();
			e.setEmployeeNumber(Integer.parseInt(o[0].toString()));
			e.setLastName(o[1].toString());
			e.setFirstName(o[2].toString());
			OfficesDto ofi= new OfficesDto ();
			ofi.setOfficeCode(o[3].toString());
			ofi.setCity(o[4].toString());
			ofi.setState(o[5]!=null ? o[5].toString() :"-");
			ofi.setCountry(o[6].toString());
			
			e.setOficina(ofi);
			
			lstEmpleados.add(e);
		}
		
		return lstEmpleados ;
	}
	@Override
	public void crearEmpleado(EmployeesDto empleado) {
		Employees e =new Employees();
		e.setEmployeeNumber(empleado.getEmployeeNumber());
		e.setLastName(empleado.getLastName());
		e.setFirstName(empleado.getFirstName());
		e.setExtension(empleado.getExtension());
		e.setEmail(empleado.getEmail());
		e.setOfficeCode(empleado.getOficina().getOfficeCode());
		e.setReportsTo(empleado.getReportsTo());
		e.setJobTitle(empleado.getJobTitle());
		employeesRepo.save(e);
	}

}
