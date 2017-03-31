package step19ConfiguringDataSourceJDBCTemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface AccountDao {
    public void insert(Account account);
    public void update(Account account);
    public void update(List<Account> accounts);
    public void delete(long accountId);
    public AccountDao find(long accountId);
    public List<Account> find(List<Long> accountIds);
    public List<Account> find(String ownerName);
    public List<Account> find(boolean locked);
    public JdbcTemplate getJdbcTemplate();
}
