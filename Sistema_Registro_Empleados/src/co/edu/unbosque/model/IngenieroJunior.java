package co.edu.unbosque.model;

public class IngenieroJunior extends EmpleadoFijo {
	private int nivel;

	public IngenieroJunior(String nombre, String apellido, String cedula, String fechaDeNacimiento, String telefono, String correo,
			String direccion, String fechaIngreso, String genero, int nivel) {
		super(nombre, apellido, cedula, fechaDeNacimiento, telefono, correo, direccion, fechaIngreso, genero);
		this.nivel = nivel;
	}
	
	public void ascender() {
		this.nivel++;
	}

	@Override
	void calcularBonoEspecifico() {
		long bono = 0;
		
		if (this.nivel == 2) {
			bono = (long) (this.salarioBase*0.06);
		}
		
		if (this.nivel == 3) {
			bono = (long) (this.salarioBase*0.09);
		}
		
		this.salarioBase += bono;		
	}
}
