package com.weixin.messagehandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.weixin.validation.util.MessageUtil;
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

		//多图文
		List<Article> articleList = new ArrayList<Article>(3);

		Article article = new Article();
		article.setTitle("git checkout branch");
		article.setDescription("检出指定分支");
		article.setUrl("http://www.cnblogs.com/startcaft/category/972509.html");
		article.setPicUrl("http://images.cnblogs.com/cnblogs_com/startcaft/984400/o_timg.jpg");
		articleList.add(article);
		
		article = new Article();
		article.setTitle("git checkout");
		article.setDescription("汇总显示差异");
		article.setUrl("http://www.cnblogs.com/startcaft/category/972509.html");
		article.setPicUrl("http://images.cnblogs.com/cnblogs_com/startcaft/984400/o_timg.jpg");
		articleList.add(article);
		
		article = new Article();
		article.setTitle("git checkout -- file");
		article.setDescription("检出指定文件");
		article.setUrl("http://www.cnblogs.com/startcaft/category/972509.html");
		article.setPicUrl("http://images.cnblogs.com/cnblogs_com/startcaft/984400/o_timg.jpg");
		articleList.add(article);

		newsMessage.setArticles(articleList);
		newsMessage.setArticleCount(articleList.size());

		return newsMessage;
	}

}
