package com.weixin.validation.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.weixin.validation.app.service.CommandUsageService;
import com.weixin.vo.CommandUsageVo;
import com.weixin.vo.ResponseEntity;

@Controller
@RequestMapping("/git")
public class CommandController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandController.class);
	
	@Autowired
	private CommandUsageService cuService;
	
	@RequestMapping("/list/{commandId}")
	@ResponseBody
	public ResponseEntity usageList(@PathVariable(value="commandId",required=true) Integer commandId){
		{
			ResponseEntity entity = new ResponseEntity();
			try {
				List<CommandUsageVo> weiXinList = cuService.getWeiXinList(commandId);
				entity.setErrCode(0);
				entity.setRespData(weiXinList);
			} catch (Exception e) {
				entity.setErrMsg(e.getMessage());
			}
			return entity;
		}
	}
	
	@RequestMapping(value="/detail/{commandUsageId}",method=RequestMethod.GET)
	public ModelAndView usageDetail(@PathVariable("commandUsageId") Integer commandUsageId){
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("git_manager/usage_detail");
			try {
				CommandUsageVo detail = cuService.getDetail(commandUsageId, true);
				mv.addObject("detail", detail);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mv.addObject("detail", null);
			}
			return mv;
		}
	}
}
