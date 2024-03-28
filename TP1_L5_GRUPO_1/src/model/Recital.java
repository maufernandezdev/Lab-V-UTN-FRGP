package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recital extends Entrada {
	//atributos
    private String banda;
    private String genero;
    private boolean vip;
    private static double valorVip = 1500.0;
    private static double valorGral = 800.0;
    private static final int maxBandasSoporte = 2;
    private List<String> bandasSoporte;
    //lista de generos válidos
    private static final List<String> generosValidos = Arrays.asList("rock", "heavy metal", "reggaetón", "trap", "latinos", "pop");


    //constructor 
    public Recital(String nombreEvento, String diaEvento, String horarioEvento, int duracionEvento, String banda, String genero, boolean vip) {
        super(nombreEvento, diaEvento, horarioEvento, duracionEvento); //herencia
        this.banda = banda;
        //valido generos posibles si no coinciden tiro error
        if (validarGenero(genero)) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("El género proporcionado no es válido para un recital.");
        }
        this.vip = vip;
        this.bandasSoporte = new ArrayList<>();
    }

    //valido el genero en el constructor
    private boolean validarGenero(String genero) {
        return generosValidos.contains(genero.toLowerCase());
    }
              
    //getters y setters 
    
	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

    //posibilidad de asignar bandas soporte
    public boolean agregarBandaSoporte(String bandaSoporte) {
        if (bandasSoporte.size() < maxBandasSoporte) {
            bandasSoporte.add(bandaSoporte);
            return true; // ---> todo bien
        }
        return false; // ---> llegue al max
    }
    
	// metodo tostring
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()); // aca se muestra la herencia de la clase padre (datos comunes de entrada)
	    sb.append("\nBanda: ").append(banda);
	    sb.append("\nGenero: ").append(genero);
	    sb.append("\nTipo: ").append(vip ? "VIP" : "General");
	    if (!bandasSoporte.isEmpty()) {
	        sb.append("\nBandas soporte: ");
	        for (String banda : bandasSoporte) {
	            sb.append(banda).append(", ");
	        }
	        sb.delete(sb.length() - 2, sb.length()); // borro la coma y el espacio extra al final
	    }
	    return sb.toString();
	}
	
    //del método abstract de la clase padre entrada - polimorfismo 
    
    @Override
    public void calcularCosto() {
        if (vip) {
            setCosto(valorVip); // asigno valor de entradas vip
        } else {
            setCosto(valorGral); // valor entradas grales
        }
    }


    
}
