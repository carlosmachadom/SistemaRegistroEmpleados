package co.edu.unbosque.model;

public class IngenieroSenior extends EmpleadoFijo {

	private int ventas;

	public IngenieroSenior(String nombre, String apellido, String cedula, String fechaDeNacimiento, String telefono, String correo,
			String direccion, String fechaIngreso, String genero, int ventas) {
		super(nombre, apellido, cedula, fechaDeNacimiento, telefono, correo, direccion, fechaIngreso, genero);
		this.ventas = ventas;
		calcularBonoEspecifico();
	}

	public void realizarVenta(int ventas) {
		this.ventas += ventas;
	}

	@Override
	void calcularBonoEspecifico() {
		long bono = 0;
		
		if (this.ventas == 0) {
			return;
		}
		
		if (this.ventas >= 1 && this.ventas <= 4) {
			bono = (long) (this.salarioBase*0.1);
		}
		
		if (this.ventas >= 5 && this.ventas <= 8) {
			bono = (long) (this.salarioBase*0.15);
		}
		
		if (this.ventas >= 9 && this.ventas <= 12) {
			bono = (long) (this.salarioBase*0.2);
		}
		
		if (this.ventas > 12) {
			bono = (long) (this.salarioBase*0.25);
		}
		
		this.salarioBase += bono;		
	}


}
