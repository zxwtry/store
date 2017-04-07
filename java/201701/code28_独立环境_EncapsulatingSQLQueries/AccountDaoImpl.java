package step28EncapsulatingSQLQueries;

import org.springframework.jdbc.object.MappingSqlQuery;

public class AccountDaoImpl implements AccountDao {
    private MappingSqlQuery<Account> accountByIdQuery;
    public void setAccountByIdQuery(MappingSqlQuery<Account> accountByIdQuery) {
        this.accountByIdQuery = accountByIdQuery;
    }
    @Override
    public Account find(long accountId) {
        return accountByIdQuery.findObject(accountId);
    }
}