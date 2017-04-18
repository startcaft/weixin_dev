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
import com.weixin.messagehandler.SingleBlogNewsMessageHandler;
import com.weixin.validation.util.HttpInvokeMethod;
import com.weixin.validation.util.WeiXinApiInvokeUtil;
import com.weixin.validation.util.WeiXinConstant;
import com.weixin.vo.ErrorEntity;
import com.weixin.wxmenu.WeiXinMenu;


@Service
public class CoreServiceImpl implements CoreService {
	
	private BaseWeiXinMessageHandler messageHandler;
	
	//初始化
	public CoreServiceImpl() {
		messageHandler = new SingleBlogNewsMessageHandler();
	}

	@Override
	public String WeiXinMessageProcess(String fromUserName, String toUserName) {
		{
			return messageHandler.processRequestTemplate(fromUserName,toUserName);
		}
	}

	@Override
	public ErrorEntity createWeiXinMenu(HttpServletRequest request) {
		
		List<WeiXinMenu> menus = new ArrayList<WeiXinMenu>();
		//一级菜单，如果一级菜单下有二级菜单，只需要配置name属性
		WeiXinMenu menu1 = new WeiXinMenu();
		menu1.setId(1);
		menu1.setName("常用命令");
		
		List<WeiXinMenu> m1SubMenus = new ArrayList<WeiXinMenu>();
		
		//二级级菜单，包含二级菜单
		WeiXinMenu m1SubMenu1 = new WeiXinMenu();
		m1SubMenu1.setId(2);
		m1SubMenu1.setpId(1);
		m1SubMenu1.setType("click");
		m1SubMenu1.setKey("click-1");
		m1SubMenu1.setName("git checkout");
		//m1SubMenu1.setUrl(request.getContextPath() + "/git/list/1");
		
		WeiXinMenu m1SubMenu2 = new WeiXinMenu();
		m1SubMenu2.setId(3);
		m1SubMenu2.setpId(1);
		m1SubMenu2.setType("click");
		m1SubMenu2.setKey("click-2");
		m1SubMenu2.setName("git reset");
		//m1SubMenu1.setUrl(request.getContextPath() + "/git/list/2");
		
		m1SubMenus.add(m1SubMenu1);
		m1SubMenus.add(m1SubMenu2);
		
		menu1.setSub_button(m1SubMenus);
		
		menus.add(menu1);
		
		Map<String,List<WeiXinMenu>> jsonMaps = new HashMap<String,List<WeiXinMenu>>();
		jsonMaps.put("button", menus);
		
		ErrorEntity errorEntity = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String menuJson = mapper.writeValueAsString(jsonMaps);
			errorEntity = WeiXinApiInvokeUtil.invoke(WeiXinConstant.CREATE_MENU_URL, HttpInvokeMethod.Post, menuJson, false);
			return errorEntity;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return errorEntity;
	}
}
