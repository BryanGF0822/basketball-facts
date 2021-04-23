package model;

public class Player {
	
	private String nombre;
	private int edad;
	private String equipo;
	private int puntosPorPartido;
	private int rebotesPorPartido;
	private int asistenciasPorPartido;
	private int robosPorPartido;
	private int bloqueosPorPartido;
	private int faltasPorPartido;
	
	public Player(String nombre, int edad, String equipo, int puntosPorPartido, int rebotesPorPartido,
			int asistenciasPorPartido, int robosPorPartido, int bloqueosPorPartido, int faltasPorPartido) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.equipo = equipo;
		this.puntosPorPartido = puntosPorPartido;
		this.rebotesPorPartido = rebotesPorPartido;
		this.asistenciasPorPartido = asistenciasPorPartido;
		this.robosPorPartido = robosPorPartido;
		this.bloqueosPorPartido = bloqueosPorPartido;
		this.faltasPorPartido = faltasPorPartido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getPuntosPorPartido() {
		return puntosPorPartido;
	}

	public void setPuntosPorPartido(int puntosPorPartido) {
		this.puntosPorPartido = puntosPorPartido;
	}

	public int getRebotesPorPartido() {
		return rebotesPorPartido;
	}

	public void setRebotesPorPartido(int rebotesPorPartido) {
		this.rebotesPorPartido = rebotesPorPartido;
	}

	public int getAsistenciasPorPartido() {
		return asistenciasPorPartido;
	}

	public void setAsistenciasPorPartido(int asistenciasPorPartido) {
		this.asistenciasPorPartido = asistenciasPorPartido;
	}

	public int getRobosPorPartido() {
		return robosPorPartido;
	}

	public void setRobosPorPartido(int robosPorPartido) {
		this.robosPorPartido = robosPorPartido;
	}

	public int getBloqueosPorPartido() {
		return bloqueosPorPartido;
	}

	public void setBloqueosPorPartido(int bloqueosPorPartido) {
		this.bloqueosPorPartido = bloqueosPorPartido;
	}

	public int getFaltasPorPartido() {
		return faltasPorPartido;
	}

	public void setFaltasPorPartido(int faltasPorPartido) {
		this.faltasPorPartido = faltasPorPartido;
	}
	
	
	
	
}
