package step26CallingStoredProceduresCRUD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    
    public static void main(String[] args) {
        solve();
//        solveAccount();
    }

//    static void solveAccount() {
//        AnnotationConfigApplicationContext applicationContext = new 
//                AnnotationConfigApplicationContext(CallingStoredProceduresConfiguration.class);
//        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
//        Account account = accountDao.findAccountById(56);
//        System.out.println(account);
//        applicationContext.close();
//    }

    static void solve() {
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(CallingStoredProceduresConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        double balance = accountDao.findBalanceById(56);
        System.out.println(balance);
        applicationContext.close();
    }
}
