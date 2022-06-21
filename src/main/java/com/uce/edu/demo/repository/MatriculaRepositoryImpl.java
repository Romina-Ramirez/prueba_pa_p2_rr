package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@Override
	public void crear(Matricula m) {
		// TODO Auto-generated method stub
		System.out.println("Se creó la matricula para el vehículo solicitado: " + m);
	}

}
