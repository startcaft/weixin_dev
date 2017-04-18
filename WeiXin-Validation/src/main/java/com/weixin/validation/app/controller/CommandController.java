package com.weixin.validation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.validation.app.service.CommandUsageService;
import com.weixin.vo.CommandUsageVo;

@Controller
@RequestMapping("/git")
public class CommandController {
	
	@Autowired
	private CommandUsageService cuService;
	
	@RequestMapping("/list/{commandId}")
	@ResponseBody
	public List<CommandUsageVo> usageList(@PathVariable(value="commandId",required=true) Integer commandId){
		
		return cuService.getList(commandId);
	}
	
	@RequestMapping("/detail/{detailId}")
	public String usageDetail(@PathVariable("detailId") Integer detailId){
		System.out.println("detailId:" + detailId);
		
		return "git_manager/usage_detail";
	}
}
