package com.weixin.messagehandler;

import java.util.Date;

import com.weixin.validation.util.MessageUtil;
import com.weixin.wxmessage.reponse.BaseResponseMessage;
import com.weixin.wxmessage.reponse.TextReponseMessage;

/**
 * 回复帮助信息的消息处理器
 */
public class TextTipMessageHandler extends BaseWeiXinMessageHandler {

	@Override
	protected BaseResponseMessage responseMessage(String fromUserName, String toUserName) {
		{
			//构建文本消息
			TextReponseMessage text = new TextReponseMessage();
			text.setToUserName(fromUserName);  
			text.setFromUserName(toUserName);  
			text.setCreateTime(new Date().getTime());  
			text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
			StringBuffer sb = new StringBuffer("git常用命令的使用场景,请回复数字查看:\n\n");
			sb.append("1.git reset命令\n");
			sb.append("2.git chekcout命令\n\n");
			sb.append("回复?显示此帮助信息");
			
			text.setContent(sb.toString());
			
			return text;
		}
	}

}
