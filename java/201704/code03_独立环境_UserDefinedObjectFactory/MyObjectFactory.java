package code03_UserDefinedObjectFactory.of;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import code03_UserDefinedObjectFactory.util.SingletonUtil;

public class MyObjectFactory extends DefaultObjectFactory {
    private static final long serialVersionUID = 3863944148059750284L;
    @Override
    public void setProperties(Properties properties) {
        SingletonUtil.getLogger().info("MyObjectFactory setProperties");
        super.setProperties(properties);
    }
    @Override
    public <T> T create(Class<T> type) {
        SingletonUtil.getLogger().info("MyObjectFactory create type");
        return super.create(type);
    }
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        
        return super.create(type, constructorArgTypes, constructorArgs);
    }
}
