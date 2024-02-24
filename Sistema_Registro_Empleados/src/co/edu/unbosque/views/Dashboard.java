package co.edu.unbosque.views;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class Dashboard extends JPanel {
	private JComboBox<String> dropDownListaEmpleados;
	private JButton crearNuevoEmpleado;
	private TablaGeneral tabla;

	public Dashboard() {
		this.setLayout(new BorderLayout());		
		this.setVisible(true);
		insertarCabecera();
		insertarSeccionTabla();
	}
	
	public void insertarCabecera() {
		JLabel titulo = new JLabel("Lista de Empleados");	
		titulo.setFont(new Font("Arial", Font.BOLD, 45));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setBorder(new EmptyBorder(40, 0, 20, 0));
		this.add(titulo, BorderLayout.NORTH);
	}
	
	public void insertarSeccionTabla() {	
		// Contenedor de tabla
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new BorderLayout());
		contenedor.setPreferredSize(new Dimension(900, 500));
		contenedor.setBorder(new EmptyBorder(0,0,0,0));
		//contenedor.setBackground(Color.black);
		
		// Contenedor de los botones de selección y crear nuevo empleado
		Box seccionBotones = Box.createHorizontalBox();
		seccionBotones.setBorder(new EmptyBorder(0,0,20,0));
		
		String[] listas = {"Empleados Freelance", "Tecnicos", "Ingenieros Junior", "Ingenieros Senior"};
		dropDownListaEmpleados = new JComboBox<>(listas);
		dropDownListaEmpleados.setActionCommand("listaEmpleadosDropdown");
		crearNuevoEmpleado = new JButton("Crear Empleado");
		crearNuevoEmpleado.setActionCommand("CrearNuevoEmpleado");
		
		seccionBotones.add(dropDownListaEmpleados);
		seccionBotones.add(Box.createHorizontalGlue());
		seccionBotones.add(crearNuevoEmpleado);
		
		contenedor.add(seccionBotones, BorderLayout.NORTH);
		
		// Contenedor de Tabla
		tabla = new TablaGeneral();
		contenedor.add(tabla, BorderLayout.CENTER);
		
		// Contenedor para centrar la tabla
		JPanel seccion = new JPanel();
		seccion.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;	
		gbc.fill = GridBagConstraints.BOTH; 
		seccion.add(contenedor, gbc);
		
		this.add(seccion, BorderLayout.CENTER);
	}

	public JComboBox<String> getDropDownListaEmpleados() {
		return dropDownListaEmpleados;
	}

	public JButton getCrearNuevoEmpleado() {
		return crearNuevoEmpleado;
	}
	
	public TablaGeneral getTablaGeneral() {
		return tabla;
	}
}
