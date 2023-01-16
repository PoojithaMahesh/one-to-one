
package one_to_one_uni_ass_dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_ass_dto.PanCard;
import one_to_one_uni_ass_dto.Person;

public class Persondao {
	public EntityManager getEMEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEMEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		PanCard adharCard = person.getPancard();
		entityManager.persist(adharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		System.out.println("deatails saved successfully");
	}

	public void updatePerson(int id, String name) {
		EntityManager entityManager = getEMEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		person.setName(name);
		entityTransaction.begin();
		PanCard adharCard = person.getPancard();
		entityManager.merge(person);
		entityTransaction.commit();
		System.out.println("updated successfully");
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEMEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		System.out.println("deleted successfully");
	}

	public Person getPersonById(int id) {
		EntityManager entityManager = getEMEntityManager();
		return entityManager.find(Person.class, id);

	}

	public List<Person> getAllPerson() {
		EntityManager eManager = getEMEntityManager();
		Query query = eManager.createQuery("select p from Person p");
		List<Person> list = query.getResultList();
		System.out.println(list);
		return list;

	}
}
