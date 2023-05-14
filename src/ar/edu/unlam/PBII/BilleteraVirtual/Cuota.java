package ar.edu.unlam.PBII.BilleteraVirtual;

public class Cuota {
	
	Integer id;
	Double valor;
	Boolean estaPagada;
	
	public Cuota(Integer id, Double valor) {
		this.id = id;
		this.valor = valor;
		estaPagada = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getEstaPagada() {
		return estaPagada;
	}

	public void setEstaPagada(Boolean estaPagada) {
		this.estaPagada = estaPagada;
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
		Cuota other = (Cuota) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuota [id=" + id + ", valor=" + valor + ", estaPagada=" + estaPagada + "]";
	}


}
