package com.ventas.web.services;

import java.util.List;

import com.ventas.web.dto.EmployeesDto;

public interface EmployeesServices {
	
	public List<EmployeesDto> consultarEmpleadosOficinas ();
	
	public void crearEmpleado(EmployeesDto empleado); 

}
