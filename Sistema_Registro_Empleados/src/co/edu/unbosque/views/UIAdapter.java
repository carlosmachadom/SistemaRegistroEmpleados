package co.edu.unbosque.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import co.edu.unbosque.controllers.Controller;
import co.edu.unbosque.model.EmpleadoFreelance;
import co.edu.unbosque.model.IngenieroJunior;
import co.edu.unbosque.model.IngenieroSenior;
import co.edu.unbosque.model.Tecnico;

public class UIAdapter implements ActionListener {
	private Controller controlador;
	private VentanaPrincipal vistaVentana;
	
	// Dashboard General
	private Dashboard dashboard;
	
	// Botones dashboard
	private JButton crearNuevoEmpleado;
	private JComboBox<String> seleccionarLista;
	
	// Tabla dashboard
	private TablaGeneral tablaDashboard;
	
	// Formulario Crear Empleado
	private FormularioCrearEmpleado formularioNuevoEmpleado;
	private JButton botonEnviarDatosNuevoEmpleado;
	
	public UIAdapter() {
		controlador = new Controller();
		vistaVentana = new VentanaPrincipal();
		vistaVentana.setVisible(true);
		
		agregarListeners();
		insertarTabla();
	}
	
	public void agregarListeners() {
		// Componentes Generales
		dashboard = vistaVentana.getLayoutDinamico().getDashboard();
		formularioNuevoEmpleado = vistaVentana.getLayoutDinamico().getFormularioNuevoEmpleado();
		
		// Boton para desplegar ventana de formulario para crear un nuevo empleado
		crearNuevoEmpleado = dashboard.getCrearNuevoEmpleado();
		crearNuevoEmpleado.addActionListener(this);
		
		// Boton para desplegar La tabla según el tipo de empleado
		seleccionarLista = dashboard.getDropDownListaEmpleados();
		seleccionarLista.addActionListener(this);
		
		botonEnviarDatosNuevoEmpleado = formularioNuevoEmpleado.getBotonCrearNuevoEmpleado();
		botonEnviarDatosNuevoEmpleado.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();		
		validarAccion(c);
	}
	
	public void validarAccion(String c) {
		switch(c) {
		case "listaEmpleadosDropdown":
			insertarTabla();
			break;
		case "FormularioCrearNuevoEmpleado":
			vistaVentana.getLayoutDinamico().mostrarVista(c);
			break;
		case "enviarDatosNuevoEmpleado":
			String tipoEmpleado = ""+formularioNuevoEmpleado.getTipoEmpleado().getSelectedItem();
			if(formularioNuevoEmpleado.validarCampos()) {
				crearNuevoEmpleado(tipoEmpleado);
				formularioNuevoEmpleado.mostrarExito("Empleado creado con exito");
				vistaVentana.getLayoutDinamico().mostrarVista("Dashboard");
			} else {
				this.formularioNuevoEmpleado.mostrarError("Corrige los datos del formulario.");			
			}
			break;
		}
	}
	
	public void crearNuevoEmpleado(String tipoEmpleado) {	
		String nombre = formularioNuevoEmpleado.getNombre();
		String apellido = formularioNuevoEmpleado.getApellido();
		String cedula = formularioNuevoEmpleado.getCedula();
		String fechaNacimiento = formularioNuevoEmpleado.getFechaNacimiento();
		String telefono = formularioNuevoEmpleado.getTelefono();
		String correo = formularioNuevoEmpleado.getEmail();
		String direccion = formularioNuevoEmpleado.getDireccion();
		String fechaIngreso = formularioNuevoEmpleado.getFechaIngreso();
		String genero = formularioNuevoEmpleado.getGenero();

		if (tipoEmpleado.equals("Ingeniero Junior")) {
			String nivel = formularioNuevoEmpleado.getNivel();
			controlador.crearNuevoEmpleadoJunior(nombre, apellido, cedula, fechaNacimiento, telefono, correo, direccion, fechaIngreso, genero, convertirStringAEntero(nivel));
		} else if(tipoEmpleado.equals("Ingeniero Senior")) {
			String ventas = formularioNuevoEmpleado.getVentas();
			controlador.crearNuevoEmpleadoSenior(nombre, apellido, cedula, fechaNacimiento, telefono, correo, direccion, fechaIngreso, genero, convertirStringAEntero(ventas));
		} else if(tipoEmpleado.equals("Empleado Freelance")) {
			String clientesCaptados = formularioNuevoEmpleado.getClientesCaptados();	
			controlador.crearNuevoEmpleadoFreelance(nombre, apellido, cedula, fechaNacimiento, telefono, correo, direccion, fechaIngreso, genero, convertirStringAEntero(clientesCaptados));
		} else if(tipoEmpleado.equals("Tecnico")) {
			controlador.crearNuevoEmpleadoTecnico(nombre, apellido, cedula, fechaNacimiento, telefono, correo, direccion, fechaIngreso, genero);
		}
	}
	
	public int convertirStringAEntero(String cadena) {
        try {
            return Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el String a entero: " + e.getMessage());
            return 0;
        }
    }
	
	public void insertarTabla() {
		tablaDashboard = dashboard.getTablaGeneral();
		
		String state = ""+this.seleccionarLista.getSelectedItem();		
		
		switch (state) {
			case "Empleados Freelance":
				ArrayList<EmpleadoFreelance> listaFreelancers = controlador.getFreelos();
				
				if(listaFreelancers.size() != 0) {
					tablaDashboard.insertarContenidoTabla(listaFreelancers);
				}
				
				break;
				
			case "Tecnicos":
				ArrayList<Tecnico> listaTecnicos = controlador.getTecnicos();
				
				if(listaTecnicos.size() != 0) {
					tablaDashboard.insertarContenidoTabla(listaTecnicos);
				}
				
				break;
				
			case "Ingenieros Junior":
				ArrayList<IngenieroJunior> listaJuniors = controlador.getJuniors();
				
				if(listaJuniors.size() != 0) {
					tablaDashboard.insertarContenidoTabla(listaJuniors);
				}

				break;
				
			case "Ingenieros Senior":
				ArrayList<IngenieroSenior> listaSeniors = controlador.getSeniors();
				
				if(listaSeniors.size() != 0) {
					tablaDashboard.insertarContenidoTabla(listaSeniors);
				}
				
				break;
			default:
				break;
		}
	}

}
