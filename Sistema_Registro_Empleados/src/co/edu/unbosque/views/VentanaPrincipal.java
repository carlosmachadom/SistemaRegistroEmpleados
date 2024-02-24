package co.edu.unbosque.views;

import java.awt.*;
import javax.swing.*;

import co.edu.unbosque.model.Personal;

public class VentanaPrincipal extends JFrame{	
	// Creación de contenedor y layout que intercambie ventanas dependiendo lo necesario
	private LayoutDinamico layout;
	
	public VentanaPrincipal() {		
		this.setTitle("Sistema de gestión Empleados");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1440, 1024);
		this.setLayout(new BorderLayout());
		//this.pack();
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		layout = new LayoutDinamico();		
		this.add(layout, BorderLayout.CENTER);
	}
	
	public LayoutDinamico getLayoutDinamico() {
		return layout;
	}
}
