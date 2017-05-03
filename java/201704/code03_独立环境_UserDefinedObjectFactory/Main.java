package code03_UserDefinedObjectFactory.main;

import java.util.List;
import java.util.logging.Level;

import org.apache.ibatis.session.SqlSession;

import code03_UserDefinedObjectFactory.mapper.FoodMapper;
import code03_UserDefinedObjectFactory.po.Food;
import code03_UserDefinedObjectFactory.util.SingletonUtil;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlsession = null;
        try {
            sqlsession = SingletonUtil.getSqlSessionFactory().openSession();
            FoodMapper foodMapper = sqlsession.getMapper(FoodMapper.class);
            //插入Food
//            Food food = new Food();
//            food.setName("food name 6");
//            food.setPrice(6.66f);
//            foodMapper.insertFood(food);
//            sqlsession.commit();
            //输出全部Food
//            List<Food> foods = foodMapper.findAllFoods();
//            System.out.println(foods);
            //输出某个Food
//            Food food = foodMapper.findFood(3);
//            System.out.println(food);
            //删除某个Food
//            System.out.println(foodMapper.deleteFood(4));
//            sqlsession.commit();
            //更新某个Food
            Food food = foodMapper.findFood(3);
            food.setName("food name 3 new name");
            food.setPrice(3333333.3f);
            foodMapper.updateFood(food);
            sqlsession.commit();
        } catch (Exception e) {
            SingletonUtil.getLogger().log(Level.SEVERE, null, e);
            if (null != sqlsession) sqlsession.rollback();
        } finally {
            try {
                if (null != sqlsession) sqlsession.close();
            } catch (Exception e) {
                SingletonUtil.getLogger().log(Level.SEVERE, null, e);
            }
        }
    }
}
