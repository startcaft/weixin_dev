package com.weixin.messagehandler;


/**
 * 抽象微信用户发送的指令类
 */
public abstract class Command {
	
	protected String fromUserName;
	protected String toUserName;
	
	public Command(String fromUserName,String toUserName) {
		this.fromUserName = fromUserName;
		this.toUserName = toUserName;
	}
	
	/**
	 * 返回指令
	 */
	public abstract String getCommandCode();
	
	/**
	 * 返回指令对应的响应消息
	 */
	public abstract String getResponseMessage();
}
