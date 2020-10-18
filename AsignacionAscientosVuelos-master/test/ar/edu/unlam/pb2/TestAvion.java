package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.asignacionascientos.AsignacionAsiento;
import ar.edu.unlam.asignacionascientos.Avion;
import ar.edu.unlam.asignacionascientos.Empresa;
import ar.edu.unlam.asignacionascientos.Pasajero;
import ar.edu.unlam.asignacionascientos.Vuelo;

public class TestAvion {

	@Test
	public void testQueRegistreUnAvion() {
		Empresa latam = new Empresa("latam");
	Avion avion1=new Avion(34,"ms3");
	assertTrue(latam.registrarAvion(avion1));
	}
	@Test
	public void testQueRegistreUnVuelo() {
		Empresa latam = new Empresa("latam");
		Avion avion2=new Avion(33, "lop");
		Vuelo vuelo1=new Vuelo(28,"klo","lou",avion2);
		assertTrue(latam.registrarVuelo(vuelo1));
	}
	@Test
	public void testQueRegistreUnPasajero() {
		Empresa latam = new Empresa("latam");
		Avion avion2=new Avion(33, "lop");
		Vuelo vuelo1=new Vuelo(28,"klo","lou",avion2);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		assertTrue(latam.registraPasajero(pasajero1));
	}

	@Test
	public void testQueAsigneUnPasajeroAUnVuelo() {
		Empresa latam = new Empresa("latam");
		Avion avion2=new Avion(33, "lop");
		Vuelo vuelo1=new Vuelo(28,"klo","lou",avion2);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,vuelo1,pasajero1, "1C");
		latam.getAsignacionesAsientos().add(asignacion);
		
		
		//System.out.println(latam.getAsignacionesAsientos().size());
		//latam.asignarPasajeroAUnVuelo(28, 40345987);
		
		latam.registrarAvion(avion2);
		latam.registrarVuelo(vuelo1);
		latam.registraPasajero(pasajero1);
		latam.asignarPasajeroAUnVuelo(28, 40345987);
		
		assertTrue(latam.asignarPasajeroAUnVuelo(28, 40345987));
	}
	
	@Test
	public void testVerifiqueSiExisteUnAsientoEnUnAvion() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		miEmpresa.getAsignacionesAsientos().add(asignacion);
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		miAvion.getListaAsientos().add("22B");
		
		
		
		assertTrue(miEmpresa.verificarSiExisteUnAsientoEnUnAvion(11, "22B"));
	}
	
	@Test
	public void testQueVerifiqueAsientoDisponibleEnUnVuelo() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		
		assertTrue(miEmpresa.verificarAsientoDisponibleParaUnVuelo(14, "22B"));
		
	}
	
	@Test
	public void testQueAsigneAsientoAPasajeroEnUnVuelo() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		
		miEmpresa.getAsignacionesAsientos().add(asignacion);
		
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		assertTrue(miEmpresa.asignarAsientoPasajeroParaUnVuelo(13, 40345987, "22B"));
	}
	
	@Test
	public void testQueCambieAsientoDePasajeroParaUnVuelo() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		miEmpresa.getAsignacionesAsientos().add(asignacion);
		
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		assertTrue(miEmpresa.cambiarAsientoDeUnPasajeroParaUnVuelo(13, 40345987, "22J"));
		
	}
	
	@Test
	public void testQueMuestreListaDeAsientosDeUnAvion() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		miEmpresa.getAsignacionesAsientos().add(asignacion);
		
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		miAvion.getListaAsientos().add("22B");
		miAvion.getListaAsientos().add("22C");
		HashSet<String> listaAsientosAvion = miAvion.getListaAsientos();
		
		for (String asientos : listaAsientosAvion) {
			System.out.println(asientos);
		}
	}
	
	@Test
	public void testQueMuestreLaListaDeAsientosOcupadosDeUnVuelo() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		miEmpresa.getAsignacionesAsientos().add(asignacion);
		
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		HashSet<AsignacionAsiento> listaAsientosOcupados = miEmpresa.getAsignacionesAsientos();
		
		for(AsignacionAsiento asignacion1 : listaAsientosOcupados) {
			System.out.println("Asientos Ocupados: " + asignacion1);
		}
	}
	
	@Test
	public void testQueMuestreListaDeAsientosDisponiblesParaUnVuelo() {
		Empresa miEmpresa = new Empresa("Air France");
		Avion miAvion = new Avion(11,"HJK");
		Vuelo miVuelo = new Vuelo(13,"EZE","BRA", miAvion);
		Pasajero pasajero1=new Pasajero(40345987,"roman");
		AsignacionAsiento asignacion = new AsignacionAsiento(1,miVuelo,pasajero1,"22B");
		miEmpresa.getAsignacionesAsientos().add(asignacion);
		
		miEmpresa.registrarAvion(miAvion);
		miEmpresa.registrarVuelo(miVuelo);
		miEmpresa.registraPasajero(pasajero1);
		
		
		
		HashSet<AsignacionAsiento> listaAsientosDisponibles = miEmpresa.getAsignacionesAsientos();
		
		for(AsignacionAsiento asignacion2 : listaAsientosDisponibles) {
			
			System.out.println("Asientos Disponibles" + asignacion2);
		}

	}
}
