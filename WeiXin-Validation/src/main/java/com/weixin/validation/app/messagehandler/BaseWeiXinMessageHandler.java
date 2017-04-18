package com.weixin.validation.app.messagehandler;


import com.weixin.validation.util.MessageUtil;
import com.weixin.wxmessage.reponse.BaseResponseMessage;

/**
 * 微信消息的统一处理 基类 <br>
 * 提供一个模板方法 processRequestTemplate(String fromUserName,String toUserName) 来处理 微信用户发送的请求消息 <br>
 * 子类实现 <T extends BaseResponseMessage, t> t responseMessage() 方法来处理 如何返回响应消息
 */
public abstract class BaseWeiXinMessageHandler {
	
	/**
	 * 模板方法，处理 请求消息，并响应消息
	 * @param fromUserName 发送消息的微信用户名
	 * @param toUserName 微信公众号用户名
	 */
	public final <T extends BaseResponseMessage> String processRequestTemplate(String fromUserName,String toUserName){
		{
			//被动回复消息的XML数据
			String respXml = null;
            //构建响应消息对象，根据自己的业务情况实现不同的子类吧
			BaseResponseMessage responseMessage = this.responseMessage(fromUserName,toUserName);
			//将被动回复的文本消息对象转换成xml
			respXml = MessageUtil.respMessageToXml(responseMessage);
	            
			return respXml;
		}
	}
	
	/**
	 * 构建一个 响应消息基类 的子类实例
	 * @param fromUserName 发送消息的微信用户名
	 * @param toUserName 微信公众号用户名
	 * @return BaseResponseMessage类型实例
	 */
	protected abstract BaseResponseMessage responseMessage(String fromUserName,String toUserName);
}
