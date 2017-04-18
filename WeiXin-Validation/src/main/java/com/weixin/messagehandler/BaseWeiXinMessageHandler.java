package com.weixin.messagehandler;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.weixin.validation.util.MessageUtil;
import com.weixin.wxmessager.reponse.BaseResponseMessage;

/**
 * 微信消息的统一处理 基类 <br>
 * 提供一个模板方法 processRequestTemplate(HttpServletRequest request) 来处理 微信用户发送的请求消息 <br>
 * 子类实现 <T extends BaseResponseMessage, t> t responseMessage() 方法来处理 如何返回响应消息
 */
public abstract class BaseWeiXinMessageHandler {
	
	/**
	 * 模板方法，处理 请求消息，并响应消息
	 */
	public final <T extends BaseResponseMessage> String processRequestTemplate(HttpServletRequest request){
		{
			//XML格式的消息数据
			String respXml = null;
			
			try {
				Map<String, String> requestMap = MessageUtil.parseRequestXml(request);
				String fromUserName = requestMap.get("FromUserName");//发送方账号
				String toUserName = requestMap.get("ToUserName");//开发者账号
				String contextPath = request.getContextPath();
//				String msgType = requestMap.get("MsgType");//消息类型
				
				//根据不同请求类型的消息，返回的文本消息内容也不一样
				// 文本消息
//	            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//	                respContent = "您发送的是文本消息！";
//	            }
//	            // 图片消息
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//	                respContent = "您发送的是图片消息！";
//	            }
//	            // 语音消息
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//	                respContent = "您发送的是语音消息！";
//	            }
//	            // 视频消息
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
//	                respContent = "您发送的是视频消息！";
//	            }
//	            // 视频消息
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
//	                respContent = "您发送的是小视频消息！";
//	            }
//	            // 地理位置消息
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//	                respContent = "您发送的是地理位置消息！";
//	            }
//	            // 链接消息
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//	                respContent = "您发送的是链接消息！";
//	            }
//	            // 事件推送
//	            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//	                // 事件类型
//	                String eventType = requestMap.get("Event");
//	                // 关注
//	                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//	                    respContent = "谢谢您的关注！";
//	                }
//	                // 取消关注
//	                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//	                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
//	                }
//	                // 扫描带参数二维码
//	                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
//	                    // TODO 处理扫描带参数二维码事件
//	                }
//	                // 上报地理位置
//	                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
//	                    // TODO 处理上报地理位置事件
//	                }
//	                // 自定义菜单
//	                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//	                    // TODO 处理菜单点击事件
//	                }
//	            }
	            
	            //构建响应消息对象，根据自己的业务情况实现不同的子类吧
				BaseResponseMessage responseMessage = this.responseMessage(fromUserName,toUserName,contextPath);
				
				//将被动回复的文本消息对象转换成xml
				respXml = MessageUtil.respMessageToXml(responseMessage);
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respXml;
		}
	}
	
	/**
	 * 构建一个 响应消息基类 的子类实例
	 * @param fromUserName 微信用户原始ID
	 * @param toUserName 开发者原始ID 
	 * @return BaseResponseMessage类型实例
	 */
	protected abstract BaseResponseMessage responseMessage(String fromUserName,String toUserName,String contextPath);
}
