package com.weixin.validation.app.service;

import java.util.List;
import com.weixin.validation.app.exception.ServiceException;
import com.weixin.vo.CommandUsageVo;

public interface CommandUsageService {
	
	/**
	 * 获取tb_command_usage指定id的详细
	 * @param IsAssociatedCommand 是否关联查询tb_command
	 */
	public CommandUsageVo getDetail(Integer id,boolean IsAssociatedCommand) throws ServiceException;
	
	/**
	 * 获取tb_command_usage集合 <br>
	 * 集合个数不能超过8个 <br>
	 * 微信多图文消息的规定 <br>
	 * @param 根据command_id过滤
	 */
	public List<CommandUsageVo> getWeiXinList(Integer commandId) throws ServiceException;
}
