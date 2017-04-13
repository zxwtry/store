package step31ORMOneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
	    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ORMConfiguration.class);
		EntityManagerFactory entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Smith");

		entityManager.persist(student);
		transaction.commit();
		entityManager.close();
		
		applicationContext.close();
	}

}