package co.edu.unbosque.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.EmpleadoFreelance;
import co.edu.unbosque.model.IngenieroJunior;
import co.edu.unbosque.model.IngenieroSenior;
import co.edu.unbosque.model.Tecnico;

public class TablaGeneral extends JPanel{
	private JPanel contenido;
	
	public TablaGeneral() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);		

		insertarPanelCabecera();
		contenido = new JPanel();		
		contenido.setBorder(new EmptyBorder(0,0,0,0));
		this.add(contenido, BorderLayout.CENTER);
		
	}
	
	public void insertarPanelCabecera() {
		JPanel cabeceraTabla = new JPanel();
		cabeceraTabla.setLayout(new GridLayout(1, 5));	
		cabeceraTabla.setBorder(new EmptyBorder(0,0,0,0));
		cabeceraTabla.setBackground(new Color(128, 128, 128, 255));
		
		JPanel seccionNombre = obtenerLabelCabecera("Nombre y apellido");		
		JPanel seccionId = obtenerLabelCabecera("Cedula");		
		JPanel seccionFechaIngreso = obtenerLabelCabecera("Fecha de Ingreso");
		JPanel seccionTelefono = obtenerLabelCabecera("Telefono");
		JPanel seccionSalario = obtenerLabelCabecera("Salario");
		
		cabeceraTabla.add(seccionNombre);
		cabeceraTabla.add(seccionId);
		cabeceraTabla.add(seccionFechaIngreso);
		cabeceraTabla.add(seccionTelefono);
		cabeceraTabla.add(seccionSalario);
		
		this.add(cabeceraTabla, BorderLayout.NORTH);
	}

	public void insertarContenidoTabla(ArrayList<?> lista) {		
		vaciarContenidoTabla();
		contenido.setLayout(new GridLayout(lista.size(), 1));
		
		for (Object obj : lista) {
	        if (obj instanceof Tecnico) {
	            Tecnico tecnico = (Tecnico) obj;
	            JPanel fila = obtenerFila(tecnico.getNombre(), tecnico.getApellido(), tecnico.getCedula(), tecnico.getTelefono(), tecnico.getFechaIngreso(), "" + tecnico.getSalarioBase());
	            contenido.add(fila);
	        } else if (obj instanceof EmpleadoFreelance) {
	            EmpleadoFreelance freelance = (EmpleadoFreelance) obj;
	            JPanel fila = obtenerFila(freelance.getNombre(), freelance.getApellido(), freelance.getCedula(), freelance.getTelefono(), freelance.getFechaIngreso(), "" + freelance.getSalarioBase());
	            contenido.add(fila);
	        } else if (obj instanceof IngenieroJunior) {
	            IngenieroJunior junior = (IngenieroJunior) obj;
	            JPanel fila = obtenerFila(junior.getNombre(), junior.getApellido(), junior.getCedula(), junior.getTelefono(), junior.getFechaIngreso(), "" + junior.getSalarioBase());
	            contenido.add(fila);
	        } else if (obj instanceof IngenieroSenior) {
	            IngenieroSenior senior = (IngenieroSenior) obj;
	            JPanel fila = obtenerFila(senior.getNombre(), senior.getApellido(), senior.getCedula(), senior.getTelefono(), senior.getFechaIngreso(), "" + senior.getSalarioBase());
	            contenido.add(fila);
	        }
	    }
		
		contenido.revalidate();
	    contenido.repaint();
	}
	
	public void vaciarContenidoTabla() {
        contenido.removeAll();
        contenido.revalidate();
        contenido.repaint();
    }
	
	public JPanel obtenerLabelCabecera(String nombreSeccion) {		
		JPanel seccion = new JPanel();
		seccion.setBorder(new LineBorder(Color.BLACK, 1));
		seccion.setBackground(new Color(0, 0, 0, 0));
		
		JLabel titulo = new JLabel(nombreSeccion);		
		
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setHorizontalAlignment(JLabel.LEFT);
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		seccion.add(titulo);
		
		return seccion;
	}
	
	public JPanel obtenerFila(String nombre, String apellido, String cedula, String telefono, String fechaIngreso, String salario) {
		JPanel fila = new JPanel();
		fila.setLayout(new GridLayout(1, 4));	
		fila.setBorder(new EmptyBorder(0,0,0,0));
		
		JPanel seccionNombre = this.obtenerLabelsFilaDeTabla(nombre + " " + apellido);
		JPanel seccionId = this.obtenerLabelsFilaDeTabla(cedula);
		JPanel seccionFechaIn = this.obtenerLabelsFilaDeTabla(fechaIngreso);
		JPanel seccionTel = this.obtenerLabelsFilaDeTabla(telefono);
		JPanel seccionSalario = this.obtenerLabelsFilaDeTabla(salario);
		
		fila.add(seccionNombre);
		fila.add(seccionId);
		fila.add(seccionFechaIn);
		fila.add(seccionTel);
		fila.add(seccionSalario);
		
		return fila;
	}
	
	public JPanel obtenerLabelsFilaDeTabla(String data) {
		JPanel seccion = new JPanel();
		seccion.setBorder(new LineBorder(Color.BLACK, 1));
		seccion.setBackground(new Color(0, 0, 0, 0));
		
		JLabel titulo = new JLabel(data);		
		
		titulo.setFont(new Font("Arial", Font.PLAIN, 18));
		titulo.setHorizontalAlignment(JLabel.LEFT);
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		seccion.add(titulo);
		
		return seccion;
	}
}
