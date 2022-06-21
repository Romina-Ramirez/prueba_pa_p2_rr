package com.uce.edu.demo.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@Override
	public void crear(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se creó el vehículo: " + v);
	}

	@Override
	public Vehiculo leer(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Se buscó el vehículo con placa:" + placa);
		Vehiculo v = new Vehiculo();
		v.setMarca("Audi");
		v.setModelo("R8");
		v.setPlaca(placa);
		v.setPrecio(new BigDecimal(35000));
		v.setTipo("Liviano");
		return v;
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se actualizó el vehículo: " + v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Se eliminó el vehículo con placa: " + placa);
	}

}
