package ar.edu.unlam.PBII.BilleteraVirtual;

public class Prestamo3Cuotas extends Prestamo {

	public Prestamo3Cuotas(Cuenta cuentaBuscada, Double valorSolicitado) {
		super(cuentaBuscada, valorSolicitado);
		tasaDeInteres = 25;
		interesTotal  = valorSolicitado * tasaDeInteres  / 100; 
		valorFinalPagar = valorSolicitado + interesTotal;
		crearCuotas();
	}

	private void crearCuotas() {
		Double valorCuota = valorFinalPagar / 3;
		
		for(int i = 0; i < 3; i++) {
			Cuota cuota = new Cuota(i+1,valorCuota);
			cuotas.add(cuota);
		}
	}

}
