package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.format.*;
import java.util.Calendar;

public abstract class EmpleadoFijo extends Empleado {
	protected long salarioBase;

	public EmpleadoFijo(String nombre, String apellido, String cedula, String fechaDeNacimiento, String telefono, String correo,
			String direccion, String fechaIngreso, String genero) {
		
		super(nombre, apellido, cedula, fechaDeNacimiento, telefono, correo, direccion, fechaIngreso, genero);
		this.salarioBase = 3000000;
	}

	protected void calcularGeneral() {
		int anosLaborados = 0;
		long bono = 0;
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		LocalDate fechaIngreso = LocalDate.parse(this.fechaIngreso, formatter);
		Calendar calendario = Calendar.getInstance();	
		
		int anoActual = calendario.get(Calendar.YEAR);
		int anoIngreso = fechaIngreso.getYear();
				
		anosLaborados = anoActual - anoIngreso;
		
		if (anosLaborados == 0) {			
			return;
		}
		
		if (anosLaborados >= 2 && anosLaborados <= 3) {
			bono = (long) (this.salarioBase*0.03);
		}
		
		if (anosLaborados >= 4 && anosLaborados <= 7) {
			bono = (long) (this.salarioBase*0.06);
		}		
		
		if (anosLaborados >= 8 && anosLaborados <= 15) {
			bono = (long) (this.salarioBase*0.09);
		}
		
		if (anosLaborados > 15) {
			bono = (long) (this.salarioBase*0.15);
		}
		
		this.salarioBase += bono;
	}
	
	abstract void calcularBonoEspecifico();

	public long getSalarioBase() {
		return salarioBase;
	}
}
