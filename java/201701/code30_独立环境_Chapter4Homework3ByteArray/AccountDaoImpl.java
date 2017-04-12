package step30Chapter4Homework3ByteArray;

import javax.sql.DataSource;

public class AccountDaoImpl implements AccountDao {

    DataSource dataSource = null;
    AccountInsert accountInsert = null;
    AccountById accountById = null;
    
    public void setAccountById(AccountById accountById) {
        this.accountById = accountById;
    }
    
    public void setAccountInsert(AccountInsert accountInsert) {
        this.accountInsert = accountInsert;
    }
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int insert(byte[] owner_photo) {
        return accountInsert.update(owner_photo);
    }

    @Override
    public Account find(int id) {
        return accountById.findObject(id);
    }
    
}
