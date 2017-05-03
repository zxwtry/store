package code03_UserDefinedObjectFactory.mapper;

import java.util.List;

import code03_UserDefinedObjectFactory.po.Food;

public interface FoodMapper {
    public int insertFood(Food food);
    public Food findFood(int id);
    public List<Food> findAllFoods();
    public int deleteFood(int id);
    public int updateFood(Food food);
}
