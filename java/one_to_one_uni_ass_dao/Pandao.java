package one_to_one_uni_ass_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_ass_dto.PanCard;
import one_to_one_uni_ass_dto.Person;

public class Pandao {
	public EntityManager getEMEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void savePan(PanCard pan) {
		EntityManager entityManager = getEMEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(pan);
		entityTransaction.commit();
		System.out.println("deatails saved successfully");
	}
	public void updatePan(int id, String name) {
		EntityManager entityManager = getEMEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = entityManager.find(PanCard.class, id);
		panCard.setName(name);;
		entityTransaction.begin();
		entityManager.merge(panCard);
		entityTransaction.commit();
		System.out.println("updated successfully");
	}
	public void deletePan(int id) {
		EntityManager entityManager = getEMEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = entityManager.find(PanCard.class, id);
		entityTransaction.begin();
		entityManager.remove(panCard);
		entityTransaction.commit();
		System.out.println("deleted successfully");
	}
	public PanCard getPanById(int id) {
		EntityManager entityManager = getEMEntityManager();
		return entityManager.find(PanCard.class, id);

	}

	public List<PanCard> getAllPanCard() {
		EntityManager eManager = getEMEntityManager();
		Query query = eManager.createQuery("select p from PanCard p");
		List<PanCard> list = query.getResultList();
		System.out.println(list);
		return list;
	}


}
