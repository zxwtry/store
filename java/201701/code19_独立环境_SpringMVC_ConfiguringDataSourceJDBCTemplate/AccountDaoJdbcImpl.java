package step19ConfiguringDataSourceJDBCTemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoJdbcImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        System.out.printf("AccountDaoJdbcImpl setJdbcTemplate is null ? %b\r\n", jdbcTemplate == null);
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
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
    public AccountDao find(long accountId) {
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
