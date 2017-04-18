package com.weixin.validation.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.validation.app.messagehandler.BlogCommand;
import com.weixin.validation.app.messagehandler.Command;
import com.weixin.validation.app.messagehandler.GitCheckoutCommand;
import com.weixin.validation.app.messagehandler.HelpCommand;
import com.weixin.validation.app.service.CoreServiceImpl;
import com.weixin.validation.util.MessageUtil;
import com.weixin.validation.util.WeiXinSignUtil;
import com.weixin.vo.ErrorEntity;

@Controller
@RequestMapping("/core")
public class WxCoreController {
	
	@Autowired
	private CoreServiceImpl coreService;
	
	/*微信接入*/
	@RequestMapping(value="/init",method=RequestMethod.GET)
	public void core(HttpServletRequest request,HttpServletResponse response) throws IOException{
		{
			//获取请求参数[微信加密签名],[时间戳],[随机数],[随机字符串]
	        String signature = request.getParameter("signature");
	        String timestamp = request.getParameter("timestamp");
	        String nonce = request.getParameter("nonce");
	        String echostr = request.getParameter("echostr");
	        
	        PrintWriter outer = response.getWriter();
	        
	        //如果验证通过，原样输出[echostr]，接入成功；否则接入失败
	        if (WeiXinSignUtil.checkSignature(signature, timestamp, nonce)) {
	        	outer.print(echostr);
			}
	        outer.close();
	        outer = null;
		}
	}
	
	/*处理微信消息*/
	@RequestMapping(value="/init",method=RequestMethod.POST)
	public void processMessage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		{
			Map<String, String> requestMap = MessageUtil.parseRequestXml(request);
			String fromUserName = requestMap.get("FromUserName");//发送方账号
			String toUserName = requestMap.get("ToUserName");//开发者账号
			String requestMsgType = requestMap.get("MsgType");//接收到的消息类型
			
			//微信消息的接收，处理，响应
			request.setCharacterEncoding("UTF-8");//防止中文乱码
			response.setCharacterEncoding("UTF-8");
			
			//接收用户消息，规则如下：
			//1，接收到指定数字命令，如"1"，则回复多条图文，包含这个命令的多个使用场景图文消息，跳转到自定义页面(命令使用场景详细说明)
			//2，接收到指定 "?"，则回复帮助统一提示消息
			//3，接收到其他任何消息，回复单一图文消息，跳转到我的blog。
			Command command = new BlogCommand(fromUserName,toUserName);
			
			if (requestMsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {//文本消息
				switch (requestMap.get("Content")) {
					case "?":
						command = new HelpCommand(fromUserName,toUserName);
						break;
					case "1":
						command = new GitCheckoutCommand(fromUserName,toUserName);
						break;
				}
			}
			
			System.out.println(command.getClass().getSimpleName());
			
			String respXmlData = command.getResponseMessage();
			
			//响应消息
			PrintWriter writer = response.getWriter();
			writer.print(respXmlData);
			writer.close();
		}
	}
	
	/*自定义菜单*/
	@RequestMapping(value="/createMenu")
	@ResponseBody
	public ErrorEntity createMenu(HttpServletRequest request,HttpServletResponse response) throws IOException{
		{
			ErrorEntity error = coreService.createWeiXinMenu(request);
			return error;
		}
	}
}
