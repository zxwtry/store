package step24RunningQueryUsingPreparedStatements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AccountDaoImpl implements AccountDao {
    
    JdbcTemplate jdbcTemplate = null;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }
    
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Account find(long accountId) {
        return jdbcTemplate.queryForObject("select * from account where id = ?;", 
                new RowMapper<Account>(){
                    @Override
                    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Account account = new Account();
                        account.setAccessTime(rs.getTimestamp("access_time"));
                        account.setBalance(rs.getDouble("balance"));
                        account.setId(rs.getLong("id"));
                        account.setLocked(rs.getBoolean("locked"));
                        account.setOwnerName(rs.getString("owner_name"));
                        return account;
                    }
                   }, accountId);
    }

    @Override
    public List<Account> find(String ownerNamePrefix) {
        return namedParameterJdbcTemplate.query(
                "select * from account where owner_name like :ownerNamePrefix", 
                Collections.singletonMap("ownerNamePrefix", ownerNamePrefix),
                new RowMapper<Account>() {
                    @Override
                    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Account account = new Account();
                        try {
                            account.setAccessTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("access_time")));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        account.setBalance(rs.getDouble("balance"));
                        account.setId(rs.getLong("id"));
                        account.setLocked(rs.getBoolean("locked"));
                        account.setOwnerName(rs.getString("owner_name"));
                        return account;
                    }
                });
    }

    @Override
    public List<Account> find(List<Long> accountIds) {
        return namedParameterJdbcTemplate.query(
                "select * from account where id in (:accountIds)", 
                Collections.singletonMap("accountIds", accountIds),
                new RowMapper<Account>() {
                    @Override
                    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Account account = new Account();
                        try {
                            account.setAccessTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("access_time")));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        account.setBalance(rs.getDouble("balance"));
                        account.setId(rs.getLong("id"));
                        account.setLocked(rs.getBoolean("locked"));
                        account.setOwnerName(rs.getString("owner_name"));
                        return account;
                    }
                });
    }
}
