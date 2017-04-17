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
		//一级菜单，如果一级菜单下有二级菜单，只需要配置name属性
		WeiXinMenu menu1 = new WeiXinMenu();
		menu1.setId(1);
		menu1.setName("Git常用命令");
		
		List<WeiXinMenu> m1SubMenus = new ArrayList<WeiXinMenu>();
		
		//二级级菜单，包含二级菜单
		WeiXinMenu m1SubMenu1 = new WeiXinMenu();
		m1SubMenu1.setId(2);
		m1SubMenu1.setpId(1);
		m1SubMenu1.setType("click");
		m1SubMenu1.setKey("click-checkout");
		m1SubMenu1.setName("git checkout");
		
		
		WeiXinMenu m1SubMenu2 = new WeiXinMenu();
		m1SubMenu2.setId(3);
		m1SubMenu2.setpId(1);
		m1SubMenu2.setType("click");
		m1SubMenu2.setKey("click-reset");
		m1SubMenu2.setName("git reset");
		
		m1SubMenus.add(m1SubMenu1);
		m1SubMenus.add(m1SubMenu2);
		
		menu1.setSub_button(m1SubMenus);
		
		menus.add(menu1);
		
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
