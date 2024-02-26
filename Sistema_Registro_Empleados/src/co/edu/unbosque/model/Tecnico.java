package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Tecnico extends EmpleadoFijo {
	private int edad;

	public Tecnico(String nombre, String apellido, String cedula, String fechaDeNacimiento, String telefono, String correo,
			String direccion, String fechaIngreso, String genero) {
		
		super(nombre, apellido, cedula, fechaDeNacimiento, telefono, correo, direccion, fechaIngreso, genero);
		
		calcularEdad();
		calcularBonoEspecifico();
	}
	
	public void calcularEdad() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		LocalDate fechaIngreso = LocalDate.parse(this.fechaDeNacimiento, formatter);
		Calendar calendario = Calendar.getInstance();	
		
		int anoActual = calendario.get(Calendar.YEAR);
		int anoNacimiento = fechaIngreso.getYear();
		this.edad = anoActual - anoNacimiento;
	}

	@Override
	void calcularBonoEspecifico() {
		long bono = 0;
		
		if (this.edad >= 40) {
			bono = (long) (this.salarioBase * 0.05);
		}
		
		if (this.edad < 40) {
			bono = (long) (this.salarioBase * 0.02);
		}
		
		this.salarioBase += bono;		
	}

}
