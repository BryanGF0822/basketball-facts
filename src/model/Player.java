package model;

public class Player {

	private String nombre;
	private int edad;
	private String equipo;
	private double puntosPorPartido;
	private double rebotesPorPartido;
	private double asistenciasPorPartido;
	private double robosPorPartido;
	private double bloqueosPorPartido;
	private double faltasPorPartido;

	public Player(String nombre, int edad, String equipo, double puntosPorPartido, double rebotesPorPartido,
			double asistenciasPorPartido, double robosPorPartido, double bloqueosPorPartido, double faltasPorPartido) {

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

	public double getPuntosPorPartido() {
		return puntosPorPartido;
	}

	public void setPuntosPorPartido(double puntosPorPartido) {
		this.puntosPorPartido = puntosPorPartido;
	}

	public double getRebotesPorPartido() {
		return rebotesPorPartido;
	}

	public void setRebotesPorPartido(double rebotesPorPartido) {
		this.rebotesPorPartido = rebotesPorPartido;
	}

	public double getAsistenciasPorPartido() {
		return asistenciasPorPartido;
	}

	public void setAsistenciasPorPartido(double asistenciasPorPartido) {
		this.asistenciasPorPartido = asistenciasPorPartido;
	}

	public double getRobosPorPartido() {
		return robosPorPartido;
	}

	public void setRobosPorPartido(double robosPorPartido) {
		this.robosPorPartido = robosPorPartido;
	}

	public double getBloqueosPorPartido() {
		return bloqueosPorPartido;
	}

	public void setBloqueosPorPartido(double bloqueosPorPartido) {
		this.bloqueosPorPartido = bloqueosPorPartido;
	}

	public double getFaltasPorPartido() {
		return faltasPorPartido;
	}

	public void setFaltasPorPartido(double faltasPorPartido) {
		this.faltasPorPartido = faltasPorPartido;
	}

	@Override
	public String toString() {
		return nombre + "," + edad + "," + equipo + "," + puntosPorPartido + "," + rebotesPorPartido + ","
				+ asistenciasPorPartido + "," + robosPorPartido + "," + bloqueosPorPartido + "," + faltasPorPartido;
	}

}
