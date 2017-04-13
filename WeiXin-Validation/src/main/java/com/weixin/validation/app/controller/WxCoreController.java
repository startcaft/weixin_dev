package com.weixin.validation.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.weixin.validation.app.service.CoreService;
import com.weixin.validation.util.WeiXinSignUtil;

@Controller
@RequestMapping("/core")
public class WxCoreController {
	
	@Autowired
	private CoreService coreService;
	
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
	
	@RequestMapping(value="/init",method=RequestMethod.POST)
	public void processMessage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		{
			//微信消息的接收，处理，响应
			request.setCharacterEncoding("UTF-8");//防止中文乱码
			response.setCharacterEncoding("UTF-8");
			
			String respXmlData = coreService.processRequest(request);
			
			//响应消息
			PrintWriter writer = response.getWriter();
			writer.print(respXmlData);
			writer.close();
		}
	}
}
