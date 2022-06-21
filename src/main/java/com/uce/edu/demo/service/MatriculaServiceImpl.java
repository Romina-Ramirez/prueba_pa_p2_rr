package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	@Qualifier("liviano")
	private IVehiculoService vehiculoServiceL;

	@Autowired
	@Qualifier("pesado")
	private IVehiculoService vehiculoServiceP;

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public void crearMatricula(String cedulaPropietario, String placaVehiculo) {
		// TODO Auto-generated method stub
		BigDecimal valorMatricula = null;
		Vehiculo vehiculo = this.iVehiculoRepository.leer(placaVehiculo);
		if (vehiculo.getTipo().equals("Liviano")) {
			valorMatricula = this.vehiculoServiceL.calcularValorMatricula(vehiculo.getPrecio());
		} else {
			valorMatricula = this.vehiculoServiceP.calcularValorMatricula(vehiculo.getPrecio());
		}

		if (valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal descuento = valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula.subtract(descuento);
		}

		Propietario p = new Propietario();
		p.setNombre("Romina");
		p.setApellido("Ramírez");
		p.setCedula("1723069801");

		Matricula m = new Matricula();
		m.setFechaMatricula(LocalDateTime.now());
		m.setPropietario(p);
		m.setValorMatricula(valorMatricula);
		m.setVehiculo(vehiculo);
		this.iMatriculaRepository.crear(m);
	}

}
