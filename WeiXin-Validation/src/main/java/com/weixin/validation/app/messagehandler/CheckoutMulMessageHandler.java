package com.weixin.validation.app.messagehandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.weixin.validation.app.service.CommandUsageService;
import com.weixin.validation.util.MessageUtil;
import com.weixin.vo.CommandUsageVo;
import com.weixin.wxmessage.reponse.Article;
import com.weixin.wxmessage.reponse.BaseResponseMessage;
import com.weixin.wxmessage.reponse.NewsResponseMessage;

/**
 * git checkout 命令使用场景的多图文消息
 */
public class CheckoutMulMessageHandler extends BaseWeiXinMessageHandler {
	

	@Override
	protected BaseResponseMessage responseMessage(String fromUserName, String toUserName) {
		// 创建图文消息
		NewsResponseMessage newsMessage = new NewsResponseMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

		List<Article> articleList = null;
		
		//获取数据
		CommandUsageService cuService = (CommandUsageService) MyApplicationContextUtil.getBean(CommandUsageService.class);
		List<CommandUsageVo> voList = cuService.getList(1);
		if (!voList.isEmpty()) {
			if (voList.size() > 8) {//如果数据大于8条，则去前8条
				articleList = new ArrayList<>(8);
				voList = voList.subList(0, 7);
			}
			else{
				articleList = new ArrayList<>(voList.size());
			}
			
			for (CommandUsageVo vo : voList) {
				Article article = new Article();
				article.setTitle(vo.getTitle());
				article.setUrl("http://www.cnblogs.com/startcaft/category/972509.html");
				article.setPicUrl("http://images.cnblogs.com/cnblogs_com/startcaft/984400/o_timg.jpg");
				
				articleList.add(article);
			}
		}
		
		newsMessage.setArticles(articleList);
		newsMessage.setArticleCount(articleList.size());

		return newsMessage;
	}

}
