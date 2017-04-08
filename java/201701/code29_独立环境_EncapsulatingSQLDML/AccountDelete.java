package step29EncapsulatingSQLDML;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class AccountDelete extends SqlUpdate{
    public AccountDelete(DataSource dataSource) {
        super(dataSource, "delete from account where id = ?");
        setParameters(new SqlParameter[] {
                new SqlParameter(Types.BIGINT)
        });
        compile();
    }

}
