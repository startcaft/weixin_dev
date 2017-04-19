package com.weixin.validation.app.messagehandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.weixin.validation.util.MessageUtil;
import com.weixin.wxmessage.reponse.Article;
import com.weixin.wxmessage.reponse.BaseResponseMessage;
import com.weixin.wxmessage.reponse.NewsResponseMessage;

/**
 * 处理请求消息，并返回单一图文响应
 */
public class SingleBlogNewsMessageHandler extends BaseWeiXinMessageHandler {

	/**
	 * 构建一个响应图文消息
	 */
	@Override
	protected BaseResponseMessage responseMessage(String fromUserName, String toUserName) {
		{	
			// 创建图文消息  
			NewsResponseMessage newsMessage = new NewsResponseMessage();  
			newsMessage.setToUserName(fromUserName);  
			newsMessage.setFromUserName(toUserName);  
			newsMessage.setCreateTime(new Date().getTime());  
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
			
			// 单一图文
			List<Article> articleList = new ArrayList<Article>(1);

			Article article = new Article();  
			article.setTitle("我的博客");
			article.setDescription("Git是一款免费，开源的分布式版本控制系统，可以有效的,高速的处理从很小到很大的项目版本管理。 "
					+ "Git是Linus Torvalds为了帮助管理Linux内核开发而开发的一个开放源码的版本控制软件。");
			article.setUrl("http://www.cnblogs.com/startcaft/category/972509.html");
			article.setPicUrl("http://119.23.56.247/pics/gitimgs/gitimg.jpg");
			
			articleList.add(article);
			
			newsMessage.setArticles(articleList);
			newsMessage.setArticleCount(articleList.size());
			
			return newsMessage;
		}
	}
}
