package ar.edu.unlam.PBII.BilleteraVirtual;

public class Prestamo12Cuotas extends Prestamo {

	public Prestamo12Cuotas(Cuenta cuenta, Double valorTotal) {
		super(cuenta, valorTotal);
		tasaDeInteres = 100;
		interesTotal  = valorSolicitado * tasaDeInteres  / 100; 
		valorFinalPagar = valorSolicitado + interesTotal;
		crearCuotas();
	}
	
	private void crearCuotas() {
		Double valorCuota = valorFinalPagar / 3;
		
		for(int i = 0; i < 12; i++) {
			Cuota cuota = new Cuota(i+1,valorCuota);
			cuotas.add(cuota);
		}
	}

}
