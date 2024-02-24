package co.edu.unbosque.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
	
	public UIAdapter() {
		controlador = new Controller();
		vistaVentana = new VentanaPrincipal();
		vistaVentana.setVisible(true);
		
		agregarListeners();
		insertarTabla();
	}
	
	public void agregarListeners() {
		dashboard = vistaVentana.getLayoutDinamico().getDashboard();
		
		crearNuevoEmpleado = dashboard.getCrearNuevoEmpleado();
		crearNuevoEmpleado.addActionListener(this);
		
		seleccionarLista = dashboard.getDropDownListaEmpleados();
		seleccionarLista.addActionListener(this);		
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
		case "CrearNuevoEmpleado":
			vistaVentana.getLayoutDinamico().mostrarVista(c);
			break;
		}
	}
	
	public void crearNuevoEmpleado() {
		
	}
	
	public void recibirDatosFormulario() {
		
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
