package step31ORMOneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
	    sovleSingleMapAccount();
	}
	static void solve1() {
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
        entityManagerFactory.close();
        applicationContext.close();
	}
	
	static void sovleSingleMapAccount() {
	    AnnotationConfigApplicationContext applicationContext = 
	            new AnnotationConfigApplicationContext(SingleMapConfiguration.class);
	    EntityManagerFactory entityManagerFactory = 
	            applicationContext.getBean(EntityManagerFactory.class);
	    EntityManager entityManager = entityManagerFactory
	            .createEntityManager();
	    EntityTransaction entityTransaction = entityManager.getTransaction();
	    entityTransaction.begin();
	    SingleMapAccount account = new SingleMapAccount();
	    account.setName("Bear Junior");
	    entityManager.persist(account);
	    entityTransaction.commit();
//	    entityManager.close();;
//	    entityManagerFactory.close();
	    applicationContext.close();
	}

}