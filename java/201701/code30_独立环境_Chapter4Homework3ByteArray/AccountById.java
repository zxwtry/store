package step30Chapter4Homework3ByteArray;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

public class AccountById extends MappingSqlQuery<Account> {
    
    private LobHandler lobHandler = new DefaultLobHandler();
    
    public AccountById(DataSource dataSource) {
        super(dataSource, "select id, owner_photo from account2 where id = ?");
        declareParameter(new SqlParameter(Types.BIGINT));
        compile();
    }

    @Override
    protected Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setOwnerPhoto(lobHandler.getBlobAsBytes(rs, "owner_photo"));
        return account;
    }

}
