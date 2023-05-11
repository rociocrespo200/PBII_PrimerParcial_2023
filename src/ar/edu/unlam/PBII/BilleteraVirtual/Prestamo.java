package ar.edu.unlam.PBII.BilleteraVirtual;

import java.util.HashSet;

public class Prestamo {
	
	Double valorTotal;
	Integer tasaDeInteres;
	HashSet<Cuota> cuotas;
	
	
	public Prestamo(Double valorTotal) {
		this.valorTotal = valorTotal;
		cuotas = new HashSet<Cuota>();
	}
	
	
	

}
