package model;
import java.util.Arrays;

public class Deporte extends Entrada{
	
    public enum TipoDeporte {
        NACIONAL,
        INTERNACIONAL
    }
    private String deporte;
	private static double PRECIO_FUTBOL = 300.0;
    private static double PRECIO_RUGBY  = 450.0;
    private static double PRECIO_HOCKEY  = 380.0;
    private static double RECARGO_INTERNACIONAL  = 1.3;
    private TipoDeporte tipo;
    private static final String[] DEPORTES_DISPONIBLES = {"futbol", "rugby", "hockey"};
    
    public Deporte(String nombreEvento, String diaEvento, String horarioEvento, int duracionEvento, String deporte, TipoDeporte tipo) {
    	super(nombreEvento, diaEvento, horarioEvento, duracionEvento);
    	setDeporte(deporte);
    	setTipo(tipo);
    }
    
    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        if (Arrays.asList(DEPORTES_DISPONIBLES).contains(deporte.toLowerCase())) {
            this.deporte = deporte.toLowerCase();
        } else {
            throw new IllegalArgumentException("Deporte inexistente: " + deporte);
        }
    }
    
    public TipoDeporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeporte tipo) {
        if (tipo != TipoDeporte.NACIONAL && tipo != TipoDeporte.INTERNACIONAL) {
            throw new IllegalArgumentException("El tipo de deporte debe ser nacional o internacional.");
        }
        this.tipo = tipo;
        calcularCosto();
    }
    
	@Override
	public void calcularCosto() {
		// TODO Auto-generated method stub
		double costoBaseEntrada = 0.0;
		switch (deporte.toLowerCase()) {
        case "futbol":
        	costoBaseEntrada = PRECIO_FUTBOL;
            break;
        case "rugby":
        	costoBaseEntrada = PRECIO_RUGBY;
            break;
        case "hockey":
        	costoBaseEntrada = PRECIO_HOCKEY;
            break;
        default:
            throw new IllegalArgumentException("El deporte especificado no tiene un precio definido.");
		}

	    if (tipo == TipoDeporte.INTERNACIONAL) {
	        setCosto(costoBaseEntrada * RECARGO_INTERNACIONAL);
	    } else {
	    	setCosto(costoBaseEntrada);
	    }
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDeporte: ").append(deporte);
		sb.append("\n" + super.toString());
		sb.append("\nAmbito: ").append(tipo);
		//sb.append("\n");
		sb.append("\n**************************");
	    return sb.toString();
	}
}
