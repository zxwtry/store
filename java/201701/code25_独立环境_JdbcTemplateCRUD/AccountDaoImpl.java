package step25JdbcTemplateCRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class AccountDaoImpl implements AccountDao {
    
    private JdbcTemplate jdbcTemplate = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public void insert(Account account) {
        String sql = "insert into account(owner_name, balance, access_time, locked) values(?, ?, ?, ?);";
        int[] types = new int[] {Types.VARCHAR, Types.DOUBLE, Types.TIMESTAMP, Types.BOOLEAN};
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(sql, types);
        pscf.setReturnGeneratedKeys(true);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Object[] params = new Object[] {account.getOwnerName(), account.getBalance()
                , account.getAccessTime(), account.isLocked()};
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(params);
        int count = jdbcTemplate.update(psc, keyHolder);
        System.out.println("count is " + count);
        if (count != 1) throw new InsertFailedException("Cannot insert account");
        account.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Account query(long id) {
        String sql = "select * from account where id = " + id;
        RowMapper<Account> rowMapper = new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                try {
                    account.setAccessTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .parse(rs.getString("access_time")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                account.setBalance(rs.getDouble("balance"));
                account.setId(rs.getLong("id"));
                account.setLocked(rs.getBoolean("locked"));
                account.setOwnerName(rs.getString("owner_name"));
                return account;
            }
        };
        return jdbcTemplate.queryForObject(sql, rowMapper);
    }

    @Override
    public List<Account> query(List<Long> ids) {
        String sql = "select * from account where id in (:ids)";
        Map<String, List<Long>> paramMap = Collections.singletonMap("ids", ids);
        RowMapper<Account> rowMapper = new RowMapper<Account>() {
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
        };
        List<Account> answer = namedParameterJdbcTemplate.query(sql, paramMap, rowMapper);
        return answer;
    }

    @Override
    public void update(Account account) {
        String sql = "update account set (owner_name, balance, access_time,"
                + "locked) = (?, ?, ?, ?) where id = ?";
        Object[] params = new Object[] {account.getOwnerName(), 
                account.getBalance(), account.getAccessTime(),
                account.isLocked(), account.getId()};
        int count = jdbcTemplate.update(sql, params);
        if (count != 1) throw new UpdateFailedException("Cannot update account");
    }
    
}