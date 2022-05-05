package com.ventas.web.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventas.web.dto.OfficesDto;
import com.ventas.web.services.OfficesServices;

@Controller
public class OfficesController {
	@Autowired
	private OfficesServices officesServices;
	@RequestMapping(value="/oficinas", method=RequestMethod.GET)
	public String consultarOficinas(Map<String, Object> model) {
	model.put("ListaOficinas", officesServices.consultarOficinas());
	return "oficinasppal";
	}
	@RequestMapping(value="/crearoficina")
	public String crear(Map<String, Object> model) {
		OfficesDto oficina= new OfficesDto();
		model.put("oficina", oficina);
		return "OficinasForm";
		
	}
	@RequestMapping(value="/guardaroficina", method=RequestMethod.POST)
	public String guardar(OfficesDto oficina) {
		officesServices.crearOficina(oficina);
		return "redirect:oficinas";
	}

	@RequestMapping(value="/EditarOficina/{id}")
	public String editar(@PathVariable(value="id") String officeCode,Map<String, Object>model) {
		OfficesDto oficina=officesServices.consultarOficinaPorCodigo(officeCode);
		model.put("oficina", oficina);
		return "OficinasForm";
	}
	
	@RequestMapping(value="/EliminarOficina/{id}")
	public String eliminar(@PathVariable(value="id") String officeCode) {
		officesServices.eliminarOficina(officeCode);
		return "redirect:/oficinas";
	}
	
}
