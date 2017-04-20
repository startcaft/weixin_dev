package com.weixin.validation.app.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weixin.gitcommand.dao.CommandUsageMapper;
import com.weixin.gitcommand.model.CommandUsage;
import com.weixin.validation.app.exception.ServiceException;
import com.weixin.vo.CommandUsageVo;


@Service
public class CommandUsageServiceImpl implements CommandUsageService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandUsageServiceImpl.class);
	
	//private static final String CACHE_NAME = "mybatisCache";
	
	@Autowired
	private CommandUsageMapper cumapper;
	
	@Override
	public CommandUsageVo getDetail(Integer commandUsageId, boolean IsAssociatedCommand) throws ServiceException {
		{
			if (commandUsageId == null || commandUsageId <= 0) {
				throw new ServiceException("无效的参数");
			}
		}
		CommandUsage entity = null;
		CommandUsageVo vo = null;
		{
			if (IsAssociatedCommand) {
				entity = cumapper.selectByPrimaryKeyWithCommand(commandUsageId);
			}
			else{
				entity =cumapper.selectByPrimaryKey(commandUsageId);
			}
		}
		{
			if (entity != null) {
				vo = new CommandUsageVo();
				BeanUtils.copyProperties(entity, vo);
				if (entity.getCommand() != null) {
					vo.setCommandName(entity.getCommand().getCommandName());
					vo.setCommandDesc(entity.getCommand().getCommandDesc());
				}
			}
		}
		return vo;
	}
	
	//@TriggersRemove(cacheName="userCache", when=When.AFTER_METHOD_INVOCATION, removeAll=true) 
	//这句代码加到service里面的添加、删除、修改方法上。这样只要这几个方法有调用，缓存自动清除。
	//@Cacheable(value=CACHE_NAME)
	public List<CommandUsageVo> getWeiXinList(Integer commandId) throws ServiceException {
		{
			Map<String, Object> params = new HashMap<>();
			params.put("commandId", commandId);
			List<CommandUsageVo> voList = new LinkedList<>();
			
			try {
				List<CommandUsage> modelList = cumapper.selectList(params);
				if (!modelList.isEmpty()) {
					//大于8个条目，要处理一下
					if (modelList.size() > 8) {
						modelList = modelList.subList(0, 7);
					}
					for (CommandUsage model : modelList) {
						CommandUsageVo vo = new CommandUsageVo();
						BeanUtils.copyProperties(model, vo);
						
						voList.add(vo);
					}
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error(e.getMessage());
				}
				throw new ServiceException("请求指定git命令使用场景失败!");
			}
			
			return voList;
		}
	}

}
