package com.ventas.web.services;

import java.util.List;

import com.ventas.web.dto.OfficesDto;

public interface OfficesServices {

	public List<OfficesDto> consultarOficinas();
	public void crearOficina(OfficesDto oficina);
	
	public OfficesDto consultarOficinaPorCodigo(String officeCode);
	
	public void eliminarOficina(String officeCode);
	
	
}
