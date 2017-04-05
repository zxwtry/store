package step27PerformingBatchOperations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) throws ParseException {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(BatchConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account1 = new Account();
        account1.setId(4);
        account1.setOwnerName("Mei YangYang Changed");
        account1.setAccessTime(sdf.parse("1995-02-01 09:30:30"));
        account1.setBalance(401);
        account1.setLocked(true);
        Account account2 = new Account();
        account2.setId(5);
        account2.setOwnerName("Lan YangYang Changed");
        account2.setAccessTime(sdf.parse("1995-02-01 09:30:30"));
        account2.setBalance(403);
        account2.setLocked(true);
        accountDao.update(Arrays.asList(account1, account2));
        applicationContext.close();
    }
}
