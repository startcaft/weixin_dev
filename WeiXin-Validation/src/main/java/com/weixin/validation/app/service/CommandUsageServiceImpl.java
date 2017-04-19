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
import org.springframework.transaction.annotation.Transactional;
import com.weixin.gitcommand.dao.CommandUsageMapper;
import com.weixin.gitcommand.model.CommandUsage;
import com.weixin.validation.app.exception.ServiceException;
import com.weixin.vo.CommandUsageVo;


@Service
public class CommandUsageServiceImpl implements CommandUsageService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandUsageServiceImpl.class);
	
	@Autowired
	private CommandUsageMapper cumapper;
	
	@Override
	public CommandUsageVo getDetail(Integer id, boolean IsAssociatedCommand) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(readOnly=true)
	@Override
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
