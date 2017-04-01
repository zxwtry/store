package step23RunningQueryWithJdbcTemplateNamedParameter;


import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    
    static void testFindLong() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationNamedParameter.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account = accountDao.find(2l);
        System.out.println(account);
        applicationContext.close();
    }
    
    static void testFindOwnerNamePrefix() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationNamedParameter.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        List<Account> l =  accountDao.find("Bear%");
        for (Account account : l)
            System.out.println(account);
        applicationContext.close();
    }
    
    static void testFindListLong() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationNamedParameter.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        List<Account> l =  accountDao.find(Arrays.asList(1l,2l));
        for (Account account : l)
            System.out.println(account);
        applicationContext.close();
    }
    
    public static void main(String[] args) {
        testFindListLong();
    }
}
