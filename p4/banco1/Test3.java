package uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Test3 {
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("UnidadPersistenciaAlumnos");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	public void prueba() {
	
		Cliente c1 = new Cliente();
		c1.setNombre = "Carlos";
		c1.setApellidos = "Marañes Palotes";
		c1.setDNI = "123456789A";
		c1.fechaNac = "12/05/2018";
		c1.direccion = "c/estercolero,Muel,Espanya";
		
		Cliente c2 = new Cliente();
		c1.setNombre = "Nicolas";
		c1.setApellidos = "Lera MC";
		c1.setDNI = "987654321B";
		c1.fechaNac = "12/03/2018";
		c1.direccion = "c/guay,Jaca,Espanya";
		
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(c1);
			em.persist(c2);
			trans.commit();
		} catch (PersistenceException e) {
			if (trans.isActive()) {
				trans.rollback();
			}
		}

		Oficina of = new Oficina();
		of.setCodigo = 1;
		of.setTelefono = "192837465";
		of.direccion = "C/mayor, Zgz";
	
		trans.begin();
		try {
			em.persist(of);
			trans.commit();
		} catch (PersistenceException e) {
			if (trans.isActive()) {
				trans.rollback();
			}
		}
		
		//Primera cuenta
		Ahorro cu1 = new Ahorro();
		cu1.setIBAN = "45ES 123456789";
		cu1.setSaldo = 100000000;
		cu1.setFecha_creacion = 12/12/2034;
		cu1.setCcc = 123456789;
		cu1.setInteres = 0.05;
		clientes.add(c2);
		
		//Segunda cuenta
		Corriente cu2 = new Corriente();
		cu1.setIBAN = "45ES 987654321";
		cu1.setSaldo = -5;
		cu1.fecha_creacion = 12/11/2034;
		cu1.setCcc = 987654321;
		clientes.add(c1);
		
		trans.begin();
		try {
			em.persist(cu1);
			em.persist(cu2);
			em.flush();
			trans.commit();
		} catch (PersistenceException e) {
			if (trans.isActive()) {
				trans.rollback();
			}
		}
		
		Operacion op = new Operacion();
		op.setFecha = 12/05/2035;
		op.setHora  = "12:12:12";
		op.setDescripcion = "MUY CHULA";

		Operacion op = new Operacion();
		op.setFecha = 15/07/2035;
		op.setHora  = "14:12:12";
		op.setDescripcion = "ERRRRRRRONEA";
		
		EntityTransaction trans1 = em.getTransaction();
		trans1.begin();
		try{
			em.persist(e1);
			em.persist(e2);
			trans1.commit();
		} catch (PersistenceException e) {
			if (trans.isActive()) {
				trans1.rollback();
			}
		}
		
		Profesor p1 = new Profesor();
		p1.setDireccionContacto(d3);
		p1.setEdad(40);
		p1.setNombre("Pepe");
		p1.setPuesto("Prof1");
		p1.addAsignatura(a3);
		p1.addAsignatura(a2);
		p1.addTelefono(t4);
		t4.setPersona(p1);
		
		Profesor p2 = new Profesor();
		p2.setDireccionContacto(d4);
		p2.setEdad(39);
		p2.setNombre("Juana");
		p2.setPuesto("Prof2");
		p2.addAsignatura(a1);
		p2.addAsignatura(a2);
		
		trans.begin();
		try{
			em.persist(p1);
			em.persist(p2);
			trans.commit();
		} catch (PersistenceException e) {
			if (trans.isActive()) {
				trans.rollback();
			}
		}
		
//		Telefono t5 = new Telefono();
//		t5.setTelefono(888);
//		trans.begin();
//		try{
//			e1.addTelefono(t5);
//			em.persist(e1);
//			trans.commit();
//			
//		} catch (PersistenceException e) {
//			if (trans.isActive()) {
//				trans.rollback();
//			}
//		}
//		System.out.println(em.contains(t5));

	}
	
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.prueba();
	}
	

}
