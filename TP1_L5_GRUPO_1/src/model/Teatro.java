package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teatro extends Entrada implements IGenero{
	
	private String genero;
	private static final double valor = 1350.50;
	private static final int maxActores = 3;
	private List<String> actores;
	private static final List<String> generosValidos=Arrays.asList("drama", "teatro", "comedia");
	

	public Teatro(String nombreEvento, String diaEvento, String horarioEvento, int duracionEvento, String genero) {
		super(nombreEvento, diaEvento, horarioEvento, duracionEvento);
		
		if (validarGenero(genero)) this.genero = genero;
        else throw new IllegalArgumentException("El género proporcionado no es válido para un recital.");
        
		this.actores = new ArrayList<>();
	}
	
	
	public boolean agregarActor(String actor) {
		if(actores.size()< maxActores) {
			actores.add(actor);
			return true;
		}
		return false;
	}
	
	
	public String getGenero() {
		return genero;
	}
		
	public void setGenero(String genero) {
		this.genero = genero;
	}
		
	public List<String> getActores() {
		return actores;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nGenero: ").append(genero);
		
		if (!actores.isEmpty()) {
	        sb.append("\nActor/es: ");
	        for (String actor : actores) {
	            sb.append(actor).append(", ");
	        }
	        sb.delete(sb.length() - 2, sb.length());
	    }
		sb.append("\n");
	    return sb.toString();
	}


	@Override
	public void calcularCosto() {
		setCosto(valor);
		
	}

	@Override
	public boolean validarGenero(String genero) {
		return generosValidos.contains(genero.toLowerCase());
	}

}
