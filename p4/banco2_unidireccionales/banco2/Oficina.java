package banco2;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "OFICINA")
public class Oficina {
    private String codigo;
    private String direccion;
    private String telefono;

    @Id
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "TELEFONO")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
//    @OneToMany(mappedBy = "oficinaByOficina")
//    //@JoinColumn(name = "oficina")
//	private Collection<Ingreso> ingreso;// = new HashSet<IngresoRetirada>();
//
//	public Collection<Ingreso> getIngreso() {
//		return ingreso;
//	}
//
//	public void setIngreso(Collection<Ingreso> ingreso) {
//		this.ingreso = ingreso;
//	}
	

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Oficina that = (Oficina) o;
//        return Objects.equals(codigo, that.codigo) &&
//                Objects.equals(direccion, that.direccion) &&
//                Objects.equals(telefono, that.telefono);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(codigo, direccion, telefono);
//    }
    
//    @OneToMany(mappedBy = "oficinaByOficina")
//	//private Set<Corriente> corrientes; //= new HashSet<Corriente>();
//    private Collection<Corriente> corrientes;
//
//	public Collection<Corriente> getCorrientes() {
//		return corrientes;
//	}
//
//	public void setCorrientes(Collection<Corriente> corrientes) {
//		this.corrientes = corrientes;
//	}
   

}
