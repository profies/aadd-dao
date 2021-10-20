package es.iestetuan.dam2.vo;

import java.util.ArrayList;
import java.util.List;

public class PerfilAprendizaje {
	private String id;
	private int orden;
	private String tipo;
	private String descripcion;
	private InfoGeneral general;
	private String sentimientos ;
	private String comportamientos;
	private String necesidades;
	private String reconocimiento;
	private String identificacion;
	private String ayudaInterna;
	private String ayudaExterna;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSentimientos() {
		return sentimientos;
	}
	public void setSentimientos(String sentimientos) {
		this.sentimientos = sentimientos;
	}
	public String getComportamientos() {
		return comportamientos;
	}
	public void setComportamientos(String comportamientos) {
		this.comportamientos = comportamientos;
	}
	public String getNecesidades() {
		return necesidades;
	}
	public void setNecesidades(String necesidades) {
		this.necesidades = necesidades;
	}
	public String getReconocimiento() {
		return reconocimiento;
	}
	public void setReconocimiento(String reconocimiento) {
		this.reconocimiento = reconocimiento;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getAyudaInterna() {
		return ayudaInterna;
	}
	public void setAyudaInterna(String ayudaInterna) {
		this.ayudaInterna = ayudaInterna;
	}
	public String getAyudaExterna() {
		return ayudaExterna;
	}
	public void setAyudaExterna(String ayudaExterna) {
		this.ayudaExterna = ayudaExterna;
	}
	public InfoGeneral getGeneral() {
		return this.general;
	}
	public void setGeneral(InfoGeneral info) {
		this.general=info;
	}
}
