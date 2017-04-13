package com.weixin.wxmessager.reponse;

/**
 * 返回为本消息
 */
public class TextReponseMessage extends BaseResponseMessage {
	
	// 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
