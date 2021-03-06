package code01_ConfiguringMybatis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    @SuppressWarnings("rawtypes")
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;
    private SqlSessionFactoryUtil() {}
    public static SqlSessionFactory initSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null)
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }
    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) initSqlSessionFactory();
        return sqlSessionFactory.openSession();
    }
}
