package step29EncapsulatingSQLDML;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static void insert() throws ParseException {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(DMLConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account = new Account();
        account.setAccessTime(sdf.parse("1949-10-01 10:10:10"));
        account.setBalance(196.88);
        account.setOwnerName("God");
        account.setLocked(false);
        System.out.println(accountDao.insert(account));
        applicationContext.close();
    }
    static void delete() {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(DMLConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        accountDao.delete(101);
        applicationContext.close();
    }
    static void update() throws ParseException {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(DMLConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account = new Account();
        account.setAccessTime(sdf.parse("1949-10-01 10:10:10"));
        account.setBalance(196.88);
        account.setOwnerName("God new");
        account.setId(182);
        account.setLocked(false);
        accountDao.update(account);
        applicationContext.close();
    }
    public static void main(String[] args) throws ParseException {
        insert();
    }
}
