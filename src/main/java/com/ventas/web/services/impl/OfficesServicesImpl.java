package com.ventas.web.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.web.dto.OfficesDto;
import com.ventas.web.entities.Offices;
import com.ventas.web.repositories.OfficesRepository;
import com.ventas.web.services.OfficesServices;
@Service
public class OfficesServicesImpl implements OfficesServices {
	@Autowired
    private OfficesRepository officeRepo;
	@Override
	public List<OfficesDto> consultarOficinas() {
		List<Offices> lstOficinas = officeRepo.findAll();
		List<OfficesDto> lstOficinasDto = new ArrayList<OfficesDto>();
		OfficesDto o;
		for (Offices of: lstOficinas) {
			o= new OfficesDto();
			o.setOfficeCode(of.getOfficeCode());
			o.setCity(of.getCity());
			o.setPhone(of.getPhone());
			o.setAddressLine1(of.getAddressLine1());
			o.setAddressLine2(of.getAddressLine2());
			o.setState(of.getState());
			o.setCountry(of.getCountry());
			o.setPostalCode(of.getPostalCode());
			o.setTerritory(of.getTerritory());
			lstOficinasDto.add(o);
		}
		return lstOficinasDto;
	}
	@Override
	public void crearOficina(OfficesDto oficina) {
		Offices o= new Offices();
		o.setOfficeCode(oficina.getOfficeCode());
		o.setCity(oficina.getCity());
		o.setPhone(oficina.getPhone());
		o.setAddressLine1(oficina.getAddressLine1());
		o.setAddressLine2(oficina.getAddressLine2());
		o.setState(oficina.getState());
		o.setCountry(oficina.getCountry());
		o.setPostalCode(oficina.getPostalCode());
		o.setTerritory(oficina.getTerritory());
		 officeRepo.save(o);
	
	}
	@Override
	public OfficesDto consultarOficinaPorCodigo(String officeCode) {
		OfficesDto o= new OfficesDto(); 
		Optional<Offices> oficina=officeRepo.findById(officeCode);
		o.setOfficeCode(oficina.get().getOfficeCode());
		o.setCity(oficina.get().getCity());
		o.setPhone(oficina.get().getPhone());
		o.setAddressLine1(oficina.get().getAddressLine1());
		o.setAddressLine2(oficina.get().getAddressLine2());
		o.setState(oficina.get().getState());
		o.setCountry(oficina.get().getCountry());
		o.setPostalCode(oficina.get().getPostalCode());
		o.setTerritory(oficina.get().getTerritory());
		return o;
	}
	@Override
	public void eliminarOficina(String officeCode) {
		officeRepo.deleteById(officeCode);
	}

}
