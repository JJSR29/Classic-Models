package com.ventas.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.web.dto.OfficesDto;
import com.ventas.web.services.OfficesServices;

@RestController
@RequestMapping("/Offices")
public class OfficesRestController {
	@Autowired
	private OfficesServices officeService;
	@GetMapping("/Consulta")
	public List<OfficesDto> consultarOficinas(){
		return officeService.consultarOficinas();
	}

	@PostMapping("/Crear")
	@ResponseStatus(HttpStatus.CREATED)
	public String crearOficina(@RequestBody OfficesDto oficina) {
		officeService.crearOficina(oficina);
		return "Operacion Exitosa";
	}
	
	@PutMapping("/Editar/{id}")
	public String editar(@RequestBody OfficesDto oficina,@PathVariable String id) {
		officeService.crearOficina(oficina);
		return "Operacion Exitosa";
	}
	
	@DeleteMapping("/Eliminar/{id}")
	public String eliminar(@PathVariable String id) {
		officeService.eliminarOficina(id);
		return "Operacion Exitosa";
	}
}
