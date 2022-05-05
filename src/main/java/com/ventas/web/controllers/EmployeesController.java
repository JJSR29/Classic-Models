package com.ventas.web.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventas.web.dto.EmployeesDto;
import com.ventas.web.dto.OfficesDto;
import com.ventas.web.services.EmployeesServices;
import com.ventas.web.services.OfficesServices;

@Controller
public class EmployeesController {
	@Autowired
	private EmployeesServices empService;
	@Autowired
	private OfficesServices officesServices;
	@RequestMapping (value="/employees", method=RequestMethod.GET)
	public String consultarempleados(Map<String, Object>model) {
		model.put("lstEmpleados", empService.consultarEmpleadosOficinas());
		return "empleadosppal";
	}
	
	@RequestMapping(value="/crearempleado")
	public String crear(Map<String, Object> model) {
		EmployeesDto empleado= new EmployeesDto();
		model.put("empleado", empleado);
		model.put("oficinas", officesServices.consultarOficinas());
		return "EmpleadosForm";	
		
	}
	
	@RequestMapping(value="/guardarempleado", method=RequestMethod.POST)
	public String guardar(EmployeesDto empleado) {
		empService.crearEmpleado(empleado);
		return "redirect:employees";
		
	}
}
