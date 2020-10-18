package ar.edu.unlam.asignacionascientos;

import java.util.HashSet;

public class Avion {
	
	private Integer id;
	private String matricula;
	private HashSet <String> listaAsientos;
	public Avion(Integer id, String matricula) {
		this.id = id;
		this.matricula = matricula;
		this.listaAsientos = new HashSet<String>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public HashSet<String> getListaAsientos() {
		return listaAsientos;
	}
	public void setListaAsientos(HashSet<String> listaAsientos) {
		this.listaAsientos = listaAsientos;
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
		Avion other = (Avion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Avion [id=" + id + ", matricula=" + matricula + ", listaAsientos=" + listaAsientos + "]";
	}
	
	

}
