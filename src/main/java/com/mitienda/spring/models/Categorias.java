package com.mitienda.spring.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categorias", catalog = "dialer")
public class Categorias implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Date created;

	private String name;

	private static Categorias instance;

	public Categorias() {
	}

	public Categorias(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Categoria{" + "id=" + id + "created=" + created + ", name='" + name + '\'' + '}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Categorias getInstance() {
		if (instance == null) {
			instance = new Categorias();
		}
		return instance;
	}

	public Categorias getByid(Categorias categorias, Integer id) {
		return Categorias.getInstance().getByid(this, id);

	}
}
