package ar.edu.unlam.asignacionascientos;

import java.util.HashSet;

public class Empresa {

	private String nombre;
	private HashSet<Vuelo> vuelos;
	private HashSet<Pasajero> Pasajeros;
	private HashSet<AsignacionAsiento> asignacionesAsientos;
	private HashSet<Avion> aviones;

	public Empresa(String nombre) {

		this.nombre = nombre;
		this.vuelos = new HashSet<Vuelo>();
		this.Pasajeros = new HashSet<Pasajero>();
		this.asignacionesAsientos = new HashSet<AsignacionAsiento>();
		this.aviones = new HashSet<Avion>();
	}

	public Boolean registrarAvion(Avion avion) {
		return this.aviones.add(avion);
	}

	public Boolean registrarVuelo(Vuelo vuelo) {
		return this.vuelos.add(vuelo);
	}

	public Boolean registraPasajero(Pasajero pasajero) {
		return this.Pasajeros.add(pasajero);
	}

	
	public Boolean asignarPasajeroAUnVuelo(Integer idVuelo, Integer dni){
			Boolean salida=false;
			for(AsignacionAsiento asignacion : this.asignacionesAsientos) {
				
				if(idVuelo.equals(asignacion.getVuelo().getId()) && dni.equals(asignacion.getPasajero().getDni())) {			
					this.asignacionesAsientos.add(asignacion);
					salida=true;
			}
				else{
					salida=false;
				}
		}
			return salida;
		
	}

	
	public Boolean verificarSiExisteUnAsientoEnUnAvion(Integer idAvion, String asiento) {
		for(Avion avion : aviones) {
			
			if(idAvion.equals(avion.getId()) && avion.getListaAsientos().contains(asiento)) {
				
				return true;
			}
		}
		return false;
	}

	public Boolean verificarAsientoDisponibleParaUnVuelo(Integer idVuelo, String asiento) {
			for(AsignacionAsiento asignacion : this.asignacionesAsientos) {
				if(idVuelo.equals(asignacion.getVuelo().getId()) && asiento.equals(asignacion.getAsiento())) {
				return false;	
			}
		}
		return true;
	}

	public Boolean asignarAsientoPasajeroParaUnVuelo(Integer idVuelo, Integer dni, String numeroAsiento) {
				for(AsignacionAsiento asignacion : this.asignacionesAsientos) {
					if(idVuelo.equals(asignacion.getVuelo().getId()) && dni.equals(asignacion.getPasajero().getDni()) && numeroAsiento.equals(asignacion.getAsiento())) {
						this.asignacionesAsientos.add(asignacion);
						return true;
					}	
		}		
		return false;
	}

	public HashSet<String> obtenerListaDeasientoDeUnAvion(Integer idAvion) {
		for(Avion avion : this.aviones) {
			if(idAvion.equals(avion.getId())) {	
			return avion.getListaAsientos();		
			}
		}		
		return null;
	}

	public HashSet<AsignacionAsiento> obtenerListaDeAsientoOcupadosDeUnVuelo(Integer idVuelo) {
			for(AsignacionAsiento asignacion : this.asignacionesAsientos) {
				if(idVuelo.equals(asignacion.getVuelo().getId()) && asignacion.getAsiento() != null) {
					return this.asignacionesAsientos;
				}		
		}
		return null;
	}

	public HashSet<AsignacionAsiento> obtenerListaDeAsientoDisponibleDeUnVuelo(Integer idVuelo) {
			   for (AsignacionAsiento asignacion : this.asignacionesAsientos) {
				   if (idVuelo.equals(asignacion.getVuelo().getId()) && asignacion.getAsiento().isEmpty()) {
					return this.asignacionesAsientos;
				}
		}
		return null;
	}
	
	public Boolean cambiarAsientoDeUnPasajeroParaUnVuelo(Integer idVuelo, Integer dni, String nuevoAsiento) {
		for(AsignacionAsiento asignacion : this.asignacionesAsientos) {
			if(idVuelo.equals(asignacion.getVuelo().getId()) && dni.equals(asignacion.getPasajero().getDni())) {
				asignacion.setAsiento(nuevoAsiento);
				return true;
			}		
		}
		return false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(HashSet<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public HashSet<Pasajero> getPasajeros() {
		return Pasajeros;
	}

	public void setPasajeros(HashSet<Pasajero> pasajeros) {
		Pasajeros = pasajeros;
	}

	public HashSet<AsignacionAsiento> getAsignacionesAsientos() {
		return asignacionesAsientos;
	}

	public void setAsignacionesAsientos(HashSet<AsignacionAsiento> asignacionesAsientos) {
		this.asignacionesAsientos = asignacionesAsientos;
	}

	public HashSet<Avion> getAviones() {
		return aviones;
	}

	public void setAviones(HashSet<Avion> aviones) {
		this.aviones = aviones;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", vuelos=" + vuelos + ", Pasajeros=" + Pasajeros
				+ ", asignacionesAsientos=" + asignacionesAsientos + ", aviones=" + aviones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Pasajeros == null) ? 0 : Pasajeros.hashCode());
		result = prime * result + ((asignacionesAsientos == null) ? 0 : asignacionesAsientos.hashCode());
		result = prime * result + ((aviones == null) ? 0 : aviones.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((vuelos == null) ? 0 : vuelos.hashCode());
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
		Empresa other = (Empresa) obj;
		if (Pasajeros == null) {
			if (other.Pasajeros != null)
				return false;
		} else if (!Pasajeros.equals(other.Pasajeros))
			return false;
		if (asignacionesAsientos == null) {
			if (other.asignacionesAsientos != null)
				return false;
		} else if (!asignacionesAsientos.equals(other.asignacionesAsientos))
			return false;
		if (aviones == null) {
			if (other.aviones != null)
				return false;
		} else if (!aviones.equals(other.aviones))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (vuelos == null) {
			if (other.vuelos != null)
				return false;
		} else if (!vuelos.equals(other.vuelos))
			return false;
		return true;
	}

	
}
