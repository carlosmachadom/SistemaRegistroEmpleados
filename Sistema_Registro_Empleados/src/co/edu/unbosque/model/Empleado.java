package co.edu.unbosque.model;

public class Empleado {
	protected String nombre;
	protected String apellido;
	protected String cedula;
	protected String fechaDeNacimiento;
	protected String telefono;
	protected String correo;
	protected String direccion;
	protected String fechaIngreso;
	protected String genero;

	public Empleado(String nombre, String apellido, String cedula, String fechaDeNacimiento, String telefono, String correo,
			String direccion, String fechaIngreso, String genero) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaIngreso = fechaIngreso;
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", cedula:" + cedula + ", fechaDeNacimiento:" + fechaDeNacimiento
				+ ", telefono:" + telefono + ", correo:" + correo + ", direccion:" + direccion + ", fechaIngreso:"
				+ fechaIngreso + ", genero:" + genero;
	}	
}
