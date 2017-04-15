package step31ORMOneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
	    solveOneToMany();
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
	    entityManager.close();;
	    applicationContext.close();
	}
	
	static void solveOntToOne() {
	    AnnotationConfigApplicationContext applicationContext = 
	            new AnnotationConfigApplicationContext(OneToOneConfiguration.class);
	    EntityManagerFactory entityManagerFactory = 
	            applicationContext.getBean(EntityManagerFactory.class);
	    EntityManager entityManager = entityManagerFactory
	            .createEntityManager();
	    EntityTransaction entityTransaction = entityManager.getTransaction();
	    entityTransaction.begin();
	    OneToOneCitizen citizen = new OneToOneCitizen();
	    OneToOneIDCard idCard = new OneToOneIDCard();
	    entityManager.persist(idCard);
	    citizen.setIdCard(idCard);
	    citizen.setName("my_name");
	    entityManager.persist(citizen);
	    entityTransaction.commit();
	    applicationContext.close();
	}
	
	static void solveManyToOne() {
	    AnnotationConfigApplicationContext applicationContext = 
	            new AnnotationConfigApplicationContext(ManyToOneConfiguration.class);
	    EntityManagerFactory entityManagerFactory = 
	            applicationContext.getBean(EntityManagerFactory.class);
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction = entityManager.getTransaction();
	    entityTransaction.begin();
	    ManyToOneEmployee employee1 = new ManyToOneEmployee();
	    ManyToOneEmployee employee2 = new ManyToOneEmployee();
	    ManyToOneEmployee employee3 = new ManyToOneEmployee();
	    ManyToOneEmployer employer1 = new ManyToOneEmployer();
	    employee1.setEmployer(employer1);
	    employee2.setEmployer(employer1);
	    employee3.setEmployer(employer1);
	    entityManager.persist(employer1);
	    entityManager.persist(employee1);
	    entityManager.persist(employee2);
	    entityManager.persist(employee3);
	    entityTransaction.commit();
	    applicationContext.close();
	}
	
	static void solveOneToMany() {
	    AnnotationConfigApplicationContext applicationContext = 
	            new AnnotationConfigApplicationContext(OneToOneConfiguration.class);
	    EntityManagerFactory entityManagerFactory = 
	            applicationContext.getBean(EntityManagerFactory.class);
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction = entityManager.getTransaction();
	    entityTransaction.begin();
	    OneToManyEmployee employee1 = new OneToManyEmployee();
	    OneToManyEmployee employee2 = new OneToManyEmployee();
	    OneToManyEmployee employee3 = new OneToManyEmployee();
	    OneToManyEmployer employer = new OneToManyEmployer();
	    employer.getEmployees().add(employee1);
	    employer.getEmployees().add(employee2);
	    employer.getEmployees().add(employee3);
	    entityManager.persist(employee1);
	    entityManager.persist(employee2);
	    entityManager.persist(employee3);
	    entityManager.persist(employer);
	    entityTransaction.commit();
	    applicationContext.close();
	}
}