package step03ComponentScan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import step01BeanConfigure.Account;
import step01BeanConfigure.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

	private Map<Long, Account> acs = new HashMap<Long, Account>();
	
	{
		Account account = new Account();
		account.setAccountId(1l);
		account.setBalance(100.0);
		account.setOwnerName("ower1");
		acs.put(account.getAccountId(), account);
		
		account = new Account();
		account.setAccountId(2l);
		account.setBalance(200.0);
		account.setOwnerName("ower2");
		acs.put(account.getAccountId(), account);
		
		account = new Account();
		account.setAccountId(3l);
		account.setBalance(300.0);
		account.setOwnerName("ower3");
		acs.put(account.getAccountId(), account);
	}
	
	@Override
	public void insert(Account account) {
		acs.put(account.getAccountId(), account);
	}

	@Override
	public void update(Account account) {
		acs.put(account.getAccountId(), account);
	}

	@Override
	public Account find(long accountId) {
		return acs.get(accountId);
	}

	@Override
	public List<Account> find(String ownerName) {
		return null;
	}

}
