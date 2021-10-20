package es.iestetuan.dam2.vo;

import java.util.ArrayList;
import java.util.List;

public class ModeloAprendizaje {
	private int id;
	private String clave;
	private String descripcion;
	private String detalle;
	private List<PerfilAprendizaje> perfiles = new ArrayList<PerfilAprendizaje>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public List<PerfilAprendizaje> getPerfilesAprendizaje() {
		return perfiles;
	}
	public void addPerfilAprendizaje(PerfilAprendizaje perfilAprendizaje) {
		this.perfiles.add(perfilAprendizaje);
	}	
}
