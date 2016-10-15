package edu.zxw.goods.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.zxw.goods.pojo.Items;

/**
 * <p>Description: 实现Controller接口的处理器(Handler)</p>
 * @author zxwtry
 */
public class ItemsController2_diff implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//调用service查找数据库，查询商品列表；这里先使用静态数据来模拟
		
		List<Items> itemsList = new ArrayList<Items>();
		
		Items items_1 = new Items();
		items_1.setName("神船大法好");
		items_1.setPrice(4000f);
		items_1.setDetail("神船半年包烂");
		
		itemsList.add(items_1);
		
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//相当于request.setAttribute(attributeValue)
		//在html页面中可以通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("/WEB-INF/html/items/itemsList.jsp");
		
		return modelAndView;
	}
	
}
