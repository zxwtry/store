package step26CallingStoredProceduresCRUD;

import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class AccountDaoImpl implements AccountDao {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleJdbcCall simpleJdbcCall = null;
    public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
        this.simpleJdbcCall = simpleJdbcCall;
    }
    @Override
    public float findBalanceById(long id) {
        /*
            procedure is :
                delimiter &&
                create procedure balance_from_id_4 
                (in account_id int , out account_balance float)
                reads sql data
                begin
                select balance into account_balance from account where id=account_id;
                end
                &&
                delimiter ;
         */
        simpleJdbcCall
             .withProcedureName("balance_from_id_4")
             .declareParameters(
                     new SqlParameter("account_id", Types.BIGINT)
                     )
             .returningResultSet("account_balance", new SingleColumnRowMapper<Float>(Float.class));
             
        simpleJdbcCall.compile();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("account_id", id);
        Map<String, Object> resultMap = simpleJdbcCall.execute(paramMap);
        float resultDouble = (float) resultMap.get("account_balance");
        return resultDouble;
    }
//    @Override
//    public Account findAccountById(long id) {
//        simpleJdbcCall
//            .withFunctionName("account_from_id")
//            .declareParameters(new SqlParameter("account_id", Types.BIGINT))
//            .returningResultSet("owner_name_out", new SingleColumnRowMapper<String>(String.class))
//            .returningResultSet("balance_out", new SingleColumnRowMapper<Float>(Float.class))
//            .returningResultSet("access_time_out", new SingleColumnRowMapper<Date>(Date.class))
//            .returningResultSet("locked_out", new SingleColumnRowMapper<Boolean>(Boolean.class));
//        simpleJdbcCall.compile();
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("account_id", id);
//        Map<String, Object> resultMap = simpleJdbcCall.execute(paramMap);
//        Account account = new Account();
//        account.setId(id);
//        account.setOwnerName((String)resultMap.get("owner_name_out"));
//        account.setBalance((float)resultMap.get("balance_out"));
//        account.setAccessTime((Date)resultMap.get("access_time_out"));
//        account.setLocked((boolean)resultMap.get("locked_out"));
//        return account;
//    }
}
