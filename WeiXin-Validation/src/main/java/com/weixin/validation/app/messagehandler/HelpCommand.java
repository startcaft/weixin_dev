package com.weixin.validation.app.messagehandler;


/**
 * 指令 ? <br>
 * 对应回复帮助信息
 */
public class HelpCommand extends Command {


	public HelpCommand(String fromUserName, String toUserName) {
		super(fromUserName, toUserName);
	}

	@Override
	public String getCommandCode() {
		return "?";
	}

	@Override
	public String getResponseMessage() {
		{
			return new TextTipMessageHandler().processRequestTemplate(super.fromUserName,super.toUserName);
		}
	}

}
