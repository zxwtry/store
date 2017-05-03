package code02_UserDefinedTypeHandler.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

public class SingletonUtil {
    private static class SqlSessionFactoryHolder {
        private static SqlSessionFactory sqlSessionFactory = null;
        static {
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                SingletonUtil.getLogger().log(Level.SEVERE, null, e);
            } finally {
                try {
                    if (inputStream != null) inputStream.close();
                } catch (Exception e2) {
                    SingletonUtil.getLogger().log(Level.SEVERE, null, e2);
                }
            }
        }
    }
    private static class LoggerHolder {
        private static Logger logger = Logger.getLogger("code02_UserDefinedTypeHandler");
    }
    private static class GsonHolder {
        private static Gson gson = new Gson();
    }
    private static class SimpleDateFormatHolder {
        private static SimpleDateFormat sdf_timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return SqlSessionFactoryHolder.sqlSessionFactory;
    }
    public static Logger getLogger() {
        return LoggerHolder.logger;
    }
    public static Gson getGson() {
        return GsonHolder.gson;
    }
    public static SimpleDateFormat getSDF_TIMESTAMP() {
        return SimpleDateFormatHolder.sdf_timestamp;
    }
}
