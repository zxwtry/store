package step25JdbcTemplateCRUD;

import java.util.List;

public interface AccountDao {
    //create
    public void insert(Account account);
    //retrieve
    public Account query(long id);
    public List<Account> query(List<Long> ids);
    //update
    public void update(Account account);
}
