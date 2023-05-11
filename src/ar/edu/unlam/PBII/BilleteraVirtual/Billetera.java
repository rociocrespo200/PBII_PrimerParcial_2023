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

	public void retirarDinero(Integer id, Double montoARetirar) {
		Cuenta cuentaBuscada = buscarCuenta(id);
	if(cuentaBuscada != null && verificarSaldo(montoARetirar, cuentaBuscada) == true) {
		cuentaBuscada.restarDinero(montoARetirar);
	}
	}

	

}
