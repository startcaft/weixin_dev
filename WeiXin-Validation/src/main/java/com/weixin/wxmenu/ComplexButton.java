package com.weixin.wxmenu;

/**
 * 复杂菜单（父按钮）
 * 规则：规则包含3个sub_button
 */
public class ComplexButton extends Button {
	
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
