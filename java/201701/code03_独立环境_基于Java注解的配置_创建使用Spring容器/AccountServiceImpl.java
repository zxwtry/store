package step03ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import step01BeanConfigure.Account;
import step01BeanConfigure.AccountDao;
import step01BeanConfigure.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
		Account sourceAccount = accountDao.find(sourceAccountId);
		Account targetAccount = accountDao.find(targetAccountId);
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		targetAccount.setBalance(targetAccount.getBalance() + amount);
		accountDao.update(sourceAccount);
		accountDao.update(targetAccount);
	}

	@Override
	public void depositMoney(long accountId, double amount) {
		Account account = accountDao.find(accountId);
		account.setBalance(account.getBalance() + amount);
		accountDao.update(account);
	}

	@Override
	public Account getAccount(long accountId) {
		return accountDao.find(accountId);
	}

}
