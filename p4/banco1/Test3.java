package banco1;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import uni.Persona;

public class Test3 {
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("UnidadPersistenciaAlumnos");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	public void prueba() {
	
		Cliente c1 = new Cliente();
		c1.setNombre("Carlos");
		c1.setApellidos("Marañes Palotes");
		c1.setDNI("123456789A");
		
		String lastCrawlDate = "2018-05-12";
		java.util.Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		c1.setFechaNac(sqlDate);
		c1.setDireccion("c/estercolero,Muel,Espanya");
		
		Cliente c2 = new Cliente();
		c2.setNombre("Nicolas");
		c2.setApellidos("Lera MC");
		c2.setDNI("987654321B");
		
		lastCrawlDate = "2018-03-12";
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		sqlDate = new java.sql.Date(utilDate.getTime());

		c2.setFechaNac(sqlDate);
		c2.setDireccion("c/guay,Jaca,Espanya");
		
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
		of.setCodigo(1);
		of.setTelefono(192837465);
		of.setDireccion("C/mayor, Zgz");
	
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
		cu1.setIBAN("45ES123456789");
		cu1.setSaldo(100000000);
		
		
		lastCrawlDate = "2034-12-12";
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sqlDate = new java.sql.Date(utilDate.getTime());
		
		cu1.setFecha_creacion(sqlDate);
		cu1.setCcc(123456789);
		cu1.setInteres(0.05);
		cu1.addCliente(c2);
		
		//Segunda cuenta
		Corriente cu2 = new Corriente();
		cu2.setIBAN("45ES987654321");
		cu2.setSaldo(-5);
		
		lastCrawlDate = "2034-11-12";
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sqlDate = new java.sql.Date(utilDate.getTime());
		
		cu2.setFecha_creacion(sqlDate);
		cu2.setCcc(987654321);
		cu2.addCliente(c1);
		
		trans.begin();
		try {
			em.persist(cu1);
			em.persist(cu2);
			em.flush();
			trans.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (trans.isActive()) {
				trans.rollback();
			}
		}
		
		Operacion op = new Operacion();
		op.setCuentaOrigen(cu1);
		op.setCodigo(1);
		
		lastCrawlDate = "2035-05-12";
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sqlDate = new java.sql.Date(utilDate.getTime());
		
		op.setFecha(sqlDate);
		op.setHora("12:12:12");
		op.setDescripcion("MUY CHULA");

		Operacion op2 = new Operacion();
		op.setCuentaOrigen(cu2);
		op.setCodigo(1);
		
		lastCrawlDate = "2035-05-15";
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sqlDate = new java.sql.Date(utilDate.getTime());
		
		op2.setFecha(sqlDate);
		op2.setHora("14:12:12");
		op2.setDescripcion("ERRRRRRRONEA");
		
		EntityTransaction trans1 = em.getTransaction();
		trans1.begin();
		try{
			em.persist(op);
			em.persist(op2);
			trans1.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (trans.isActive()) {
				trans1.rollback();
			}
		}
		
		String q15 = "select p.descripcion from H_OPERACION p";
		Query query15 = em.createQuery(q15);
		List<String> res15 = query15.getResultList();
		System.out.println(res15);
		
		
		q15 = "select p.descripcion from H_CUENTA";
		query15 = em.createQuery(q15);
		res15 = query15.getResultList();
		System.out.println(res15);
	
	}
	
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.prueba();
	}
	

}