package com.mitienda.spring.models;

import java.sql.Connection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facturas_linea", catalog = "dialer")
public class FacturaLinea {

	private Connection con;

	@Id
	private Integer id;
	private Date created;
	private Integer id_factura;
	private String nombre;
	private Integer precio; // 100 = 1,00

	private static FacturaLinea instance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getId_factura() {
		return id_factura;
	}

	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public static FacturaLinea getInstance() {
		if (instance == null) {
			instance = new FacturaLinea();
		}
		return instance;
	}

	public FacturaLinea getByid(FacturaLinea facturalinea, Integer id) {
		return FacturaLinea.getInstance().getByid(this, id);

	}

}