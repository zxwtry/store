package step27PerformingBatchOperations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {
    
    JdbcTemplate jdbcTemplate = null;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void update(final List<Account> accounts) {
        String sql = "update account set owner_name=?, balance=?,"
                + "access_time=?, locked=? where id=?";
        BatchPreparedStatementSetter bpss = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Account account = accounts.get(i);
                ps.setString(1, account.getOwnerName());
                ps.setDouble(2, account.getBalance());
                ps.setTimestamp(3, new Timestamp(account.getAccessTime().getTime()));
                ps.setBoolean(4, account.isLocked());
                ps.setLong(5, account.getId());
            }
            @Override
            public int getBatchSize() {
                return accounts.size();
            }
        };
        int[] counts = jdbcTemplate.batchUpdate(sql, bpss);
        for (int i = 0; i < counts.length; i ++) {
            if (counts[i] == 0) throw new UpdateFailedException("Row not updated: " + i);
        }
    }
}
