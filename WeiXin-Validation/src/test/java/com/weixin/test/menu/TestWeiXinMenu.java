package com.weixin.test.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.validation.app.App;
import com.weixin.wxmenu.WeiXinMenu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={App.class})
//@ActiveProfiles("prod")
public class TestWeiXinMenu {
	
	@Test
	public void testMenu(){
		
		List<WeiXinMenu> menus = new ArrayList<WeiXinMenu>();
		//第一个一级菜单，跳转一个url
		WeiXinMenu menu1 = new WeiXinMenu();
		menu1.setId(1);
		menu1.setName("Git常用命令");
		menu1.setType("click");
		menu1.setKey("click-1");
		menus.add(menu1);
		
		/*
		//第二个一级菜单，包含二级菜单
		WeiXinMenu menu2 = new WeiXinMenu();
		menu2.setId(2);
		menu2.setName("测试资源");
		List<WeiXinMenu> menu2SubMenus = new ArrayList<WeiXinMenu>();
		menu1 = new WeiXinMenu();
		menu1.setId(3);
		menu1.setpId(2);
		menu1.setName("事件测试");
		menu1.setType("click");
		menu1.setKey("A0001");
		menu2SubMenus.add(menu1);
		menu1 = new WeiXinMenu();
		menu1.setId(4);
		menu1.setpId(2);
		menu1.setName("扫描测试");
		menu1.setType("pic_sysphoto");
		menu1.setKey("rselfmenu_1_0");
		menu2SubMenus.add(menu1);
		menu2.setSub_button(menu2SubMenus);
		menus.add(menu2);
		*/
		
		Map<String,List<WeiXinMenu>> jsonMaps = new HashMap<String,List<WeiXinMenu>>();
		jsonMaps.put("button", menus);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String menuJson = mapper.writeValueAsString(jsonMaps);
			System.out.println(menuJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
