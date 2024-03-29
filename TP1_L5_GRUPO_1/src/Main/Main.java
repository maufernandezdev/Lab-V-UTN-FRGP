package Main;
import model.Entrada;
import model.Recital;
import model.Teatro;

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
	}

}
