package src.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facturas", catalog = "dialer")
public class Factura {

	@Id
	private Integer id;
	private Date created;
	private Date fecha;
	private Integer serie;
	private Integer id_cliente;

	private static Factura instance;

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public static Factura getInstance() {
		if (instance == null) {
			instance = new Factura();
		}
		return instance;
	}

	public Factura getByid(Factura factura, Integer id) {
		return Factura.getInstance().getByid(this, id);

	}

}
