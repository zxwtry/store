package code02_UserDefinedTypeHandler.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import code02_UserDefinedTypeHandler.util.SingletonUtil;

@MappedTypes({ Date.class })
@MappedJdbcTypes({ JdbcType.BIGINT })
public class MyDateTypeHandler implements TypeHandler<Date> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        SingletonUtil.getLogger().info("MyDateTypeHandler 1 setParameter");
        ps.setLong(i, parameter.getTime());
    }

    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        SingletonUtil.getLogger().info("MyDateTypeHandler 2 getResult");
        return new Date(rs.getLong(columnName));
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        SingletonUtil.getLogger().info("MyDateTypeHandler 3 getResult");
        return new Date(rs.getLong(columnIndex));
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        SingletonUtil.getLogger().info("MyDateTypeHandler 4 getResult");
        return new Date(cs.getLong(columnIndex));
    }
    
}
