package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoService {

	public void crearVehiculo(Vehiculo v);

	public Vehiculo leerVehiculo(String placa);

	public void actualizarVehiculo(Vehiculo v);

	public void eliminarVehiculo(String placa);

	public BigDecimal calcularValorMatricula(BigDecimal precioVehiculo);

}
