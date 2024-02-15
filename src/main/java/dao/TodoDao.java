package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.TodoTask;
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
	
	public List<TodoUser> findByEmail(String email)
	{	
		return manager.createQuery("select x from TodoUser x where email=?1").setParameter(1, email).getResultList();
	}
	
	public void saveTask(TodoTask task) {
		transaction.begin();
		manager.persist(task);
		transaction.commit();
	}
}
