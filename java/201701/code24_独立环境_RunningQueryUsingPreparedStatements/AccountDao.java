package step24RunningQueryUsingPreparedStatements;

import java.util.List;

public interface AccountDao {
    public List<Account> find(boolean locked);
    public List<Account> findNoPre(boolean locked);
    public List<Account> findBook(boolean locked);
}
