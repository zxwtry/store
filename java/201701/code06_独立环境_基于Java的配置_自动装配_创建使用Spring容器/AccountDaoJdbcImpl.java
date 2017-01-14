package step06JavaAutowiring;

import java.util.List;

public class AccountDaoJdbcImpl implements AccountDao {

	@Override
	public void insert(Account account) {

	}

	@Override
	public void update(Account account) {

	}

	@Override
	public void update(List<Account> accounts) {

	}

	@Override
	public void delete(long accountId) {

	}

	@Override
	public Account find(long accountId) {
		return null;
	}

	@Override
	public List<Account> find(List<Long> accountIds) {
		return null;
	}

	@Override
	public List<Account> find(String ownerName) {
		return null;
	}

	@Override
	public List<Account> find(boolean locked) {
		return null;
	}

}
