package com.weixin.validation.app.messagehandler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.weixin.validation.app.exception.ServiceException;
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

		List<Article> articleList = new LinkedList<>();
		List<CommandUsageVo> voList = new LinkedList<>();
		
		try {
			//获取数据
			CommandUsageService cuService = (CommandUsageService) MyApplicationContextUtil.getBean(CommandUsageService.class);
			voList = cuService.getWeiXinList(1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (!voList.isEmpty()) {
			for (int i = 0; i < voList.size(); i++) {
				Article article = new Article();
				article.setTitle(voList.get(i).getTitle());
				article.setUrl("http://startcaft.win/WeiXin-Validation/git/detail/" + voList.get(i).getId());
				if(i==0){
					article.setPicUrl("http://startcaft.win/pics/gitimgs/gittop.jpg");
				}
				else{
					article.setPicUrl("http://startcaft.win/pics/gitimgs/branch.jpg");
				}
				
				articleList.add(article);
			}
		}
		
		newsMessage.setArticles(articleList);
		newsMessage.setArticleCount(articleList.size());

		return newsMessage;
	}

}
