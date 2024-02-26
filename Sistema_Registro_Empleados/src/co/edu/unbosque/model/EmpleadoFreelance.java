package co.edu.unbosque.model;

public class EmpleadoFreelance extends Empleado {
	protected long salarioBase; 
	protected int clientesCaptados;

	public EmpleadoFreelance(String nombre, String apellido, String cedula, String fechaDeNacimiento, String telefono, String correo,
			String direccion, String fechaIngreso, String genero, int clientesCaptados) {
		
		super(nombre, apellido, cedula, fechaDeNacimiento, telefono, correo, direccion, fechaIngreso, genero);
		this.clientesCaptados = clientesCaptados;
		this.salarioBase = 1200000;
		
		calcularBonoEspecifico();
	}

	public void calcularBonoEspecifico() {
		long montoTotal = 0;
		
		if (this.clientesCaptados != 0) {
			montoTotal = this.clientesCaptados * 500000;
			
			if (montoTotal > 2000000) {
				montoTotal = 2000000;
			}
		}
		
		this.salarioBase += montoTotal;
	}
	
	public long getSalarioBase() {
		return salarioBase;
	}
}
