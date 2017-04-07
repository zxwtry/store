package step28EncapsulatingSQLQueries;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(FindObjectConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        System.out.println(accountDao.find(9));
        applicationContext.close();
    }
}