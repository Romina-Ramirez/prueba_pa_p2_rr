package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.service.IPropietarioService;
import com.uce.edu.demo.service.IVehiculoService;

@SpringBootApplication
public class PruebaPaP2RrApplication implements CommandLineRunner{
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("1. Crear un propietario.");
		Propietario propietario = new Propietario();
		propietario.setNombre("Mina");
		propietario.setApellido("Kim");
		propietario.setCedula("0701283728");
		this.propietarioService.crearPropietario(propietario);
		
		System.out.println("\n----------------------------\n");
		
		System.out.println("2. Crear un vehículo.");
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Ford");
		vehiculo.setModelo("Mustang");
		vehiculo.setPlaca("ASD - 183");
		vehiculo.setPrecio(new BigDecimal(19000));
		vehiculo.setTipo("Liviano");
		this.vehiculoService.crearVehiculo(vehiculo);
		
		System.out.println("\n----------------------------\n");
		
		System.out.println("3. Actualizar atributo del vehiculo");
		vehiculo.setPlaca("ASD - 146");
		this.vehiculoService.actualizarVehiculo(vehiculo);
		
		System.out.println("\n----------------------------\n");
		
		System.out.println("4.Realizar matricula del vehiculo");
		Matricula matricula = new Matricula();
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		this.iMatriculaRepository.crear(matricula);
		
	}

}
