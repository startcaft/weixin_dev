package com.weixin.wxmenu;

import java.util.List;

/**
 * 自定义微信公众号菜单json对象。
 * id，pId属性是为了将菜单对象保存到数据库中。
 */
public class WeiXinMenu {
	
	private Integer id;
	private String name;
	private String type;
	private String url;
	private String key;
	private Integer pId;
	
	private List<WeiXinMenu> sub_button;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public List<WeiXinMenu> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WeiXinMenu> sub_button) {
		this.sub_button = sub_button;
	}
}