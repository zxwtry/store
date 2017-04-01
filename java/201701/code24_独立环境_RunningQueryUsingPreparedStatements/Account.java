package step24RunningQueryUsingPreparedStatements;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Date getAccessTime() {
        return accessTime;
    }
    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }
    public boolean isLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    @Override
    public String toString() {
        return String.format("Account id is %d\r\nAccount ownerName is %s\r\nAccount balance is %f\r\nAccount accessTime is %s\r\nAccount locked is %b\r\n", 
                id, ownerName, balance, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(accessTime), locked);
    }
}
