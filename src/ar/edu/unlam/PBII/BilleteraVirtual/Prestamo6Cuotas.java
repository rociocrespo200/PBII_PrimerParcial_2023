package ar.edu.unlam.PBII.BilleteraVirtual;

public class Prestamo6Cuotas extends Prestamo {

	public Prestamo6Cuotas(Cuenta cuenta, Double valorTotal) {
		super(cuenta, valorTotal);
		tasaDeInteres = 50;
		interesTotal  = valorSolicitado * tasaDeInteres  / 100; 
		valorFinalPagar = valorSolicitado + interesTotal;
		crearCuotas();
	}
	
	private void crearCuotas() {
		Double valorCuota = valorFinalPagar / 3;
		
		for(int i = 0; i < 6; i++) {
			Cuota cuota = new Cuota(i+1,valorCuota);
			cuotas.add(cuota);
		}
	}

}
