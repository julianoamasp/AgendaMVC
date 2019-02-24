package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	public static void main(String args[]) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsuarioEntity");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId(0);
		usuario.setNome("ronron");
		usuario.setEmail("ronrogn@gmail.com");
		usuario.setSenha("123");
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
}
