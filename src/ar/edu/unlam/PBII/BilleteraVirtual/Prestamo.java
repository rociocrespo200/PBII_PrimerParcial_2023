package ar.edu.unlam.PBII.BilleteraVirtual;

import java.util.HashSet;

public class Prestamo {
	
	Cuenta cuenta;
	Double valorSolicitado,interesTotal,valorFinalPagar; 
	Integer tasaDeInteres;
	HashSet<Cuota> cuotas;
	
	
	public Prestamo(Cuenta cuenta, Double valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
		this.cuenta = cuenta;
		cuotas = new HashSet<Cuota>();
		cuenta.sumarDinero(valorSolicitado);

	}


	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public Double getValorSolicitado() {
		return valorSolicitado;
	}


	public void setValorSolicitado(Double valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}


	public Double getInteresTotal() {
		return interesTotal;
	}


	public void setInteresTotal(Double interesTotal) {
		this.interesTotal = interesTotal;
	}


	public Double getValorFinalPagar() {
		return valorFinalPagar;
	}


	public void setValorFinalPagar(Double valorFinalPagar) {
		this.valorFinalPagar = valorFinalPagar;
	}


	public Integer getTasaDeInteres() {
		return tasaDeInteres;
	}


	public void setTasaDeInteres(Integer tasaDeInteres) {
		this.tasaDeInteres = tasaDeInteres;
	}


	public HashSet<Cuota> getCuotas() {
		return cuotas;
	}


	public void setCuotas(HashSet<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	
	
	
	

}
