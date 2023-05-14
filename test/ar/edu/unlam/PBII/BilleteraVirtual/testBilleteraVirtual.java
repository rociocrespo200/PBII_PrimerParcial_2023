package ar.edu.unlam.PBII.BilleteraVirtual;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBilleteraVirtual {

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
		Cuenta cuentaDestino;
		Integer idDestino = 4;
		String nombreDestino = "karen";
		cuentaDestino = new Cuenta(idDestino, nombreDestino);
		Double montoTransferir = 500.0, montoEsperado = 500.0;
		
		actual.agregarCuenta(cuentaDestino);
		actual.agregarCuenta(cuenta);
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);	
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
		Double montoTransferir = 500.0;
		Double dineroAIngresar = 1000.0;
		cuenta = new Cuenta(idOrigen,nombre);
		
		actual.agregarCuenta(cuenta);
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
	
		
		assertFalse(actual.transferirDineroAOtraCuenta(montoTransferir, 1, 4));
	}
	@Test
	public void queNoSePuedaTransferirSiNoHaySuficienteDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer idOrigen = 1;
		String nombre = "Rocio";
		Cuenta cuentaDestino;
		Integer idDestino = 4;
		String nombreDestino = "karen";
		
		cuenta = new Cuenta(idOrigen,nombre);
		cuentaDestino = new Cuenta(idDestino, nombreDestino);
		actual.agregarCuenta(cuentaDestino);
		actual.agregarCuenta(cuenta);
		
		Double montoTransferir = 500.0, dineroAIngresar = 400.0;
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		
		assertFalse(actual.transferirDineroAOtraCuenta(montoTransferir, 1, 4));
		
	}
	
	@Test
	public void queSePuedaRetirarDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		Double dineroAIngresar = 1000.0;
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		
		Double montoARetirar = 200.0, montoEsperado = 800.0;
		cuentaBuscada= actual.buscarCuenta(id);
		
		assertTrue(actual.retirarDinero(id, montoARetirar));
		assertEquals(montoEsperado, cuentaBuscada.getSaldoPesos());
		
	}
	
	@Test
	public void queNOSePuedaRetirarDineroSiNoHaySuficienteDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double dineroAIngresar = 1000.0;
		actual.ingresarDineroEncuenta(cuenta, dineroAIngresar);
		cuentaBuscada= actual.buscarCuenta(id);
		
		Double montoARetirar = 1200.0;
		actual.retirarDinero(id, montoARetirar);
		
		assertFalse(actual.retirarDinero(id, montoARetirar));
		assertEquals(dineroAIngresar, cuentaBuscada.getSaldoPesos());
	}
	
	@Test
	public void queSePuedaSolicitarUnPrestamoEnTresCuotas() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		assertEquals(montoSolicitado, cuentaBuscada.getSaldoPesos());
	}
	
	@Test
	public void queSePuedaSolicitarUnPrestamoEnSeisCuotas() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		
		Prestamo prestamo = new Prestamo6Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		assertEquals(montoSolicitado, cuentaBuscada.getSaldoPesos());
	}
	
	@Test
	public void queSePuedaSolicitarUnPrestamoEnDoceCuotas() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		
		Prestamo prestamo = new Prestamo12Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		assertEquals(montoSolicitado, cuentaBuscada.getSaldoPesos());
	}
	
	@Test
	public void queSeCreenLasCuotasParaPrestamo3Cuotas() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		assertEquals(3, cuentaBuscada.getPrestamo().cuotas.size());
	}
	
	@Test
	public void queSeCreeenLasCuotasParaPrestamo6Cuotas() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		
		Prestamo prestamo = new Prestamo6Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		assertEquals(6, cuentaBuscada.getPrestamo().cuotas.size());
	}
	
	@Test
	public void queSeCreeenLasCuotasParaPrestamo12Cuotas() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		
		Prestamo prestamo = new Prestamo12Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		assertEquals(12, cuentaBuscada.getPrestamo().cuotas.size());
	}
	
	@Test
	public void queNOSePuedaSacarUnPrestamoMenorA30000() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		cuentaBuscada = actual.buscarCuenta(id);
		
		Double montoSolicitado = 20000.0;
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		
		assertFalse(actual.solicitarPrestamo(id, prestamo));
	}
	
	@Test
	public void queNOSePuedaSacarUnPrestamoMayorA100000() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		cuentaBuscada = actual.buscarCuenta(id);
		
		Double montoSolicitado = 200000.0;
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		
		assertFalse(actual.solicitarPrestamo(id, prestamo));
	}

	
	@Test
	public void queNOSePuedaRealizarDosPrestamosALaVez() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Matias";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitadoDelPrimerPrestamo = 50000.0;
		Double montoSolicitadoDelSegundoPrestamo = 60000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		Prestamo prestamoUno = new Prestamo3Cuotas(cuentaBuscada, montoSolicitadoDelPrimerPrestamo);
		Prestamo prestamoDos = new Prestamo3Cuotas(cuentaBuscada, montoSolicitadoDelSegundoPrestamo);
		
		actual.solicitarPrestamo(id, prestamoUno);
		actual.solicitarPrestamo(id, prestamoDos);
		
		assertEquals(montoSolicitadoDelPrimerPrestamo,cuentaBuscada.getPrestamo().getValorSolicitado());
	}


	
	@Test
	public void queSePuedaConsultarElEstadoDelPrestamo() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio", valorEsperado, valorObtenido;
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double montoSolicitado = 100000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		actual.obtenerResumenDePrestamo(cuenta);
		valorEsperado = prestamo.toString() + prestamo.getCuotas().toString();
		valorObtenido = actual.obtenerResumenDePrestamo(cuenta);
		
		assertEquals(valorEsperado, valorObtenido);
	}

	
	@Test
	public void queSePuedaPagarCuotaDePrestamo() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		Boolean estaPagada_esperado = true;
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);	
		Double montoSolicitado = 60000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		Double valorEsperado = 35000.0;
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		
		Integer idCuota = 1;
		actual.pagarCuotaPrestamo(cuentaBuscada,idCuota );
		
		assertEquals(valorEsperado, cuentaBuscada.getSaldoPesos());
		assertEquals(estaPagada_esperado, actual.buscarCuotaPorId(cuentaBuscada, idCuota).getEstaPagada());
	}

	
	@Test
	public void queNOSePuedaPagarCuotaDePrestamoSiNoHaySuficienteDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta, cuentaBuscada;
		Integer id = 1;
		String nombre = "Rocio";
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Double valorEsperado = 0.0;
		Double montoSolicitado = 60000.0;
		cuentaBuscada = actual.buscarCuenta(id);
		Prestamo prestamo = new Prestamo3Cuotas(cuentaBuscada, montoSolicitado);
		actual.solicitarPrestamo(id, prestamo);
		actual.retirarDinero(id, montoSolicitado);
		
		Integer idCuota = 1;
		actual.pagarCuotaPrestamo(cuentaBuscada,idCuota );
		
		assertEquals(valorEsperado, cuentaBuscada.getSaldoPesos());
	}
	
	@Test
	public void queSePuedaComprarDolares() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		Double dineroAIngresar = 30000.0;
		Double valorEsperado = 20.0;
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Cuenta cuentaBuscada = actual.buscarCuenta(id);
		actual.ingresarDineroEncuenta(cuentaBuscada, dineroAIngresar);
		
		Double montoAConvertirEnPesos = 10000.0;
		actual.comprarDolares(cuentaBuscada, montoAConvertirEnPesos);
		
		assertEquals(valorEsperado, cuentaBuscada.getSaldoDolares());
	}
	
	@Test
	public void queNOSePuedaComprarDolaresSiNoHaySuficienteDinero() {
		Billetera actual = new Billetera();
		Cuenta cuenta;
		Integer id = 1;
		String nombre = "Rocio";
		Double dineroAIngresar = 350.0;
		Double valorEsperado = 0.0;
		cuenta = new Cuenta(id,nombre);
		actual.agregarCuenta(cuenta);
		Cuenta cuentaBuscada = actual.buscarCuenta(id);
		actual.ingresarDineroEncuenta(cuentaBuscada, dineroAIngresar);
		
		Double montoAConvertirEnPesos = 10000.0;
		actual.comprarDolares(cuentaBuscada, montoAConvertirEnPesos);
		
		assertEquals(valorEsperado, cuentaBuscada.getSaldoDolares());
	}


}

