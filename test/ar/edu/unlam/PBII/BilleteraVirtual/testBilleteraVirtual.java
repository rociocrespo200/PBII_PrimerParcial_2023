package ar.edu.unlam.PBII.BilleteraVirtual;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBilleteraVirtual {
	/*
	 * queSePuedaAgregarUnCuenta
	 * KAREN
	 * queNoSePuedaAgregarCuentaRepetido
	 * queSePuedaIngresarDinero
	 * queSePuedaTransferirAUnaCuentaExistente
	 * queNOSePuedaTransferirAUnaCuentaInexistente
	 * queNoSePuedaTransferirSiNoHaySuficienteDinero
	 * queSePuedaRetirarDinero
	 * ROCIO
	 * queNOSePuedaRetirarDineroSiNoHaySuficienteDinero
	 * queSePuedaSolicitarUnPrestamoEnTresCuotas
	 * queSePuedaSolicitarUnPrestamoEnSeisCuotas
	 * queSePuedaSolicitarUnPrestamoEnDoceCuotas
	 * queNOSePuedaSacarUnPrestamoMenorA30000
	 * queNOSePuedaSacarUnPrestamoMayorA100000
	 * MATIAS
	 * queNOSePuedaRealizarDosPrestamosALaVez
	 * queSePuedaConsultarElEstadoDelPrestamo
	 * queSePuedaPagarCuotaDePrestamo
	 * queNOSePuedaPagarCuotaDePrestamoSiNoHaySuficienteDinero
	 * queSePuedaComprarDolares
	 * queNOSePuedaComprarDolaresSiNoHaySuficienteDinero
	 * */

	@Test
	public void queSePuedaAgregarUnCuenta() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		
		cuenta = new Cuenta(id,nombre);
		
		actual.agregarCuenta(cuenta);
		cuentaBuscada = actual.buscarCuenta(1);
		
		assertEquals(cuenta, cuentaBuscada);
	}
	
	@Test
	public void queNoSePuedaAgregarCuentaRepetido() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaIngresarDinero() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaTransferirAUnaCuentaExistente() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queNOSePuedaTransferirAUnaCuentaInexistente() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queNoSePuedaTransferirSiNoHaySuficienteDinero() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaRetirarDinero() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queNOSePuedaRetirarDineroSiNoHaySuficienteDinero() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaSolicitarUnPrestamoEnTresCuotas() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaSolicitarUnPrestamoEnSeisCuotas() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaSolicitarUnPrestamoEnDoceCuotas() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queNOSePuedaSacarUnPrestamoMenorA30000() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queNOSePuedaSacarUnPrestamoMayorA100000() {
		fail("Not yet implemented");
	}

	
	@Test
	public void queNOSePuedaRealizarDosPrestamosALaVez() {
		fail("Not yet implemented");
	}

	
	@Test
	public void queSePuedaConsultarElEstadoDelPrestamo() {
		fail("Not yet implemented");
	}

	
	@Test
	public void queSePuedaPagarCuotaDePrestamo() {
		fail("Not yet implemented");
	}

	
	@Test
	public void queNOSePuedaPagarCuotaDePrestamoSiNoHaySuficienteDinero() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queSePuedaComprarDolares() {
		fail("Not yet implemented");
	}
	
	@Test
	public void queNOSePuedaComprarDolaresSiNoHaySuficienteDinero() {
		fail("Not yet implemented");
	}


}

