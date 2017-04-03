package step25JdbcTemplateCRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) throws ParseException {
//        insert();
//        queryByIds();
//        update();
//        delete();
    }
    
    static void delete() {
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(ConfigurationCRUD.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        accountDao.delete(1l);
        applicationContext.close();
    }
    
    static void update() throws ParseException {
        Account account = new Account();
        account.setAccessTime(sdf.parse("1959-09-09 09:09:09"));
        account.setBalance(334.56);
        account.setOwnerName("Bear 2999");
        account.setId(1);
        account.setLocked(false);
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(ConfigurationCRUD.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        accountDao.update(account);
        applicationContext.close();
    }
    
    static void queryByIds() {
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(ConfigurationCRUD.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        List<Account> answer = accountDao.query(Arrays.asList(1l ,5l, 10l));
        System.out.println(answer);
        applicationContext.close();
    }
    
    static void queryById() throws ParseException {
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(ConfigurationCRUD.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account = accountDao.query(1l);
        System.out.println(account);
        applicationContext.close();
    }
    
    static void insert() throws ParseException {
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(ConfigurationCRUD.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account = new Account();
        account.setAccessTime(sdf.parse("1999-09-09 09:09:09"));
        account.setBalance(234.56);
        account.setId(567);
        account.setLocked(true);
        account.setOwnerName("Bear 1999");
        accountDao.insert(account);
        System.out.println(account.getId());
        applicationContext.close();
    }
}
