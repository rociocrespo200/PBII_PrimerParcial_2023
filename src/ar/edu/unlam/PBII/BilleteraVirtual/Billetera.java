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
	
	

}
