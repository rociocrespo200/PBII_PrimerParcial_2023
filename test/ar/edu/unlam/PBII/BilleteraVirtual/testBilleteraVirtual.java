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
		
		Cuenta cuenta2;
		Integer id2 = 1;
		String nombre2 = "Rocio";
		
		cuenta = new Cuenta(id,nombre);
		cuenta2 = new Cuenta(id2,nombre2);
		
		actual.agregarCuenta(cuenta);
		actual.agregarCuenta(cuenta2);
		
		assertEquals(1, actual.cuentas.size());
	}
	
	@Test
	public void queSePuedaIngresarDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		
		Double dineroAIngresar = 1000.0;
		
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Cuenta cuentaBuscada = actual.buscarCuenta(id);
		actual.ingresarDineroEncuenta(cuentaBuscada, dineroAIngresar);
		
		assertEquals(dineroAIngresar, cuentaBuscada.getSaldoPesos());
		
	}
	
	@Test
	public void queSePuedaTransferirAUnaCuentaExistente() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer idOrigen = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(idOrigen,nombre);
		
		Double dineroAIngresar = 1000.0;
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		
		Cuenta cuentaDestino;
		Integer idDestino = 4;
		String nombreDestino = "karen";
		cuentaDestino = new Cuenta(idDestino, nombreDestino);
		Double montoTransferir = 500.0, montoEsperado = 500.0;
		
		actual.agregarCuenta(cuentaDestino);
		actual.agregarCuenta(cuenta);
		Cuenta cuentaOrigen = actual.buscarCuenta(1);
		Cuenta cuentaBuscada = actual.buscarCuenta(4);
	
		assertTrue(actual.transferirDineroAOtraCuenta(montoTransferir, 1,4));
		assertEquals(montoTransferir, cuentaBuscada.getSaldoPesos());
		assertEquals(montoEsperado, cuentaOrigen.getSaldoPesos());
	}
	
	@Test
	public void queNoSePuedaTransferirAUnaCuentaInexistente() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer idOrigen = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(idOrigen,nombre);
		
		Double dineroAIngresar = 1000.0;
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		
		Double montoTransferir = 500.0;
		
		actual.agregarCuenta(cuenta);
		
		assertFalse(actual.transferirDineroAOtraCuenta(montoTransferir, 1, 4));
	}
	@Test
	public void queNoSePuedaTransferirSiNoHaySuficienteDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer idOrigen = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(idOrigen,nombre);
		
		Double dineroAIngresar = 400.0;
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		
		Cuenta cuentaDestino;
		Integer idDestino = 4;
		String nombreDestino = "karen";
		cuentaDestino = new Cuenta(idDestino, nombreDestino);
		Double montoTransferir = 500.0;
		
		actual.agregarCuenta(cuentaDestino);
		actual.agregarCuenta(cuenta);
		
		assertFalse(actual.transferirDineroAOtraCuenta(montoTransferir, 1, 4));
		
	}
	
	@Test
	public void queSePuedaRetirarDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double dineroAIngresar = 1000.0;
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		
		Double montoARetirar = 200.0, montoEsperado = 800.0;
		actual.retirarDinero(id, montoARetirar);
		
		Cuenta cuentaBuscada= actual.buscarCuenta(id);
		
		assertEquals(montoEsperado, cuentaBuscada.getSaldoPesos());
		
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

