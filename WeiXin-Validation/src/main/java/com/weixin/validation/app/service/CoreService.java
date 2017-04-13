package com.weixin.validation.app.service;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.weixin.validation.util.MessageUtil;
import com.weixin.wxmessager.reponse.TextReponseMessage;

@Service
public class CoreService {
	
	public String processRequest(HttpServletRequest request){
		{
			//XML格式的消息数据
			String respXml = null;
			//默认返回的文本消息内容
			String respContent = "未知的消息类型!";
			
			try {
				Map<String, String> requestMap = MessageUtil.parseRequestXml(request);
				String fromUserName = requestMap.get("FromUserName");//发送方账号
				String toUserName = requestMap.get("ToUserName");//开发者账号
				String msgType = requestMap.get("MsgType");//消息类型
				
				//根据不同请求类型的消息，返回的文本消息内容也不一样
				// 文本消息
	            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
	                respContent = "您发送的是文本消息！";
	            }
	            // 图片消息
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
	                respContent = "您发送的是图片消息！";
	            }
	            // 语音消息
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
	                respContent = "您发送的是语音消息！";
	            }
	            // 视频消息
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
	                respContent = "您发送的是视频消息！";
	            }
	            // 视频消息
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
	                respContent = "您发送的是小视频消息！";
	            }
	            // 地理位置消息
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
	                respContent = "您发送的是地理位置消息！";
	            }
	            // 链接消息
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
	                respContent = "您发送的是链接消息！";
	            }
	            // 事件推送
	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
	                // 事件类型
	                String eventType = requestMap.get("Event");
	                // 关注
	                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
	                    respContent = "谢谢您的关注！";
	                }
	                // 取消关注
	                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
	                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
	                }
	                // 扫描带参数二维码
	                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
	                    // TODO 处理扫描带参数二维码事件
	                }
	                // 上报地理位置
	                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
	                    // TODO 处理上报地理位置事件
	                }
	                // 自定义菜单
	                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
	                    // TODO 处理菜单点击事件
	                }
	            }
	            
	            //构建被动回复的文本消息对象
				TextReponseMessage responseMessage = new TextReponseMessage();
				responseMessage.setToUserName(fromUserName);
				responseMessage.setFromUserName(toUserName);
				responseMessage.setCreateTime(new Date().getTime());
				responseMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				responseMessage.setContent(respContent);
				
				//将被动回复的文本消息对象转换成xml
				respXml = MessageUtil.respMessageToXml(responseMessage);
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respXml;
		}
	}
}
