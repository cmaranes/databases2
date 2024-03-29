package banco2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ingreso")
public class Ingreso extends Operacion{
	@Column(name = "OFICINA")
	private String oficina;
	
  private Oficina oficinaByOficina;
  @ManyToOne
  @JoinColumn(name = "OFICINA", referencedColumnName = "CODIGO", insertable = false, updatable = false)
  public Oficina getOficinaByOficina() {
      return oficinaByOficina;
  }

  public void setOficinaByOficina(Oficina oficinaByOficina) {
      this.oficinaByOficina = oficinaByOficina;
  }

public String getOficina() {
	return oficina;
}

public void setOficina(String oficina) {
	this.oficina = oficina;
}

}
