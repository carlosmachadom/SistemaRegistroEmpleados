package co.edu.unbosque.views;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioGeneral extends JPanel {
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
	
	private JComboBox<String> tipoEmpleado;
	private JButton botonGeneral;
	
	// Elementos variables
	private String tituloFormulario;
	private String tipoFormulario;

	public FormularioGeneral(String tituloFormulario, String tipoFormulario) {
		this.tituloFormulario = tituloFormulario;
		this.tipoFormulario = tipoFormulario;
		
		this.setLayout(new BorderLayout());		
		this.setVisible(true);
		
			
	}
	
	public void insertarCabecera() {
		JPanel cabecera = new JPanel();		
		JLabel tituloFormulario = new JLabel(this.tituloFormulario);
		tituloFormulario.setFont(new Font("Arial", Font.BOLD, 18));
		tituloFormulario.setHorizontalAlignment(JLabel.LEFT);
		tituloFormulario.setVerticalAlignment(JLabel.CENTER);
		tituloFormulario.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		cabecera.add(tituloFormulario);
		this.add(cabecera, BorderLayout.NORTH);
	}
	
	public void insertarFomulario() {
		JPanel cuerpoFormulario = new JPanel();
		cuerpoFormulario.setLayout(new BorderLayout());
		
		
	}
	
	public JPanel obtenerCampo(JTextField ref, String titulo) {
		JPanel labelContainer = new JPanel();
		JLabel tituloLabel = new JLabel(titulo);
		ref = new JTextField();
		
		return new JPanel();
	}
	
}
