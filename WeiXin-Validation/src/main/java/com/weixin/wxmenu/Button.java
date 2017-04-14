package com.weixin.wxmenu;

/**
 * 按钮的基类
 */
public abstract class Button {
    
    private String name;//按钮名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}