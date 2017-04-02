package step24RunningQueryUsingPreparedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AccountDaoImpl implements AccountDao {
    
    JdbcTemplate jdbcTemplate = null;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }
    
    @Override
    public List<Account> find(boolean locked) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory
                ("select * from account where locked = ?", new int[] {Types.BOOLEAN});
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(new Object[]{locked});
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
        return jdbcTemplate.query(psc, rowMapper);
    }

    @Override
    public List<Account> findNoPre(boolean locked) {
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
        List<Account> answer = jdbcTemplate.query("select * from account where locked = ?", rowMapper, new int[] {Types.BOOLEAN});
        return answer;
    }

    @Override
    public List<Account> findBook(boolean locked) {
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
        String sql = "select * from account where locked = ?";
        final boolean locked_copy = locked;
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setBoolean(1, locked_copy);
            }
        };
        List<Account> answer = jdbcTemplate.query(sql, pss, rowMapper);
        return answer;
    }
}