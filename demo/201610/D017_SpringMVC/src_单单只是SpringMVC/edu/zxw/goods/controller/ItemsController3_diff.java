package edu.zxw.goods.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import edu.zxw.goods.pojo.Items;

/**
 * <p>Description: 实现HttpRequestHandler接口的处理器(Handler)</p>
 * @author zxwtry
 */
public class ItemsController3_diff implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Items> itemsList = new ArrayList<Items>();
		
		Items items_1 = new Items();
		items_1.setName("神船大法好");
		items_1.setPrice(4000f);
		items_1.setDetail("神船半年包烂");
		
		Items items_2 = new Items();
		items_2.setName("为发烧而生");
		items_2.setPrice(1999f);
		items_2.setDetail("r u ok ?");
		
		Items items_3 = new Items();
		items_3.setName("索尼大法好");
		items_3.setPrice(10000f);
		items_3.setDetail("姨夫神功护体");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		itemsList.add(items_3);
		
		//设置模型数据
		request.setAttribute("itemsList", itemsList);
		//设置转发地址
		request.getRequestDispatcher("/WEB-INF/html/items/itemsList.jsp").forward(request, response);
		
		
	}

//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		//调用service查找数据库，查询商品列表；这里先使用静态数据来模拟
//		
//		List<Items> itemsList = new ArrayList<Items>();
//		
//		Items items_1 = new Items();
//		items_1.setName("联想笔记本");
//		items_1.setPrice(6000f);
//		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
//		
//		Items items_2 = new Items();
//		items_2.setName("苹果手机");
//		items_2.setPrice(5000f);
//		items_2.setDetail("iphone6苹果手机！");
//		
//		itemsList.add(items_1);
//		itemsList.add(items_2);
//		
//		//返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		
//		//相当于request.setAttribute(attributeValue)
//		//在html页面中可以通过itemsList取数据
//		modelAndView.addObject("itemsList", itemsList);
//		
//		//指定视图
//		modelAndView.setViewName("/WEB-INF/html/items/itemsList.jsp");
//		
//		return modelAndView;
//	}
	
}
