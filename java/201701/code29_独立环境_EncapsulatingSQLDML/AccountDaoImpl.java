package step29EncapsulatingSQLDML;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class AccountDaoImpl implements AccountDao {
    AccountDelete accountDelete;
    AccountInsert accountInsert;
    AccountUpdate accountUpdate;
    
    public void setAccountDelete(AccountDelete accountDelete) {
        this.accountDelete = accountDelete;
    }

    public void setAccountInsert(AccountInsert accountInsert) {
        this.accountInsert = accountInsert;
    }

    public void setAccountUpdate(AccountUpdate accountUpdate) {
        this.accountUpdate = accountUpdate;
    }

    @Override
    public long insert(Account account) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        accountInsert.update(
                new Object[] {
                        account.getOwnerName(),
                        account.getBalance(),
                        account.getAccessTime(),
                        account.isLocked()
                }, keyHolder
        );
        return keyHolder.getKey().longValue();
    }

    @Override
    public void delete(long id) {
        accountDelete.update(id);
    }

    @Override
    public void update(Account account) {
        accountUpdate.update(new Object[] {
                account.getOwnerName(),
                account.getBalance(),
                account.getAccessTime(),
                account.isLocked(),
                account.getId()
        });
    }
}
