package com.jdbc.model;

public class Vehiculo {

	private int id;
	private String placa;
	private String marca;
	private String modelo;
	private String cilindraje;
	private String anio;
	private String consumo;

	// Constructor vacio
	public Vehiculo() {
	}

	// Metodos get y set

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", cilindraje=" + cilindraje
				+ ", anio=" + anio + ", consumo=" + consumo + "]";
	}

	
	/*public String toString() {
		return "Vehiculo [placa=" + this.placa + ", marca=" + this.marca + ", modelo=" + this.modelo + "]";
	}*/
	
	

}
