package step01BeanConfigure;

import java.util.List;

public interface AccountDao {
	public void insert(Account account);
	public void update(Account account);
	public Account find(long accountId);
	public List<Account> find(String ownerName);
}
