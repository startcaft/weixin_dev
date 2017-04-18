package com.weixin.validation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/git")
public class CommandController {
	
	@RequestMapping("/list/{commondId}")
	public String usageList(@PathVariable(value="commondId",required=true) Integer commondId){
		System.out.println("commondId:" + commondId);
		
		return "git_manager/usage_list";
	}
	
	@RequestMapping("/detail/{detailId}")
	public String usageDetail(@PathVariable("detailId") Integer detailId){
		System.out.println("detailId:" + detailId);
		
		return "git_manager/usage_detail";
	}
}
