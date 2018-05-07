package banco1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="H_OPERACION")
public class Operacion {
	
	// Se supone que es una clave compuesta
	@Id
	@Column(name = "CODIGO")
	private int codigo;

	//@Id
	@ManyToOne
	//@JoinColumn(name = "IBAN")
	// https://stackoverflow.com/questions/27305950/jpa-foreign-key-that-is-also-a-primary-key-mapping
	@PrimaryKeyJoinColumn(name="CUENTAORIGEN", referencedColumnName="IBAN")
	private Cuenta cuentaOrigen;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "CANTIDAD")
	private double cantidad;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}



		

}
