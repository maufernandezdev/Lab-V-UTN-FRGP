package Main;
import model.Entrada;
import model.Recital;
import model.Teatro;
import model.Deporte;
import model.Deporte.TipoDeporte;

public class Main {

	public static void main(String[] args) {

		//datos para prueba recital
		Entrada[] entradas = new Entrada[3];		
		
		Recital recitalVip = new Recital("Recital de Heavy", "Sábado 21-1-24", "20:00", 3, "Banda musical 1", "heavy metal", true);
		Recital recitalGral = new Recital("Recital de Pop", "Domingo 22-1-24", "21:00", 3, "Banda musical 2", "pop", false);
		
		Teatro teatro = new Teatro("Obra de teatro","Jueves 28-3-24","19:00", 2,"Drama");

		entradas[0] = recitalVip;
		entradas[1] = recitalGral;	
		
		entradas[2]=teatro;
		
		recitalVip.agregarBandaSoporte("Banda soporte 1");
		recitalVip.agregarBandaSoporte("Banda soporte 2");
		
		teatro.agregarActor("Tomas");
		teatro.agregarActor("Marcos");
		
		
		for (Entrada e : entradas) {
			System.out.println(e);
		}
		
		/* [MRF - 29/03/2024] prueba clase deporte */
		System.out.println("--------------------------------------");
		System.out.println("¡Entradas correspondientes a deportes!");
		Entrada[] entradasDeporte = new Entrada[3];	
		entradasDeporte[0] = new Deporte("Copa Argentina", "21-1-24", "19:00", 2, "futbol", TipoDeporte.NACIONAL);
		entradasDeporte[1] = new Deporte("Copa Mundial", "01-06-26", "12:00", 2, "futbol", TipoDeporte.INTERNACIONAL);
		Deporte entradaRugby = new Deporte("Campeonato local", "01-06-24", "13:00", 2, "rugby", TipoDeporte.NACIONAL);
		entradaRugby.setTipo(TipoDeporte.INTERNACIONAL);
		entradasDeporte[2] =  entradaRugby;
		
		for (Entrada e : entradasDeporte) {
			System.out.println(e.toString());
		}
		System.out.println("--------------------------------------");
	}

}
