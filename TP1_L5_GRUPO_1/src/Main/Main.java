package Main;
import model.Entrada;
import model.Recital;

public class Main {

	public static void main(String[] args) {

		//datos para prueba recital
		Entrada[] entradas = new Entrada[2];		
		
		Recital recitalVip = new Recital("Recital de Heavy", "Sábado 21-1-24", "20:00", 3, "Banda musical 1", "heavy metal", true);
		Recital recitalGral = new Recital("Recital de Pop", "Domingo 22-1-24", "21:00", 3, "Banda musical 2", "pop", false);

		entradas[0] = recitalVip;
		entradas[1] = recitalGral;	
		
		recitalVip.agregarBandaSoporte("Banda soporte 1");
		recitalVip.agregarBandaSoporte("Banda soporte 2");
		
		for (Entrada e : entradas) {
			System.out.println(e);
		}
	}

}
