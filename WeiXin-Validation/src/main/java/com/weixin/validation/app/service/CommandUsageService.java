package com.weixin.validation.app.service;

import java.util.List;

import com.weixin.vo.CommandUsageVo;

public interface CommandUsageService {
	
	/**
	 * 获取tb_command_usage指定id的详细
	 * @param IsAssociatedCommand 是否关联查询tb_command
	 */
	public CommandUsageVo getDetail(Integer id,boolean IsAssociatedCommand);
	
	/**
	 * 获取tb_command_usage集合
	 * @param 根据command_id过滤
	 */
	public List<CommandUsageVo> getList(Integer commandId);
}
