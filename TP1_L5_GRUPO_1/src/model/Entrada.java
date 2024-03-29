package model;

abstract public class Entrada {

	// Atributos
	
	private int numeroEntrada;
	private String nombreEvento;
	private String diaEvento;
	private String horarioEvento;
	private int duracionEvento;
	private Double costo;
	
	private static int cont=0; // Variable estática

	// Métodos 

	public abstract void calcularCosto(); // Método abstracto para calcular el costo de entrada
	
    // Constructor
    
	public Entrada(String nombreEvento, String diaEvento, String horarioEvento, int duracionEvento) {
		cont++;
		this.numeroEntrada = cont; // Número único de entrada
		this.nombreEvento = nombreEvento;
		this.diaEvento = diaEvento;
		this.horarioEvento = horarioEvento;
		this.duracionEvento = duracionEvento;
	}
	
	public Entrada() {
		
	}
	
	// Gets & Sets
	public int getNumeroEntrada() {
		return numeroEntrada;
	}
	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getDiaEvento() {
		return diaEvento;
	}
	public void setDiaEvento(String diaEvento) {
		this.diaEvento = diaEvento;
	}
	public String getHorarioEvento() {
		return horarioEvento;
	}
	public void setHorarioEvento(String horarioEvento) {
		this.horarioEvento = horarioEvento;
	}
	public int getDuracionEvento() {
		return duracionEvento;
	}
	public void setDuracionEvento(int duracionEvento) {
		this.duracionEvento = duracionEvento;
	}
	public double getCosto() {
        if (costo == null) {
            calcularCosto(); // Calcula el costo si no se calculo o seteo desde el main (para setearlo del main habria que poner public el setCosto)
        }
        return costo;
	}
	protected void setCosto(double costo) {  // Es del tipo Protected para permitir que las subclases lo modifiquen directamente si es necesario
		this.costo = costo;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Entrada [numeroEntrada=" + numeroEntrada + ", nombreEvento=" + nombreEvento + ", diaEvento=" + diaEvento
				+ ", horarioEvento=" + horarioEvento + ", duracionEvento=" + duracionEvento + ", costo=" + getCosto() + "]";
	}
}
