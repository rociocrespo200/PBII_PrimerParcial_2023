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
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		
		cuenta = new Cuenta(id,nombre);
		
		actual.agregarCuenta(cuenta);
		
		assertTrue(actual.agregarCuenta(cuenta));
	}
	
	@Test
	public void queSePuedaIngresarDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		
		Double dineroAIngresar = 1000.0;
		
		cuenta = new Cuenta(id,nombre);
		cuenta.ingresarDineroEnCuenta(dineroAIngresar);
		
		assertEquals(dineroAIngresar, cuenta.getSaldoPesos());
		
	}
	
	@Test
	public void queSePuedaTransferirAUnaCuentaExistente() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer idOrigen = 1;
		String nombre = "Rocio";
		
		Double dineroAIngresar = 1000.0;
		
		cuenta = new Cuenta(idOrigen,nombre);
		cuenta.ingresarDineroEnCuenta(dineroAIngresar);
		
		Cuenta cuentaDestino;
		Integer idDestino = 4;
		String nombreDestino = "karen";
		
		Double montoTransferir = 500.0;
		cuentaDestino = new Cuenta(idDestino, nombreDestino);
		
		actual.transferirDineroAOtraCuenta(montoTransferir, idOrigen, idDestino);
	
		assertEquals(montoTransferir, cuentaDestino.getSaldoPesos());
		
	}
	
	@Test
	public void queNoSePuedaTransferirAUnaCuentaInexistente() {
		
	}
	
	@Test
	public void queNoSePuedaTransferirSiNoHaySuficienteDinero() {
		
	}
	
	@Test
	public void queSePuedaRetirarDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		
		Double dineroAIngresar = 1000.0;
		
		cuenta = new Cuenta(id,nombre);
		cuenta.ingresarDineroEnCuenta(dineroAIngresar);
		
		Double dineroARetirar = 500.0;
		
		assertTrue(cuenta.extraerDineroDeCuenta(dineroARetirar));
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

