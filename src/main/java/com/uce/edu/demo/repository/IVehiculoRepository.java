package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void crear(Vehiculo v);

	public Vehiculo leer(String placa);

	public void actualizar(Vehiculo v);

	public void eliminar(String placa);

}
