package co.edu.unbosque.views;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class LayoutDinamico extends JPanel {
	private CardLayout layout;		
	private Dashboard dashboard;
	private FormularioCrearEmpleado formularioNuevoEmpleado;

	public LayoutDinamico() {
		layout = new CardLayout();		
		this.setLayout(layout);
		this.setVisible(true);
		
		dashboard = new Dashboard();
		formularioNuevoEmpleado = new FormularioCrearEmpleado();
		
		
		this.add(dashboard, "Dashboard");
		this.add(formularioNuevoEmpleado, "FormularioCrearNuevoEmpleado");
		mostrarVista("Dashboard");
	}

	public void mostrarVista(String vista) {
		layout.show(this, vista);
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public FormularioCrearEmpleado getFormularioNuevoEmpleado() {
		return formularioNuevoEmpleado;
	}
}
