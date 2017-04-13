package com.weixin.wxmessager;

/**
 * 请求消息之文本消息
 */
public class ContentMessager extends BaseMessage {
	
	// 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
