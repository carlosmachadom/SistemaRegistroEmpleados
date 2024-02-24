package co.edu.unbosque.views;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class LayoutDinamico extends JPanel {
	private CardLayout layout;		
	private Dashboard dashboard;

	public LayoutDinamico() {
		layout = new CardLayout();		
		this.setLayout(layout);
		this.setVisible(true);
		
		dashboard = new Dashboard();
		
		this.add(dashboard, "Dashboard");
		mostrarVista("Dashboard");
	}

	public void mostrarVista(String vista) {
		layout.show(this, vista);
	}

	public Dashboard getDashboard() {
		return dashboard;
	}
}
