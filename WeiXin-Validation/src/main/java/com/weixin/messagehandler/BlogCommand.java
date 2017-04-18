package com.weixin.messagehandler;


/**
 * 默认指令 <br>
 * 回复单一图文消息，链接到我的博客园
 */
public class BlogCommand extends Command {

	public BlogCommand(String fromUserName, String toUserName) {
		super(fromUserName, toUserName);
	}

	@Override
	public String getCommandCode() {
		return null;
	}

	@Override
	public String getResponseMessage() {
		return new SingleBlogNewsMessageHandler().processRequestTemplate(super.fromUserName,super.toUserName);
	}
}
