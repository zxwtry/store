package edu.zxw.goods.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.zxw.goods.pojo.Items;

/**
 * <p>Description: 使用注解方式的处理器(Handler)</p>
 * @author zxwtry
 */

//使用@Controller标识它是一个控制器
@Controller
public class ItemsController4_annotation {
	
	//商品查询列表
	//一个url对应一个方法
	//也可以写成@RequestMapping("/queryItems.action")
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {
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
		
		Items items_4 = new Items();
		items_4.setName("伟大的牙膏厂");
		items_4.setPrice(3000f);
		items_4.setDetail("八核扫雷数框框");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		itemsList.add(items_3);
		itemsList.add(items_4);
		
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//相当于request.setAttribute(attributeValue)
		//在html页面中可以通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("itemsList");
		
		return modelAndView;
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		//调用service查找数据库，查询商品列表；这里先使用静态数据来模拟
//		
//		List<Items> itemsList = new ArrayList<Items>();
//		
//		Items items_1 = new Items();
//		items_1.setName("神船大法好");
//		items_1.setPrice(4000f);
//		items_1.setDetail("神船半年包烂");
//		
//		Items items_2 = new Items();
//		items_2.setName("为发烧而生");
//		items_2.setPrice(1999f);
//		items_2.setDetail("r u ok ?");
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
