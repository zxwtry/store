package step30Chapter4Homework3ByteArray;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class AccountInsert extends SqlUpdate {
    
    public AccountInsert(DataSource dataSource) {
        super(dataSource, "insert into account2(owner_photo) values(?)");
        setParameters(new SqlParameter[] {
                new SqlParameter(Types.BLOB)
        });
        setReturnGeneratedKeys(true);
        setGeneratedKeysColumnNames(new String[] {"id"});
        compile();
    }
    
}
