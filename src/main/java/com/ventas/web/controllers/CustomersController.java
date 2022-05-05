package com.ventas.web.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventas.web.services.CustomersServices;


@Controller
public class CustomersController {
	//@Autowired
	//private CustomersServices customersServices;
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public String consultarClientes(Map<String, Object> model) {
	//model.put("LstClientes", customersServices.consultarClientes());
	return "clientesppal";
	}
}