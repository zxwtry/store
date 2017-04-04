package step27PerformingBatchOperations;

import java.util.List;

public interface AccountDao {
    public void update(final List<Account> accounts);
}