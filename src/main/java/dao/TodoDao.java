package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.TodoUser;

public class TodoDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveUser(TodoUser user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}
}
