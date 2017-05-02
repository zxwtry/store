package code02_UserDefinedTypeHandler.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import code02_UserDefinedTypeHandler.util.SingletonUtil;

@MappedTypes({ java.lang.String.class })
@MappedJdbcTypes({ JdbcType.VARCHAR })
public class MyStringTypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        SingletonUtil.getLogger().log(Level.INFO, "MyStringTypeHandler1 setParameter");
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        SingletonUtil.getLogger().log(Level.INFO, "MyStringTypeHandler2 getResult");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        SingletonUtil.getLogger().log(Level.INFO, "MyStringTypeHandler3 getResult");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        SingletonUtil.getLogger().log(Level.INFO, "MyStringTypeHandler4 getResult");
        return cs.getString(columnIndex);
    }

}
