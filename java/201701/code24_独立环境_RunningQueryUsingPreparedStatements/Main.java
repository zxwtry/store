package step24RunningQueryUsingPreparedStatements;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    //6     data：pre 1000 times time is 5644
    //162   data：pre 1000 times time is 6233
    static void pre1000times() {
        long time = System.currentTimeMillis();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationPreparedStatements.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        for (int i = 0; i < 1000; i ++)
            accountDao.find(false);
        applicationContext.close();
        System.out.printf("pre 1000 times time is %d\r\n", (System.currentTimeMillis() - time));
    }
    //6     data：no pre 1000 times time is 5834
    //162   data：no pre 1000 times time is 6338
    static void noPre1000times() {
        long time = System.currentTimeMillis();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationPreparedStatements.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        for (int i = 0; i < 1000; i ++)
            accountDao.findNoPre(false);
        applicationContext.close();
        System.out.printf("no pre 1000 times time is %d\r\n", (System.currentTimeMillis() - time));
    }
    //162   data: book 1000 times time is 6196
    static void book1000times() {
        long time = System.currentTimeMillis();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationPreparedStatements.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        for (int i = 0; i < 1000; i ++)
            accountDao.findBook(false);
        applicationContext.close();
        System.out.printf("book 1000 times time is %d\r\n", (System.currentTimeMillis() - time));
    }
    public static void main(String[] args) throws SQLException {
        book1000times();
    }
}