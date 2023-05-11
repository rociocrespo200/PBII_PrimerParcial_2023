package ar.edu.unlam.PBII.BilleteraVirtual;

public class Cuenta {
	
	Integer id;
	String nombre;
	Double saldoPesos, saldoDolares;
	Prestamo prestamo;
	
	public Cuenta(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		saldoPesos = 0.0;
		saldoDolares = 0.0;
		prestamo = null;
	}

	public boolean extraerDineroDeCuenta(Double montoAExtraer) {
		if(montoAExtraer <= this.saldoPesos) {
			this.saldoPesos = saldoPesos - montoAExtraer;
			return true;
		}
		return false;
	}

	public void ingresarDineroEnCuenta(Double montoADepositar) {
		
		this.saldoPesos = saldoPesos + montoADepositar;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldoPesos() {
		return saldoPesos;
	}

	public void setSaldoPesos(Double saldoPesos) {
		this.saldoPesos = saldoPesos;
	}

	public Double getSaldoDolares() {
		return saldoDolares;
	}

	public void setSaldoDolares(Double saldoDolares) {
		this.saldoDolares = saldoDolares;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
	

}
