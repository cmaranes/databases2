package banco2;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@DiscriminatorColumn(name="tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "CUENTA")
public class Cuenta {
    private String iban;
    private long numero;
    private long saldo;
    private Time fechacreacion;
    private String tipo;
    private Collection<Operacion> operacionsByIban;
  //  private Collection<OperacionEntity> operacionsByIban_0;

    @Id
    @Column(name = "IBAN")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Basic
    @Column(name = "NUMERO")
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "SALDO")
    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    @Basic
    @Column(name = "FECHACREACION")
    public Time getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Time fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @OneToMany(mappedBy = "cuentaByIbanorigen")
    public Collection<Operacion> getOperacionsByIban() {
        return operacionsByIban;
    }

    public void setOperacionsByIban(Collection<Operacion> operacionsByIban) {
        this.operacionsByIban = operacionsByIban;
    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cuenta that = (Cuenta) o;
//        return numero == that.numero &&
//                saldo == that.saldo &&
//                Objects.equals(iban, that.iban) &&
//                Objects.equals(fechacreacion, that.fechacreacion) &&
//                Objects.equals(tipo, that.tipo) &&
//                Objects.equals(interes, that.interes) &&
//                Objects.equals(oficina, that.oficina);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(iban, numero, saldo, fechacreacion, tipo, interes, oficina);
//    }
}
