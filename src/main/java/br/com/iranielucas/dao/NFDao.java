package br.com.iranielucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.iranielucas.entidade.NotaFiscal;

public class NFDao {
	public void armazenarNoBanco(NotaFiscal notaFiscal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(notaFiscal);

		em.getTransaction().commit();
		em.close();
	}
}
