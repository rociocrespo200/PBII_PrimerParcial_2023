package ar.edu.unlam.PBII.BilleteraVirtual;

import java.util.HashSet;

public class Billetera {
	
	HashSet<Cuenta> cuentas;

	public Billetera() {
		cuentas = new HashSet<Cuenta>();
	}

	public boolean agregarCuenta(Cuenta cuenta) {
		if(!cuentas.contains(cuenta)) {
		cuentas.add(cuenta);
		return true;
		}
		return false;
	}

	public Cuenta buscarCuenta(Integer id) {
		for(Cuenta cuenta : cuentas) {
			if(cuenta.getId() == id) {
				return cuenta;
			}
		}
		return null;
	}

	public void transferirDineroAOtraCuenta(Double montoTransferir, Integer idOrigen, Integer idDestino) {
		Cuenta cuentaOrigen = buscarCuenta(idOrigen);
		Cuenta cuentaDestino = buscarCuenta(idDestino);
		if (cuentaDestino != null &&
			cuentaOrigen.getSaldoPesos()>= montoTransferir) {
			cuentaOrigen.extraerDineroDeCuenta(montoTransferir);
			cuentaDestino.ingresarDineroEnCuenta(montoTransferir);
	}
	
	}

}
