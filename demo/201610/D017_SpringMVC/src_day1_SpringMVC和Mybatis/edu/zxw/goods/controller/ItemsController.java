package edu.zxw.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.zxw.goods.pojo.ItemsCustom;
import edu.zxw.goods.service.ItemsService;

/**
 * @author		zxwtry
 * @email		zxwtry@qq.com
 * @project		springmvc1015
 * @package		edu.zxw.goods.controller
 * @file		ItemsController.java
 * @date		2016年11月18日 下午5:10:08
 * @details		SpringMVC的处理器
 */

@Controller
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	/**
	 * @method		queryItems 
	 * @parameter	void
	 * @return 		ModelAndView
	 * @details 	异常内部处理，不抛
	 */
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() {
		ModelAndView mv = new ModelAndView();
		try {
			List<ItemsCustom> itemsList = itemsService.findItemsList(null);
			mv.addObject("itemsList", itemsList);
			mv.setViewName("items/itemsList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * @method		editItems 
	 * @parameter	Model model
	 * @parameter	@RequestParam(value="id",required=true) Integer items_id
	 * @return 		String		---	返回的页面
	 * @details 	异常内部处理
	 */
	@RequestMapping(value="/editItems",method={RequestMethod.POST, RequestMethod.GET})
	public String editItems(Model model, @RequestParam(value="id",required=true) Integer items_id) {
		try {
			ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
			model.addAttribute("itemsCustom", itemsCustom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "items/editItems";
	}
	
	@RequestMapping(value="/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) {
		try {
			itemsService.updateItems(id, itemsCustom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
