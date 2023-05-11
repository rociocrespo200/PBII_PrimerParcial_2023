package ar.edu.unlam.PBII.BilleteraVirtual;

import java.util.HashSet;

public class Billetera {
	
	HashSet<Cuenta> cuentas;

	public Billetera() {
		cuentas = new HashSet<Cuenta>();
	}

	public void agregarCuenta(Cuenta cuenta) {
		cuentas.add(cuenta);
	
	}

	public Cuenta buscarCuenta(Integer id) {
		for(Cuenta cuenta : cuentas) {
			if(cuenta.getId() == id) {
				return cuenta;
			}
		}
		return null;
	}

	public boolean transferirDineroAOtraCuenta(Double montoTransferir, Integer idOrigen, Integer idDestino) {
		Cuenta cuentaOrigen = buscarCuenta(idOrigen);
		Cuenta cuentaDestino = buscarCuenta(idDestino);
		if (verificarSaldo(montoTransferir, cuentaOrigen) == true && cuentaDestino != null && cuentaOrigen != null) {
		cuentaOrigen.restarDinero(montoTransferir);
		cuentaDestino.sumarDinero(montoTransferir);
			return true;
			}
		return false;
	}

	private boolean verificarSaldo(Double montoTransferir, Cuenta cuentaOrigen) {
		if(cuentaOrigen.getSaldoPesos()>= montoTransferir) {
			return true;
		}
		return false;
	}

	public void ingresarDineroEncuenta(Cuenta cuentaBuscada, Double dineroAIngresar) {
		cuentaBuscada.setSaldoPesos(dineroAIngresar);
		
	}

	public boolean retirarDinero(Integer id, Double montoARetirar) {
		Cuenta cuentaBuscada = buscarCuenta(id);
		if(cuentaBuscada != null && verificarSaldo(montoARetirar, cuentaBuscada) == true) {
			cuentaBuscada.restarDinero(montoARetirar);
			return true;
		}
	return false;
	}

	public boolean solicitarPrestamo(Integer id, Prestamo prestamo) {
		Cuenta cuentaBuscada = buscarCuenta(id);
		if(cuentaBuscada != null && prestamo.getValorSolicitado() >= 30000.0 && prestamo.getValorSolicitado() <= 100000.0) {
			cuentaBuscada.solicitarPrestamo(prestamo);
			return true;
		}
		return false;
	}

	public HashSet<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(HashSet<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	
	
	

}
