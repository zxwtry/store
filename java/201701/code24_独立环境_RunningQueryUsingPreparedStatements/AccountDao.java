package step24RunningQueryUsingPreparedStatements;

import java.util.List;

public interface AccountDao {
    public Account find(long accountId);
    public List<Account> find(String ownerNamePrefix);
    public List<Account> find(List<Long> accountIds);
}
