package model;

import java.util.Arrays;
import java.util.List;

public class EventoInfantil extends Entrada implements Interfaz{
	
	private int edad;
    private boolean souvenir;
    private String genero;
    private static double costoMenor = 250.0;
    private static double costoMayor = 500.0;

	private static final List<String> generosValidos=Arrays.asList("Circo", "Festival de Arte", "Feria de Libros");
	

	public EventoInfantil(String nombreEvento, String diaEvento, String horarioEvento, int duracionEvento,
			int edad, String genero, boolean souvenir) {
		super(nombreEvento, diaEvento, horarioEvento, duracionEvento);
		this.edad = edad;
		
		if (validarGenero(genero)) {
            this.setGenero(genero);
        } else {
            throw new IllegalArgumentException("El género proporcionado no es válido para un recital.");
        }
		this.souvenir = souvenir;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isSouvenir() {
		return souvenir;
	}
	public void setSouvenir(boolean souvenir) {
		this.souvenir = souvenir;
	}
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nGenero: ").append(genero);
		sb.append("\nEdad: ").append(edad);
		
		if (souvenir) {
			sb.append("\nSouvenir: ").append("SI");
	    }else {
	    	sb.append("\nSouvenir: ").append("NO");
	    }
		
		return sb.toString();
	}

	@Override
	public void calcularCosto() {
		if (this.edad < 8) {
            setCosto(costoMenor); 
        } else {
            setCosto(costoMayor); 
        }
	}

	@Override
	public boolean validarGenero(String genero) {
		return generosValidos.contains(genero);
	}
}
