package com.weixin.validation.app.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.messagehandler.BaseWeiXinMessageHandler;
import com.weixin.messagehandler.SingleNewsMessageHandler;
import com.weixin.wxmenu.MenuService;
import com.weixin.wxmenu.WeiXinMenu;


@Service
public class CoreServiceImpl implements CoreService {
	
	private BaseWeiXinMessageHandler messageHandler;
	
	//初始化
	public CoreServiceImpl() {
		messageHandler = new SingleNewsMessageHandler();
	}

	@Override
	public String WeiXinMessageProcess(HttpServletRequest request) {
		{
			return messageHandler.processRequestTemplate(request);
		}
	}

	@Override
	public String createWeiXinMenu(HttpServletRequest request) {
		
		List<WeiXinMenu> menus = new ArrayList<WeiXinMenu>();
		//一级菜单，如果一级菜单下有二级菜单，只需要配置name属性
		WeiXinMenu menu1 = new WeiXinMenu();
		menu1.setId(1);
		menu1.setName("Git常用命令");
		
		List<WeiXinMenu> m1SubMenus = new ArrayList<WeiXinMenu>();
		
		//二级级菜单，包含二级菜单
		WeiXinMenu m1SubMenu1 = new WeiXinMenu();
		m1SubMenu1.setId(2);
		m1SubMenu1.setpId(1);
		m1SubMenu1.setType("view");
		m1SubMenu1.setKey("click-checkout");
		m1SubMenu1.setName("git checkout");
		m1SubMenu1.setUrl(request.getContextPath() + "/git/list/1");
		
		WeiXinMenu m1SubMenu2 = new WeiXinMenu();
		m1SubMenu2.setId(3);
		m1SubMenu2.setpId(1);
		m1SubMenu2.setType("view");
		m1SubMenu2.setKey("click-reset");
		m1SubMenu2.setName("git reset");
		m1SubMenu1.setUrl(request.getContextPath() + "/git/list/2");
		
		m1SubMenus.add(m1SubMenu1);
		m1SubMenus.add(m1SubMenu2);
		
		menu1.setSub_button(m1SubMenus);
		
		menus.add(menu1);
		
		Map<String,List<WeiXinMenu>> jsonMaps = new HashMap<String,List<WeiXinMenu>>();
		jsonMaps.put("button", menus);
		
		String resultJson = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String menuJson = mapper.writeValueAsString(jsonMaps);
			resultJson = new MenuService().createMenu(menuJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resultJson;
	}
}
