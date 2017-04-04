package step26CallingStoredProceduresCRUD;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new 
                AnnotationConfigApplicationContext(CallingStoredProceduresConfiguration.class);
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        simpleJdbcCall
            .withProcedureName("concat")
            .withoutProcedureColumnMetaDataAccess()
            .declareParameters(
                    new SqlParameter("owner_name", Types.VARCHAR))
            .returningResultSet("result", new SingleColumnRowMapper<>(String.class));
        simpleJdbcCall.compile();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("owner_name", "Bear Junior");
        Map<String, Object> resultMap = simpleJdbcCall.execute(paramMap);
        
        @SuppressWarnings("unchecked")
        List<String> resultList = (List<String>) resultMap.get("result");
        for (String value : resultList)
            System.out.println(value);
        
        applicationContext.close();
    }
}
