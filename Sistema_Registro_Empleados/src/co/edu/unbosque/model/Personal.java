package co.edu.unbosque.model;

import java.util.ArrayList;

public class Personal {
	private ArrayList<Tecnico> tecnicos;
	private ArrayList<EmpleadoFreelance> freelancers;
	private ArrayList<IngenieroJunior> juniors;
	private ArrayList<IngenieroSenior> seniors;

	public Personal() {
		this.tecnicos = new ArrayList<Tecnico>();
		this.freelancers = new ArrayList<EmpleadoFreelance>();
		this.juniors = new ArrayList<IngenieroJunior>();
		this.seniors = new ArrayList<IngenieroSenior>();
	}

	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public ArrayList<EmpleadoFreelance> getFreelos() {
		return freelancers;
	}

	public ArrayList<IngenieroJunior> getJuniors() {
		return juniors;
	}

	public ArrayList<IngenieroSenior> getSenior() {
		return seniors;
	}
	
	public void agregarNuevoEmpleado(Empleado e) {		
		if (e instanceof IngenieroJunior) {
			juniors.add((IngenieroJunior) e);
		}
		
		if (e instanceof IngenieroSenior) {
			seniors.add((IngenieroSenior) e);
		}
		
		if (e instanceof Tecnico) {
			tecnicos.add((Tecnico) e);
		}
		
		if (e instanceof EmpleadoFreelance) {
			freelancers.add((EmpleadoFreelance) e);
		}
	}
	
	public Empleado buscarEmpleado(String cc, String tipoDeEmpleado) {
		Empleado e = null;
		
		switch(tipoDeEmpleado) {
			case "Ingeniero Junior": 
				for (IngenieroJunior empleado : juniors) {
					if (empleado.getCedula().equals(cc)) {
						e = empleado;
					}
				}
			break;
			
			case "Ingeniero Senior":
				for (IngenieroSenior empleado : seniors) {
					if (empleado.getCedula().equals(cc)) {
						e = empleado;
					}
				}
			break;
			
			case "Tecnico":
				for (Tecnico empleado : tecnicos) {
					if (empleado.getCedula().equals(cc)) {
						e = empleado;
					}
				}
			break;
			
			case "Freelance":
				for (EmpleadoFreelance empleado : freelancers) {
					if (empleado.getCedula().equals(cc)) {
						e = empleado;
					}
				}
			break;
			
			default:
				break;
		}
		
		return e;
	}
}
