package co.edu.unbosque.controllers;
import java.util.ArrayList;

import co.edu.unbosque.model.*;

public class Controller {
	private Personal personal;
	private FabricaDeEmpleados fabricaEmpleados;
	
	public Controller(){
		personal = new Personal();
		fabricaEmpleados = new FabricaDeEmpleados();
		
		crearEmpleadosDeMuestra();
	}
	
	public void crearEmpleadosDeMuestra() {
		// Empleados Junior
		crearNuevoEmpleadoJunior(
				"Carlos", 
				"Machado", 
				"1016473882", 
				"1995-02-23", 
				"3166727882", 
				"mcdario0223@gmail.com", 
				"Cra26#65-44",
				"2021-08-02",
				"M",
				6);
		
		// Empleados Senior
		crearNuevoEmpleadoSenior(
				"Juan", 
				"Cardenas", 
				"1016473882", 
				"1990-02-23", 
				"3166727882", 
				"juan@unbosque.edu.co", 
				"Cra34#32-44",
				"2020-06-14",
				"M",
				2);
		
		// Empleados Freelance
		crearNuevoEmpleadoFreelance(
				"Daniel", 
				"Martinez", 
				"1016569882", 
				"1997-04-23", 
				"3166727882", 
				"daniel@unbosque.edu.co", 
				"Cra26#65-44",
				"2022-08-02",
				"M",
				2);
		
		crearNuevoEmpleadoFreelance(
				"Amelia", 
				"Zarate", 
				"1016473882", 
				"1991-06-23", 
				"3166727882", 
				"amelia@unbosque.edu.co", 
				"Cra26#65-44",
				"2023-04-02",
				"M",
				1);
		
		// Empleados técnicos
		crearNuevoEmpleadoTecnico(
				"Laura", 
				"Morales", 
				"1016473882", 
				"2000-05-23", 
				"3166727882", 
				"laura@unbosque.edu.co", 
				"Cra26#65-44",
				"2021-08-02",
				"M");
	}
	
	public void crearNuevoEmpleadoJunior(
			String nombre, 
			String apellido, 
			String cedula, 
			String fechaDeNacimiento, 
			String telefono, 
			String correo,
			String direccion, 
			String fechaIngreso, 
			String genero, 
			int nivel) {
		
		IngenieroJunior ingeniero = fabricaEmpleados.crearEmpleadoJunior(
				nombre, 
				apellido, 
				cedula, 
				fechaDeNacimiento, 
				telefono, 
				correo, 
				direccion, 
				fechaIngreso, 
				genero, 
				nivel);
		
		
		personal.agregarNuevoEmpleado(ingeniero);
	}
	
	public void crearNuevoEmpleadoSenior(
			String nombre, 
			String apellido, 
			String cedula, 
			String fechaDeNacimiento, 
			String telefono, 
			String correo,
			String direccion, 
			String fechaIngreso, 
			String genero, 
			int ventas) {
		
		IngenieroSenior ingeniero = fabricaEmpleados.crearEmpleadoSenior(
				nombre, 
				apellido, 
				cedula, 
				fechaDeNacimiento, 
				telefono, 
				correo, 
				direccion, 
				fechaIngreso, 
				genero, 
				ventas);
		
		personal.agregarNuevoEmpleado(ingeniero);
		
	}
	
	public void crearNuevoEmpleadoTecnico(
			String nombre, 
			String apellido, 
			String cedula, 
			String fechaDeNacimiento, 
			String telefono, 
			String correo,
			String direccion, 
			String fechaIngreso, 
			String genero) {
		
		Tecnico tecnico = fabricaEmpleados.crearEmpleadoTecnico(
				nombre, 
				apellido, 
				cedula, 
				fechaDeNacimiento, 
				telefono, 
				correo, 
				direccion, 
				fechaIngreso, 
				genero);
		
		personal.agregarNuevoEmpleado(tecnico);
		
	}
	
	public void crearNuevoEmpleadoFreelance(
			String nombre, 
			String apellido, 
			String cedula, 
			String fechaDeNacimiento, 
			String telefono, 
			String correo,
			String direccion, 
			String fechaIngreso, 
			String genero,
			int clientesCaptados) {
		
		EmpleadoFreelance freelance = fabricaEmpleados.crearEmpleadoFreelance(
					nombre, 
					apellido, 
					cedula, 
					fechaDeNacimiento, 
					telefono, 
					correo, 
					direccion, 
					fechaIngreso, 
					genero,
					clientesCaptados);
		
		personal.agregarNuevoEmpleado(freelance);
	}
	
	public void buscarEmpleado() {
		
	}
	
	public void actualizarEmpleado() {
		
	}
	
	public void eliminarEmpleado() {
		
	}
	
	public ArrayList<Tecnico> getTecnicos() {
		return personal.getTecnicos();
	}

	public ArrayList<EmpleadoFreelance> getFreelos() {
		return personal.getFreelos();
	}

	public ArrayList<IngenieroJunior> getJuniors() {
		return personal.getJuniors();
	}

	public ArrayList<IngenieroSenior> getSeniors() {
		return personal.getSenior();
	}
}
