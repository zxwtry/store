package step30Chapter4Homework3ByteArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static String path = "F:/a.png";
    static String save_path = "C:/a.png";
    
    public static void main(String[] args) throws IOException {
        find();
    }
    
    static void find() throws IOException {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(ByteArrayConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        Account account = accountDao.find(2);
        System.out.println(account.getOwnerPhoto().length);
        save(account.getOwnerPhoto(), save_path);
        applicationContext.close();
    }
    
    static void insert() throws IOException {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(ByteArrayConfiguration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        byte[] bs = getByte(path);
        System.out.println(accountDao.insert(bs));
        applicationContext.close();
    }
    
    static byte[] getByte(String path) throws IOException {
        InputStream isr = new FileInputStream(new File(path));
        LinkedList<Byte> lists = new LinkedList<>();
        byte[] bs = new byte[16];
        int count = 1;
        while (true) {
            count = isr.read(bs);
            if (count == -1) break;
            for (int i = 0; i < count; i ++)
                lists.add(bs[i]);
        }
        isr.close();
        byte[] ans = new byte[lists.size()];
        int ai = 0;
        for (byte b : lists)
            ans[ai ++] = b;
        return ans;
    }
    
    static void save(byte[] bs, String path) throws IOException {
        OutputStream os = new FileOutputStream(new File(path));
        os.write(bs);
        os.close();
    }
    
}
