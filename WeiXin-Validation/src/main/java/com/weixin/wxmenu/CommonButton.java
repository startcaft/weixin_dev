package com.weixin.wxmenu;

/**
 * 普通按钮（子按钮）<br>
 * 规则：没有子菜单的菜单项，可能是二级菜单项，也有可能是不包含二级菜单的以及菜单 <br>
 */
public class CommonButton extends Button {
	
	private String type;
	private String key;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
