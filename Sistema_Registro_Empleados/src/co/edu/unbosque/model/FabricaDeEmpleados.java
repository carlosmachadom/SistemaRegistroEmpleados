package co.edu.unbosque.model;

public class FabricaDeEmpleados {
	public IngenieroJunior crearEmpleadoJunior(
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
		
		return new IngenieroJunior(
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
	}		
	
	public IngenieroSenior crearEmpleadoSenior(
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
		
		return new IngenieroSenior(
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
	}		
	
	public Tecnico crearEmpleadoTecnico(
			String nombre, 
			String apellido, 
			String cedula, 
			String fechaDeNacimiento, 
			String telefono, 
			String correo,
			String direccion, 
			String fechaIngreso, 
			String genero) {
		
		return new Tecnico(
				nombre, 
				apellido, 
				cedula, 
				fechaDeNacimiento, 
				telefono, 
				correo, 
				direccion, 
				fechaIngreso, 
				genero);
	}		
	
	public EmpleadoFreelance crearEmpleadoFreelance(
			String nombre, 
			String apellido, 
			String cedula, 
			String fechaDeNacimiento, 
			String telefono, 
			String correo,
			String direccion, 
			String fechaIngreso, 
			String genero) {
		
		return new EmpleadoFreelance(
				nombre, 
				apellido, 
				cedula, 
				fechaDeNacimiento, 
				telefono, 
				correo, 
				direccion, 
				fechaIngreso, 
				genero);
	}		
}
