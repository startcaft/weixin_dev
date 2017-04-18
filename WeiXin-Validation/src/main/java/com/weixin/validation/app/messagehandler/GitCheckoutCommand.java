package com.weixin.validation.app.messagehandler;


/**
 * 指令1 <br>
 * 对应回复多条图文消息，罗列git checkout命令的经常用到的场景，url跳转到自定义页面，详细描述该条命令的使用
 */
public class GitCheckoutCommand extends Command {

	public GitCheckoutCommand(String fromUserName, String toUserName) {
		super(fromUserName, toUserName);
	}

	@Override
	public String getCommandCode() {
		return "1";
	}

	@Override
	public String getResponseMessage() {
		{
			return new CheckoutMulMessageHandler().processRequestTemplate(super.fromUserName, super.toUserName);
		}
	}
}
