package com.uce.edu.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
@Qualifier("liviano")
public class VehiculoLivianoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public void crearVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.crear(v);
	}

	@Override
	public Vehiculo leerVehiculo(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.leer(placa);
	}

	@Override
	public void actualizarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(v);
	}

	@Override
	public void eliminarVehiculo(String placa) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminar(placa);
	}

	@Override
	public BigDecimal calcularValorMatricula(BigDecimal precioVehiculo) {
		// TODO Auto-generated method stub
		BigDecimal valorMatricula = precioVehiculo.multiply(new BigDecimal(14)).divide(new BigDecimal(100));
		return valorMatricula;
	}

}
