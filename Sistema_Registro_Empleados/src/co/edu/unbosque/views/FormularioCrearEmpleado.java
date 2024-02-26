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
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JComboBox<String> genero;
	private JTextField nivel;
	private JTextField ventas;
	private JTextField clientesCaptados;
	private JTextField sueldo;
	
	private JPanel contenedorCamposLayout;
	private JPanel contenedorCampoDinamico;
	private JButton botonCrearNuevoEmpleado;	

	public FormularioCrearEmpleado() {		
		this.contenedorCampoDinamico = new JPanel(new BorderLayout());

		this.setLayout(new BorderLayout());		
		this.setVisible(true);		
		
		insertarCabecera();
		insertarCamposFormulario();
		validarTipoEmpleado();
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
		contenedorCamposLayout = new JPanel(new BorderLayout());
		contenedorCamposLayout.setPreferredSize(new Dimension(900, 500));
		contenedorCamposLayout.setBorder(new EmptyBorder(0,0,0,0));
		
		camposFormulario = new JPanel();		
		camposFormulario.setLayout(new GridLayout(0, 2, 20, 10));
		
		String[] tiposDeEmpleados = {"Empleado Freelance", "Tecnico", "Ingeniero Junior", "Ingeniero Senior"};
		JPanel labelDropdownTipoEmpleados = obtenerDropDownTipoEmpleados("Elije el tipo de empleado a crear", tiposDeEmpleados, "seleccionTipoEmpleado");
		contenedorCamposLayout.add(labelDropdownTipoEmpleados, BorderLayout.NORTH);
		
		nombre = new JTextField();
		JPanel labelNombre = obtenerCampo("Nombre");
		labelNombre.add(nombre);
		
		apellido = new JTextField();
		JPanel labelApellido = obtenerCampo("Apellido");
		labelApellido.add(apellido);
		
		cedula = new JTextField();
		JPanel labelCedula = obtenerCampo("Cedula");
		labelCedula.add(cedula);
		
		fechaNacimiento = new JTextField();
		JPanel labelFechaNacimiento = obtenerCampo("Fecha de nacimiento: Usa Formato yyyy-mm-dd");
		labelFechaNacimiento.add(fechaNacimiento);
		
		telefono = new JTextField();;
		JPanel labelTelefono = obtenerCampo("Telefono");
		labelTelefono.add(telefono);
		
		email = new JTextField();
		JPanel labelEmail = obtenerCampo("Email: Solo recibe correos @unbosque.edu.co");
		labelEmail.add(email);
		
		direccion = new JTextField();
		JPanel labelDireccion = obtenerCampo("Direccion");
		labelDireccion.add(direccion);
		
		fechaIngreso = new JTextField();
		JPanel labelFechaIngreso = obtenerCampo("Fecha de ingreso: Usa Formato yyyy-mm-dd");
		labelFechaIngreso.add(fechaIngreso);	
		
		String[] generos = {"Masculino", "Femenino"};
		JPanel labelDropdownGeneros = obtenerDropDownGeneros("Genero", generos, "seleccionGenero");
		
		camposFormulario.add(labelNombre);	
		camposFormulario.add(labelApellido);	
		camposFormulario.add(labelCedula);	
		camposFormulario.add(labelFechaNacimiento);	
		camposFormulario.add(labelTelefono);	
		camposFormulario.add(labelEmail);	
		camposFormulario.add(labelDireccion);	
		camposFormulario.add(labelFechaIngreso);	
		camposFormulario.add(labelDropdownGeneros);
		camposFormulario.add(contenedorCampoDinamico);
		
		contenedorCamposLayout.add(camposFormulario, BorderLayout.CENTER);
		insertarSeccionBoton();
		
		JPanel seccion = new JPanel();
		seccion.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;	
		gbc.fill = GridBagConstraints.BOTH; 
		seccion.add(contenedorCamposLayout, gbc);		
		
		this.add(seccion, BorderLayout.CENTER);
	}
	
	public void insertarSeccionBoton() {
		JPanel contenedorGeneral = new JPanel();
		contenedorGeneral.setLayout(new BorderLayout());
		contenedorGeneral.setPreferredSize(new Dimension(900, 80));
		contenedorGeneral.setBorder(new EmptyBorder(12,0,0,0));
		
		JPanel seccionEnviar = new JPanel(new GridLayout(1, 1));
		seccionEnviar.setBorder(new EmptyBorder(0,0,20,0));		
		
		botonCrearNuevoEmpleado = new JButton("Enviar");
		botonCrearNuevoEmpleado.setActionCommand("enviarDatosNuevoEmpleado");
		
		seccionEnviar.add(botonCrearNuevoEmpleado);
		
		contenedorGeneral.add(seccionEnviar);
		
		contenedorCamposLayout.add(contenedorGeneral, BorderLayout.SOUTH);
	}
	
	public JPanel obtenerCampo(String titulo) {
		JPanel labelContainer = new JPanel(new GridLayout(2, 1));
		JLabel tituloLabel = new JLabel(titulo);
		labelContainer.add(tituloLabel);
		
		return labelContainer;
	}
	
	public JPanel obtenerDropDownTipoEmpleados(String titulo, String[] lista, String command) {
		JPanel labelContainer = new JPanel(new GridLayout(2, 1));
		JLabel tituloLabel = new JLabel(titulo);
		tipoEmpleado = new JComboBox<>(lista);
		tipoEmpleado.setActionCommand(command);
		tipoEmpleado.addActionListener(this);
		
		labelContainer.setBorder(new EmptyBorder(0,0,12,0));
		labelContainer.add(tituloLabel);
		labelContainer.add(tipoEmpleado);
		
		return labelContainer;
	}
	
	public JPanel obtenerDropDownGeneros(String titulo, String[] lista, String command) {
		JPanel labelContainer = new JPanel(new GridLayout(2, 1));
		JLabel tituloLabel = new JLabel(titulo);
		genero = new JComboBox<>(lista);
		genero.setActionCommand(command);
		genero.addActionListener(this);
		
		labelContainer.setBorder(new EmptyBorder(0,0,12,0));
		labelContainer.add(tituloLabel);
		labelContainer.add(genero);
		
		return labelContainer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		
		if (c.equals("seleccionTipoEmpleado")) {
			validarTipoEmpleado();
		}
	}
	
	public void validarTipoEmpleado() {			
		vaciarCampoDinamico();
		
		String selectedItem = ""+this.tipoEmpleado.getSelectedItem();	
		
		switch(selectedItem) {
		case "Empleado Freelance": 			
			clientesCaptados = new JTextField();
			JPanel labelClientesCaptados = obtenerCampo("Clientes Captados");
			labelClientesCaptados.add(clientesCaptados);
			contenedorCampoDinamico.add(labelClientesCaptados);
			break;
		case "Ingeniero Junior":
			nivel = new JTextField();
			JPanel labelNivel = obtenerCampo("Nivel");
			labelNivel.add(nivel);
			contenedorCampoDinamico.add(labelNivel);
			break;
		case "Ingeniero Senior":			
			ventas = new JTextField();
			JPanel labelVentas = obtenerCampo("Ventas");
			labelVentas.add(ventas);
			contenedorCampoDinamico.add(labelVentas);
			break;
		default:
			break;
		}	
		
		camposFormulario.revalidate();
		camposFormulario.repaint();
	}
	
	public void vaciarCampoDinamico() {
		contenedorCampoDinamico.removeAll();
		contenedorCampoDinamico.revalidate();
		contenedorCampoDinamico.repaint();
	}
	
	public boolean validarCampos() {
		boolean rta = true;
		Color c = new Color(255, 102, 102);
		
		if (getNombre() == null || !campoDeTextoGeneralValido(getNombre())) {		
			nombre.setBackground(c);
			rta = rta != false ? false : rta;
		} else if(getNombre() != null && campoDeTextoGeneralValido(getNombre())) {
			nombre.setBackground(Color.white);			
		}
		
		if (getApellido() == null || !campoDeTextoGeneralValido(getApellido())) {
			apellido.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getApellido() != null && campoDeTextoGeneralValido(getApellido())){
			apellido.setBackground(Color.white);
		}
		
		if (getCedula() == null || !campoDeNumeroValido(getCedula())) {
			cedula.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getCedula() != null && campoDeNumeroValido(getCedula())){
			cedula.setBackground(Color.white);
		}

		if (getFechaNacimiento() == null || !campoDeFechaValido(getFechaNacimiento())) {
			fechaNacimiento.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getFechaNacimiento() != null && campoDeFechaValido(getFechaNacimiento())){
			fechaNacimiento.setBackground(Color.white);
		}
		
		if (getTelefono() == null || !campoDeNumeroValido(getTelefono())) {
			telefono.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getTelefono() != null || campoDeNumeroValido(getTelefono())){
			telefono.setBackground(Color.white);
		}

		if (getEmail() == null || !campoDeCorreoElectronicoValido(getEmail())) {
			email.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getEmail() != null && campoDeCorreoElectronicoValido(getEmail())){
			email.setBackground(Color.white);
		}		
		
		if (getDireccion() == null || !campoDeDireccionValido(getDireccion())) {
			direccion.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getDireccion() != null && campoDeDireccionValido(getDireccion())) {
			direccion.setBackground(Color.white);
		}		
		
		if (getFechaIngreso() == null || !campoDeFechaValido(getFechaIngreso())) {
			fechaIngreso.setBackground(c);
			rta = rta != false ? false : rta;
		} else if (getFechaIngreso() != null && campoDeFechaValido(getFechaIngreso())){
			fechaIngreso.setBackground(Color.white);
		}

		switch(""+this.tipoEmpleado.getSelectedItem()) {
		case "Empleado Freelance": 			
			if (getClientesCaptados() == null || !campoDeNumeroValido(getClientesCaptados())) {
				clientesCaptados.setBackground(c);
				rta = rta != false ? false : rta;
			} else if (getClientesCaptados() != null && campoDeNumeroValido(getClientesCaptados())){
				clientesCaptados.setBackground(Color.white);
			}
			break;
		case "Ingeniero Junior":
			if (getNivel() == null || !campoDeNumeroValido(getNivel())) {
				nivel.setBackground(c);
				rta = rta != false ? false : rta;
			} else if (getNivel() != null && campoDeNumeroValido(getNivel())){
				nivel.setBackground(Color.white);
			}
			break;
		case "Ingeniero Senior":			
			if (getVentas() == null || !campoDeNumeroValido(getVentas())) {
				ventas.setBackground(c);
				rta = rta != false ? false : rta;
			} else if (getVentas() != null && campoDeNumeroValido(getVentas())){
				ventas.setBackground(Color.white);
			}
			break;
		default:
			break;
		}
		
		return rta;
	}
	
	public boolean campoDeTextoGeneralValido(String texto) {
		boolean rta = false;
		
		String input = texto;		
		Pattern p = Pattern.compile("^[a-zA-Z]+(?:[' -]?[a-zA-Z]+)*$");
		rta = p.matcher(input).matches();
		
		return rta;		
	}
	
	public boolean campoDeDireccionValido(String texto) {
		boolean rta = false;
		
		String input = texto;		
		Pattern p = Pattern.compile("^[a-zA-Z0-9#\\- ]+$");
		rta = p.matcher(input).matches();
		
		return rta;		
	}
	
	public boolean campoDeCorreoElectronicoValido(String texto) {
		boolean rta = false;
		
		String input = texto;		
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@unbosque\\.edu\\.co$");
		rta = p.matcher(input).matches();
		
		return rta;		
	}
	
	public boolean campoDeFechaValido(String texto) {
		boolean rta = false;
		
		String input = texto;		
		Pattern p = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
		rta = p.matcher(input).matches();
		
		return rta;		
	}
	
	public boolean campoDeNumeroValido(String texto) {
		boolean rta = false;
		
		String input = texto;		
		Pattern p = Pattern.compile("^\\d{1,15}$");
		rta = p.matcher(input).matches();
		
		return rta;		
	}
	
	public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
	
	public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

	public JComboBox<String> getTipoEmpleado() {
		return tipoEmpleado;
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getApellido() {
		return apellido.getText();
	}

	public String getCedula() {
		return cedula.getText();
	}

	public String getFechaNacimiento() {
		return fechaNacimiento.getText();
	}

	public String getTelefono() {
		return telefono.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getDireccion() {
		return direccion.getText();
	}

	public String getFechaIngreso() {
		return fechaIngreso.getText();
	}

	public String getGenero() {
		return ""+genero.getSelectedItem();
	}

	public String getNivel() {
		return nivel.getText();
	}

	public String getVentas() {
		return ventas.getText();
	}

	public String getClientesCaptados() {
		return clientesCaptados.getText();
	}

	public JButton getBotonCrearNuevoEmpleado() {
		return botonCrearNuevoEmpleado;
	}
}
