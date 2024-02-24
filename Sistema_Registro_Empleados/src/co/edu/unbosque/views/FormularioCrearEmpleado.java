package co.edu.unbosque.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioCrearEmpleado extends JPanel implements ActionListener{
	
	private JPanel camposFormulario;
	private JComboBox<String> tipoEmpleado;	
	private JTextField nombre;
	private JTextField apellido;
	private JTextField cedula;
	private JTextField fechaNacimiento;
	private JTextField telefono;
	private JTextField email;
	private JTextField direccion;
	private JTextField fechaIngreso;
	private JTextField genero;
	private JTextField nivel;
	private JTextField ventas;
	private JTextField clientesCaptados;	
	private JButton botonCrear;	

	public FormularioCrearEmpleado() {		
		this.setLayout(new BorderLayout());		
		this.setVisible(true);
		
		insertarCabecera();
		insertarCamposFormulario();
	}
	
	public void insertarCabecera() {
		JPanel cabecera = new JPanel();		
		JLabel tituloFormulario = new JLabel("Crea un nuevo empleado");
		tituloFormulario.setFont(new Font("Arial", Font.BOLD, 45));
		tituloFormulario.setHorizontalAlignment(JLabel.LEFT);
		tituloFormulario.setVerticalAlignment(JLabel.CENTER);
		tituloFormulario.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		cabecera.add(tituloFormulario);
		this.add(cabecera, BorderLayout.NORTH);
	}
	
	public void insertarCamposFormulario() {
		JPanel contenedorCamposLayout = new JPanel(new BorderLayout());
		contenedorCamposLayout.setPreferredSize(new Dimension(900, 400));
		contenedorCamposLayout.setBorder(new EmptyBorder(0,0,0,0));
		
		camposFormulario = new JPanel();		
		camposFormulario.setLayout(new GridLayout(0, 2, 20, 10));
		
		String[] tiposDeEmpleados = {"Empleado Freelance", "Tecnico", "Ingeniero Junior", "Ingeniero Senior"};
		JPanel labelDropdown = obtenerDropDown(tipoEmpleado, "Elije el tipo de empleado a crear", tiposDeEmpleados, "seleccionTipoEmpleado");
		contenedorCamposLayout.add(labelDropdown, BorderLayout.NORTH);
		
		JPanel labelNombre = obtenerCampo(nombre, "Nombre");
		JPanel labelApellido = obtenerCampo(apellido, "Apellido");
		JPanel labelCedula = obtenerCampo(cedula, "Cedula");
		JPanel labelFechaNacimiento = obtenerCampo(fechaNacimiento, "Fecha de nacimiento");
		JPanel labelTelefono = obtenerCampo(telefono, "Telefono");
		JPanel labelEmail = obtenerCampo(email, "Email");
		JPanel labelDireccion = obtenerCampo(direccion, "Direccion");
		JPanel labelFechaIngreso = obtenerCampo(fechaIngreso, "Fecha de ingreso");
		JPanel labelGenero = obtenerCampo(genero, "Genero");				
		
		camposFormulario.add(labelNombre);	
		camposFormulario.add(labelApellido);	
		camposFormulario.add(labelCedula);	
		camposFormulario.add(labelFechaNacimiento);	
		camposFormulario.add(labelTelefono);	
		camposFormulario.add(labelEmail);	
		camposFormulario.add(labelDireccion);	
		camposFormulario.add(labelFechaIngreso);	
		camposFormulario.add(labelGenero);	
		
		contenedorCamposLayout.add(camposFormulario, BorderLayout.CENTER);
		
		JPanel seccion = new JPanel();
		seccion.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;	
		gbc.fill = GridBagConstraints.BOTH; 
		seccion.add(contenedorCamposLayout, gbc);		
		
		this.add(seccion, BorderLayout.CENTER);
	}
	
	public void insertarBoton() {
		botonCrear = new JButton("Enviar");
		botonCrear.setActionCommand("enviarDatosNuevoEmpleado");
	}
	
	public JPanel obtenerCampo(JTextField ref, String titulo) {
		JPanel labelContainer = new JPanel(new GridLayout(2, 1));
		JLabel tituloLabel = new JLabel(titulo);
		ref = new JTextField();
		labelContainer.add(tituloLabel);
		labelContainer.add(ref);
		
		return labelContainer;
	}
	
	public JPanel obtenerDropDown(JComboBox<String> ref, String titulo, String[] lista, String command) {
		JPanel labelContainer = new JPanel(new GridLayout(2, 1));
		JLabel tituloLabel = new JLabel(titulo);
		ref = new JComboBox<>(lista);
		ref.setActionCommand(command);
		ref.addActionListener(this);
		
		labelContainer.setBorder(new EmptyBorder(0,0,12,0));
		labelContainer.add(tituloLabel);
		labelContainer.add(ref);
		
		return labelContainer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		validarTipoEmpleado(c);
	}
	
	public void validarTipoEmpleado(String c) {		
		
		if (c != "seleccionTipoEmpleado") return;
		
		switch(c) {
		case "Empleado Freelance": 
			JPanel labelClientesCaptados = obtenerCampo(clientesCaptados, "Clientes Captados");
			camposFormulario.add(labelClientesCaptados);
			break;
		case "Ingeniero Junior":
			JPanel labelNivel = obtenerCampo(nivel, "Nivel");
			camposFormulario.add(labelNivel);
			break;
		case "Ingeniero Senior":
			JPanel labelVentas = obtenerCampo(ventas, "Ventas");
			camposFormulario.add(labelVentas);
			break;
		default:
			break;
		}	
		
		camposFormulario.revalidate();
		camposFormulario.repaint();
	}
}
